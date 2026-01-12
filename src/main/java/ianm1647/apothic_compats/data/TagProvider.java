package ianm1647.apothic_compats.data;

import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
            tag(CuriosTags.BACK).addOptional(loc(Comp.Curios.BACK_PLATE.value()));
            tag(CuriosTags.BELT).addOptional(loc(Comp.Curios.FLORID_BELT.value()));
            tag(CuriosTags.BODY).addOptional(loc(Comp.Curios.BODY_CHAIN.value()));
            tag(CuriosTags.BRACELET).addOptional(loc(Comp.Curios.FLASHY_BRACELET.value()));
            tag(CuriosTags.CHARM).addOptional(loc(Comp.Curios.FANCY_CHARM.value()));
            tag(CuriosTags.CURIO).addOptional(loc(Comp.Curios.EMBELLISHED_CURIO.value()));
            tag(ModTags.Curios.FEET).addOptional(loc(Comp.Curios.ADORNED_BOOTS.value()));
            tag(CuriosTags.HANDS).addOptional(loc(Comp.Curios.SHOWY_GLOVES.value()));
            tag(CuriosTags.HEAD).addOptional(loc(Comp.Curios.HEAD_COVER.value()));
            tag(CuriosTags.NECKLACE).addOptional(loc(Comp.Curios.ORNAMENTED_NECKLACE.value()));
            tag(CuriosTags.RING).addOptional(loc(Comp.Curios.ORNATE_RING.value()));
        }

        private ResourceLocation loc(Item item) {
            return BuiltInRegistries.ITEM.getKey(item);
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

    public static class Biomes extends BiomeTagsProvider {
        public Biomes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, ApothicCompats.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ModTags.Biomes.IS_MAGNETIC_CAVES).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "magnetic_caves"));
            tag(ModTags.Biomes.IS_ABYSSAL_CHASM).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "abyssal_chasm"));
            tag(ModTags.Biomes.IS_CANDY_CAVITY).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "candy_cavity"));
            tag(ModTags.Biomes.IS_FORLORN_HOLLOWS).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "forlorn_hollows"));
            tag(ModTags.Biomes.IS_PRIMORDIAL_CAVES).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "primordial_caves"));
            tag(ModTags.Biomes.IS_TOXIC_CAVES).addOptional(ResourceLocation.fromNamespaceAndPath("alexscaves", "toxic_caves"));
        }
    }


}
