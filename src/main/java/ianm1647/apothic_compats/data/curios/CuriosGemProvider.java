package ianm1647.apothic_compats.data.curios;

import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.data.GemProvider;
import dev.shadowsoffire.apotheosis.socket.gem.Gem;
import dev.shadowsoffire.apotheosis.socket.gem.GemClass;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.*;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class CuriosGemProvider extends GemProvider {
    String mod = "curios";

    public CuriosGemProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static final GemClass HAND_CURIOS = new GemClass("hand_curios", ModLootCategories.HANDS, ModLootCategories.BRACELET, ModLootCategories.RING);
    public static final GemClass BODY_CURIOS = new GemClass("body_curios", ModLootCategories.BODY, ModLootCategories.BACK, ModLootCategories.BELT, ModLootCategories.FEET);
    public static final GemClass HEAD_CURIOS = new GemClass("head_curios", ModLootCategories.HEAD, ModLootCategories.NECKLACE);
    public static final GemClass CHARM_CURIO = new GemClass("charm_curio", ModLootCategories.CHARM, ModLootCategories.CURIO);

    @Override
    public String getName() {
        return "Curios Gems";
    }

    @Override
    public void generate() {
        HolderLookup.Provider registries = this.lookupProvider.join();
        HolderLookup.RegistryLookup<Enchantment> enchants = registries.lookup(Registries.ENCHANTMENT).get();

        addGem("curios/hasty", c -> c
                .bonus(HEAD_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.BLOCK_BREAK_SPEED)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.5)
                        .value(Purity.CHIPPED, 1)
                        .value(Purity.FLAWED, 1.5)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 2.5)
                        .value(Purity.PERFECT, 3))
                .bonus(HAND_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.075)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.125)
                        .value(Purity.NORMAL, 0.15)
                        .value(Purity.FLAWLESS, 0.175)
                        .value(Purity.PERFECT, 0.2))
                .bonus(BODY_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.MOVEMENT_EFFICIENCY)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.1)
                        .value(Purity.CHIPPED, 0.15)
                        .value(Purity.FLAWED, 0.2)
                        .value(Purity.NORMAL, 0.25)
                        .value(Purity.FLAWLESS, 0.3)
                        .value(Purity.PERFECT, 0.35))
                .bonus(CHARM_CURIO, AttributeBonus.builder()
                        .attr(Attributes.SNEAKING_SPEED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3)));

        addGem("curios/destroyer", c -> c
                .minPurity(Purity.FLAWED)
                .bonus(HEAD_CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.CRIT_CHANCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.3)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.4))
                .bonus(HAND_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6))
                .bonus(BODY_CURIOS, MobEffectBonus.builder()
                        .effect(MobEffects.DAMAGE_RESISTANCE)
                        .target(MobEffectAffix.Target.ATTACK_SELF)
                        .value(Purity.FLAWED, 300, 0, 1200)
                        .value(Purity.NORMAL, 360, 1, 1200)
                        .value(Purity.FLAWLESS, 420, 1, 1200)
                        .value(Purity.PERFECT, 540, 2, 1200))
                .bonus(CHARM_CURIO, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.ARMOR_SHRED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.3)
                        .value(Purity.NORMAL, 0.4)
                        .value(Purity.FLAWLESS, 0.5)
                        .value(Purity.PERFECT, 0.6)));

        addGem("curios/hardened", c -> c
                .minPurity(Purity.FLAWED)
                .bonus(HEAD_CURIOS, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.EXPERIENCE_GAINED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.FLAWED, 0.2)
                        .value(Purity.NORMAL, 0.25)
                        .value(Purity.FLAWLESS, 0.3)
                        .value(Purity.PERFECT, 0.35))
                .bonus(HAND_CURIOS, EnchantmentBonus.builder()
                        .enchantment(enchants.getOrThrow(Enchantments.LOOTING))
                        .mode(EnchantmentBonus.Mode.EXISTING)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4))
                .bonus(BODY_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.LUCK)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6))
                .bonus(CHARM_CURIO, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.HEALING_RECEIVED)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.35)
                        .value(Purity.FLAWLESS, 0.45)
                        .value(Purity.PERFECT, 0.55)));

        addGem("curios/refusal", c -> c
                .bonus(HEAD_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.KNOCKBACK_RESISTANCE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.1)
                        .value(Purity.CHIPPED, 0.2)
                        .value(Purity.FLAWED, 0.3)
                        .value(Purity.NORMAL, 0.4)
                        .value(Purity.FLAWLESS, 0.5)
                        .value(Purity.PERFECT, 0.6))
                .bonus(HAND_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.ATTACK_KNOCKBACK)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3))
                .bonus(BODY_CURIOS, AttributeBonus.builder()
                        .attr(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.2)
                        .value(Purity.FLAWED, 0.25)
                        .value(Purity.NORMAL, 0.3)
                        .value(Purity.FLAWLESS, 0.35)
                        .value(Purity.PERFECT, 0.4))
                .bonus(CHARM_CURIO, AttributeBonus.builder()
                        .attr(Attributes.ARMOR_TOUGHNESS)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 0.5)
                        .value(Purity.CHIPPED, 1)
                        .value(Purity.FLAWED, 1.5)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 2.5)
                        .value(Purity.PERFECT, 3)));
    }

    private void addGem(String name, UnaryOperator<Gem.Builder> config) {
        addGem(name, TieredWeights.forAllTiers(DEFAULT_WEIGHT, DEFAULT_QUALITY), config);
    }

    private void addGem(String name, TieredWeights weights, UnaryOperator<Gem.Builder> config) {
        var builder = new Gem.Builder(weights);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(name), builder.build(), new ModLoadedCondition(mod));
    }
}
