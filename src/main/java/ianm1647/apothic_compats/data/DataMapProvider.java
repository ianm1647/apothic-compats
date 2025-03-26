package ianm1647.apothic_compats.data;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.data.ApothDataMapProvider;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.mobs.InvaderSpawnRules;
import dev.shadowsoffire.apotheosis.mobs.util.SurfaceType;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.dimension.DimensionType;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class DataMapProvider extends ApothDataMapProvider {
    public DataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    public static final ResourceKey<DimensionType> AETHER = register("aether", "the_aether");
    public static final ResourceKey<DimensionType> OTHER = register("allthemodium", "the_other");
    public static final ResourceKey<DimensionType> STARLIGHT = register("eternal_starlight", "starlight");
    public static final ResourceKey<DimensionType> OTHERSIDE = register("deeperdarker", "otherside");
    public static final ResourceKey<DimensionType> BUMBLEZONE = register("the_bumblezone", "the_bumblezone");
    public static final ResourceKey<DimensionType> UNDERGARDEN = register("undergarden", "undergarden");

    @Override
    protected void gather() {
        Builder<InvaderSpawnRules, DimensionType> invaderRules = builder(Apoth.DataMaps.INVADER_SPAWN_RULES);

        invaderRules.add(AETHER, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.NEEDS_SKY), false, new ModLoadedCondition(AETHER.location().getNamespace()));

        invaderRules.add(OTHER, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.NEEDS_SKY), false, new ModLoadedCondition(OTHER.location().getNamespace()));

        invaderRules.add(STARLIGHT, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.NEEDS_SKY), false, new ModLoadedCondition(STARLIGHT.location().getNamespace()));

        invaderRules.add(OTHERSIDE, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.ANY), false, new ModLoadedCondition(OTHERSIDE.location().getNamespace()));

        invaderRules.add(BUMBLEZONE, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.ANY), false, new ModLoadedCondition(BUMBLEZONE.location().getNamespace()));

        invaderRules.add(UNDERGARDEN, new InvaderSpawnRules(
                Map.of(
                        WorldTier.HAVEN, 0F,
                        WorldTier.FRONTIER, 0.013F,
                        WorldTier.ASCENT, 0.018F,
                        WorldTier.SUMMIT, 0.025F,
                        WorldTier.PINNACLE, 0.03F),
                Optional.empty(),
                SurfaceType.ANY), false, new ModLoadedCondition(UNDERGARDEN.location().getNamespace()));

        Builder<LootCategory, Item> catOverrides = builder(Apoth.DataMaps.LOOT_CATEGORY_OVERRIDES);

        catOverrides.add(BuiltInRegistries.ITEM.wrapAsHolder(Apoth.Items.POTION_CHARM.value()), Apoth.LootCategories.NONE, true);
        catOverrides.add(ModTags.Items.CURIO_BLACKLIST, Apoth.LootCategories.NONE, true);
    }

    private static ResourceKey<DimensionType> register(String mod, String name) {
        return ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(mod, name));
    }
}
