package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.data.InvaderProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.mobs.types.Invader;
import dev.shadowsoffire.apotheosis.mobs.util.BasicBossData;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import io.redspace.irons_artifice.registry.EntityRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArtificeInvaderProvider extends InvaderProvider {
    String mod = "irons_artifice";

    public ArtificeInvaderProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Artifice Invaders";
    }

    @Override
    public void generate() {
        addBoss("gunslinger", b -> basicGunStats(b)
                .entity(EntityRegistry.GUNSLINGER.get())
                .basicData(c -> gunGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addBoss("illificer", b -> basicGunStats(b)
                .entity(EntityRegistry.ILLIFICER.get())
                .basicData(c -> gunGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.SUMMIT, DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        //TODO: ANCIENT

        addAncientBoss("gunslinger", b -> ancientGunStats(b)
                .entity(EntityRegistry.GUNSLINGER.get())
                .basicData(c -> gunGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));

        addAncientBoss("illificer", b -> ancientGunStats(b)
                .entity(EntityRegistry.ILLIFICER.get())
                .basicData(c -> gunGear(c)
                        .name(Component.literal(BasicBossData.NAME_GEN))
                        .weights(TieredWeights.forTiersAbove(WorldTier.PINNACLE, 10, DEFAULT_QUALITY))
                        .constraints(Constraints.forDimension(Level.OVERWORLD))
                        .bonusLoot(Apoth.LootTables.BONUS_BOSS_DROPS, Apoth.LootTables.BONUS_RARE_BOSS_DROPS)));
    }

    protected static Invader.Builder basicGunStats(Invader.Builder builder) {
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");

        return builder
                .stats(uncommon, c -> c
                        .enchantChance(0.25F)
                        .enchLevels(20, 12)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 20, 50)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.05F, 0.10F)
                        .modifier(Comp.Attributes.Artifice.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.2F, 0.4F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(0.25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F))
                .stats(rare, c -> c
                        .enchantChance(0.35F)
                        .enchLevels(23, 15)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 45, 70)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.15F, 0.25F)
                        .modifier(Comp.Attributes.Artifice.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.3F, 0.55F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(0.4F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F))
                .stats(epic, c -> c
                        .enchantChance(0.6F)
                        .enchLevels(35, 25)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 95, 120)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.25F, 0.40F)
                        .modifier(Comp.Attributes.Artifice.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.45F, 0.65F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(0.5F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(4F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(10F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F))
                .stats(mythic, c -> c
                        .enchantChance(0.75F)
                        .enchLevels(35, 25)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 125, 150)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.3F, 0.65F)
                        .modifier(Comp.Attributes.Artifice.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.75F, 1.2F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(0.8F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(10F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    protected static Invader.Builder ancientGunStats(Invader.Builder builder) {
        LootRarity ancient = ancientRarity("ancient");
        return builder
                .stats(ancient, c -> c
                        .enchantChance(0.95F)
                        .enchLevels(40, 30)
                        .effect(1, MobEffects.FIRE_RESISTANCE)
                        .modifier(Attributes.MAX_HEALTH, AttributeModifier.Operation.ADD_VALUE, 220, 450)
                        .modifier(Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.5F, 0.8F)
                        .modifier(Comp.Attributes.Artifice.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 0.9F, 1.8F)
                        .modifier(Attributes.KNOCKBACK_RESISTANCE, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(1F))
                        .modifier(Attributes.ARMOR, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(20F))
                        .modifier(Attributes.ARMOR_TOUGHNESS, AttributeModifier.Operation.ADD_VALUE, StepFunction.constant(25F))
                        .modifier(Attributes.SCALE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, -0.15F, 0.25F));
    }

    public static BasicBossData.Builder gunGear(BasicBossData.Builder builder) {
        builder.gearSets(WorldTier.HAVEN, "#haven_gun");
        builder.gearSets(WorldTier.FRONTIER, "#frontier_gun");
        builder.gearSets(WorldTier.ASCENT, "#ascent_gun");
        builder.gearSets(WorldTier.SUMMIT, "#summit_gun");
        builder.gearSets(WorldTier.PINNACLE, "#pinnacle_gun");
        return builder;
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