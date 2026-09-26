package ianm1647.apothic_compats.data.aether;

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
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AetherAffixLootProvider extends AffixLootEntryProvider {

    String mod = "aether";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("aether:the_aether"));

    public AetherAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    protected static final TieredWeights SKYROOT = TieredWeights.builder()
        .with(WorldTier.HAVEN, 25, 1)
        .with(WorldTier.FRONTIER, 10, 0)
        .with(WorldTier.ASCENT, 5, 0)
        .build();
    protected static final TieredWeights HOLYSTONE = TieredWeights.builder()
        .with(WorldTier.FRONTIER, 25, 1)
        .with(WorldTier.ASCENT, 10, 0)
        .with(WorldTier.SUMMIT, 5, 0)
        .build();
    protected static final TieredWeights ZANITE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 15, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights GRAVITITE = TieredWeights.builder()
        .with(WorldTier.ASCENT, 25, 0)
        .with(WorldTier.SUMMIT, 15, 0)
        .with(WorldTier.PINNACLE, 5, 0)
        .build();
    protected static final TieredWeights VALKYRIE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();


    protected static final TieredWeights OBSIDIAN = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights NEPTUNE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights PHOENIX = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights SENTRY = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    protected static final TieredWeights CANDY_CANE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights VAMPIRE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights HOLY = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights LIGHTNING = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();
    protected static final TieredWeights FLAMING = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();


    protected static final TieredWeights RANGED = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    protected static final TieredWeights SHIELDS = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    @Override
    public void generate() {
        AetherItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof TieredItem i) {
                if (i.getTier() == AetherItemTiers.SKYROOT) {
                    addTools(SKYROOT, i);
                }
                if (i.getTier() == AetherItemTiers.HOLYSTONE) {
                    addTools(HOLYSTONE, i);
                }
                if (i.getTier() == AetherItemTiers.ZANITE) {
                    addTools(ZANITE, i);
                }
                if (i.getTier() == AetherItemTiers.GRAVITITE) {
                    addTools(GRAVITITE, i);
                }
                if (i.getTier() == AetherItemTiers.VALKYRIE) {
                    addTools(VALKYRIE, i);
                }
                if (i.getTier() == AetherItemTiers.CANDY_CANE) {
                    addTools(CANDY_CANE, i);
                }
                if (i.getTier() == AetherItemTiers.VAMPIRE) {
                    addTools(VAMPIRE, i);
                }
                if (i.getTier() == AetherItemTiers.HOLY) {
                    addTools(HOLY, i);
                }
                if (i.getTier() == AetherItemTiers.LIGHTNING) {
                    addTools(LIGHTNING, i);
                }
                if (i.getTier() == AetherItemTiers.FLAMING) {
                    addTools(FLAMING, i);
                }
            }

            if (item.get() instanceof ArmorItem a) {
                if (a.getMaterial() == AetherArmorMaterials.ZANITE) {
                    addArmor(ZANITE, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.GRAVITITE) {
                    addArmor(GRAVITITE, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.VALKYRIE) {
                    addArmor(VALKYRIE, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.OBSIDIAN) {
                    addArmor(OBSIDIAN, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.NEPTUNE) {
                    addArmor(NEPTUNE, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.PHOENIX) {
                    addArmor(PHOENIX, a);
                }
                if (a.getMaterial() == AetherArmorMaterials.SENTRY) {
                    addArmor(SENTRY, a);
                }
            }
        });

        addTools(RANGED, AetherItems.PHOENIX_BOW.get());
        addTools(RANGED, AetherItems.ENCHANTED_DART_SHOOTER.get());
        addTools(RANGED, AetherItems.GOLDEN_DART_SHOOTER.get());
        addTools(RANGED, AetherItems.POISON_DART_SHOOTER.get());

    }

    @Override
    public String getName() {
        return "Aether Affix Loot Entries";
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
