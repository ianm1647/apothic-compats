package ianm1647.apothic_compats.data.deep_aether;

import com.thevortex.allthemodium.material.ATMTier;
import com.thevortex.allthemodium.registry.ArmorRegistries;
import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import io.github.razordevs.deep_aether.init.DAItems;
import io.github.razordevs.deep_aether.init.DATiers;
import io.github.razordevs.deep_aether.item.gear.DAArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DeepAetherAffixLootProvider extends AffixLootEntryProvider {

    String mod = "deep_aether";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("aether:the_aether"));

    public DeepAetherAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SKYJADE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 5, 0)
        .with(WorldTier.SUMMIT, 10, 0)
        .build();
    protected static final TieredWeights STRATUS = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 5, 0)
        .with(WorldTier.PINNACLE, 10, 0)
        .build();
    protected static final TieredWeights STORMFORGED = TieredWeights.builder()
        .with(WorldTier.SUMMIT, 5, 0)
        .with(WorldTier.PINNACLE, 10, 0)
        .build();

    @Override
    public void generate() {
        DAItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == DATiers.SKYJADE) {
                    addTools(SKYJADE, i);
                }
                if (i.getTier() == DATiers.STRATUS) {
                    addTools(STRATUS, i);
                }
                if (i.getTier() == DATiers.STORM) {
                    addTools(STORMFORGED, i);
                }
            }

            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == DAArmorMaterials.SKYJADE) {
                    addArmor(SKYJADE, a);
                }
                if (a.getMaterial() == DAArmorMaterials.STRATUS) {
                    addArmor(STRATUS, a);
                }
                if (a.getMaterial() == DAArmorMaterials.STORMFORGED) {
                    addArmor(STORMFORGED, a);
                }
            }
        });

        addTools(STORMFORGED, DAItems.STORM_BOW.get());

    }

    @Override
    public String getName() {
        return "Deep Aether Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(AETHER), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(AETHER), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
