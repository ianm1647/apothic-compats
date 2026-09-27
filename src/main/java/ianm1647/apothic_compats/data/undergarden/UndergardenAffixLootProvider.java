package ianm1647.apothic_compats.data.undergarden;

import com.thevortex.allthemodium.registry.ModRegistry;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import quek.undergarden.registry.UGArmorMaterials;
import quek.undergarden.registry.UGItemTiers;
import quek.undergarden.registry.UGItems;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UndergardenAffixLootProvider extends AffixLootEntryProvider {

    String mod = "undergarden";

    private static ResourceKey<Level> UNDERGARDEN = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("undergarden:undergarden"));

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
        UGItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == UGItemTiers.CLOGGRUM) {
                    addTools(CLOGGRUM, i);
                }
                if (i.getTier() == UGItemTiers.FROSTSTEEL) {
                    addTools(FROSTSTEEL, i);
                }
                if (i.getTier() == UGItemTiers.UTHERIUM) {
                    addTools(UTHERIUM, i);
                }
                if (i.getTier() == UGItemTiers.FORGOTTEN) {
                    addTools(FORGOTTEN, i);
                }
            }
            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == UGArmorMaterials.CLOGGRUM) {
                    addArmor(CLOGGRUM, a);
                }
                if (a.getMaterial() == UGArmorMaterials.ANCIENT) {
                    addArmor(ANCIENT, a);
                }
                if (a.getMaterial() == UGArmorMaterials.FROSTSTEEL) {
                    addArmor(FROSTSTEEL, a);
                }
                if (a.getMaterial() == UGArmorMaterials.UTHERIUM) {
                    addArmor(UTHERIUM, a);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Undergarden Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(UNDERGARDEN), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
