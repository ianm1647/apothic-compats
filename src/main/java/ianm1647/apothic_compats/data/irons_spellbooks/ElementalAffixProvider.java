package ianm1647.apothic_compats.data.irons_spellbooks;

import dev.muon.irons_apothic.affix.ManaCostAffix;
import dev.muon.irons_apothic.affix.SpellLevelAffix;
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
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ElementalAffixProvider extends AffixProvider {
    String mod = "irons_apothic";

    public ElementalAffixProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public String getName() {
        return "Iron's Spellbooks Elemental Affixes";
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

    private void addElementalAttribute(String school, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addElementalAttribute(String school, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
    }

    private void addAncientElementalAttribute(String school, String name, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addAncientElementalAttribute(String school, String name, String modid, Holder<Attribute> attribute, AttributeModifier.Operation op, UnaryOperator<AttributeAffix.Builder> config) {
        var builder = new AttributeAffix.Builder(attribute, op);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
    }

    private void addSpellLevel(String school, String name, UnaryOperator<SpellLevelAffix.Builder> config) {
        var builder = new SpellLevelAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addSpellLevel(String school, String name, String modid, UnaryOperator<SpellLevelAffix.Builder> config) {
        var builder = new SpellLevelAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
    }

    private void addAncientSpellLevel(String school, String name, UnaryOperator<SpellLevelAffix.Builder> config) {
        var builder = new SpellLevelAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addAncientSpellLevel(String school, String name, String modid, UnaryOperator<SpellLevelAffix.Builder> config) {
        var builder = new SpellLevelAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
    }

    private void addManaCost(String school, String name, UnaryOperator<ManaCostAffix.Builder> config) {
        var builder = new ManaCostAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addManaCost(String school, String name, String modid, UnaryOperator<ManaCostAffix.Builder> config) {
        var builder = new ManaCostAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
    }

    private void addAncientManaCost(String school, String name, UnaryOperator<ManaCostAffix.Builder> config) {
        var builder = new ManaCostAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(mod));
    }

    private void addAncientManaCost(String school, String name, String modid, UnaryOperator<ManaCostAffix.Builder> config) {
        var builder = new ManaCostAffix.Builder();
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("elemental/ancient/" + school + "/" + name), builder.build(), new ModLoadedCondition(modid), new ModLoadedCondition(mod));
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
