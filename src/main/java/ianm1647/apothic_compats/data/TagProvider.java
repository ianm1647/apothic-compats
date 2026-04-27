package ianm1647.apothic_compats.data;

import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import top.theillusivec4.curios.api.CuriosTags;

import java.util.concurrent.CompletableFuture;

public class TagProvider {
    public static class Items extends ItemTagsProvider {
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
            super(output, provider, ApothicCompats.MODID);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ModTags.Curios.BACK).addOptional(Comp.Curios.BACK_PLATE.value());
            tag(ModTags.Curios.BELT).addOptional(Comp.Curios.FLORID_BELT.value());
            tag(ModTags.Curios.BODY).addOptional(Comp.Curios.BODY_CHAIN.value());
            tag(ModTags.Curios.BRACELET).addOptional(Comp.Curios.FLASHY_BRACELET.value());
            tag(ModTags.Curios.CHARM).addOptional(Comp.Curios.FANCY_CHARM.value());
            tag(ModTags.Curios.CURIO).addOptional(Comp.Curios.EMBELLISHED_CURIO.value());
            tag(ModTags.Curios.FEET).addOptional(Comp.Curios.ADORNED_BOOTS.value());
            tag(ModTags.Curios.HANDS).addOptional(Comp.Curios.SHOWY_GLOVES.value());
            tag(ModTags.Curios.HEAD).addOptional(Comp.Curios.HEAD_COVER.value());
            tag(ModTags.Curios.NECKLACE).addOptional(Comp.Curios.ORNAMENTED_NECKLACE.value());
            tag(ModTags.Curios.RING).addOptional(Comp.Curios.ORNATE_RING.value());

            tag(ModTags.Items.CURIOS_FILTER)
                    .addTag(ModTags.Curios.BACK)
                    .addTag(ModTags.Curios.BELT)
                    .addTag(ModTags.Curios.BODY)
                    .addTag(ModTags.Curios.BRACELET)
                    .addTag(ModTags.Curios.CHARM)
                    .addTag(ModTags.Curios.CURIO)
                    .addTag(ModTags.Curios.FEET)
                    .addTag(ModTags.Curios.HANDS)
                    .addTag(ModTags.Curios.HEAD)
                    .addTag(ModTags.Curios.NECKLACE)
                    .addTag(ModTags.Curios.RING)
                    .addOptionalTag(ModTags.Curios.RUNE)
                    .addOptionalTag(ModTags.Curios.BROOCH)
                    .addOptionalTag(ModTags.Curios.AN_FOCUS);
        }
    }

    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider, ApothicCompats.MODID);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
        }
    }

//    public static class Biomes extends BiomeTagsProvider {
//        public Biomes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
//            super(output, lookupProvider, ApothicCompats.MODID);
//        }
//
//        @Override
//        protected void addTags(HolderLookup.Provider provider) {
//            tag(ModTags.Biomes.IS_MAGNETIC_CAVES).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "magnetic_caves"));
//            tag(ModTags.Biomes.IS_ABYSSAL_CHASM).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "abyssal_chasm"));
//            tag(ModTags.Biomes.IS_CANDY_CAVITY).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "candy_cavity"));
//            tag(ModTags.Biomes.IS_FORLORN_HOLLOWS).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "forlorn_hollows"));
//            tag(ModTags.Biomes.IS_PRIMORDIAL_CAVES).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "primordial_caves"));
//            tag(ModTags.Biomes.IS_TOXIC_CAVES).addOptional(Identifier.fromNamespaceAndPath("alexscaves", "toxic_caves"));
//        }
//    }


}
