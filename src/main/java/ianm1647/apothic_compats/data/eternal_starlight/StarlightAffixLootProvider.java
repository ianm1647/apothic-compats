package ianm1647.apothic_compats.data.eternal_starlight;

import cn.leolezury.eternalstarlight.common.item.combat.ESItemTiers;
import cn.leolezury.eternalstarlight.common.registry.ESArmorMaterials;
import cn.leolezury.eternalstarlight.common.registry.ESItems;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.combat.AetherArmorMaterials;
import com.aetherteam.aether.item.combat.AetherItemTiers;
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
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class StarlightAffixLootProvider extends AffixLootEntryProvider {

    String mod = "eternal_starlight";

    private static ResourceKey<Level> STARLIGHT = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("eternal_starlight:starlight"));

    public Map<Holder<ArmorMaterial>, TieredWeights> armorWeights = new HashMap<>();
    public Map<Tier, TieredWeights> toolWeights = new HashMap<>();
    public Map<Item, TieredWeights> itemWeights = new HashMap<>();

    public StarlightAffixLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights ALCHEMIST = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights AIR_SAC = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights AMARAMBER = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights MALARITE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights AETHERSENT = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .build();

    protected static final TieredWeights DEEPSILVER = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights PETAL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights THERMAL = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights GLACITE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 5, 0)
            .with(WorldTier.SUMMIT, 10, 0)
            .build();

    protected static final TieredWeights STARFIRE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights STARLIT_DIAMOND = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights FLOWGLAZE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 5, 0)
            .with(WorldTier.PINNACLE, 10, 0)
            .build();

    protected static final TieredWeights WEAPONS = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 5, 0)
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 15, 0)
            .build();

    @Override
    public void generate() {
        ESItems.ITEMS.registry().stream().forEach(item -> {
            String name = item.getDescriptionId();
            if (item instanceof TieredItem i && !name.contains("hoe")) {
                if (i.getTier() == ESItemTiers.AMARAMBER) {
                    addTools(AMARAMBER, i);
                }
                if (i.getTier() == ESItemTiers.AETHERSENT) {
                    addTools(AETHERSENT, i);
                }
                if (i.getTier() == ESItemTiers.DEEPSILVER) {
                    addTools(DEEPSILVER, i);
                }
                if (i.getTier() == ESItemTiers.MALARITE) {
                    addTools(MALARITE, i);
                }
                if (i.getTier() == ESItemTiers.THERMAL_SPRINGSTONE) {
                    addTools(THERMAL, i);
                }
                if (i.getTier() == ESItemTiers.PETAL) {
                    addTools(PETAL, i);
                }
                if (i.getTier() == ESItemTiers.GLACITE) {
                    addTools(GLACITE, i);
                }
                if (i.getTier() == ESItemTiers.STARLIT_DIAMOND) {
                    addTools(STARLIT_DIAMOND, i);
                }
                if (i.getTier() == ESItemTiers.STARFIRE) {
                    addTools(STARFIRE, i);
                }
                if (i.getTier() == ESItemTiers.FLOWGLAZE) {
                    addTools(FLOWGLAZE, i);
                }
            }

            if (item instanceof ArmorItem a) {
                if (a.getMaterial() == ESArmorMaterials.ALCHEMIST.asHolder()) {
                    addArmor(ALCHEMIST, a);
                }
                if (a.getMaterial() == ESArmorMaterials.AIR_SAC.asHolder()) {
                    addArmor(AIR_SAC, a);
                }
                if (a.getMaterial() == ESArmorMaterials.AMARAMBER.asHolder()) {
                    addArmor(AMARAMBER, a);
                }
                if (a.getMaterial() == ESArmorMaterials.AETHERSENT.asHolder()) {
                    addArmor(AETHERSENT, a);
                }
                if (a.getMaterial() == ESArmorMaterials.DEEPSILVER.asHolder()) {
                    addArmor(DEEPSILVER, a);
                }
                if (a.getMaterial() == ESArmorMaterials.THERMAL_SPRINGSTONE.asHolder()) {
                    addArmor(THERMAL, a);
                }
                if (a.getMaterial() == ESArmorMaterials.GLACITE.asHolder()) {
                    addArmor(GLACITE, a);
                }
            }
        });

        addTools(WEAPONS, ESItems.GLACITE_SHIELD.get());
        addTools(WEAPONS, ESItems.CRESCENT_SPEAR.get());
        addTools(WEAPONS, ESItems.CRYSTAL_CROSSBOW.get());
        addTools(WEAPONS, ESItems.MECHANICAL_CROSSBOW.get());
        addTools(WEAPONS, ESItems.MOONRING_BOW.get());
        addTools(WEAPONS, ESItems.STARFALL_LONGBOW.get());

    }

    @Override
    public String getName() {
        return "Eternal Starlight Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(STARLIGHT), new ItemStack(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(STARLIGHT), new ItemStack(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        ResourceLocation key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stack().getItem()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
