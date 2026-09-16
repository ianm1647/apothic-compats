package ianm1647.apothic_compats.data.aether_ii;

import com.aetherteam.aetherii.item.AetherIIItems;
import dev.shadowsoffire.apotheosis.data.AffixLootEntryProvider;
import dev.shadowsoffire.apotheosis.loot.AffixLootEntry;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AetherIIAffixLootProvider extends AffixLootEntryProvider {

    String mod = "aether_ii";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, Identifier.parse("aether_ii:aether_holy_isles"));

    public AetherIIAffixLootProvider(PackOutput output, CompletableFuture<Provider> registries) {
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
    protected static final TieredWeights ARKENIUM = TieredWeights.builder()
            .with(WorldTier.ASCENT, 15, 0)
            .with(WorldTier.SUMMIT, 25, 0)
            .with(WorldTier.PINNACLE, 15, 0)
            .build();
    protected static final TieredWeights GRAVITITE = TieredWeights.builder()
            .with(WorldTier.ASCENT, 10, 0)
            .with(WorldTier.SUMMIT, 15, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();

    protected static final TieredWeights BEAST = TieredWeights.builder()
            .with(WorldTier.HAVEN, 10, 1)
            .with(WorldTier.FRONTIER, 25, 0)
            .build();
    protected static final TieredWeights BURRUKAI = TieredWeights.builder()
            .with(WorldTier.FRONTIER, 10, 0)
            .with(WorldTier.ASCENT, 25, 0)
            .build();
    protected static final TieredWeights NEPTUNE = TieredWeights.builder()
            .with(WorldTier.SUMMIT, 10, 0)
            .with(WorldTier.PINNACLE, 25, 0)
            .build();


    @Override
    public void generate() {
        addTools(SKYROOT,
                AetherIIItems.SKYROOT_SHORTSWORD.get(),
                AetherIIItems.SKYROOT_PIKE.get(),
                AetherIIItems.SKYROOT_HAMMER.get(),
                AetherIIItems.SKYROOT_CROSSBOW.get(),
                AetherIIItems.SKYROOT_SHOVEL.get(),
                AetherIIItems.SKYROOT_PICKAXE.get(),
                AetherIIItems.SKYROOT_AXE.get(),
                AetherIIItems.SKYROOT_TROWEL.get(),
                AetherIIItems.SKYROOT_SHIELD.get());

        addTools(HOLYSTONE,
                AetherIIItems.HOLYSTONE_SHORTSWORD.get(),
                AetherIIItems.HOLYSTONE_PIKE.get(),
                AetherIIItems.HOLYSTONE_HAMMER.get(),
                AetherIIItems.HOLYSTONE_CROSSBOW.get(),
                AetherIIItems.HOLYSTONE_SHOVEL.get(),
                AetherIIItems.HOLYSTONE_PICKAXE.get(),
                AetherIIItems.HOLYSTONE_AXE.get(),
                AetherIIItems.HOLYSTONE_TROWEL.get());

        addTools(ZANITE,
                AetherIIItems.ZANITE_SHORTSWORD.get(),
                AetherIIItems.ZANITE_PIKE.get(),
                AetherIIItems.ZANITE_HAMMER.get(),
                AetherIIItems.ZANITE_CROSSBOW.get(),
                AetherIIItems.ZANITE_SHOVEL.get(),
                AetherIIItems.ZANITE_PICKAXE.get(),
                AetherIIItems.ZANITE_AXE.get(),
                AetherIIItems.ZANITE_TROWEL.get());

        addTools(ARKENIUM,
                AetherIIItems.ARKENIUM_SHORTSWORD.get(),
                AetherIIItems.ARKENIUM_PIKE.get(),
                AetherIIItems.ARKENIUM_HAMMER.get(),
                AetherIIItems.ARKENIUM_CROSSBOW.get(),
                AetherIIItems.ARKENIUM_SHOVEL.get(),
                AetherIIItems.ARKENIUM_PICKAXE.get(),
                AetherIIItems.ARKENIUM_AXE.get(),
                AetherIIItems.ARKENIUM_TROWEL.get());

        addTools(GRAVITITE,
                AetherIIItems.GRAVITITE_SHORTSWORD.get(),
                AetherIIItems.GRAVITITE_PIKE.get(),
                AetherIIItems.GRAVITITE_HAMMER.get(),
                AetherIIItems.GRAVITITE_CROSSBOW.get(),
                AetherIIItems.GRAVITITE_SHOVEL.get(),
                AetherIIItems.GRAVITITE_PICKAXE.get(),
                AetherIIItems.GRAVITITE_AXE.get(),
                AetherIIItems.GRAVITITE_TROWEL.get());

        addArmor(BEAST,
                AetherIIItems.BEAST_PELT_BOOTS.get(),
                AetherIIItems.BEAST_PELT_CHESTPLATE.get(),
                AetherIIItems.BEAST_PELT_LEGGINGS.get(),
                AetherIIItems.BEAST_PELT_HELMET.get());

        addArmor(BURRUKAI,
                AetherIIItems.BURRUKAI_PLATE_BOOTS.get(),
                AetherIIItems.BURRUKAI_PLATE_CHESTPLATE.get(),
                AetherIIItems.BURRUKAI_PLATE_LEGGINGS.get(),
                AetherIIItems.BURRUKAI_PLATE_HELMET.get(),
                AetherIIItems.BURRUKAI_PLATE_SHIELD.get());

        addArmor(ZANITE,
                AetherIIItems.ZANITE_BOOTS.get(),
                AetherIIItems.ZANITE_CHESTPLATE.get(),
                AetherIIItems.ZANITE_LEGGINGS.get(),
                AetherIIItems.ZANITE_HELMET.get(),
                AetherIIItems.ZANITE_SHIELD.get());

        addArmor(ARKENIUM,
                AetherIIItems.ARKENIUM_BOOTS.get(),
                AetherIIItems.ARKENIUM_CHESTPLATE.get(),
                AetherIIItems.ARKENIUM_LEGGINGS.get(),
                AetherIIItems.ARKENIUM_HELMET.get(),
                AetherIIItems.ARKENIUM_SHIELD.get());

        addArmor(GRAVITITE,
                AetherIIItems.GRAVITITE_BOOTS.get(),
                AetherIIItems.GRAVITITE_CHESTPLATE.get(),
                AetherIIItems.GRAVITITE_LEGGINGS.get(),
                AetherIIItems.GRAVITITE_HELMET.get(),
                AetherIIItems.GRAVITITE_SHIELD.get());

        addArmor(NEPTUNE,
                AetherIIItems.NEPTUNE_BOOTS.get(),
                AetherIIItems.NEPTUNE_CHESTPLATE.get(),
                AetherIIItems.NEPTUNE_LEGGINGS.get(),
                AetherIIItems.NEPTUNE_HELMET.get());

    }

    @Override
    public String getName() {
        return "Aether II Affix Loot Entries";
    }

    protected void addTools(TieredWeights weights, Item... tools) {
        for (Item tool : tools) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(AETHER), new ItemStackTemplate(tool), Set.of()));
        }
    }

    protected void addArmor(TieredWeights weights, Item... pieces) {
        for (Item piece : pieces) {
            this.addEntry(new AffixLootEntry(weights, Constraints.forDimension(AETHER), new ItemStackTemplate(piece), Set.of()));
        }
    }

    protected void addEntry(AffixLootEntry entry) {
        Identifier key = ApothicCompats.loc(mod + "/" + BuiltInRegistries.ITEM.getKey(entry.stackTemplate().item().value()).getPath());
        this.addConditionally(key, entry, new ModLoadedCondition(mod));
    }
}
