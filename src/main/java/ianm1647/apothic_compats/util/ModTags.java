package ianm1647.apothic_compats.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import top.theillusivec4.curios.api.CuriosTags;

public class ModTags {

    public static class Curios {
        public static final TagKey<Item> FEET = CuriosTags.createItemTag("feet");

        public static final TagKey<Item> AN_FOCUS = CuriosTags.createItemTag("an_focus");

        public static final TagKey<Item> BROOCH = CuriosTags.createItemTag("brooch");
        public static final TagKey<Item> RUNE = CuriosTags.createItemTag("rune");
    }

    public static class Items {

        public static final TagKey<Item> CURIO_BLACKLIST = itemTag("curio_blacklist");

        private static TagKey<Item> itemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("apothic_compats", path));
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
            return create(ResourceLocation.fromNamespaceAndPath("apothic_compats", path));
        }

        public static TagKey<Biome> create(ResourceLocation name) {
            return TagKey.create(Registries.BIOME, name);
        }

    }

}
