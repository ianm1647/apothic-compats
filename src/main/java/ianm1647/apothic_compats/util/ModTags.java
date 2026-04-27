package ianm1647.apothic_compats.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosTags;

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
}
