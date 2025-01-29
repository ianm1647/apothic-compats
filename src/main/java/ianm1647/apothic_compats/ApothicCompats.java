package ianm1647.apothic_compats;

import com.mojang.logging.LogUtils;
import dev.shadowsoffire.placebo.datagen.DataGenBuilder;
import ianm1647.apothic_compats.data.RarityProvider;
import ianm1647.apothic_compats.data.aether.*;
import ianm1647.apothic_compats.data.ars_nouveau.*;
import ianm1647.apothic_compats.data.deep_aether.*;
import ianm1647.apothic_compats.data.deeperdarker.*;
import ianm1647.apothic_compats.data.eternal_starlight.*;
import ianm1647.apothic_compats.data.mekanism.*;
import ianm1647.apothic_compats.data.the_bumblezone.*;
import ianm1647.apothic_compats.data.twilight.*;
import ianm1647.apothic_compats.data.undergarden.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(ApothicCompats.MODID)
public class ApothicCompats {
    public static final String MODID = "apothic_compats";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ApothicCompats(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::data);
    }

    public void data(GatherDataEvent e) {
        DataGenBuilder.create(MODID)
                .provider(RarityProvider::new)

                .provider(AetherAffixLootProvider::new)
                .provider(AetherGearSetProvider::new)
                .provider(AetherInvaderProvider::new)

                .provider(ArsAffixLootProvider::new)
                .provider(ArsGearSetProvider::new)
                .provider(ArsGemProvider::new)
                .provider(ArsInvaderProvider::new)

                .provider(DeepAetherAffixLootProvider::new)
                .provider(DeepAetherGearSetProvider::new)

                .provider(DeeperDarkerAffixLootProvider::new)
                .provider(DeeperDarkerGearSetProvider::new)
                .provider(DeeperDarkerInvaderProvider::new)

                .provider(StarlightAffixLootProvider::new)
                .provider(StarlightGearSetProvider::new)
                .provider(StarlightInvaderProvider::new)

                .provider(MekanismAffixLootProvider::new)
                .provider(MekanismGearSetProvider::new)

                .provider(BumblezoneAffixLootProvider::new)
                .provider(BumblezoneGearSetProvider::new)
                .provider(BumblezoneInvaderProvider::new)

                .provider(TwilightInvaderProvider::new)

                .provider(UndergardenAffixLootProvider::new)
                .provider(UndergardenGearSetProvider::new)
                .provider(UndergardenInvaderProvider::new)

                .build(e);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Apothic Compats is starting...");
    }
}
