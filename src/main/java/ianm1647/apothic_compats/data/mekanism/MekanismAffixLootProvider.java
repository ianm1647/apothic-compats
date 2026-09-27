package ianm1647.apothic_compats.data.mekanism;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import mekanism.tools.common.config.MekanismToolsConfig;
import mekanism.tools.common.registries.ToolsArmorMaterials;
import mekanism.tools.common.registries.ToolsItems;
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

public class MekanismAffixLootProvider extends AffixLootEntryProvider {

    String mod = "mekanismtools";

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public MekanismAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights LAPIS = TieredWeights.builder()
            .with(WorldTier.HAVEN, 10, 0)
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 5, 0)
            .build();

    protected static final TieredWeights OSMIUM = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights BRONZE = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights STEEL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights GLOWSTONE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights OBSIDIAN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 2, 0)
            .with(WorldTier.PINNACLE, 5, 0)
            .build();

    @Override
    public void generate() {
        ToolsItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == MekanismToolsConfig.materials.lapisLazuli) {
                    addTools(LAPIS, i);
                }
                if (i.getTier() == MekanismToolsConfig.materials.osmium) {
                    addTools(OSMIUM, i);
                }
                if (i.getTier() == MekanismToolsConfig.materials.bronze) {
                    addTools(BRONZE, i);
                }
                if (i.getTier() == MekanismToolsConfig.materials.steel) {
                    addTools(STEEL, i);
                }
                if (i.getTier() == MekanismToolsConfig.materials.refinedGlowstone) {
                    addTools(GLOWSTONE, i);
                }
                if (i.getTier() == MekanismToolsConfig.materials.refinedObsidian) {
                    addTools(OBSIDIAN, i);
                }
            }

            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == ToolsArmorMaterials.LAPIS_LAZULI) {
                    addArmor(LAPIS, a);
                }
                if (a.getMaterial() == ToolsArmorMaterials.OSMIUM) {
                    addArmor(OSMIUM, a);
                }
                if (a.getMaterial() == ToolsArmorMaterials.BRONZE) {
                    addArmor(BRONZE, a);
                }
                if (a.getMaterial() == ToolsArmorMaterials.STEEL) {
                    addArmor(STEEL, a);
                }
                if (a.getMaterial() == ToolsArmorMaterials.REFINED_GLOWSTONE) {
                    addArmor(GLOWSTONE, a);
                }
                if (a.getMaterial() == ToolsArmorMaterials.REFINED_OBSIDIAN) {
                    addArmor(OBSIDIAN, a);
                }
            }
        });

        addTools(LAPIS, ToolsItems.LAPIS_LAZULI_SHIELD.get());
        addTools(OSMIUM, ToolsItems.OSMIUM_SHIELD.get());
        addTools(BRONZE, ToolsItems.BRONZE_SHIELD.get());
        addTools(STEEL, ToolsItems.STEEL_SHIELD.get());
        addTools(GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SHIELD.get());
        addTools(OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SHIELD.get());
    }

    @Override
    public String getName() {
        return "Mekanism Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, new ItemStack(tool)));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, new ItemStack(piece)));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
