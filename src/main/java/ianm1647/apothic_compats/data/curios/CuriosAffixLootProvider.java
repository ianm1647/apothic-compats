package ianm1647.apothic_compats.data.curios;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class CuriosAffixLootProvider extends AffixLootEntryProvider {

    String mod = "curios";

    public CuriosAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights CURIOS = TieredWeights.builder()
            .with(WorldTier.HAVEN, 20, 5)
            .with(WorldTier.FRONTIER, 20, 5)
            .with(WorldTier.ASCENT, 20, 5)
            .with(WorldTier.SUMMIT, 20, 5)
            .with(WorldTier.PINNACLE, 20, 5)
            .build();

    @Override
    public void generate() {
        addEntry(CURIOS, new ItemStack(Comp.Curios.BACK_PLATE));
        addEntry(CURIOS, new ItemStack(Comp.Curios.FLORID_BELT));
        addEntry(CURIOS, new ItemStack(Comp.Curios.BODY_CHAIN));
        addEntry(CURIOS, new ItemStack(Comp.Curios.FLASHY_BRACELET));
        addEntry(CURIOS, new ItemStack(Comp.Curios.FANCY_CHARM));
        addEntry(CURIOS, new ItemStack(Comp.Curios.EMBELLISHED_CURIO));
        addEntry(CURIOS, new ItemStack(Comp.Curios.ADORNED_BOOTS));
        addEntry(CURIOS, new ItemStack(Comp.Curios.SHOWY_GLOVES));
        addEntry(CURIOS, new ItemStack(Comp.Curios.HEAD_COVER));
        addEntry(CURIOS, new ItemStack(Comp.Curios.ORNAMENTED_NECKLACE));
        addEntry(CURIOS, new ItemStack(Comp.Curios.ORNATE_RING));
    }

    @Override
    public String getName() {
        return "Curios Affix Loot Entries";
    }


    protected void addEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, stack), new ModLoadedCondition(mod));
    }
}
