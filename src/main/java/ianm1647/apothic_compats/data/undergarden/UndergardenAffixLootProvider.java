package ianm1647.apothic_compats.data.undergarden;

import dev.shadowsoffire.apotheosis.Apotheosis;
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
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UndergardenAffixLootProvider extends AffixLootEntryProvider {

    String mod = "undergarden";

    private static ResourceKey<Level> UNDERGARDEN = ResourceKey.create(Registries.DIMENSION, Identifier.parse("undergarden:undergarden"));

    public UndergardenAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights CLOGGRUM = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 15, 0)
            .with(WorldTier.ASCENT, 25, 0)
            .build();

    protected static final TieredWeights ANCIENT = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 15, 0)
            .with(WorldTier.ASCENT, 25, 0)
            .build();

    protected static final TieredWeights FROSTSTEEL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 15, 0)
            .with(WorldTier.SUMMIT, 25, 0)
            .build();

    protected static final TieredWeights UTHERIUM = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 15, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    protected static final TieredWeights FORGOTTEN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 15, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    @Override
    public void generate() {
//        armorWeights.put(UGArmorMaterials.CLOGGRUM, CLOGGRUM);
//        armorWeights.put(UGArmorMaterials.ANCIENT, ANCIENT);
//        armorWeights.put(UGArmorMaterials.FROSTSTEEL, FROSTSTEEL);
//        armorWeights.put(UGArmorMaterials.UTHERIUM, UTHERIUM);
//
//        toolWeights.put(UGItemTiers.CLOGGRUM, CLOGGRUM);
//        toolWeights.put(UGItemTiers.FROSTSTEEL, FROSTSTEEL);
//        toolWeights.put(UGItemTiers.UTHERIUM, UTHERIUM);
//        toolWeights.put(UGItemTiers.FORGOTTEN, FORGOTTEN);

    }

    @Override
    public String getName() {
        return "Undergarden Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = Apotheosis.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
