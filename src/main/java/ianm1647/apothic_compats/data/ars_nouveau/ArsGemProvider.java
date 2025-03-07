package ianm1647.apothic_compats.data.ars_nouveau;

import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.hollingsworth.arsnouveau.setup.registry.ModPotions;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.affix.effect.MobEffectAffix;
import dev.shadowsoffire.apotheosis.data.GemProvider;
import dev.shadowsoffire.apotheosis.socket.gem.Gem;
import dev.shadowsoffire.apotheosis.socket.gem.Purity;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.AttributeBonus;
import dev.shadowsoffire.apotheosis.socket.gem.bonus.MobEffectBonus;
import dev.shadowsoffire.apotheosis.tiers.Constraints;
import dev.shadowsoffire.apotheosis.tiers.TieredWeights;
import dev.shadowsoffire.apotheosis.tiers.WorldTier;
import ianm1647.apothic_compats.ApothicCompats;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

public class ArsGemProvider extends GemProvider {
    public ArsGemProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    String mod = "ars_nouveau";

    @Override
    public String getName() {
        return "Ars Nouveau Gems";
    }

    @Override
    public void generate() {
        addGem("ars_nouveau/mana", TieredWeights.forTiersAbove(WorldTier.FRONTIER, DEFAULT_WEIGHT, DEFAULT_QUALITY), c -> c
                .unique()
                .contstraints(Constraints.forDimension(Level.OVERWORLD))
                .bonus(Apoth.LootCategories.HELMET, AttributeBonus.builder()
                        .attr(PerkAttributes.MAX_MANA)
                        .op(AttributeModifier.Operation.ADD_VALUE)
                        .value(Purity.CRACKED, 10)
                        .value(Purity.CHIPPED, 25)
                        .value(Purity.FLAWED, 50)
                        .value(Purity.NORMAL, 75)
                        .value(Purity.FLAWLESS, 100)
                        .value(Purity.PERFECT, 200))
                .bonus(Apoth.LootCategories.CHESTPLATE, AttributeBonus.builder()
                        .attr(PerkAttributes.MANA_REGEN_BONUS)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.25)
                        .value(Purity.FLAWED, 0.3)
                        .value(Purity.NORMAL, 0.45)
                        .value(Purity.FLAWLESS, 0.75)
                        .value(Purity.PERFECT, 1.25))
                .bonus(LOWER_ARMOR, AttributeBonus.builder()
                        .attr(PerkAttributes.SPELL_DAMAGE_BONUS)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.CRACKED, 0.15)
                        .value(Purity.CHIPPED, 0.25)
                        .value(Purity.FLAWED, 0.3)
                        .value(Purity.NORMAL, 0.45)
                        .value(Purity.FLAWLESS, 0.75)
                        .value(Purity.PERFECT, 1.25))
                .bonus(Apoth.LootCategories.SHIELD, AttributeBonus.builder()
                        .attr(PerkAttributes.WARDING)
                        .op(AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                        .value(Purity.FLAWED, 0.05)
                        .value(Purity.NORMAL, 0.1)
                        .value(Purity.FLAWLESS, 0.15)
                        .value(Purity.PERFECT, 0.2))
                .bonus(LIGHT_WEAPON, MobEffectBonus.builder()
                        .effect(ModPotions.FREEZING_EFFECT)
                        .target(MobEffectAffix.Target.ATTACK_TARGET)
                        .value(Purity.FLAWLESS, 240, 0, 600)
                        .value(Purity.PERFECT, 400, 1, 300)));

    }

    private void addGem(String name, TieredWeights weights, UnaryOperator<Gem.Builder> config) {
        var builder = new Gem.Builder(weights);
        config.apply(builder);
        this.addConditionally(ApothicCompats.loc(name), builder.build(), new ModLoadedCondition(mod));
    }
}
