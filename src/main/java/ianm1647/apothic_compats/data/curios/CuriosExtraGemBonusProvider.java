package ianm1647.apothic_compats.data.curios;

import dev.shadowsoffire.apotheosis.Apotheosis;
import dev.shadowsoffire.apotheosis.affix.effect.DamageReductionAffix;
import dev.shadowsoffire.apotheosis.socket.gem.ExtraGemBonusRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.GemClass;
import dev.shadowsoffire.apotheosis.socket.gem.GemRegistry;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.DamageReductionBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MultiAttrBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.special.AllStatsBonus;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.util.data.DynamicRegistryProvider;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.Comp.LootCategories.Curios;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CuriosExtraGemBonusProvider extends DynamicRegistryProvider<ExtraGemBonusRegistry.ExtraGemBonus> {

    public CuriosExtraGemBonusProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ExtraGemBonusRegistry.INSTANCE);
    }

    public static final GemClass CURIOS = new GemClass("curios",
            Curios.BACK, Curios.BELT, Curios.BODY, Curios.BRACELET, Curios.CHARM,
            Curios.CURIO, Curios.FEET, Curios.HANDS, Curios.HEAD, Curios.NECKLACE,
            Curios.RING, Curios.BROOCH, Curios.RUNE, Curios.AN_FOCUS
    );

    @Override
    public @NotNull String getName() {
        return "Curios Extra Gem Bonuses";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        addBonus(Apotheosis.loc("core/ballast"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.015)
                        .value(Purity.CHIPPED, 0.025)
                        .value(Purity.FLAWED, 0.035)
                        .value(Purity.NORMAL, 0.045)
                        .value(Purity.FLAWLESS, 0.05)
                        .value(Purity.PERFECT, 0.075)));

        addBonus(Apotheosis.loc("core/brawlers"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.5)
                        .value(Purity.CHIPPED, 1)
                        .value(Purity.FLAWED, 1.5)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 2.5)
                        .value(Purity.PERFECT, 3)));

        addBonus(Apotheosis.loc("core/breach"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ARMOR_TOUGHNESS)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 1.5)
                        .value(Purity.FLAWED, 2)
                        .value(Purity.NORMAL, 2.5)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("core/combatant"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_CHANCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.02)
                        .value(Purity.FLAWED, 0.04)
                        .value(Purity.FLAWED, 0.06)
                        .value(Purity.NORMAL, 0.08)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.12)));

        addBonus(Apotheosis.loc("core/guardian"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.KNOCKBACK_RESISTANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.06)
                        .value(Purity.FLAWED, 0.07)
                        .value(Purity.NORMAL, 0.08)
                        .value(Purity.FLAWLESS, 0.09)
                        .value(Purity.PERFECT, 0.1)));

        addBonus(Apotheosis.loc("core/lightning"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.SNEAKING_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.025)
                        .value(Purity.CHIPPED, 0.05)
                        .value(Purity.FLAWED, 0.075)
                        .value(Purity.NORMAL, 0.1)
                        .value(Purity.FLAWLESS, 0.125)
                        .value(Purity.PERFECT, 0.15)));

        addBonus(Apotheosis.loc("core/lunar"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.LUCK)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addBonus(Apotheosis.loc("core/samurai"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_SHRED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.01)
                        .value(Purity.CHIPPED, 0.03)
                        .value(Purity.FLAWED, 0.05)
                        .value(Purity.NORMAL, 0.07)
                        .value(Purity.FLAWLESS, 0.09)
                        .value(Purity.PERFECT, 0.1)));

        addBonus(Apotheosis.loc("core/slipstream"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.MOVEMENT_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.075)
                        .value(Purity.FLAWED, 0.1)
                        .value(Purity.NORMAL, 0.125)
                        .value(Purity.FLAWLESS, 0.15)
                        .value(Purity.PERFECT, 0.2)));

        addBonus(Apotheosis.loc("core/solar"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROT_PIERCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.02)
                        .value(Purity.CHIPPED, 0.04)
                        .value(Purity.FLAWED, 0.06)
                        .value(Purity.NORMAL, 0.8)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.12)));

        addBonus(Apotheosis.loc("core/splendor"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.HEALING_RECEIVED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.025)
                        .value(Purity.CHIPPED, 0.05)
                        .value(Purity.FLAWED, 0.075)
                        .value(Purity.NORMAL, 0.1)
                        .value(Purity.FLAWLESS, 0.125)
                        .value(Purity.PERFECT, 0.15)));

        addBonus(Apotheosis.loc("core/tyrannical"), b -> b
                .bonus(CURIOS, MultiAttrBonus.builder()
                        .desc("bonus.apotheosis:multi_attr.desc.and")
                        .modifier(a -> a
                                .attr(ALObjects.Attributes.EXPERIENCE_GAINED)
                                .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                                .value(Purity.CRACKED, 0.1f)
                                .value(Purity.CHIPPED, 0.125f)
                                .value(Purity.FLAWED, 0.15f)
                                .value(Purity.NORMAL, 0.175f)
                                .value(Purity.FLAWLESS, 0.2f)
                                .value(Purity.PERFECT, 0.25f))
                        .modifier(a -> a
                                .attr(Attributes.LUCK)
                                .op(AttributeModifier.Operation.ADD_VALUE)
                                .value(Purity.CRACKED, -1)
                                .value(Purity.CHIPPED, -2)
                                .value(Purity.FLAWED, -3)
                                .value(Purity.NORMAL, -4)
                                .value(Purity.FLAWLESS, -5)
                                .value(Purity.PERFECT, -6))));

        addBonus(Apotheosis.loc("core/warlord"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_KNOCKBACK)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.025)
                        .value(Purity.CHIPPED, 0.05)
                        .value(Purity.FLAWED, 0.075)
                        .value(Purity.NORMAL, 0.1)
                        .value(Purity.FLAWLESS, 0.125)
                        .value(Purity.PERFECT, 0.15)));

        addBonus(Apotheosis.loc("overworld/earth"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.BLOCK_BREAK_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.05)
                        .value(Purity.NORMAL, 0.075)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.125)));

        addBonus(Apotheosis.loc("overworld/royalty"), b -> b
                .bonus(CURIOS, AllStatsBonus.builder()
                .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .value(Purity.FLAWED, 0.01F)
                .value(Purity.NORMAL, 0.015F)
                .value(Purity.FLAWLESS, 0.02F)
                .value(Purity.PERFECT, 0.025F)
                .attributes(
                        Attributes.MAX_HEALTH,
                        Attributes.KNOCKBACK_RESISTANCE,
                        Attributes.MOVEMENT_SPEED,
                        Attributes.ATTACK_DAMAGE,
                        Attributes.ATTACK_KNOCKBACK,
                        Attributes.ATTACK_SPEED,
                        Attributes.BLOCK_BREAK_SPEED,
                        Attributes.ARMOR,
                        Attributes.ARMOR_TOUGHNESS,
                        Attributes.LUCK,
                        Attributes.STEP_HEIGHT,
                        Attributes.BLOCK_INTERACTION_RANGE,
                        Attributes.ENTITY_INTERACTION_RANGE,
                        ALObjects.Attributes.ARMOR_PIERCE,
                        ALObjects.Attributes.ARMOR_SHRED,
                        ALObjects.Attributes.ARROW_DAMAGE,
                        ALObjects.Attributes.ARROW_VELOCITY,
                        ALObjects.Attributes.COLD_DAMAGE,
                        ALObjects.Attributes.CRIT_CHANCE,
                        ALObjects.Attributes.CRIT_DAMAGE,
                        ALObjects.Attributes.CURRENT_HP_DAMAGE,
                        ALObjects.Attributes.DODGE_CHANCE,
                        ALObjects.Attributes.EXPERIENCE_GAINED,
                        ALObjects.Attributes.FIRE_DAMAGE,
                        ALObjects.Attributes.GHOST_HEALTH,
                        ALObjects.Attributes.HEALING_RECEIVED,
                        ALObjects.Attributes.LIFE_STEAL,
                        ALObjects.Attributes.OVERHEAL,
                        ALObjects.Attributes.PROT_PIERCE,
                        ALObjects.Attributes.PROT_SHRED,
                        NeoForgeMod.SWIM_SPEED)));


        addBonus(Apotheosis.loc("overworld/verdant_ruin"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.COLD_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.02)
                        .value(Purity.CHIPPED, 0.04)
                        .value(Purity.FLAWED, 0.06)
                        .value(Purity.NORMAL, 0.08)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.12)));

        addBonus(Apotheosis.loc("the_nether/blood_lord"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.BURNING_TIME)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, -0.05f)
                        .value(Purity.CHIPPED, -0.075f)
                        .value(Purity.FLAWED, -0.1f)
                        .value(Purity.NORMAL, -0.125f)
                        .value(Purity.FLAWLESS, -0.15f)
                        .value(Purity.PERFECT, -0.175f)));

        addBonus(Apotheosis.loc("the_nether/inferno"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.LIFE_STEAL)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.03)
                        .value(Purity.CHIPPED, 0.04)
                        .value(Purity.FLAWED, 0.05)
                        .value(Purity.NORMAL, 0.06)
                        .value(Purity.FLAWLESS, 0.07)
                        .value(Purity.PERFECT, 0.08)));

        addBonus(Apotheosis.loc("the_nether/molten_breach"), b -> b
                .bonus(CURIOS, DamageReductionBonus.builder()
                        .damageType(DamageReductionAffix.DamageType.FIRE)
                        .value(Purity.FLAWED, 0.025f)
                        .value(Purity.NORMAL, 0.05f)
                        .value(Purity.FLAWLESS, 0.075f)
                        .value(Purity.PERFECT, 0.1f)));

        addBonus(Apotheosis.loc("the_end/mageslayer"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_PIERCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.02)
                        .value(Purity.CHIPPED, 0.04)
                        .value(Purity.FLAWED, 0.06)
                        .value(Purity.NORMAL, 0.08)
                        .value(Purity.FLAWLESS, 0.1)
                        .value(Purity.PERFECT, 0.12)));

        addTwilightBonus(Apotheosis.loc("twilight/queen"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROJECTILE_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.03f)
                        .value(Purity.NORMAL, 0.06f)
                        .value(Purity.FLAWLESS, 0.9f)
                        .value(Purity.PERFECT, 0.12f)));

        addTwilightBonus(Apotheosis.loc("twilight/forest"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.05f)
                        .value(Purity.NORMAL, 0.075f)
                        .value(Purity.FLAWLESS, 0.1f)
                        .value(Purity.PERFECT, 0.125f)));

