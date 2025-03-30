package ianm1647.apothic_compats.data.malum;

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
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.affix.malum.ScytheCleavingAffix;
import ianm1647.apothic_compats.affix.malum.ScytheExecutingAffix;
import ianm1647.apothic_compats.affix.malum.ScytheFestiveAffix;
import ianm1647.apothic_compats.affix.malum.ScytheThunderstruckAffix;
import ianm1647.apothic_compats.loot.ModLootCategories;
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

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ScytheAffixProvider extends AffixProvider {
    public ScytheAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "malum";

    @Override
    public String getName() {
        return "Malum Scythe Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        this.addAttribute("scythe", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/berserking")))
                .categories(ModLootCategories.SCYTHE)
                .value(common, 0.15F, 0.20F)
                .value(uncommon, 0.15F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.30F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("scythe", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(rare, 0.15F, 0.43F)
                .value(epic, 0.18F, 0.48F)
                .value(mythic, 0.25F, 0.55F));

        this.addAttribute("scythe", "violent", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(common, 2F, 3F)
                .value(uncommon, 2F, 3F)
                .value(rare, 3F, 5F)
                .value(epic, 4F, 6F)
                .value(mythic, 5F, 8F));

        this.addAttribute("scythe", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(common, 2F, 4F)
                .value(uncommon, 2F, 4F)
                .value(rare, 4F, 8F)
                .value(epic, 5F, 10F)
                .value(mythic, 5F, 12F));

        this.addAttribute("scythe", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.25F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("scythe", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.10F, 0.25F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.25F, 0.55F));

        this.addAttribute("scythe", "infernal", ALObjects.Attributes.FIRE_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/glacial")))
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(uncommon, 2F, 4F)
                .value(rare, 2F, 5F)
                .value(epic, 4F, 6F)
                .value(mythic, 4F, 10F));

        this.addAttribute("scythe", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.20F, 0.30F)
                .value(rare, 0.20F, 0.35F)
                .value(epic, 0.25F, 0.50F)
                .value(mythic, 0.40F, 0.85F));

        this.addAttribute("scythe", "glacial", ALObjects.Attributes.COLD_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/infernal")))
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(uncommon, 2F, 4F)
                .value(rare, 2F, 5F)
                .value(epic, 4F, 6F)
                .value(mythic, 4F, 10F));

        this.addAttribute("scythe", "lengthy", Attributes.ENTITY_INTERACTION_RANGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(common, 0.5F, 1.5F)
                .value(uncommon, 0.5F, 1.5F)
                .value(rare, 0.75F, 2.5F)
                .value(epic, 1F, 2.5F)
                .value(mythic, 1.5F, 3));

        this.addAttribute("scythe", "forceful", Attributes.ATTACK_KNOCKBACK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(common, 0.5F, 1F)
                .value(uncommon, 0.5F, 1.5F)
                .value(rare, 0.75F, 2.5F)
                .value(epic, 1F, 2.5F)
                .value(mythic, 1.5F, 3));

        this.addAttribute("scythe", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/vampiric")))
                .categories(ModLootCategories.SCYTHE)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.30F)
                .value(mythic, 0.20F, 0.45F));

        this.addAttribute("scythe", "giant_slaying", ALObjects.Attributes.CURRENT_HP_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 15, 2.5F)))
                .categories(ModLootCategories.SCYTHE)
                .value(epic, 0.10F, 0.20F)
                .value(mythic, 0.10F, 0.25F));

        this.addMobEffect("scythe", "bloodletting", ALObjects.MobEffects.BLEEDING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addMobEffect("scythe", "caustic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .limit(3)
                .value(rare, 100, 180, 0, 60)
                .value(epic, 100, 200, StepFunction.fromBounds(0, 1, 0.125F), 60)
                .value(mythic, 200, 400, StepFunction.fromBounds(0, 1, 0.25F), 60));

        this.addMobEffect("scythe", "sophisticated", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .limit(3)
                .value(uncommon, 400, 600, 0, 400)
                .value(rare, 400, 800, 0, 400)
                .value(epic, 400, 800, StepFunction.fromBounds(0, 1, 0.25F), 400)
                .value(mythic, 400, 1000, StepFunction.fromBounds(0, 2, 0.25F), 400));

        this.addMobEffect("scythe", "omniscient", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("scythe/mob_effect/sophisticated")))
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .limit(8)
                .value(mythic, 100, 160, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addMobEffect("scythe", "weakening", MobEffects.WEAKNESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(uncommon, 80, 140, 0, 300)
                .value(rare, 80, 160, 0, 300)
                .value(epic, 80, 180, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 80, 200, StepFunction.fromBounds(0, 2, 0.125F), 300));

        this.addMobEffect("scythe", "elusive", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .limit(3)
                .value(uncommon, 200, 400, 0, 300)
                .value(rare, 200, 600, 0, 300)
                .value(epic, 200, 600, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 200, 800, StepFunction.fromBounds(0, 2, 0.25F), 300));

        this.addConditionally(ApothicCompats.loc("scythe/festive"),
                AffixBuilder.simple(ScytheFestiveAffix::new)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(0.005F)
                        .value(epic, 0.02F, 0.05F)
                        .value(mythic, 0.03F, 0.06F)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("scythe/thunderstruck"),
                AffixBuilder.categorized(ScytheThunderstruckAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(1)
                        .value(epic, 3, 6)
                        .value(mythic, 4, 8)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("scythe/cleaving"),
                new ScytheCleavingAffix.Builder()
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(epic, 0.3F, 0.5F, 2, 5)
                        .value(mythic, 0.4F, 0.6F, 3, 6)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("scythe/executing"),
                AffixBuilder.simple(ScytheExecutingAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(epic, 0.10F, 0.20F)
                        .value(mythic, 0.15F, 0.25F)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("scythe/ancient/festive"),
                AffixBuilder.simple(ScytheFestiveAffix::new)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(0.005F)
                        .value(ancient, 0.09F, 0.15F)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("scythe/ancient/thunderstruck"),
                AffixBuilder.categorized(ScytheThunderstruckAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(1)
                        .value(ancient, 7, 11)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("scythe/ancient/cleaving"),
                new ScytheCleavingAffix.Builder()
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(ancient, 0.8F, 1.0F, 3, 6)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("scythe/ancient/executing"),
                AffixBuilder.simple(ScytheExecutingAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(ancient, 0.35F, 0.6F)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addAncientAttribute("scythe", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/berserking")))
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.5F, 0.8F));

        this.addAncientAttribute("scythe", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.5F, 1.15F));

        this.addAncientAttribute("scythe", "violent", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 10F, 16F));

        this.addAncientAttribute("scythe", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 10F, 24F));

        this.addAncientAttribute("scythe", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.5F, 0.8F));

        this.addAncientAttribute("scythe", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.5F, 1.15F));

        this.addAncientAttribute("scythe", "infernal", ALObjects.Attributes.FIRE_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/glacial")))
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 8F, 20F));

        this.addAncientAttribute("scythe", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.75F, 1.2F));

        this.addAncientAttribute("scythe", "glacial", ALObjects.Attributes.COLD_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/infernal")))
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 8F, 20F));

        this.addAncientAttribute("scythe", "lengthy", Attributes.ENTITY_INTERACTION_RANGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 3, 6));

        this.addAncientAttribute("scythe", "forceful", Attributes.ATTACK_KNOCKBACK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .step(0.25F)
                .value(ancient, 3, 6));

        this.addAncientAttribute("scythe", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("scythe/attribute/vampiric")))
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.4F, 0.9F));

        this.addAncientAttribute("scythe", "giant_slaying", ALObjects.Attributes.CURRENT_HP_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 0.3F, 0.7F));

        this.addAncientMobEffect("scythe", "bloodletting", ALObjects.MobEffects.BLEEDING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .value(ancient, 200, 400, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addAncientMobEffect("scythe", "caustic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .value(ancient, 400, 800, StepFunction.fromBounds(0, 2, 0.5F), 150));

        this.addAncientMobEffect("scythe", "sophisticated", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .value(ancient, 600, 1500, StepFunction.fromBounds(0, 3, 0.5F), 600));

        this.addAncientMobEffect("scythe", "omniscient", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("scythe/mob_effect/sophisticated")))
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .value(ancient, 250, 450, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addAncientMobEffect("scythe", "weakening", MobEffects.WEAKNESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .value(ancient, 150, 450, StepFunction.fromBounds(0, 3, 0.25F), 150));

        this.addAncientMobEffect("scythe", "elusive", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.SCYTHE)
                .stacking()
                .value(ancient, 400, 1200, StepFunction.fromBounds(0, 3, 0.5F), 300));
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
        return AffixRegistry.INSTANCE.holder(ApothicCompats.loc(path));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
