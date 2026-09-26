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
import net.minecraft.world.item.Item;
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
        addCurios(CURIOS, Comp.Curios.BACK_PLATE.value());
        addCurios(CURIOS, Comp.Curios.FLORID_BELT.value());
        addCurios(CURIOS, Comp.Curios.BODY_CHAIN.value());
        addCurios(CURIOS, Comp.Curios.FLASHY_BRACELET.value());
        addCurios(CURIOS, Comp.Curios.FANCY_CHARM.value());
        addCurios(CURIOS, Comp.Curios.EMBELLISHED_CURIO.value());
        addCurios(CURIOS, Comp.Curios.ADORNED_BOOTS.value());
        addCurios(CURIOS, Comp.Curios.SHOWY_GLOVES.value());
        addCurios(CURIOS, Comp.Curios.HEAD_COVER.value());
        addCurios(CURIOS, Comp.Curios.ORNAMENTED_NECKLACE.value());
        addCurios(CURIOS, Comp.Curios.ORNATE_RING.value());
    }

    @Override
    public String getName() {
        return "Curios Affix Loot Entries";
    }

    protected void addCurios(TieredWeights weights, Item... curios) {
        for (Item curio : curios) {
            this.addEntry(new AffixLootEntry(weights, new ItemStack(curio)));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