//        addModdedBonus(ApothicCompats.loc("ars_nouveau/mana"), "ars_nouveau", b -> b
//                .bonus(CURIOS, AttributeBonus.builder()
//                        .attr(PerkAttributes.MAX_MANA)
//                        .op(AttributeModifier.Operation.ADD_VALUE)
//                        .value(Purity.CRACKED, 10)
//                        .value(Purity.CHIPPED, 20)
//                        .value(Purity.FLAWED, 30)
//                        .value(Purity.NORMAL, 40)
//                        .value(Purity.FLAWLESS, 50)
//                        .value(Purity.PERFECT, 75)));
//
//        addModdedBonus(ApothicCompats.loc("malum/soul_stained"), "malum", b -> b
//                .bonus(CURIOS, AttributeBonus.builder()
//                        .attr(MalumAttributes.CHARGE_CAPACITY)
//                        .op(AttributeModifier.Operation.ADD_VALUE)
//                        .value(Purity.CRACKED, 1)
//                        .value(Purity.CHIPPED, 2)
//                        .value(Purity.FLAWED, 3)
//                        .value(Purity.NORMAL, 4)
//                        .value(Purity.FLAWLESS, 5)
//                        .value(Purity.PERFECT, 6)));
//
//        addModdedBonus(ApothicCompats.loc("malum/thief"), "malum", b -> b
//                .bonus(CURIOS, AttributeBonus.builder()
//                        .attr(MalumAttributes.MALIGNANT_CONVERSION)
//                        .op(AttributeModifier.Operation.ADD_VALUE)
//                        .value(Purity.CRACKED, 0.15)
//                        .value(Purity.CHIPPED, 0.2)
//                        .value(Purity.FLAWED, 0.25)
//                        .value(Purity.NORMAL, 0.3)
//                        .value(Purity.FLAWLESS, 0.35)
//                        .value(Purity.PERFECT, 0.5)));
//
//        addModdedBonus(ApothicCompats.loc("malum/etheric"), "malum", b -> b
//                .bonus(CURIOS, AttributeBonus.builder()
//                        .attr(MalumAttributes.SOUL_WARD_CAPACITY)
//                        .op(AttributeModifier.Operation.ADD_VALUE)
//                        .value(Purity.FLAWED, 3)
//                        .value(Purity.NORMAL, 6)
//                        .value(Purity.FLAWLESS, 9)
//                        .value(Purity.PERFECT, 12)));
        
    }

    private void addBonus(Identifier gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"));
    }

    private void addTwilightBonus(Identifier gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition("twilightforest"));
    }

    private void addModdedBonus(Identifier gem, String mod, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + mod + "/" + gem.getPath().replace(mod + "/", "")), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition(mod));
    }
}
