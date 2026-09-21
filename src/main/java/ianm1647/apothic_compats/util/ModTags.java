package ianm1647.apothic_compats.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ModTags {

    public static class Curios {
        public static final TagKey<Item> BACK = curiosTag("back");
        public static final TagKey<Item> BELT = curiosTag("belt");
        public static final TagKey<Item> BODY = curiosTag("body");
        public static final TagKey<Item> BRACELET = curiosTag("bracelet");
        public static final TagKey<Item> CHARM = curiosTag("charm");
        public static final TagKey<Item> CURIO = curiosTag("curio");
        public static final TagKey<Item> FEET = curiosTag("feet");
        public static final TagKey<Item> HANDS = curiosTag("hands");
        public static final TagKey<Item> HEAD = curiosTag("head");
        public static final TagKey<Item> NECKLACE = curiosTag("necklace");
        public static final TagKey<Item> RING = curiosTag("ring");

        public static final TagKey<Item> AN_FOCUS = curiosTag("an_focus");

        public static final TagKey<Item> BROOCH = curiosTag("brooch");
        public static final TagKey<Item> RUNE = curiosTag("rune");

        private static TagKey<Item> curiosTag(String path) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("curios", path));
        }
    }

    public static class Items {

        public static final TagKey<Item> CURIOS_FILTER = itemTag("curios_filter");
        public static final TagKey<Item> CURIO_BLACKLIST = itemTag("curio_blacklist");

        private static TagKey<Item> itemTag(String path) {
            return ItemTags.create(Identifier.fromNamespaceAndPath("apothic_compats", path));
        }
    }


    public static class Biomes {
        public static final TagKey<Biome> IS_MAGNETIC_CAVES = common("is_magnetic_caves");
        public static final TagKey<Biome> IS_ABYSSAL_CHASM = common("is_abyssal_chasm");
        public static final TagKey<Biome> IS_CANDY_CAVITY = common("is_candy_cavity");
        public static final TagKey<Biome> IS_FORLORN_HOLLOWS = common("is_forlorn_hollows");
        public static final TagKey<Biome> IS_PRIMORDIAL_CAVES = common("is_primordial_caves");
        public static final TagKey<Biome> IS_TOXIC_CAVES = common("is_toxic_caves");

        private static TagKey<Biome> common(String path) {
            return create(Identifier.fromNamespaceAndPath("apothic_compats", path));
        }

        public static TagKey<Biome> create(Identifier name) {
            return TagKey.create(Registries.BIOME, name);
        }

    }
}
