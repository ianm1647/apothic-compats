package ianm1647.apothic_compats.data.aether;

import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.ancientreforging.AncientReforging;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.concurrent.CompletableFuture;

public class AetherAffixLootProvider extends AffixLootEntryProvider {

    String mod = "aether";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, Identifier.parse("aether:the_aether"));

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


    protected static final TieredWeights BOWS = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    protected static final TieredWeights SHIELDS = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 7, 1)
            .with(WorldTier.PINNACLE, 10, 1)
            .build();

    @Override
    public void generate() {
//        armorWeights.put(AetherArmorMaterials.ZANITE, ZANITE);
//        armorWeights.put(AetherArmorMaterials.GRAVITITE, GRAVITITE);
//        armorWeights.put(AetherArmorMaterials.VALKYRIE, VALKYRIE);
//        armorWeights.put(AetherArmorMaterials.OBSIDIAN, OBSIDIAN);
//        armorWeights.put(AetherArmorMaterials.NEPTUNE, NEPTUNE);
//        armorWeights.put(AetherArmorMaterials.PHOENIX, PHOENIX);
//        armorWeights.put(AetherArmorMaterials.SENTRY, SENTRY);
//
//        toolWeights.put(AetherItemTiers.SKYROOT, SKYROOT);
//        toolWeights.put(AetherItemTiers.HOLYSTONE, HOLYSTONE);
//        toolWeights.put(AetherItemTiers.ZANITE, ZANITE);
//        toolWeights.put(AetherItemTiers.GRAVITITE, GRAVITITE);
//        toolWeights.put(AetherItemTiers.VALKYRIE, VALKYRIE);
//
//        toolWeights.put(AetherItemTiers.CANDY_CANE, CANDY_CANE);
//        toolWeights.put(AetherItemTiers.VAMPIRE, VAMPIRE);
//        toolWeights.put(AetherItemTiers.HOLY, HOLY);
//        toolWeights.put(AetherItemTiers.LIGHTNING, LIGHTNING);
//        toolWeights.put(AetherItemTiers.FLAMING, FLAMING);
//
//        itemWeights.put(AetherItems.PHOENIX_BOW.get(), BOWS);
//
//        addEntry(BOWS, new ItemStack(AetherItems.POISON_DART_SHOOTER.get()));
//        addEntry(BOWS, new ItemStack(AetherItems.ENCHANTED_DART_SHOOTER.get()));
//        addEntry(BOWS, new ItemStack(AetherItems.GOLDEN_DART_SHOOTER.get()));
    }

    @Override
    public String getName() {
        return "Aether Affix Loot Entries";
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
        this.add(AncientReforging.loc(BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath()), entry);
    }
}
