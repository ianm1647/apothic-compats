package ianm1647.apothic_compats;

import dev.shadowsoffire.apotheosis.data.RarityProvider;
import dev.shadowsoffire.placebo.datagen.DataGenBuilder;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.ancientreforging.data.ARRarityProvider;
import ianm1647.apothic_compats.affix.ModAffixRegistry;
import ianm1647.apothic_compats.data.*;
import ianm1647.apothic_compats.data.ae2.*;
import ianm1647.apothic_compats.data.aether_ii.*;
import ianm1647.apothic_compats.data.alexsmods.*;
import ianm1647.apothic_compats.data.curios.*;
import ianm1647.apothic_compats.data.allthemodium.*;
import ianm1647.apothic_compats.data.friendsandfoes.*;
import ianm1647.apothic_compats.data.irons_artifice.*;
import ianm1647.apothic_compats.data.undergarden.*;
import ianm1647.apothic_compats.event.ArtificeAffixEvents;
import ianm1647.apothic_compats.event.ArtificeAttributeEvents;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
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
        modContainer.registerConfig(ModConfig.Type.STARTUP, Config.STARTUP_CONFIG);

        Comp.bootstrap(modEventBus);
        ModAffixRegistry.registerAffixes();

        modEventBus.register(this);

        if (ModList.get().isLoaded("irons_artifice")) {
            modEventBus.addListener(ArtificeAttributeEvents::applyAttribs);
            NeoForge.EVENT_BUS.register(new ArtificeAffixEvents());
            NeoForge.EVENT_BUS.register(new ArtificeAttributeEvents());
        }
    }

    @SubscribeEvent
    public void data(GatherDataEvent.Client e) {
        DataGenerator generator = e.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();

        generator.addProvider(true, new TagProvider.Items(output, lookupProvider));
        generator.addProvider(true, new TagProvider.Biomes(output, lookupProvider));
        generator.addProvider(true, new TagProvider.Attributes(output, lookupProvider));
        generator.addProvider(true, new CuriosProvider(output, lookupProvider));

        DataGenBuilder.create(ApothicCompats.MODID)
                .provider(DynamicRegistryProvider.runSilently((DataGenBuilder.DataProviderFactory<RarityProvider>)RarityProvider::new))
                .provider(DynamicRegistryProvider.runSilently((DataGenBuilder.DataProviderFactory<ARRarityProvider>)ARRarityProvider::new))
                .provider(DataMapProvider::new)
                .provider(RarityOverrideProvider::new)
                .provider(RecipeProvider::new)
                .provider(ModelsProvider::new)

                .provider(Ae2AffixLootProvider::new)
                .provider(Ae2GearSetProvider::new)

                .provider(ArtificeAffixProvider::new)

                .provider(AetherIIAffixLootProvider::new)
                .provider(AetherIIAffixProvider::new)
                .provider(AetherIIGearSetProvider::new)
                .provider(AetherIIInvaderProvider::new)

                .provider(CavesInvaderProvider::new)
                .provider(MobsInvaderProvider::new)

                .provider(ATMAffixLootProvider::new)
                .provider(ATMGearSetProvider::new)
                .provider(ATMInvaderProvider::new)

                .provider(CuriosAffixLootProvider::new)
                .provider(CuriosAffixProvider::new)
                .provider(CuriosExtraGemBonusProvider::new)

                .provider(FAFInvaderProvider::new)

                .provider(UndergardenAffixLootProvider::new)
                .provider(UndergardenAffixProvider::new)
                .provider(UndergardenGearSetProvider::new)
                .provider(UndergardenInvaderProvider::new)

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
