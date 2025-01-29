package ianm1647.apothic_compats.data.mekanism;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
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
        armorWeights.put(ToolsArmorMaterials.LAPIS_LAZULI, LAPIS);
        armorWeights.put(ToolsArmorMaterials.OSMIUM, OSMIUM);
        armorWeights.put(ToolsArmorMaterials.BRONZE, BRONZE);
        armorWeights.put(ToolsArmorMaterials.STEEL, STEEL);
        armorWeights.put(ToolsArmorMaterials.REFINED_GLOWSTONE, GLOWSTONE);
        armorWeights.put(ToolsArmorMaterials.REFINED_OBSIDIAN, OBSIDIAN);

        toolWeights.put(MekanismToolsConfig.materials.lapisLazuli, LAPIS);
        toolWeights.put(MekanismToolsConfig.materials.osmium, OSMIUM);
        toolWeights.put(MekanismToolsConfig.materials.bronze, BRONZE);
        toolWeights.put(MekanismToolsConfig.materials.steel, STEEL);
        toolWeights.put(MekanismToolsConfig.materials.refinedGlowstone, GLOWSTONE);
        toolWeights.put(MekanismToolsConfig.materials.refinedObsidian, OBSIDIAN);

        addEntry(new AffixLootEntry(LAPIS, ToolsItems.LAPIS_LAZULI_SHIELD.getItemStack()));
        addEntry(new AffixLootEntry(OSMIUM, ToolsItems.OSMIUM_SHIELD.getItemStack()));
        addEntry(new AffixLootEntry(BRONZE, ToolsItems.BRONZE_SHIELD.getItemStack()));
        addEntry(new AffixLootEntry(STEEL, ToolsItems.STEEL_SHIELD.getItemStack()));
        addEntry(new AffixLootEntry(GLOWSTONE, ToolsItems.REFINED_GLOWSTONE_SHIELD.getItemStack()));
        addEntry(new AffixLootEntry(OBSIDIAN, ToolsItems.REFINED_OBSIDIAN_SHIELD.getItemStack()));

        for (Item i : BuiltInRegistries.ITEM) {
            if (!mod.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace())) {
                continue;
            }

            LootCategory cat = LootCategory.forItem(i.getDefaultInstance());
            if (cat.isNone()) {
                continue;
            }

            if (i instanceof TieredItem t) {
                TieredWeights weights = toolWeights.get(t.getTier());
                if (weights != null) {
                    this.addEntry(new AffixLootEntry(weights, new ItemStack(i)));
                }
            }
            else if (i instanceof ArmorItem a && a.getType() != ArmorItem.Type.BODY) {
                TieredWeights weights = armorWeights.get(a.getMaterial());
                if (weights != null) {
                    this.addEntry(new AffixLootEntry(weights, new ItemStack(i)));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Mekanism Affix Loot Entries";
    }


    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath(ApothicCompats.MODID,mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
