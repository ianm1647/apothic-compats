package ianm1647.apothic_compats.data.irons_artifice;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.socket.gem.ExtraGemBonusRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.GemRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArtificeExtraGemBonusProvider extends DynamicRegistryProvider<ExtraGemBonusRegistry.ExtraGemBonus> {

    public ArtificeExtraGemBonusProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ExtraGemBonusRegistry.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "Artifice Extra Gem Bonuses";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();

        addBonus(Apotheosis.loc("core/ballast"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3)));

        addBonus(Apotheosis.loc("core/combatant"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_PIERCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 1.5)
                        .value(Purity.FLAWLESS, 2)
                        .value(Purity.PERFECT, 3)));

        addBonus(Apotheosis.loc("core/breach"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_CHANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 0.02)
                        .value(Purity.FLAWED, 0.04)
                        .value(Purity.FLAWED, 0.06)
                        .value(Purity.NORMAL, 0.08)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.12)));

        addBonus(Apotheosis.loc("core/lightning"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(Comp.Attributes.Artifice.GUN_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.15)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.35)
                        .value(Purity.FLAWLESS, 0.45)
                        .value(Purity.PERFECT, 0.55)));

        addBonus(Apotheosis.loc("core/slipstream"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(Attributes.LUCK)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("core/solar"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROT_PIERCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.01)
                        .value(Purity.CHIPPED, 0.02)
                        .value(Purity.FLAWED, 0.03)
                        .value(Purity.NORMAL, 0.04)
                        .value(Purity.FLAWLESS, 0.05)
                        .value(Purity.PERFECT, 0.075)));

        addBonus(Apotheosis.loc("core/warlord"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(Comp.Attributes.Artifice.GUN_RECOIL)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CHIPPED, -0.05)
                        .value(Purity.FLAWED, -0.1)
                        .value(Purity.NORMAL, -0.15)
                        .value(Purity.FLAWLESS, -0.2)
                        .value(Purity.PERFECT, -0.25)));

        addBonus(Apotheosis.loc("overworld/earth"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(Comp.Attributes.Artifice.BULLET_PIERCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("the_nether/blood_lord"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(Attributes.BURNING_TIME)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CHIPPED, -0.025f)
                        .value(Purity.FLAWED, -0.05f)
                        .value(Purity.NORMAL, -0.075f)
                        .value(Purity.FLAWLESS, -0.1f)
                        .value(Purity.PERFECT, -0.125f)));

        addBonus(Apotheosis.loc("the_nether/inferno"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.FIRE_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6)));

        addBonus(Apotheosis.loc("the_end/mageslayer"), b -> b
                .bonus(Comp.LootCategories.Artifice.GUN, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROT_SHRED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.NORMAL, 0.1)
                        .value(Purity.FLAWLESS, 0.2)
                        .value(Purity.PERFECT, 0.3)));

    }

    private void addBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("irons_artifice/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"));
    }

    private void addTwilightBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("irons_artifice/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition("twilightforest"));
    }

    private void addModdedBonus(ResourceLocation gem, String mod, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("irons_artifice/" + mod + "/" + gem.getPath().replace(mod + "/", "")), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition(mod));
    }
}