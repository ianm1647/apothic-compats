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
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
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
        addCurio(CURIOS, Comp.Curios.BACK_PLATE.value());
        addCurio(CURIOS, Comp.Curios.FLORID_BELT.value());
        addCurio(CURIOS, Comp.Curios.BODY_CHAIN.value());
        addCurio(CURIOS, Comp.Curios.FLASHY_BRACELET.value());
        addCurio(CURIOS, Comp.Curios.FANCY_CHARM.value());
        addCurio(CURIOS, Comp.Curios.EMBELLISHED_CURIO.value());
        addCurio(CURIOS, Comp.Curios.ADORNED_BOOTS.value());
        addCurio(CURIOS, Comp.Curios.SHOWY_GLOVES.value());
        addCurio(CURIOS, Comp.Curios.HEAD_COVER.value());
        addCurio(CURIOS, Comp.Curios.ORNAMENTED_NECKLACE.value());
        addCurio(CURIOS, Comp.Curios.ORNATE_RING.value());
    }

    @Override
    public String getName() {
        return "Curios Affix Loot Entries";
    }


    protected void addCurio(TieredWeights weights, Item curio) {
        this.addEntry(new AffixLootEntry(weights, new ItemStackTemplate(curio)));
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
