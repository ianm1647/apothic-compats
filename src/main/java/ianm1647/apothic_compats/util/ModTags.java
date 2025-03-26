package ianm1647.apothic_compats.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosTags;

public class ModTags {

    public static class Curios {
        public static final TagKey<Item> FEET = CuriosTags.createItemTag("feet");

    }

    public static class Items {

        public static final TagKey<Item> CURIO_BLACKLIST = itemTag("curio_blacklist");

        private static TagKey<Item> itemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("apothic_compats", path));
        }
    }

}
