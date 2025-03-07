package ianm1647.apothic_compats.data.undergarden;

import ianm1647.ancientreforging.AncientReforging;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.affix.AffixType;
import dev.shadowsoffire.apotheosis.affix.AttributeAffix;
import dev.shadowsoffire.apotheosis.affix.effect.DamageReductionAffix;
import dev.shadowsoffire.apotheosis.affix.effect.EnchantmentAffix;
import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.data.AffixProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;
import quek.undergarden.registry.UGEffects;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class UndergardenAffixProvider extends AffixProvider {
    String mod = "undergarden";

    public UndergardenAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Undergarden Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        this.addMobEffect("melee", "brittle", UGEffects.BRITTLENESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("melee", "brittle", UGEffects.BRITTLENESS, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "featherweight", UGEffects.FEATHERWEIGHT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("melee", "featherweight", UGEffects.FEATHERWEIGHT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "virulence", UGEffects.VIRULENCE, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("melee", "virulence", UGEffects.VIRULENCE, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "anti_virulence", UGEffects.VIRULENT_RESISTANCE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("melee", "anti_virulence", UGEffects.VIRULENT_RESISTANCE, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("ranged", "virulence", UGEffects.VIRULENCE, MobEffectAffix.Target.ARROW_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("ranged", "virulence", UGEffects.VIRULENCE, MobEffectAffix.Target.ARROW_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("ranged", "gooey", UGEffects.GOOEY, MobEffectAffix.Target.ARROW_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.BOW, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 80, 120, 0, 80)
                .value(rare, 80, 160, 0, 80)
                .value(epic, 120, 200, 0, 80)
                .value(mythic, 160, 240, StepFunction.fromBounds(0, 1, 0.125F), 80));
        this.addAncientMobEffect("ranged", "gooey", UGEffects.GOOEY, MobEffectAffix.Target.ARROW_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.BOW, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 280, StepFunction.fromBounds(1, 2, 0.125F), 80));

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

    private static LootRarity rarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(Apotheosis.loc(path)));
    }

    private static LootRarity ancientRarity(String path) {
        return Preconditions.checkNotNull(RarityRegistry.INSTANCE.getValue(AncientReforging.loc(path)));
    }
}
