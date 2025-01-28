package ianm1647.apothic_compats.data.ars_nouveau;

import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ArsAffixLootProvider extends AffixLootEntryProvider {

    String mod = "ars_nouveau";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public ArsAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SORCERER = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 25, 1)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();
    protected static final TieredWeights ARCANIST = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 25, 1)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();
    protected static final TieredWeights BATTLEMAGE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 25, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights WEAPON = TieredWeights.builder()
            .with(WorldTier.ASCENT, 25, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    @Override
    public void generate() {
        addEntry(new AffixLootEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_HOOD)));
        addEntry(new AffixLootEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_ROBES)));
        addEntry(new AffixLootEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_LEGGINGS)));
        addEntry(new AffixLootEntry(SORCERER, new ItemStack(ItemsRegistry.SORCERER_BOOTS)));

        addEntry(new AffixLootEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_HOOD)));
        addEntry(new AffixLootEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_ROBES)));
        addEntry(new AffixLootEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_LEGGINGS)));
        addEntry(new AffixLootEntry(ARCANIST, new ItemStack(ItemsRegistry.ARCANIST_BOOTS)));

        addEntry(new AffixLootEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_HOOD)));
        addEntry(new AffixLootEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_ROBES)));
        addEntry(new AffixLootEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_LEGGINGS)));
        addEntry(new AffixLootEntry(BATTLEMAGE, new ItemStack(ItemsRegistry.BATTLEMAGE_BOOTS)));

        addEntry(new AffixLootEntry(WEAPON, new ItemStack(ItemsRegistry.ENCHANTERS_SWORD)));
        addEntry(new AffixLootEntry(WEAPON, new ItemStack(ItemsRegistry.ENCHANTERS_SHIELD)));
    }

    @Override
    public String getName() {
        return "Ars Nouveau Affix Loot Entries";
    }


    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID,mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
