package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.affix.*;
import dev.shadowsoffire.apotheosis.affix.effect.*;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apotheosis.util.ApothMiscUtil;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.dynreg.DynamicHolder;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.ancientreforging.AncientReforging;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.data.AffixProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import ianm1647.apothic_compats.affix.irons_artifice.*;
import io.redspace.irons_artifice.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArtificeAffixProvider extends AffixProvider {
    String mod = "irons_artifice";

    public ArtificeAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Iron's Artifice Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        this.addAttribute("gun", "murderous", AttributeRegistry.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 0.1F, 0.2F)
                .value(uncommon, 0.3F, 0.4F)
                .value(rare, 0.5F, 0.6F)
                .value(epic, 0.7F,  0.8F)
                .value(mythic, 0.9F, 1.0F));

        this.addAttribute("gun", "violent", AttributeRegistry.GUN_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 2, 3)
                .value(uncommon, 4, 5)
                .value(rare, 6, 7)
                .value(epic, 8, 9)
                .value(mythic, 10, 12));

        this.addAttribute("gun", "agile", AttributeRegistry.FIRE_RATE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common,0.1f , 0.2f)
                .value(uncommon, 0.2f, 0.3f)
                .value(rare, 0.3f, 0.4f)
                .value(epic, 0.4f, 0.5f)
                .value(mythic, 0.5f, 0.6f));

        this.addAttribute("gun", "multishot", AttributeRegistry.PROJECTILE_COUNT, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(rare, 1)
                .value(epic, 2)
                .value(mythic, 3));

        this.addAttribute("gun", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 0.25F, 0.4F)
                .value(uncommon, 0.25F, 0.4F)
                .value(rare, 0.35F, 0.5F)
                .value(epic, 0.35F, 0.6F)
                .value(mythic, 0.55F, 0.65F));

        this.addAttribute("gun", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .step(0.25F)
                .value(common, 2F, 4F)
                .value(uncommon, 2F, 4F)
                .value(rare, 4F, 8F)
                .value(epic, 5F, 10F)
                .value(mythic, 5F, 12F));

        this.addAttribute("gun", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.25F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("gun", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.10F, 0.25F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.25F, 0.55F));

        this.addAttribute("gun", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.15F, 0.3F)
                .value(rare, 0.15F, 0.3F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.2F, 0.4F));

        this.addMobEffect("gun", "shulkers", MobEffects.LEVITATION, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(epic, 20, 80, StepFunction.fromBounds(0, 1, 0.25F), 140)
                .value(mythic, 20, 100, StepFunction.fromBounds(0, 2, 0.25F), 140));

        this.addMobEffect("gun", "acidic", ALObjects.MobEffects.SUNDERING, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .limit(4)
                .value(mythic, 80, 160, 0, 40));

        this.addMobEffect("gun", "ensnaring", MobEffects.SLOWNESS, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(uncommon, 40, 80, 0, 160)
                .value(rare, 40, 100, 0, 160)
                .value(epic, 40, 120, StepFunction.fromBounds(0, 1, 0.25F), 160)
                .value(mythic, 80, 160, StepFunction.fromBounds(0, 2, 0.25F), 160));

        this.addMobEffect("gun", "fleeting", MobEffects.SPEED, BulletModifierAffix.Target.BULLET_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(uncommon, 100, 200, 0, 0)
                .value(rare, 100, 200, 0, 0)
                .value(epic, 100, 200, StepFunction.fromBounds(0, 1, 0.25F), 0)
                .value(mythic, 100, 300, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addMobEffect("gun", "grievous", ALObjects.MobEffects.GRIEVOUS, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(uncommon, 200, 200, 0, 500)
                .value(rare, 200, 300, 0, 500)
                .value(epic, 200, 300, StepFunction.fromBounds(0, 1, 0.25F), 400)
                .value(mythic, 200, 300, StepFunction.fromBounds(0, 2, 0.25F), 400));

        this.addMobEffect("gun", "ivy_laced", MobEffects.POISON, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .limit(5)
                .value(rare, 100, 160, 0, 40)
                .value(epic, 100, 160, StepFunction.fromBounds(0, 1, 0.25F), 40)
                .value(mythic, 100, 200, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addMobEffect("gun", "blighted", MobEffects.WITHER, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(epic, 160, 200, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 160, 200, StepFunction.fromBounds(0, 3, 0.25F), 300));

        this.addMobEffect("gun", "deathbound", MobEffects.WITHER, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("gun/mob_effect/blighted")))
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .limit(4)
                .value(mythic, 100, 200, 1, 40));

        this.addConditionally(ApothicCompats.loc("gun/telepathic"), new TelepathicGunAffix(
                        AffixDefinition.builder(AffixType.BASIC_EFFECT)
                                .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                                .build(),
                        linkedSet(rare, epic, mythic)), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("gun/festive"),
                FestiveAffix.builder()
                        .categories(Comp.LootCategories.Artifice.GUN)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(epic, StepFunction.fromBounds(0.02F, 0.05F, 0.005F), 20)
                        .value(mythic, StepFunction.fromBounds(0.03F, 0.06F, 0.005F), 20)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("gun/magical"), new MagicalBulletAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .build(),
                linkedSet(rare, epic, mythic)), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("gun/infinite"), new InfiniteAmmoAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(5, DEFAULT_QUALITY))
                        .build(),
                linkedSet(mythic)), new ModLoadedCondition(mod));

        this.addAncientAttribute("gun", "murderous", AttributeRegistry.GUN_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 1.0F, 1.5F));

        this.addAncientAttribute("gun", "violent", AttributeRegistry.GUN_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 12, 20));

        this.addAncientAttribute("gun", "agile", AttributeRegistry.FIRE_RATE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 0.6f, 0.8f));

        this.addAncientAttribute("gun", "multishot", AttributeRegistry.PROJECTILE_COUNT, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 4));

        this.addAncientAttribute("gun", "experienced", ALObjects.Attributes.EXPERIENCE_GAINED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 0.65F, 0.9F));

        this.addAncientAttribute("gun", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .step(0.25F)
                .value(ancient, 8F, 16F));

        this.addAncientAttribute("gun", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 0.35F, 0.6F));

        this.addAncientAttribute("gun", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 0.3F, 0.65F));

        this.addAncientAttribute("gun", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 0.4F, 0.8F));

        this.addAncientMobEffect("gun", "shulkers", MobEffects.LEVITATION, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 40, 200, StepFunction.fromBounds(0, 3, 0.5F), 70));

        this.addAncientMobEffect("gun", "acidic", ALObjects.MobEffects.SUNDERING, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .value(ancient, 160, 320, 0, 30));

        this.addAncientMobEffect("gun", "ensnaring", MobEffects.SLOWNESS, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 150, 350, StepFunction.fromBounds(0, 3, 0.25F), 80));

        this.addAncientMobEffect("gun", "fleeting", MobEffects.SPEED, BulletModifierAffix.Target.BULLET_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 200, 500, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addAncientMobEffect("gun", "grievous", ALObjects.MobEffects.GRIEVOUS, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 400, 600, StepFunction.fromBounds(0, 3, 0.5F), 200));

        this.addAncientMobEffect("gun", "ivy_laced", MobEffects.POISON, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .value(ancient, 200, 400, StepFunction.fromBounds(0, 3, 0.5F), 20));

        this.addAncientMobEffect("gun", "blighted", MobEffects.WITHER, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Comp.LootCategories.Artifice.GUN)
                .value(ancient, 320, 500, StepFunction.fromBounds(0, 4, 0.5F), 100));

        this.addAncientMobEffect("gun", "deathbound", MobEffects.WITHER, BulletModifierAffix.Target.BULLET_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("gun/mob_effect/blighted")))
                .categories(Comp.LootCategories.Artifice.GUN)
                .stacking()
                .value(ancient, 200, 400, 2, 20));

        this.addConditionally(ApothicCompats.loc("gun/ancient/telepathic"), new TelepathicGunAffix(
                        AffixDefinition.builder(AffixType.BASIC_EFFECT)
                                .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                                .build(),
                        linkedSet(ancient)), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("gun/ancient/festive"),
                FestiveAffix.builder()
                        .categories(Comp.LootCategories.Artifice.GUN)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(ancient, StepFunction.fromBounds(0.05F, 0.12F, 0.005F), 20)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("gun/ancient/magical"), new MagicalBulletAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .build(),
                linkedSet(ancient)), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("gun/ancient/infinite"), new InfiniteAmmoAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(10, DEFAULT_QUALITY))
                        .build(),
                linkedSet(ancient)), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

    }

    private void addEnchantment(String type, String name, Holder<Enchantment> enchantment, EnchantmentAffix.Mode mode, UnaryOperator<EnchantmentAffix.Builder> config) {
        var builder = new EnchantmentAffix.Builder(enchantment, mode);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/enchantment/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addMobEffect(String type, String name, Holder<MobEffect> effect, BulletModifierAffix.Target target, UnaryOperator<BulletModifierAffix.Builder> config) {
        var builder = new BulletModifierAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/mob_effect/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addDamageReduction(String type, String name, DamageReductionAffix.DamageType dType, UnaryOperator<DamageReductionAffix.Builder> config) {
        var builder = new DamageReductionAffix.Builder(dType);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/dmg_reduction/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addAncientEnchantment(String type, String name, Holder<Enchantment> enchantment, EnchantmentAffix.Mode mode, UnaryOperator<EnchantmentAffix.Builder> config) {
        var builder = new EnchantmentAffix.Builder(enchantment, mode);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/enchantment/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addAncientMobEffect(String type, String name, Holder<MobEffect> effect, BulletModifierAffix.Target target, UnaryOperator<BulletModifierAffix.Builder> config) {
        var builder = new BulletModifierAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/mob_effect/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addAncientDamageReduction(String type, String name, DamageReductionAffix.DamageType dType, UnaryOperator<DamageReductionAffix.Builder> config) {
        var builder = new DamageReductionAffix.Builder(dType);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/dmg_reduction/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addAncientAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private static DynamicHolder<Affix> afx(String path) {
        return AffixRegistry.INSTANCE.holder(ApothicCompats.loc(path));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }

    private static Set<LootRarity> linkedSet(LootRarity... rarities) {
        return ApothMiscUtil.linkedSet(rarities);
    }
}
