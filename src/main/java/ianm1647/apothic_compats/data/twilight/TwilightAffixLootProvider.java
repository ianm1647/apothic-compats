package ianm1647.apothic_compats.data.twilight;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TwilightAffixLootProvider extends AffixLootEntryProvider {

    private static ResourceKey<Level> TWILIGHT = ResourceKey.create(Registries.DIMENSION, Identifier.parse("twilightforest:twilight_forest"));

    protected static final TieredWeights IRONWOOD = TieredWeights.builder()
        .with(WorldTier.FRONTIER, 25, 1)
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 10, 0)
        .build();
    protected static final TieredWeights STEELEAF = TieredWeights.builder()
        .with(WorldTier.FRONTIER, 25, 1)
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 10, 0)
        .build();
    protected static final TieredWeights KNIGHTMETAL = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 25, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights ARCTIC_FIERY = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 25, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights YETI = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 5, 1)
        .with(WorldTier.PINNACLE, 25, 2)
        .build();
    protected static final TieredWeights BOWS = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 7, 1)
        .with(WorldTier.PINNACLE, 7, 1)
        .build();

    public TwilightAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Twilight Affix Loot Entries";
    }

    @Override
    public void generate() {
//        Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
//        armorWeights.put(TFArmorMaterials.IRONWOOD, IRONWOOD);
//        armorWeights.put(TFArmorMaterials.STEELEAF, STEELEAF);
//        armorWeights.put(TFArmorMaterials.KNIGHTMETAL, KNIGHTMETAL);
//        armorWeights.put(TFArmorMaterials.ARCTIC, ARCTIC_FIERY);
//        armorWeights.put(TFArmorMaterials.FIERY, ARCTIC_FIERY);
//        armorWeights.put(TFArmorMaterials.YETI, YETI);
//
//        Map<Tier, TieredWeights> toolWeights = new HashMap<>();
//        toolWeights.put(TFToolMaterials.IRONWOOD, IRONWOOD);
//        toolWeights.put(TFToolMaterials.STEELEAF, STEELEAF);
//        toolWeights.put(TFToolMaterials.KNIGHTMETAL, KNIGHTMETAL);
//        toolWeights.put(TFToolMaterials.ICE, ARCTIC_FIERY);
//        toolWeights.put(TFToolMaterials.FIERY, ARCTIC_FIERY);
//        toolWeights.put(TFToolMaterials.GIANT, YETI);
//        toolWeights.put(TFToolMaterials.GLASS, YETI);
//
//        this.addEntry(BOWS, new ItemStack(TFItems.ENDER_BOW.get()));
//        this.addEntry(BOWS, new ItemStack(TFItems.ICE_BOW.get()));
//        this.addEntry(BOWS, new ItemStack(TFItems.SEEKER_BOW.get()));
//        this.addEntry(BOWS, new ItemStack(TFItems.TRIPLE_BOW.get()));
//        this.addEntry(TieredWeights.forTiersAbove(WorldTier.ASCENT, 5, 1), new ItemStack(TFItems.KNIGHTMETAL_SHIELD.get()));

    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(TWILIGHT), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(TWILIGHT), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = Apotheosis.loc("twilight/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition("twilightforest"));
    }

}
