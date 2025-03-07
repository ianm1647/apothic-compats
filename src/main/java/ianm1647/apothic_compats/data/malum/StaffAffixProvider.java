package ianm1647.apothic_compats.data.malum;

import com.sammy.malum.registry.common.AttributeRegistry;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.*;
import dev.shadowsoffire.apotheosis.affix.effect.*;
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
import ianm1647.apothic_compats.affix.malum.*;
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
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class StaffAffixProvider extends AffixProvider {
    public StaffAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "malum";

    @Override
    public String getName() {
        return "Malum Staff Affixes";
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

        /*

        ***

        STAFF RANGED ATTRIBUTES

        ***

        */

        this.addAttribute("staff/ranged", "agile", AttributeRegistry.CHARGE_DURATION, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, -2)
                .value(uncommon, -4)
                .value(rare, -6)
                .value(epic, -8)
                .value(mythic, -10));

        this.addAttribute("staff/ranged", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.15F, 0.3F)
                .value(rare, 0.15F, 0.3F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.2F, 0.4F));

        this.addMobEffect("staff/ranged", "shulkers", MobEffects.LEVITATION, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(epic, 20, 80, StepFunction.fromBounds(0, 1, 0.25F), 140)
                .value(mythic, 20, 100, StepFunction.fromBounds(0, 2, 0.25F), 140));

        this.addMobEffect("staff/ranged", "acidic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(4)
                .value(mythic, 80, 160, 0, 40));

        this.addMobEffect("staff/ranged", "ensnaring", MobEffects.MOVEMENT_SLOWDOWN, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(uncommon, 40, 80, 0, 160)
                .value(rare, 40, 100, 0, 160)
                .value(epic, 40, 120, StepFunction.fromBounds(0, 1, 0.25F), 160)
                .value(mythic, 80, 160, StepFunction.fromBounds(0, 2, 0.25F), 160));

        this.addMobEffect("staff/ranged", "fleeting", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.PROJECTILE_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(uncommon, 100, 200, 0, 0)
                .value(rare, 100, 200, 0, 0)
                .value(epic, 100, 200, StepFunction.fromBounds(0, 1, 0.25F), 0)
                .value(mythic, 100, 300, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addMobEffect("staff/ranged", "grievous", ALObjects.MobEffects.GRIEVOUS, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(uncommon, 200, 200, 0, 500)
                .value(rare, 200, 300, 0, 500)
                .value(epic, 200, 300, StepFunction.fromBounds(0, 1, 0.25F), 400)
                .value(mythic, 200, 300, StepFunction.fromBounds(0, 2, 0.25F), 400));

        this.addMobEffect("staff/ranged", "ivy_laced", MobEffects.POISON, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(5)
                .value(rare, 100, 160, 0, 40)
                .value(epic, 100, 160, StepFunction.fromBounds(0, 1, 0.25F), 40)
                .value(mythic, 100, 200, StepFunction.fromBounds(0, 2, 0.25F), 40));

        Holder<Enchantment> looting = enchants.getOrThrow(Enchantments.LOOTING);
        this.addEnchantment("staff/ranged", "prosperous", looting, EnchantmentAffix.Mode.SINGLE, b -> b
                .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(epic, 2, 3)
                .value(mythic, 3, 4));

        this.addAncientAttribute("staff/ranged", "agile", AttributeRegistry.CHARGE_DURATION, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, -12));

        this.addAncientAttribute("staff/ranged", "windswept", Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.4F, 0.8F));

        this.addAncientMobEffect("staff/ranged", "shulkers", MobEffects.LEVITATION, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 40, 200, StepFunction.fromBounds(0, 3, 0.5F), 70));

        this.addAncientMobEffect("staff/ranged", "acidic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 160, 320, 0, 30));

        this.addAncientMobEffect("staff/ranged", "ensnaring", MobEffects.MOVEMENT_SLOWDOWN, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 150, 350, StepFunction.fromBounds(0, 3, 0.25F), 80));

        this.addAncientMobEffect("staff/ranged", "fleeting", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.PROJECTILE_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 200, 500, StepFunction.fromBounds(0, 2, 0.25F), 0));

        this.addAncientMobEffect("staff/ranged", "grievous", ALObjects.MobEffects.GRIEVOUS, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 400, 600, StepFunction.fromBounds(0, 3, 0.5F), 200));

        this.addAncientMobEffect("staff/ranged", "ivy_laced", MobEffects.POISON, MobEffectAffix.Target.PROJECTILE_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 200, 400, StepFunction.fromBounds(0, 3, 0.5F), 20));

        this.addAncientEnchantment("staff/ranged", "prosperous", looting, EnchantmentAffix.Mode.SINGLE, b -> b
                .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(ancient, 4, 5));

        /*

        ***

        STAFF MELEE ATTRIBUTES

        ***

        */

        this.addAttribute("staff/melee", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("staff/melee/attribute/berserking")))
                .categories(ModLootCategories.STAFF)
                .value(common, 0.15F, 0.20F)
                .value(uncommon, 0.15F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.30F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("staff/melee", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(rare, 0.15F, 0.43F)
                .value(epic, 0.18F, 0.48F)
                .value(mythic, 0.25F, 0.55F));

        this.addAttribute("staff/melee", "violent", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(common, 1F, 2F)
                .value(uncommon, 1F, 2F)
                .value(rare, 2F, 4F)
                .value(epic, 3F, 5F)
                .value(mythic, 4F, 7F));

        this.addAttribute("staff/melee", "wizarding", LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 0.15F, 0.20F)
                .value(uncommon, 0.15F, 0.25F)
                .value(rare, 0.20F, 0.30F)
                .value(epic, 0.25F, 0.35F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("staff/melee", "magekilling", LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 2F, 3F)
                .value(uncommon, 2F, 3F)
                .value(rare, 3F, 5F)
                .value(epic, 4F, 6F)
                .value(mythic, 5F, 8F));

        this.addAttribute("staff/melee", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(common, 2F, 4F)
                .value(uncommon, 2F, 4F)
                .value(rare, 4F, 8F)
                .value(epic, 5F, 10F)
                .value(mythic, 5F, 12F));

        this.addAttribute("staff/melee", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.25F)
                .value(mythic, 0.25F, 0.40F));

        this.addAttribute("staff/melee", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.10F, 0.25F)
                .value(epic, 0.15F, 0.35F)
                .value(mythic, 0.25F, 0.55F));

        this.addAttribute("staff/melee", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(common, 0.15F, 0.25F)
                .value(uncommon, 0.20F, 0.30F)
                .value(rare, 0.20F, 0.35F)
                .value(epic, 0.25F, 0.50F)
                .value(mythic, 0.40F, 0.85F));

        this.addAttribute("staff/melee", "forceful", Attributes.ATTACK_KNOCKBACK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(common, 0.5F, 1F)
                .value(uncommon, 0.5F, 1.5F)
                .value(rare, 0.75F, 2.5F)
                .value(epic, 1F, 2.5F)
                .value(mythic, 1.5F, 3));

        this.addAttribute("staff/melee", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("staff/melee/attribute/vampiric")))
                .categories(ModLootCategories.STAFF)
                .value(common, 0.10F, 0.20F)
                .value(uncommon, 0.10F, 0.20F)
                .value(rare, 0.15F, 0.25F)
                .value(epic, 0.15F, 0.30F)
                .value(mythic, 0.20F, 0.45F));

        this.addAttribute("staff/melee", "giant_slaying", ALObjects.Attributes.CURRENT_HP_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 15, 2.5F)))
                .categories(ModLootCategories.STAFF)
                .value(epic, 0.10F, 0.20F)
                .value(mythic, 0.10F, 0.25F));

        this.addMobEffect("staff/melee", "bloodletting", ALObjects.MobEffects.BLEEDING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addMobEffect("staff/melee", "caustic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(3)
                .value(rare, 100, 180, 0, 60)
                .value(epic, 100, 200, StepFunction.fromBounds(0, 1, 0.125F), 60)
                .value(mythic, 200, 400, StepFunction.fromBounds(0, 1, 0.25F), 60));

        this.addMobEffect("staff/melee", "sophisticated", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(3)
                .value(uncommon, 400, 600, 0, 400)
                .value(rare, 400, 800, 0, 400)
                .value(epic, 400, 800, StepFunction.fromBounds(0, 1, 0.25F), 400)
                .value(mythic, 400, 1000, StepFunction.fromBounds(0, 2, 0.25F), 400));

        this.addMobEffect("staff/melee", "omniscient", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("staff/melee/mob_effect/sophisticated")))
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(8)
                .value(mythic, 100, 160, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addMobEffect("staff/melee", "weakening", MobEffects.WEAKNESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(uncommon, 80, 140, 0, 300)
                .value(rare, 80, 160, 0, 300)
                .value(epic, 80, 180, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 80, 200, StepFunction.fromBounds(0, 2, 0.125F), 300));

        this.addMobEffect("staff/melee", "elusive", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .limit(3)
                .value(uncommon, 200, 400, 0, 300)
                .value(rare, 200, 600, 0, 300)
                .value(epic, 200, 600, StepFunction.fromBounds(0, 1, 0.25F), 300)
                .value(mythic, 200, 800, StepFunction.fromBounds(0, 2, 0.25F), 300));

        this.addConditionally(ApothicCompats.loc("staff/festive"),
                AffixBuilder.simple(StaffFestiveAffix::new)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(0.005F)
                        .value(epic, 0.02F, 0.05F)
                        .value(mythic, 0.03F, 0.06F)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("staff/thunderstruck"),
                AffixBuilder.simple(StaffThunderstruckAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(1)
                        .value(epic, 3, 6)
                        .value(mythic, 4, 8)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("staff/cleaving"),
                new StaffCleavingAffix.Builder()
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(epic, 0.3F, 0.5F, 2, 5)
                        .value(mythic, 0.4F, 0.6F, 3, 6)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("staff/executing"),
                AffixBuilder.simple(StaffExecutingAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(epic, 0.10F, 0.20F)
                        .value(mythic, 0.15F, 0.25F)
                        .build(), new ModLoadedCondition(mod));

        this.addConditionally(ApothicCompats.loc("staff/ancient/festive"),
                AffixBuilder.simple(StaffFestiveAffix::new)
                        .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(0.005F)
                        .value(ancient, 0.09F, 0.15F)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("staff/ancient/thunderstruck"),
                AffixBuilder.simple(StaffThunderstruckAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .step(1)
                        .value(ancient, 7, 11)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("staff/ancient/cleaving"),
                new StaffCleavingAffix.Builder()
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(ancient, 0.8F, 1.0F, 3, 6)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addConditionally(ApothicCompats.loc("staff/ancient/executing"),
                AffixBuilder.simple(StaffExecutingAffix::new)
                        .definition(AffixType.ABILITY, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                        .value(ancient, 0.35F, 0.6F)
                        .build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));

        this.addAncientAttribute("staff/melee", "vampiric", ALObjects.Attributes.LIFE_STEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("staff/melee/attribute/berserking")))
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.5F, 0.8F));

        this.addAncientAttribute("staff/melee", "murderous", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.5F, 0.75F));

        this.addAncientAttribute("staff/melee", "violent", Attributes.ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(ancient, 8F, 12F));

        this.addAncientAttribute("staff/melee", "wizarding", LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.35F, 0.65F));

        this.addAncientAttribute("staff/melee", "magekilling", LodestoneAttributes.MAGIC_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 6F, 10F));

        this.addAncientAttribute("staff/melee", "piercing", ALObjects.Attributes.ARMOR_PIERCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(ancient, 10F, 24F));

        this.addAncientAttribute("staff/melee", "lacerating", ALObjects.Attributes.CRIT_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.5F, 0.8F));

        this.addAncientAttribute("staff/melee", "intricate", ALObjects.Attributes.CRIT_CHANCE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.5F, 1.15F));

        this.addAncientAttribute("staff/melee", "graceful", Attributes.ATTACK_SPEED, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.75F, 1.2F));

        this.addAncientAttribute("staff/melee", "forceful", Attributes.ATTACK_KNOCKBACK, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .step(0.25F)
                .value(ancient, 3, 6));

        this.addAncientAttribute("staff/melee", "berserking", ALObjects.Attributes.OVERHEAL, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY))
                        .exclusiveWith(afx("staff/melee/attribute/vampiric")))
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.4F, 0.9F));

        this.addAncientAttribute("staff/melee", "giant_slaying", ALObjects.Attributes.CURRENT_HP_DAMAGE, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5)))
                .categories(ModLootCategories.STAFF)
                .value(ancient, 0.3F, 0.7F));

        this.addAncientMobEffect("staff/melee", "bloodletting", ALObjects.MobEffects.BLEEDING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 200, 400, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addAncientMobEffect("staff/melee", "caustic", ALObjects.MobEffects.SUNDERING, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 400, 800, StepFunction.fromBounds(0, 2, 0.5F), 150));

        this.addAncientMobEffect("staff/melee", "sophisticated", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 600, 1500, StepFunction.fromBounds(0, 3, 0.5F), 600));

        this.addAncientMobEffect("staff/melee", "omniscient", ALObjects.MobEffects.KNOWLEDGE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, d -> d
                        .weights(TieredWeights.onlyFor(WorldTier.PINNACLE, 20, 5))
                        .exclusiveWith(afx("staff/melee/mob_effect/sophisticated")))
                .categories(ModLootCategories.STAFF)
                .stacking()
                .value(ancient, 250, 450, StepFunction.fromBounds(0, 2, 0.25F), 40));

        this.addAncientMobEffect("staff/melee", "weakening", MobEffects.WEAKNESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
                .value(ancient, 150, 450, StepFunction.fromBounds(0, 3, 0.25F), 150));

        this.addAncientMobEffect("staff/melee", "elusive", MobEffects.MOVEMENT_SPEED, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ModLootCategories.STAFF)
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
        return AffixRegistry.INSTANCE.holder(Apotheosis.loc(path));
    }

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
