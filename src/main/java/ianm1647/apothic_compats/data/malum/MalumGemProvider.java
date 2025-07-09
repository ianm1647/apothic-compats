package ianm1647.apothic_compats.data.malum;

import com.sammy.malum.registry.common.MalumAttributes;
import com.sammy.malum.registry.common.MalumMobEffects;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.data.GemProvider;
import dev.shadowsoffire.apotheosis.socket.gem.Gem;
import dev.shadowsoffire.apotheosis.socket.gem.GemClass;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MobEffectBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MultiAttrBonus;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import ianm1647.apothic_compats.ApothicCompats;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class MalumGemProvider extends GemProvider {
    public MalumGemProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static final GemClass MALUM_WEAPON = new GemClass("malum_weapon", ModLootCategories.SCYTHE, ModLootCategories.STAFF);

    String mod = "malum";

    @Override
    public String getName() {
        return "Malum Gems";
    }

    @Override
    public void generate() {
        addGem("malum/soul_stained", TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY), c -> c
                .contstraints(Constraints.forDimension(Level.OVERWORLD))
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(MalumAttributes.SPIRIT_SPOILS)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6))
                .bonus(CORE_ARMOR, AttributeBonus.builder()
                        .attr(MalumAttributes.SCYTHE_PROFICIENCY)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.25)
                        .value(Purity.FLAWED, 0.35)
                        .value(Purity.NORMAL, 0.45)
                        .value(Purity.FLAWLESS, 0.55)
                        .value(Purity.PERFECT, 0.65))
                .bonus(LIGHT_WEAPON, MobEffectBonus.builder()
                        .effect(MalumMobEffects.ASCENSION)
                        .target(MobEffectAffix.Target.ATTACK_SELF)
                        .value(Purity.CRACKED, 40, 0)
                        .value(Purity.CHIPPED, 60, 0)
                        .value(Purity.FLAWED, 80, 1)
                        .value(Purity.NORMAL, 100, 1)
                        .value(Purity.FLAWLESS, 120, 2)
                        .value(Purity.PERFECT, 140, 2))
                .bonus(Apoth.LootCategories.HELMET, AttributeBonus.builder()
                        .attr(MalumAttributes.GEAS_LIMIT)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.FLAWED, 1)
                        .value(Purity.NORMAL, 2)
                        .value(Purity.FLAWLESS, 3)
                        .value(Purity.PERFECT, 4)));

        addGem("malum/thief", TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY), c -> c
                .contstraints(Constraints.forDimension(Level.OVERWORLD))
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.LIFE_STEAL)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.05)
                        .value(Purity.CHIPPED, 0.1)
                        .value(Purity.FLAWED, 0.15)
                        .value(Purity.NORMAL, 0.2)
                        .value(Purity.FLAWLESS, 0.25)
                        .value(Purity.PERFECT, 0.3))
                .bonus(Apoth.LootCategories.HELMET, AttributeBonus.builder()
                        .attr(MalumAttributes.CHARGE_CAPACITY)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6))
                .bonus(LIGHT_WEAPON, MobEffectBonus.builder()
                        .effect(MalumMobEffects.ECHOING_ARCANA)
                        .target(MobEffectAffix.Target.ATTACK_SELF)
                        .value(Purity.CRACKED, 40, 0)
                        .value(Purity.CHIPPED, 60, 0)
                        .value(Purity.FLAWED, 80, 1)
                        .value(Purity.NORMAL, 100, 1)
                        .value(Purity.FLAWLESS, 120, 2)
                        .value(Purity.PERFECT, 140, 2))
                .bonus(CORE_ARMOR, MultiAttrBonus.builder()
                        .desc("bonus.apotheosis:multi_attr.desc.and")
                        .modifier(b -> b
                                .attr(MalumAttributes.SOUL_WARD_RECOVERY_RATE)
                                .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                                .value(Purity.NORMAL, 0.4F)
                                .value(Purity.FLAWLESS, 0.5F)
                                .value(Purity.PERFECT, 0.6F))
                        .modifier(b -> b
                                .attr(MalumAttributes.SOUL_WARD_CAPACITY)
                                .op(AttributeModifier.Operation.ADD_VALUE)
                                .value(Purity.NORMAL, -3)
                                .value(Purity.FLAWLESS, -6)
                                .value(Purity.PERFECT, -9))));

        addGem("malum/etheric", TieredWeights.forTiersAbove(WorldTier.ASCENT, DEFAULT_WEIGHT, DEFAULT_QUALITY), c -> c
                .contstraints(Constraints.forDimension(Level.OVERWORLD))
                .bonus(MALUM_WEAPON, AttributeBonus.builder()
                        .attr(ALObjects.Attributes.FIRE_DAMAGE)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 1)
                        .value(Purity.CHIPPED, 2)
                        .value(Purity.FLAWED, 3)
                        .value(Purity.NORMAL, 4)
                        .value(Purity.FLAWLESS, 5)
                        .value(Purity.PERFECT, 6))
                .bonus(CORE_ARMOR, AttributeBonus.builder()
                        .attr(MalumAttributes.ARCANE_RESONANCE)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.25)
                        .value(Purity.FLAWED, 0.35)
                        .value(Purity.NORMAL, 0.45)
                        .value(Purity.FLAWLESS, 0.55)
                        .value(Purity.PERFECT, 0.65))
                .bonus(LIGHT_WEAPON, MobEffectBonus.builder()
                        .effect(MalumMobEffects.PYROMANIACS_FERVOR)
                        .target(MobEffectAffix.Target.ATTACK_SELF)
                        .value(Purity.CRACKED, 40, 0)
                        .value(Purity.CHIPPED, 60, 0)
                        .value(Purity.FLAWED, 80, 1)
                        .value(Purity.NORMAL, 100, 1)
                        .value(Purity.FLAWLESS, 120, 2)
                        .value(Purity.PERFECT, 140, 2)));

    }

    private void addGem(String name, TieredWeights weights, UnaryOperator<Gem.Builder> config) {
        var builder = new Gem.Builder(weights);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(name), builder.build(), new ModLoadedCondition(mod));
    }
}
