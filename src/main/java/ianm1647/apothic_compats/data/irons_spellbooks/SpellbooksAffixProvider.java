package ianm1647.apothic_compats.data.irons_spellbooks;

import dev.muon.irons_apothic.affix.SpellEffectAffix;
import dev.muon.irons_apothic.affix.SpellTriggerAffix;
import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixRegistry;
import dev.shadowsoffire.apotheosis.affix.AttributeAffix;
import dev.shadowsoffire.apotheosis.data.AffixProvider;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apotheosis.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.util.ApothMiscUtil;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import ianm1647.ancientreforging.AncientReforging;
import ianm1647.apothic_compats.ApothicCompats;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class SpellbooksAffixProvider extends AffixProvider {

    String mod = "irons_apothic";

    public SpellbooksAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Iron's Spellbooks Affixes";
    }

    @Override
    public void generate() {
        LootRarity common = rarity("common");
        LootRarity uncommon = rarity("uncommon");
        LootRarity rare = rarity("rare");
        LootRarity epic = rarity("epic");
        LootRarity mythic = rarity("mythic");
        LootRarity ancient = ancientRarity("ancient");
        

    }

    private void addSpellTriggerAffix(String type, String name, AbstractSpell spell, SpellTriggerAffix.TriggerType trigger, UnaryOperator<SpellTriggerAffix.Builder> config) {
        var builder = new SpellTriggerAffix.Builder(spell, trigger);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addSpellEffect(String type, String name, Holder<MobEffect> effect, SpellEffectAffix.SpellTarget target, UnaryOperator<SpellEffectAffix.Builder> config) {
        var builder = new SpellEffectAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell_effect/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addModdedSpellEffect(String type, String name, String modid, Holder<MobEffect> effect, SpellEffectAffix.SpellTarget target, UnaryOperator<SpellEffectAffix.Builder> config) {
        var builder = new SpellEffectAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell_effect/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(modid));
    }

    private void addAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    public void addModdedAttribute(String type, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(modid));
    }

    private void addAncientSpellTriggerAffix(String type, String name, AbstractSpell spell, SpellTriggerAffix.TriggerType trigger, UnaryOperator<SpellTriggerAffix.Builder> config) {
        var builder = new SpellTriggerAffix.Builder(spell, trigger);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addAncientSpellEffect(String type, String name, Holder<MobEffect> effect, SpellEffectAffix.SpellTarget target, UnaryOperator<SpellEffectAffix.Builder> config) {
        var builder = new SpellEffectAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell_effect/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addModdedAncientSpellEffect(String type, String name, String modid, Holder<MobEffect> effect, SpellEffectAffix.SpellTarget target, UnaryOperator<SpellEffectAffix.Builder> config) {
        var builder = new SpellEffectAffix.Builder(effect, target);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/spell_effect/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(modid), new ModLoadedCondition(AncientReforging.MODID));
    }

    private void addAncientAttribute(String type, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(AncientReforging.MODID));
    }

    public void addModdedAncientAttribute(String type, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(type + "/attribute/ancient/" + name), builder.build(), new ModLoadedCondition(mod), new ModLoadedCondition(modid), new ModLoadedCondition(AncientReforging.MODID));
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
