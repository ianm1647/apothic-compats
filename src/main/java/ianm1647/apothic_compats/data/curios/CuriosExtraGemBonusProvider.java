package ianm1647.apothic_compats.data.curios;

import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.sammy.malum.registry.common.MalumAttributes;
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
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
            ModLootCategories.HANDS, ModLootCategories.BRACELET, ModLootCategories.RING, ModLootCategories.BODY, ModLootCategories.BACK,
            ModLootCategories.BELT, ModLootCategories.FEET, ModLootCategories.HEAD, ModLootCategories.NECKLACE, ModLootCategories.CHARM,
            ModLootCategories.CURIO, ModLootCategories.BROOCH, ModLootCategories.RUNE, ModLootCategories.AN_FOCUS
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
                        .value(Purity.CRACKED, 0.075)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.125)
                        .value(Purity.NORMAL, 0.15)
                        .value(Purity.FLAWLESS, 0.175)
                        .value(Purity.PERFECT, 0.2)));

        addBonus(Apotheosis.loc("core/brawlers"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6)));

        addBonus(Apotheosis.loc("core/breach"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ARMOR_TOUGHNESS)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 1.5)
                        .value(Purity.FLAWED, 2)
                        .value(Purity.NORMAL, 2.5)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 5)));

        addBonus(Apotheosis.loc("core/combatant"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_CHANCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.05)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.3)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.4)));

        addBonus(Apotheosis.loc("core/guardian"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.KNOCKBACK_RESISTANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3)));

        addBonus(Apotheosis.loc("core/lightning"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.SNEAKING_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3)));

        addBonus(Apotheosis.loc("core/lunar"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.LUCK)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 2)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 6)
                        .value(Purity.PERFECT, 8)));

        addBonus(Apotheosis.loc("core/samurai"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_SHRED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3)));

        addBonus(Apotheosis.loc("core/slipstream"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.MOVEMENT_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.1)
                        .value(Purity.CHIPPED, 0.15)
                        .value(Purity.FLAWED, 0.2)
                        .value(Purity.NORMAL, 0.25)
                        .value(Purity.FLAWLESS, 0.3)
                        .value(Purity.PERFECT, 0.35)));

        addBonus(Apotheosis.loc("core/solar"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROT_PIERCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.125)
                        .value(Purity.FLAWED, 0.2)
                        .value(Purity.NORMAL, 0.275)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.425)));

        addBonus(Apotheosis.loc("core/splendor"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.HEALING_RECEIVED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.25)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.45)));

        addBonus(Apotheosis.loc("core/tyrannical"), b -> b
                .bonus(CURIOS, MultiAttrBonus.builder()
                        .desc("bonus.apotheosis:multi_attr.desc.and")
                        .modifier(a -> a
                                .attr(ALObjects.Attributes.EXPERIENCE_GAINED)
                                .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                                .value(Purity.CRACKED, 0.1f)
                                .value(Purity.CHIPPED, 0.15f)
                                .value(Purity.FLAWED, 0.2f)
                                .value(Purity.NORMAL, 0.35f)
                                .value(Purity.FLAWLESS, 0.5f)
                                .value(Purity.PERFECT, 0.65f))
                        .modifier(a -> a
                                .attr(Attributes.LUCK)
                                .op(AttributeModifier.Operation.ADD_VALUE)
                                .value(Purity.CRACKED, -1)
                                .value(Purity.CHIPPED, -2)
                                .value(Purity.FLAWED, -3)
                                .value(Purity.NORMAL, -4)
                                .value(Purity.FLAWLESS, -5)
                                .value(Purity.PERFECT, -7))));

        addBonus(Apotheosis.loc("core/warlord"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_KNOCKBACK)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.45)));

        addBonus(Apotheosis.loc("overworld/earth"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.MINING_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.1)
                        .value(Purity.NORMAL, 0.15)
                        .value(Purity.FLAWLESS, 0.2)
                        .value(Purity.PERFECT, 0.3)));

        addBonus(Apotheosis.loc("overworld/royalty"), b -> b
                .bonus(CURIOS, AllStatsBonus.builder()
                .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .value(Purity.FLAWED, 0.025F)
                .value(Purity.NORMAL, 0.05F)
                .value(Purity.FLAWLESS, 0.075F)
                .value(Purity.PERFECT, 0.1F)
                .attributes(
                        Attributes.MAX_HEALTH,
                        Attributes.KNOCKBACK_RESISTANCE,
                        Attributes.MOVEMENT_SPEED,
                        Attributes.ATTACK_DAMAGE,
                        Attributes.ATTACK_KNOCKBACK,
                        Attributes.ATTACK_SPEED,
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
                        ALObjects.Attributes.MINING_SPEED,
                        ALObjects.Attributes.OVERHEAL,
                        ALObjects.Attributes.PROT_PIERCE,
                        ALObjects.Attributes.PROT_SHRED,
                        NeoForgeMod.SWIM_SPEED)));


        addBonus(Apotheosis.loc("overworld/verdant_ruin"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.COLD_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.35)));

        addBonus(Apotheosis.loc("the_nether/blood_lord"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.BURNING_TIME)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, -0.1f)
                        .value(Purity.CHIPPED, -0.15f)
                        .value(Purity.FLAWED, -0.2f)
                        .value(Purity.NORMAL, -0.25f)
                        .value(Purity.FLAWLESS, -0.35f)
                        .value(Purity.PERFECT, -0.5f)));

        addBonus(Apotheosis.loc("the_nether/inferno"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.LIFE_STEAL)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.10)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.20)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.45)));

        addBonus(Apotheosis.loc("the_nether/molten_breach"), b -> b
                .bonus(CURIOS, DamageReductionBonus.builder()
                        .damageType(DamageReductionAffix.DamageType.FIRE)
                        .value(Purity.FLAWED, 0.025f)
                        .value(Purity.NORMAL, 0.05f)
                        .value(Purity.FLAWLESS, 0.075f)
                        .value(Purity.PERFECT, 0.1f)));

        addBonus(Apotheosis.loc("the_end/mageslayer"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(Attributes.KNOCKBACK_RESISTANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.25)
                        .value(Purity.FLAWED, 0.35)
                        .value(Purity.NORMAL, 0.45)
                        .value(Purity.FLAWLESS, 0.55)
                        .value(Purity.PERFECT, 0.7)));

        addTwilightBonus(Apotheosis.loc("twilight/queen"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.PROJECTILE_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.15f)
                        .value(Purity.NORMAL, 0.25f)
                        .value(Purity.FLAWLESS, 0.35f)
                        .value(Purity.PERFECT, 0.5f)));

        addTwilightBonus(Apotheosis.loc("twilight/forest"), b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.15f)
                        .value(Purity.NORMAL, 0.25f)
                        .value(Purity.FLAWLESS, 0.35f)
                        .value(Purity.PERFECT, 0.5f)));

        addModdedBonus(ApothicCompats.loc("ars_nouveau/mana"), "ars_nouveau", b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(PerkAttributes.MAX_MANA)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 10)
                        .value(Purity.CHIPPED, 20)
                        .value(Purity.FLAWED, 30)
                        .value(Purity.NORMAL, 40)
                        .value(Purity.FLAWLESS, 50)
                        .value(Purity.PERFECT, 75)));

        addModdedBonus(ApothicCompats.loc("malum/soul_stained"), "malum", b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(MalumAttributes.CHARGE_CAPACITY)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6)));

        addModdedBonus(ApothicCompats.loc("malum/thief"), "malum", b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(MalumAttributes.MALIGNANT_CONVERSION)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.2)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.3)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.5)));

        addModdedBonus(ApothicCompats.loc("malum/etheric"), "malum", b -> b
                .bonus(CURIOS, AttributeBonus.builder()
                        .attr(MalumAttributes.SOUL_WARD_CAPACITY)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 6)
                        .value(Purity.FLAWLESS, 9)
                        .value(Purity.PERFECT, 12)));
        
    }

    private void addBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"));
    }

    private void addTwilightBonus(ResourceLocation gem, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + gem.getNamespace() + "/" + gem.getPath()), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition("twilightforest"));
    }

    private void addModdedBonus(ResourceLocation gem, String mod, UnaryOperator<ExtraGemBonusRegistry.ExtraGemBonus.Builder> config) {
        var builder = ExtraGemBonusRegistry.ExtraGemBonus.builder(GemRegistry.INSTANCE.holder(gem));
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc("curios/" + mod + "/" + gem.getPath().replace(mod + "/", "")), builder.build(), new ModLoadedCondition("curios"), new ModLoadedCondition(mod));
    }
}
