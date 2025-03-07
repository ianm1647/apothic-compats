package ianm1647.apothic_compats.data.aether;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.*;
import dev.shadowsoffire.apotheosis.affix.effect.DamageReductionAffix;
import dev.shadowsoffire.apotheosis.affix.effect.EnchantmentAffix;
import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.data.AffixProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apotheosis.util.ApothMiscUtil;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.affix.aether.MagicalDartAffix;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class DartShooterAffixProvider extends AffixProvider {
    public DartShooterAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "aether";

    @Override
    public String getName() {
        return "Aether Dart Shooter Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        HolderLookup.RegistryLookup<Enchantment> enchants = this.lookupProvider.join().lookup(Registries.ENCHANTMENT).get();

        this.addAttribute("dart_shooter", "agile", ALObjects.Attributes.DRAW_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(common, 0.2F, 0.4F)
                .value(uncommon, 0.2F, 0.4F)
                .value(rare, 0.3F, 0.5F)
                .value(epic, 0.5F, 0.6F)
                .value(mythic, 0.5F, 0.65F));

        this.addAttribute("dart_shooter", "elven", ALObjects.Attributes.PROJECTILE_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(common, 0.15F, 0.20F)
                .value(uncommon, 0.15F, 0.25F)
                .value(rare, 0.20F, 0.30F)
                .value(epic, 0.25F, 0.35F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("dart_shooter", "streamlined", ALObjects.Attributes.ARROW_VELOCITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(common, 0.15F, 0.20F)
                .value(uncommon, 0.15F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.30F)
                .value(mythic, 0.15F, 0.35F));

        this.addAttribute("dart_shooter", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.15F, 0.3F)
                .value(rare, 0.15F, 0.3F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.2F, 0.4F));

        this.addMobEffect("dart_shooter", "shulkers", MobEffects.LEVITATION, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(epic, 20, 80, StepFunction.fromBounds(0, 1, 0.25F), 140)
                .value(mythic, 20, 100, StepFunction.fromBounds(0, 2, 0.25F), 140));

        this.addMobEffect("dart_shooter", "acidic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .limit(4)
                .value(mythic, 80, 160, 0, 40));

        this.addMobEffect("dart_shooter", "ensnaring", MobEffects.MOVEMENT_SLOWDOWN, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(uncommon, 40, 80, 0, 160)
                .value(rare, 40, 100, 0, 160)
                .value(epic, 40, 120, StepFunction.fromBounds(0, 1, 0.25F), 160)
                .value(mythic, 80, 160, StepFunction.fromBounds(0, 2, 0.25F), 160));

        this.addMobEffect("dart_shooter", "fleeting", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.PROJECTILE_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(uncommon, 100, 200, 0, 0)
                .value(rare, 100, 200, 0, 0)
                .value(epic, 100, 200, StepFunction.fromBounds(0, 1, 0.25F), 0)
                .value(mythic, 100, 300, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addMobEffect("dart_shooter", "grievous", ALObjects.MobEffects.GRIEVOUS, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(uncommon, 200, 200, 0, 500)
                .value(rare, 200, 300, 0, 500)
                .value(epic, 200, 300, StepFunction.fromBounds(0, 1, 0.25F), 400)
                .value(mythic, 200, 300, StepFunction.fromBounds(0, 2, 0.25F), 400));

        this.addMobEffect("dart_shooter", "ivy_laced", MobEffects.POISON, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .limit(5)
                .value(rare, 100, 160, 0, 40)
                .value(epic, 100, 160, StepFunction.fromBounds(0, 1, 0.25F), 40)
                .value(mythic, 100, 200, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addMobEffect("dart_shooter", "blighted", MobEffects.WITHER, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(epic, 160, 200, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 160, 200, StepFunction.fromBounds(0, 3, 0.25F), 300));

        this.addMobEffect("dart_shooter", "deathbound", MobEffects.WITHER, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("ranged/mob_effect/blighted")))
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .limit(4)
                .value(mythic, 100, 200, 1, 40));

        this.addConditionally(ApothicCompats.loc("dart_shooter/magical"), new MagicalDartAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .build(),
                linkedSet(epic, mythic)), new ModLoadedCondition(mod));

        Holder<Enchantment> looting = enchants.getOrThrow(Enchantments.LOOTING);
        this.addEnchantment("dart_shooter", "prosperous", looting, EnchantmentAffix.Mode.SINGLE, b -> b
                .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .step(0.25F)
                .value(epic, 6, 8)
                .value(mythic, 8, 10));

        this.addAncientAttribute("dart_shooter", "agile", ALObjects.Attributes.DRAW_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 1F, 1.5F));

        this.addAncientAttribute("dart_shooter", "elven", ALObjects.Attributes.PROJECTILE_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 0.5F, 0.8F));

        this.addAncientAttribute("dart_shooter", "streamlined", ALObjects.Attributes.ARROW_VELOCITY, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 0.3F, 0.7F));

        this.addAncientAttribute("dart_shooter", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 0.4F, 0.8F));

        this.addAncientMobEffect("dart_shooter", "shulkers", MobEffects.LEVITATION, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 40, 200, StepFunction.fromBounds(0, 3, 0.5F), 70));

        this.addAncientMobEffect("dart_shooter", "acidic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .value(ancient, 160, 320, 0, 30));

        this.addAncientMobEffect("dart_shooter", "ensnaring", MobEffects.MOVEMENT_SLOWDOWN, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 150, 350, StepFunction.fromBounds(0, 3, 0.25F), 80));

        this.addAncientMobEffect("dart_shooter", "fleeting", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.PROJECTILE_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 200, 500, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addAncientMobEffect("dart_shooter", "grievous", ALObjects.MobEffects.GRIEVOUS, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 400, 600, StepFunction.fromBounds(0, 3, 0.5F), 200));

        this.addAncientMobEffect("dart_shooter", "ivy_laced", MobEffects.POISON, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .value(ancient, 200, 400, StepFunction.fromBounds(0, 3, 0.5F), 20));

        this.addAncientMobEffect("dart_shooter", "blighted", MobEffects.WITHER, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .value(ancient, 320, 500, StepFunction.fromBounds(0, 4, 0.5F), 100));

        this.addAncientMobEffect("dart_shooter", "deathbound", MobEffects.WITHER, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("ranged/mob_effect/blighted")))
                .categories(ModLootCategories.DART_SHOOTER)
                .stacking()
                .value(ancient, 200, 400, 2, 20));

        this.addConditionally(ApothicCompats.loc("dart_shooter/ancient/magical"), new MagicalDartAffix(
                AffixDefinition.builder(AffixType.ABILITY)
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .build(),
                linkedSet(ancient)), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addAncientEnchantment("dart_shooter", "prosperous", looting, EnchantmentAffix.Mode.SINGLE, b -> b
                .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.DART_SHOOTER)
                .step(0.25F)
                .value(ancient, 10, 14));


    }

    private void addEnchantment(String type, String name, Holder<Enchantment> enchantment, EnchantmentAffix.Mode mode, UnaryOperator<EnchantmentAffix.Builder> config) {
        var builder = new EnchantmentAffix.Builder(enchantment, mode);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/enchantment/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addMobEffect(String type, String name, Holder<MobEffect> effect, MobEffectAffix.Target target, UnaryOperator<MobEffectAffix.Builder> config) {
        var builder = new MobEffectAffix.Builder(effect, target);
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

    private void addAncientMobEffect(String type, String name, Holder<MobEffect> effect, MobEffectAffix.Target target, UnaryOperator<MobEffectAffix.Builder> config) {
        var builder = new MobEffectAffix.Builder(effect, target);
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
        return AffixRegistry.INSTANCE.holder(Apotheosis.loc(path));
    }

    private static Set<LootRarity> linkedSet(LootRarity... rarities) {
        return ApothMiscUtil.linkedSet(rarities);
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
