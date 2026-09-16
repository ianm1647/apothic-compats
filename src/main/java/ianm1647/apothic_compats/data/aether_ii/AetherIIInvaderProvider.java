package ianm1647.apothic_compats.data.aether_ii;

import com.aetherteam.aetherii.entity.AetherIIEntityTypes;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.mobs.util.BasicBossData;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.ancientreforging.AncientReforging;
import dev.shadowsoffire.apotheosis.data.InvaderProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.mobs.types.Invader;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class AetherIIInvaderProvider extends InvaderProvider {

    String mod = "aether_ii";

    private static ResourceKey<Level> AETHER = ResourceKey.create(Registries.DIMENSION, Identifier.parse("aether_ii:aether_holy_isles"));

    public AetherIIInvaderProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Aether II Invaders";
    }

    @Override
    public void generate() {

        addBoss("cockatrice", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.COCKATRICE.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("zephyr", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.ZEPHYR.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("tempest", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.TEMPEST.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("aerwhale", b -> basicMeleeStats(b)
                .entity(AetherIIEntityTypes.AERWHALE.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.onlyFor(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("burrukai", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.ARCTIC_BURRUKAI.value())
                .entity(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI.get())
                .entity(AetherIIEntityTypes.MAGNETIC_BURRUKAI.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("swet", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.BLUE_SWET.value())
                .entity(AetherIIEntityTypes.GOLDEN_SWET.get())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("arkenium_taluton", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.ARKENIUM_TALUTON.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("gravitite_taluton", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.GRAVITITE_TALUTON.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("sentry_golem", b -> basicRangedStats(b)
                .entity(AetherIIEntityTypes.SENTRY_GOLEM.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        /*

        TODO: ANCIENT
        TODO: ANCIENT (lol i just needed a non-gray separator)
        TODO: ANCIENT

         */

        addAncientBoss("cockatrice", b -> ancientMeleeStats(b)
                .entity(AetherIIEntityTypes.COCKATRICE.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("zephyr", b -> ancientRangedStats(b)
                .entity(AetherIIEntityTypes.ZEPHYR.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("tempest", b -> ancientRangedStats(b)
                .entity(AetherIIEntityTypes.TEMPEST.value())
                .basicData(c -> rangedGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("arkenium_taluton", b -> ancientMeleeStats(b)
                .entity(AetherIIEntityTypes.ARKENIUM_TALUTON.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("sentry_golem", b -> ancientMeleeStats(b)
                .entity(AetherIIEntityTypes.SENTRY_GOLEM.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(AETHER))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

    }

    protected static Invader.Builder ancientMeleeStats(Invader.Builder builder) {
        LootRarity ancient = ancientRarity("ancient");
        return builder
                .stats(ancient, c -> c
                        .enchantChance(0.95F)
                        .enchLevels(40, 30)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 220, 450)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.5F, 0.8F)
                        .modifier(Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.8F, 1.5F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(1.2F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    protected static Invader.Builder ancientRangedStats(Invader.Builder builder) {
        LootRarity ancient = ancientRarity("ancient");
        return builder
                .stats(ancient, c -> c
                        .enchantChance(0.95F)
                        .enchLevels(40, 30)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 220, 450)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.5F, 0.8F)
                        .modifier(ALObjects.Attributes.PROJECTILE_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.9F, 1.8F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(1F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    @Override
    protected void addBoss(String name, UnaryOperator<Invader.Builder> builder) {
        this.addConditionally(ApothicCompats.loc(mod + "/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod));
    }

    protected void addAncientBoss(String name, UnaryOperator<Invader.Builder> builder) {
        this.addConditionally(ApothicCompats.loc(mod + "/ancient/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
