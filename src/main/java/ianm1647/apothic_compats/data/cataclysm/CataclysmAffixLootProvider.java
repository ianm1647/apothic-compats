package ianm1647.apothic_compats.data.cataclysm;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CataclysmAffixLootProvider extends AffixLootEntryProvider {

    String mod = "cataclysm";

    public CataclysmAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights BLACK_STEEL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    @Override
    public void generate() {
        //toolWeights.put(Tooltier.BLACK_STEEL, BLACK_STEEL);
    }

    @Override
    public String getName() {
        return "Cataclysm Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, new ItemStackTemplate(tool)));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, new ItemStackTemplate(piece)));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
