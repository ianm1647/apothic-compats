package ianm1647.apothic_compats;

import dev.shadowsoffire.apotheosis.data.RarityProvider;
import dev.shadowsoffire.placebo.datagen.DataGenBuilder;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.data.ARRarityProvider;
import ianm1647.apothic_compats.data.*;
import ianm1647.apothic_compats.data.ae2.Ae2AffixLootProvider;
import ianm1647.apothic_compats.data.ae2.Ae2GearSetProvider;
import ianm1647.apothic_compats.data.alexsmods.MobsInvaderProvider;
import ianm1647.apothic_compats.data.curios.CuriosAffixLootProvider;
import ianm1647.apothic_compats.data.curios.CuriosExtraGemBonusProvider;
import ianm1647.apothic_compats.data.curios.CuriosProvider;
import ianm1647.apothic_compats.data.allthemodium.*;
import ianm1647.apothic_compats.data.curios.CuriosAffixProvider;
import ianm1647.apothic_compats.data.friendsandfoes.FAFInvaderProvider;
import ianm1647.apothic_compats.event.AffixEvents;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(ApothicCompats.MODID)
public class ApothicCompats {
    public static final String MODID = "apothic_compats";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public ApothicCompats(IEventBus modEventBus, ModContainer modContainer) {
        //modEventBus.register(new AffixEvents());
        modContainer.registerConfig(ModConfig.Type.STARTUP, Config.STARTUP_CONFIG);

        Comp.bootstrap(modEventBus);
        //ModAffixRegistry.registerAffixes();

        modEventBus.register(this);
    }

    @SubscribeEvent
    public void data(GatherDataEvent.Client e) {
        DataGenerator generator = e.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();

        generator.addProvider(true, new TagProvider.Items(output, lookupProvider));
//        generator.addProvider(true, new ItemModelsProvider(output, helper));
        generator.addProvider(true, new CuriosProvider(output, lookupProvider));

        DataGenBuilder.create(ApothicCompats.MODID)
                .provider(DynamicRegistryProvider.runSilently((DataGenBuilder.DataProviderFactory<RarityProvider>)RarityProvider::new))
                .provider(DynamicRegistryProvider.runSilently((DataGenBuilder.DataProviderFactory<ARRarityProvider>)ARRarityProvider::new))
                .provider(DataMapProvider::new)
                .provider(RarityOverrideProvider::new)
                .provider(RecipeProvider::new)

                .provider(Ae2AffixLootProvider::new)
                .provider(Ae2GearSetProvider::new)
//
//                .provider(AetherAffixLootProvider::new)
//                .provider(AetherAffixProvider::new)
//                .provider(AetherGearSetProvider::new)
//                .provider(AetherInvaderProvider::new)
//                .provider(DartShooterAffixProvider::new)
//
//                .provider(CavesInvaderProvider::new)
                .provider(MobsInvaderProvider::new)

                .provider(ATMAffixLootProvider::new)
                .provider(ATMGearSetProvider::new)
                .provider(ATMInvaderProvider::new)

//                .provider(ArsAffixLootProvider::new)
//                .provider(ArsAffixProvider::new)
//                .provider(ArsGearSetProvider::new)
//                .provider(ArsGemProvider::new)
//                .provider(ArsInvaderProvider::new)
//
//                .provider(ChaosInvaderProvider::new)
//
//                .provider(CataclysmAffixLootProvider::new)
//                .provider(CataclysmGearSetProvider::new)
//                .provider(CataclysmInvaderProvider::new)
//
//                .provider(PotatoCannonAffixProvider::new)

                .provider(CuriosAffixLootProvider::new)
                .provider(CuriosAffixProvider::new)
                .provider(CuriosExtraGemBonusProvider::new)

//                .provider(DeepAetherAffixLootProvider::new)
//                .provider(DeepAetherGearSetProvider::new)
//
//                .provider(DeeperDarkerAffixLootProvider::new)
//                .provider(DeeperDarkerAffixProvider::new)
//                .provider(DeeperDarkerGearSetProvider::new)
//                .provider(DeeperDarkerInvaderProvider::new)

//                .provider(FarmersDelightAffixLootProvider::new)
//
                .provider(FAFInvaderProvider::new)
//
//                .provider(StarlightAffixLootProvider::new)
//                .provider(StarlightAffixProvider::new)
//                .provider(StarlightGearSetProvider::new)
//                .provider(StarlightInvaderProvider::new)
//
//                .provider(MalumAffixProvider::new)
//                .provider(MalumExtraGemBonusProvider::new)
//                .provider(MalumGemProvider::new)
//                .provider(ScytheAffixProvider::new)
//                .provider(StaffAffixProvider::new)
//
//                .provider(MekanismAffixLootProvider::new)
//                .provider(MekanismGearSetProvider::new)
//
//                .provider(MowzieInvaderProvider::new)
//
//                .provider(BumblezoneAffixLootProvider::new)
//                .provider(BumblezoneAffixProvider::new)
//                .provider(BumblezoneGearSetProvider::new)
//                .provider(BumblezoneInvaderProvider::new)
//
//                .provider(TwilightAffixLootProvider::new)
//                .provider(TwilightAffixProvider::new)
//                .provider(TwilightInvaderProvider::new)
//
//                .provider(UndergardenAffixLootProvider::new)
//                .provider(UndergardenAffixProvider::new)
//                .provider(UndergardenGearSetProvider::new)
//                .provider(UndergardenInvaderProvider::new)

                .build(e);

        Object2IntOpenHashMap<String> map = (Object2IntOpenHashMap<String>) DataProvider.FIXED_ORDER_FIELDS;
        map.put("ancientreforging:ancient", 6);
    }

    public static Identifier loc(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Apothic Compats is starting...");
    }
}
