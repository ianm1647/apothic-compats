package ianm1647.apothic_compats;

import dev.shadowsoffire.placebo.datagen.DataGenBuilder;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.apothic_compats.affix.ModAffixRegistry;
import ianm1647.apothic_compats.data.DataMapProvider;
import ianm1647.apothic_compats.data.CustomRarityProvider;
import ianm1647.apothic_compats.data.RarityOverrideProvider;
import ianm1647.apothic_compats.data.ae2.*;
import ianm1647.apothic_compats.data.aether.*;
import ianm1647.apothic_compats.data.allthemodium.*;
import ianm1647.apothic_compats.data.ars_nouveau.*;
import ianm1647.apothic_compats.data.cataclysm.*;
import ianm1647.apothic_compats.data.curios.CuriosAffixProvider;
import ianm1647.apothic_compats.data.curios.CuriosGemProvider;
import ianm1647.apothic_compats.data.deep_aether.*;
import ianm1647.apothic_compats.data.deeperdarker.*;
import ianm1647.apothic_compats.data.farmersdelight.*;
import ianm1647.apothic_compats.data.eternal_starlight.*;
import ianm1647.apothic_compats.data.malum.*;
import ianm1647.apothic_compats.data.mekanism.*;
import ianm1647.apothic_compats.data.the_bumblezone.*;
import ianm1647.apothic_compats.data.twilight.*;
import ianm1647.apothic_compats.data.undergarden.*;
import ianm1647.apothic_compats.loot.ModLootCategories;
import ianm1647.apothic_compats.util.ModSlotGroups;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(ApothicCompats.MODID)
public class ApothicCompats {
    public static final String MODID = "apothic_compats";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public ApothicCompats(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register(this);
        ModSlotGroups.register(modEventBus);
        ModLootCategories.registerLootCategories(modEventBus);

        ModAffixRegistry.registerAffixes();
        modEventBus.addListener(this::data);
    }

    public void data(GatherDataEvent e) {
        DataGenBuilder.create(ApothicCompats.MODID)
                .provider(DynamicRegistryProvider.runSilently(CustomRarityProvider::new))
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

                .provider(CuriosAffixProvider::new)
                .provider(CuriosGemProvider::new)

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
