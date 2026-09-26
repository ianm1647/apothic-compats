package ianm1647.apothic_compats.data.ars_nouveau;

import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import com.hollingsworth.arsnouveau.setup.registry.MaterialRegistry;
import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.registry.ArmorRegistries;
import com.thevortex.allthemodium.registry.ModRegistry;
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
        ItemsRegistry.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == MaterialRegistry.LIGHT) {
                    addArmor(SORCERER, a);
                }
                if (a.getMaterial() == MaterialRegistry.MEDIUM) {
                    addArmor(ARCANIST, a);
                }
                if (a.getMaterial() == MaterialRegistry.HEAVY) {
                    addArmor(BATTLEMAGE, a);
                }
            }
        });

        addTools(WEAPON, ItemsRegistry.ENCHANTERS_SWORD.get(), ItemsRegistry.ENCHANTERS_SHIELD.get());
    }

    @Override
    public String getName() {
        return "Ars Nouveau Affix Loot Entries";
    }


    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(Level.OVERWORLD), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
