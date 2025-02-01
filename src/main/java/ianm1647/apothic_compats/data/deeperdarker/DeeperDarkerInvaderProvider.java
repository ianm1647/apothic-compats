package ianm1647.apothic_compats.data.deeperdarker;

import com.ianm1647.ancientreforging.AncientReforging;
import com.kyanite.deeperdarker.content.DDEntities;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.data.InvaderProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.mobs.types.Invader;
import dev.shadowsoffire.apotheosis.mobs.util.BasicBossData;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class DeeperDarkerInvaderProvider extends InvaderProvider {

    String mod = "deeperdarker";

    private static ResourceKey<Level> OTHERSIDE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("deeperdarker:otherside"));

    public DeeperDarkerInvaderProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Deeper Darker Invaders";
    }

    @Override
    public void generate() {
        addBoss("shattered", b -> basicMeleeStats(b)
                .entity(DDEntities.SHATTERED.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));
        addBoss("shriek_worm", b -> basicMeleeStats(b)
                .entity(DDEntities.SHRIEK_WORM.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));
        addBoss("stalker", b -> basicMeleeStats(b)
                .entity(DDEntities.STALKER.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        // TODO ANCIENT

        addAncientBoss("shattered", b -> ancientMeleeStats(b)
                .entity(DDEntities.SHATTERED.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));
        addAncientBoss("shriek_worm", b -> ancientMeleeStats(b)
                .entity(DDEntities.SHRIEK_WORM.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));
        addAncientBoss("stalker", b -> ancientMeleeStats(b)
                .entity(DDEntities.STALKER.value())
                .basicData(c -> meleeGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(OTHERSIDE))
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
    protected void addBoss (String name, UnaryOperator < Invader.Builder > builder){
        this.addConditionally(ApothicCompats.loc(mod + "/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod));
    }

    protected void addAncientBoss (String name, UnaryOperator < Invader.Builder > builder){
        this.addConditionally(ApothicCompats.loc(mod + "/ancient/" + name), builder.apply(Invader.builder()).size(1.0, 1.0).build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static LootRarity ancientRarity (String path){
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}