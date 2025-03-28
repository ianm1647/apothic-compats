package ianm1647.apothic_compats.data;

import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TagProvider {
    public static class Items extends ItemTagsProvider {
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, provider, blockTags, ApothicCompats.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(CuriosTags.BACK).add(Comp.Curios.BACK_PLATE.value());
            tag(CuriosTags.BELT).add(Comp.Curios.FLORID_BELT.value());
            tag(CuriosTags.BODY).add(Comp.Curios.BODY_CHAIN.value());
            tag(CuriosTags.BRACELET).add(Comp.Curios.FLASHY_BRACELET.value());
            tag(CuriosTags.CHARM).add(Comp.Curios.FANCY_CHARM.value());
            tag(CuriosTags.CURIO).add(Comp.Curios.EMBELLISHED_CURIO.value());
            tag(ModTags.Curios.FEET).add(Comp.Curios.ADORNED_BOOTS.value());
            tag(CuriosTags.HANDS).add(Comp.Curios.SHOWY_GLOVES.value());
            tag(CuriosTags.HEAD).add(Comp.Curios.HEAD_COVER.value());
            tag(CuriosTags.NECKLACE).add(Comp.Curios.ORNAMENTED_NECKLACE.value());
            tag(CuriosTags.RING).add(Comp.Curios.ORNATE_RING.value());
        }
    }

    public static class Blocks extends BlockTagsProvider {
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, ApothicCompats.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
        }
    }
}
