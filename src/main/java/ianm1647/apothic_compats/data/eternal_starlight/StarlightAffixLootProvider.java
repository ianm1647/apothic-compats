package ianm1647.apothic_compats.data.eternal_starlight;

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

public class StarlightAffixLootProvider extends AffixLootEntryProvider {

    String mod = "eternal_starlight";

    private static ResourceKey<Level> STARLIGHT = ResourceKey.create(Registries.DIMENSION, Identifier.parse("eternal_starlight:starlight"));

    public StarlightAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights ALCHEMIST = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights AIR_SAC = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights AMARAMBER = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights MALARITE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights AETHERSENT = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights DEEPSILVER = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights PETAL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights THERMAL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights GLACITE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights STARFIRE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights STARLIT_DIAMOND = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights FLOWGLAZE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights WEAPONS = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 15, 0)
            .build();

    @Override
    public void generate() {
//        armorWeights.put(ESArmorMaterials.ALCHEMIST.asHolder(), ALCHEMIST);
//        armorWeights.put(ESArmorMaterials.AIR_SAC.asHolder(), AIR_SAC);
//        armorWeights.put(ESArmorMaterials.AMARAMBER.asHolder(), AMARAMBER);
//        armorWeights.put(ESArmorMaterials.AETHERSENT.asHolder(), AETHERSENT);
//        armorWeights.put(ESArmorMaterials.DEEPSILVER.asHolder(), DEEPSILVER);
//        armorWeights.put(ESArmorMaterials.THERMAL_SPRINGSTONE.asHolder(), THERMAL);
//        armorWeights.put(ESArmorMaterials.GLACITE.asHolder(), GLACITE);
//
//        toolWeights.put(ESItemTiers.AMARAMBER, AMARAMBER);
//        toolWeights.put(ESItemTiers.AETHERSENT, AETHERSENT);
//        toolWeights.put(ESItemTiers.DEEPSILVER, DEEPSILVER);
//        toolWeights.put(ESItemTiers.MALARITE, MALARITE);
//        toolWeights.put(ESItemTiers.THERMAL_SPRINGSTONE, THERMAL);
//        toolWeights.put(ESItemTiers.PETAL, PETAL);
//        toolWeights.put(ESItemTiers.GLACITE, GLACITE);
//        toolWeights.put(ESItemTiers.STARLIT_DIAMOND, STARLIT_DIAMOND);
//        toolWeights.put(ESItemTiers.STARFIRE, STARFIRE);
//        toolWeights.put(ESItemTiers.FLOWGLAZE, FLOWGLAZE);
//
//        addEntry(WEAPONS, new ItemStack(ESItems.GLACITE_SHIELD.asHolder()));
//        addEntry(WEAPONS, new ItemStack(ESItems.CRESCENT_SPEAR.asHolder()));
//        addEntry(WEAPONS, new ItemStack(ESItems.CRYSTAL_CROSSBOW.asHolder()));
//        addEntry(WEAPONS, new ItemStack(ESItems.MECHANICAL_CROSSBOW.asHolder()));
//        addEntry(WEAPONS, new ItemStack(ESItems.MOONRING_BOW.asHolder()));
//        addEntry(WEAPONS, new ItemStack(ESItems.STARFALL_LONGBOW.asHolder()));
    }

    @Override
    public String getName() {
        return "Eternal Starlight Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(STARLIGHT), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(STARLIGHT), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
