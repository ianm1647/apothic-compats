package ianm1647.apothic_compats.data.the_bumblezone;

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

public class BumblezoneAffixLootProvider extends AffixLootEntryProvider {

    String mod = "the_bumblezone";

    private static ResourceKey<Level> BUMBLEZONE = ResourceKey.create(Registries.DIMENSION, Identifier.parse("the_bumblezone:the_bumblezone"));

    public BumblezoneAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights BEE = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 5, 0)
            .build();

    @Override
    public void generate() {
//        armorWeights.put(BzArmorMaterials.BEE_MATERIAL.holder(), BEE);
//        addEntry(BEE, new ItemStack(BzItems.STINGER_SPEAR.get()));
//        addEntry(BEE, new ItemStack(BzItems.HONEY_CRYSTAL_SHIELD.get()));

    }

    @Override
    public String getName() {
        return "The Bumblezone Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(BUMBLEZONE), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(BUMBLEZONE), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
