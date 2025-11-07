package ianm1647.apothic_compats;

import dev.shadowsoffire.apotheosis.data.RarityProvider;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.datagen.DataGenBuilder;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.data.ARRarityProvider;
import ianm1647.apothic_compats.affix.ModAffixRegistry;
import ianm1647.apothic_compats.data.*;
import ianm1647.apothic_compats.data.create.PotatoCannonAffixProvider;
import ianm1647.apothic_compats.data.curios.CuriosAffixLootProvider;
import ianm1647.apothic_compats.data.curios.CuriosExtraGemBonusProvider;
import ianm1647.apothic_compats.data.curios.CuriosProvider;
import ianm1647.apothic_compats.data.malum.MalumExtraGemBonusProvider;
import ianm1647.apothic_compats.data.ae2.*;
import ianm1647.apothic_compats.data.aether.*;
import ianm1647.apothic_compats.data.allthemodium.*;
import ianm1647.apothic_compats.data.ars_nouveau.*;
import ianm1647.apothic_compats.data.cataclysm.*;
import ianm1647.apothic_compats.data.curios.CuriosAffixProvider;
import ianm1647.apothic_compats.data.deep_aether.*;
import ianm1647.apothic_compats.data.deeperdarker.*;
import ianm1647.apothic_compats.data.farmersdelight.*;
import ianm1647.apothic_compats.data.eternal_starlight.*;
import ianm1647.apothic_compats.data.malum.*;
import ianm1647.apothic_compats.data.mekanism.*;
import ianm1647.apothic_compats.data.the_bumblezone.*;
import ianm1647.apothic_compats.data.twilight.*;
import ianm1647.apothic_compats.data.undergarden.*;
import ianm1647.apothic_compats.event.AffixEvents;
import ianm1647.apothic_compats.event.AttributeEvents;
import ianm1647.apothic_compats.loot.ModLootCategories;
import ianm1647.apothic_compats.util.ModSlotGroups;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Mod(ApothicCompats.MODID)
public class ApothicCompats {
    public static final String MODID = "apothic_compats";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public ApothicCompats(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new AffixEvents());
        NeoForge.EVENT_BUS.register(new AttributeEvents());
        modContainer.registerConfig(ModConfig.Type.STARTUP, Config.STARTUP_CONFIG);

        Comp.register(modEventBus);
        ModSlotGroups.register(modEventBus);
        ModLootCategories.registerLootCategories(modEventBus);

        ModAffixRegistry.registerAffixes();
        modEventBus.addListener(this::data);
    }

    public void data(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();
        ExistingFileHelper helper = e.getExistingFileHelper();

        TagProvider.Blocks blockTags = new TagProvider.Blocks(output, lookupProvider, helper);
        generator.addProvider(e.includeServer(), blockTags);
        generator.addProvider(e.includeServer(), new TagProvider.Items(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(e.includeClient(), new ItemModelsProvider(output, helper));
        generator.addProvider(e.includeServer(), new CuriosProvider(output, helper, lookupProvider));

        DataGenBuilder.create(ApothicCompats.MODID)
                .provider(DynamicRegistryProvider.runSilently(RarityProvider::new))
                .provider(DynamicRegistryProvider.runSilently(ARRarityProvider::new))
                .provider(DataMapProvider::new)
                .provider(RarityOverrideProvider::new)

                .provider(Ae2AffixLootProvider::new)
                .provider(Ae2GearSetProvider::new)

                .provider(AetherAffixLootProvider::new)
                .provider(AetherAffixProvider::new)
                .provider(AetherGearSetProvider::new)
                .provider(AetherInvaderProvider::new)
                .provider(DartShooterAffixProvider::new)

                .provider(ATMAffixLootProvider::new)
                .provider(ATMGearSetProvider::new)
                .provider(ATMInvaderProvider::new)

                .provider(ArsAffixLootProvider::new)
                .provider(ArsAffixProvider::new)
                .provider(ArsGearSetProvider::new)
                .provider(ArsGemProvider::new)
                .provider(ArsInvaderProvider::new)

                .provider(CataclysmAffixLootProvider::new)
                .provider(CataclysmGearSetProvider::new)
                .provider(CataclysmInvaderProvider::new)

                .provider(PotatoCannonAffixProvider::new)

                .provider(CuriosAffixLootProvider::new)
                .provider(CuriosAffixProvider::new)
                .provider(CuriosExtraGemBonusProvider::new)

                .provider(DeepAetherAffixLootProvider::new)
                .provider(DeepAetherGearSetProvider::new)

                .provider(DeeperDarkerAffixLootProvider::new)
                .provider(DeeperDarkerAffixProvider::new)
                .provider(DeeperDarkerGearSetProvider::new)
                .provider(DeeperDarkerInvaderProvider::new)

                .provider(FarmersDelightAffixLootProvider::new)

                .provider(StarlightAffixLootProvider::new)
                .provider(StarlightAffixProvider::new)
                .provider(StarlightGearSetProvider::new)
                .provider(StarlightInvaderProvider::new)

                .provider(MalumAffixProvider::new)
                .provider(MalumExtraGemBonusProvider::new)
                .provider(MalumGemProvider::new)
                .provider(ScytheAffixProvider::new)
                .provider(StaffAffixProvider::new)

                .provider(MekanismAffixLootProvider::new)
                .provider(MekanismGearSetProvider::new)

                .provider(BumblezoneAffixLootProvider::new)
                .provider(BumblezoneAffixProvider::new)
                .provider(BumblezoneGearSetProvider::new)
                .provider(BumblezoneInvaderProvider::new)

                .provider(TwilightAffixProvider::new)
                .provider(TwilightInvaderProvider::new)

                .provider(UndergardenAffixLootProvider::new)
                .provider(UndergardenAffixProvider::new)
                .provider(UndergardenGearSetProvider::new)
                .provider(UndergardenInvaderProvider::new)

                .build(e);

        Object2IntOpenHashMap<String> map = (Object2IntOpenHashMap<String>) DataProvider.FIXED_ORDER_FIELDS;
        map.put("ancientreforging:ancient", 6);
    }

    public static ResourceLocation loc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Apothic Compats is starting...");
    }
}
