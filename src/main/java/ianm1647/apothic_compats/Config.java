package ianm1647.apothic_compats;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static ModConfigSpec STARTUP_CONFIG;
    private static final Map<String, ModConfigSpec.BooleanValue> ITEMS = new HashMap<>();
    public static ModConfigSpec.BooleanValue ENABLE_CUSTOM_CURIOS;

    public Config() {
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        ENABLE_CUSTOM_CURIOS.get();
    }

    static {
        ModConfigSpec.Builder STARTUP_BUILDER = new ModConfigSpec.Builder();
        STARTUP_BUILDER.push("Curios");
        ENABLE_CUSTOM_CURIOS = STARTUP_BUILDER.comment("Should custom loot curios be enabled?").define("enableCustomCurios", true);
        STARTUP_BUILDER.pop();
        STARTUP_CONFIG = STARTUP_BUILDER.build();
    }

    private static void put(ModConfigSpec.Builder builder, String name) {
        ITEMS.put(name, builder.define(name, true));
    }

    private static boolean contains(String item) {
        return ITEMS.containsKey(item);
    }
}
