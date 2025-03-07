package ianm1647.apothic_compats.data.ars_nouveau;

import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.hollingsworth.arsnouveau.setup.registry.ModPotions;
import dev.shadowsoffire.apotheosis.Apoth;
import ianm1647.ancientreforging.AncientReforging;
import dev.shadowsoffire.apotheosis.Apotheosis;
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

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArsAffixProvider extends AffixProvider {
    String mod = "ars_nouveau";

    public ArsAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Ars Nouveau Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");

        // ARMOR
        this.addAttribute("armor", "mana", PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ARMOR).categories(Apoth.LootCategories.SHIELD)
                .value(common, 15, 25)
                .value(uncommon, 30, 40)
                .value(rare, 45, 55)
                .value(epic, 60, 70)
                .value(mythic, 75, 85));

        this.addAncientAttribute("armor", "mana", PerkAttributes.MAX_MANA, AttributeModifier.Operation.ADD_VALUE, b -> b
                .definition(AffixType.STAT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(ARMOR).categories(Apoth.LootCategories.SHIELD)
                .value(ancient, 90, 100));

        // MELEE
        this.addMobEffect("melee", "freezing", ModPotions.FREEZING_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("melee", "freezing", ModPotions.FREEZING_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "blasting", ModPotions.BLAST_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("melee", "blasting", ModPotions.BLAST_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "shocking", ModPotions.SHOCKED_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("melee", "shocking", ModPotions.SHOCKED_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "snaring", ModPotions.SNARE_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("melee", "snaring", ModPotions.SNARE_EFFECT, MobEffectAffix.Target.ATTACK_TARGET, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

        this.addMobEffect("melee", "mana_regen", ModPotions.MANA_REGEN_EFFECT, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("melee", "mana_regen", ModPotions.MANA_REGEN_EFFECT, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.MELEE_WEAPON, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

        // RANGED
        this.addMobEffect("ranged", "mana_regen", ModPotions.MANA_REGEN_EFFECT, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.BOW, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(uncommon, 100, 100, 0, 80)
                .value(rare, 100, 120, 0, 80)
                .value(epic, 100, 120, 0, 80)
                .value(mythic, 100, 120, StepFunction.fromBounds(0, 1, 0.125F), 80));

        this.addAncientMobEffect("ranged", "mana_regen", ModPotions.MANA_REGEN_EFFECT, MobEffectAffix.Target.ATTACK_SELF, b -> b
                .definition(AffixType.BASIC_EFFECT, DEFAULT_WEIGHT, DEFAULT_QUALITY)
                .categories(Apoth.LootCategories.BOW, Apoth.LootCategories.TRIDENT)
                .stacking()
                .limit(3)
                .value(ancient, 200, 360, StepFunction.fromBounds(1, 2, 0.125F), 80));

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
