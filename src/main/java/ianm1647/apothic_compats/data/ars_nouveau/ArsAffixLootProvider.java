package ianm1647.apothic_compats.data.ars_nouveau;

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
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ArsAffixLootProvider extends AffixLootEntryProvider {

    String mod = "ars_nouveau";

    public ArsAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SORCERER = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 25, 1)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 5, 0)
            .build();
    protected static final TieredWeights ARCANIST = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 25, 1)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 5, 0)
            .build();
    protected static final TieredWeights BATTLEMAGE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 25, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 5, 0)
            .build();

    protected static final TieredWeights WEAPON = TieredWeights.builder()
            .with(WorldTier.ASCENT, 25, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 5, 0)
            .build();

    @Override
    public void generate() {
//        addEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_HOOD));
//        addEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_ROBES));
//        addEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_LEGGINGS));
//        addEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_BOOTS));
//
//        addEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_HOOD));
//        addEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_ROBES));
//        addEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_LEGGINGS));
//        addEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_BOOTS));
//
//        addEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_HOOD));
//        addEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_ROBES));
//        addEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_LEGGINGS));
//        addEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_BOOTS));
//
//        addEntry(WEAPON, new ItemStack(ItemsRegistry.ENCHANTERS_SWORD));
//        addEntry(WEAPON, new ItemStack(ItemsRegistry.ENCHANTERS_SHIELD));
    }

    @Override
    public String getName() {
        return "Ars Nouveau Affix Loot Entries";
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
