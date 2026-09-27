package ianm1647.apothic_compats.data.twilight;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import twilightforest.init.TFArmorMaterials;
import twilightforest.init.TFItems;
import twilightforest.util.TFToolMaterials;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TwilightAffixLootProvider extends AffixLootEntryProvider {

    private static ResourceKey<Level> TWILIGHT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("twilightforest:twilight_forest"));

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
    public void generate() {
        TFItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == TFToolMaterials.IRONWOOD) {
                    addTools(IRONWOOD, i);
                }
                if (i.getTier() == TFToolMaterials.STEELEAF) {
                    addTools(STEELEAF, i);
                }
                if (i.getTier() == TFToolMaterials.KNIGHTMETAL) {
                    addTools(KNIGHTMETAL, i);
                }
                if (i.getTier() == TFToolMaterials.ICE) {
                    addTools(ARCTIC_FIERY, i);
                }
                if (i.getTier() == TFToolMaterials.FIERY) {
                    addTools(ARCTIC_FIERY, i);
                }
                if (i.getTier() == TFToolMaterials.GIANT) {
                    addTools(YETI, i);
                }
                if (i.getTier() == TFToolMaterials.GLASS) {
                    addTools(YETI, i);
                }
            }
            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == TFArmorMaterials.IRONWOOD) {
                    addArmor(IRONWOOD, a);
                }
                if (a.getMaterial() == TFArmorMaterials.STEELEAF) {
                    addArmor(STEELEAF, a);
                }
                if (a.getMaterial() == TFArmorMaterials.KNIGHTMETAL) {
                    addArmor(KNIGHTMETAL, a);
                }
                if (a.getMaterial() == TFArmorMaterials.ARCTIC) {
                    addArmor(ARCTIC_FIERY, a);
                }
                if (a.getMaterial() == TFArmorMaterials.FIERY) {
                    addArmor(ARCTIC_FIERY, a);
                }
                if (a.getMaterial() == TFArmorMaterials.YETI) {
                    addArmor(YETI, a);
                }
            }
        });

        addTools(BOWS, TFItems.ENDER_BOW.get());
        addTools(BOWS, TFItems.ICE_BOW.get());
        addTools(BOWS, TFItems.SEEKER_BOW.get());
        addTools(BOWS, TFItems.TRIPLE_BOW.get());
        addTools(TieredWeights.forTiersAbove(WorldTier.ASCENT, 5, 1), TFItems.KNIGHTMETAL_SHIELD.get());

    }

    @Override
    public String getName() {
        return "Twilight Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(TWILIGHT), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(TWILIGHT), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = Apotheosis.loc("twilight/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition("twilightforest"));
    }
}
