package ianm1647.apothic_compats.data.farmersdelight;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FarmersDelightAffixLootProvider extends AffixLootEntryProvider {

    String mod = "farmersdelight";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public FarmersDelightAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights FLINT = TieredWeights.onlyFor(WorldTier.HAVEN, 25, 0);
    protected static final TieredWeights GOLD = TieredWeights.builder()
            .with(WorldTier.HAVEN, 5, 0)
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 5, 0)
            .build();
    protected static final TieredWeights IRON = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 25, 1)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();
    protected static final TieredWeights DIAMOND = TieredWeights.builder()
            .with(WorldTier.ASCENT, 25, 0)
            .with(WorldTier.SUMMIT, 25, 0)
            .with(WorldTier.PINNACLE, 5, 0)
            .build();
    protected static final TieredWeights NETHERITE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 1)
            .with(WorldTier.PINNACLE, 25, 2)
            .build();

    @Override
    public void generate() {
        addEntry(IRON, new ItemStack(ModItems.IRON_KNIFE.get()));
        addEntry(DIAMOND, new ItemStack(ModItems.DIAMOND_KNIFE.get()));
        addNetherEntry(DIAMOND, new ItemStack(ModItems.DIAMOND_KNIFE.get()));
        addNetherEntry(NETHERITE, new ItemStack(ModItems.NETHERITE_KNIFE.get()));
    }

    @Override
    public String getName() {
        return "Farmers Delight Affix Loot Entries";
    }


    protected void addEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), stack, Set.of()), new ModLoadedCondition(mod));
    }

    protected void addNetherEntry(TieredWeights weights, ItemStack stack) {
        ResourceLocation key = ApothicCompats.loc(mod + "/nether/" + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
        this.addConditionally(key, new AffixLootEntry(weights, Constraints.forDimension(Level.NETHER), stack, Set.of()), new ModLoadedCondition(mod));
    }
}
