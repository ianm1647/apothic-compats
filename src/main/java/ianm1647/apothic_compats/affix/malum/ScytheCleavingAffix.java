package ianm1647.apothic_compats.affix.malum;

import com.google.common.base.Predicate;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.shadowsoffire.apotheosis.AdventureConfig;
import dev.shadowsoffire.apotheosis.affix.Affix;
import dev.shadowsoffire.apotheosis.affix.AffixBuilder;
import dev.shadowsoffire.apotheosis.affix.AffixDefinition;
import dev.shadowsoffire.apotheosis.affix.AffixInstance;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.loot.LootRarity;
import dev.shadowsoffire.apothic_attributes.ApothicAttributes;
import dev.shadowsoffire.placebo.util.StepFunction;
import ianm1647.apothic_compats.loot.ModLootCategories;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;
import org.spongepowered.include.com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ScytheCleavingAffix extends Affix {
    public static final Codec<ScytheCleavingAffix> CODEC = RecordCodecBuilder.create((inst) -> {
        return inst.group(affixDef(), LootRarity.mapCodec(ScytheCleavingAffix.CleaveValues.CODEC).fieldOf("values").forGetter((a) -> {
            return a.values;
        })).apply(inst, ScytheCleavingAffix::new);
    });
    protected final Map<LootRarity, ScytheCleavingAffix.CleaveValues> values;
    private static boolean cleaving = false;

    public ScytheCleavingAffix(AffixDefinition def, Map<LootRarity, ScytheCleavingAffix.CleaveValues> values) {
        super(def);
        this.values = values;
    }

    public boolean canApplyTo(ItemStack stack, LootCategory cat, LootRarity rarity) {
        return ModLootCategories.isScythe(cat) && this.values.containsKey(rarity);
    }

    public MutableComponent getDescription(AffixInstance inst, AttributeTooltipContext ctx) {
        return Component.translatable("affix." + String.valueOf(this.id()) + ".desc", new Object[]{fmt(100.0F * this.getChance(inst.getRarity(), inst.level())), this.getTargets(inst.getRarity(), inst.level())});
    }

    public Component getAugmentingText(AffixInstance inst, AttributeTooltipContext ctx) {
        MutableComponent comp = this.getDescription(inst, ctx);
        LootRarity rarity = inst.getRarity();
        float minChance = this.getChance(rarity, 0.0F);
        float maxChance = this.getChance(rarity, 1.0F);
        if (minChance != maxChance) {
            Component minComp = Component.translatable("%s%%", new Object[]{fmt(100.0F * minChance)});
            Component maxComp = Component.translatable("%s%%", new Object[]{fmt(100.0F * maxChance)});
            comp.append(valueBounds(minComp, maxComp));
        }

        int minTargets = this.getTargets(rarity, 0.0F);
        int maxTargets = this.getTargets(rarity, 1.0F);
        if (minTargets != maxTargets) {
            Component minComp = Component.literal(fmt((float)minTargets));
            Component maxComp = Component.literal(fmt((float)maxTargets));
            return comp.append(valueBounds(minComp, maxComp));
        } else {
            return comp;
        }
    }

    private float getChance(LootRarity rarity, float level) {
        return ((ScytheCleavingAffix.CleaveValues)this.values.get(rarity)).chance.get(level);
    }

    private int getTargets(LootRarity rarity, float level) {
        return ((ScytheCleavingAffix.CleaveValues)this.values.get(rarity)).targets.getInt(level);
    }

    public void doPostAttack(AffixInstance inst, LivingEntity user, Entity target) {
        if ((double) ApothicAttributes.getLocalAtkStrength(user) >= 0.98 && !cleaving && !user.level().isClientSide) {
            cleaving = true;
            float chance = this.getChance(inst.getRarity(), inst.level());
            int targets = this.getTargets(inst.getRarity(), inst.level());
            if (user.level().random.nextFloat() < chance && user instanceof Player) {
                Player player = (Player)user;
                List<Entity> nearby = target.level().getEntities(target, (new AABB(target.blockPosition())).inflate(6.0), cleavePredicate(user, target));
                Iterator var8 = nearby.iterator();

                while(var8.hasNext()) {
                    Entity e = (Entity)var8.next();
                    if (targets > 0) {
                        ((Player) user).getAttackStrengthScale(300);
                        player.attack(e);
                        --targets;
                    }
                }
            }

            cleaving = false;
        }

    }

    public Codec<? extends Affix> getCodec() {
        return CODEC;
    }

    public static Predicate<Entity> cleavePredicate(Entity user, Entity target) {
        return (e) -> {
            if (e instanceof Animal && !(target instanceof Animal) || e instanceof AbstractVillager && !(target instanceof AbstractVillager)) {
                return false;
            } else if (!AdventureConfig.cleaveHitsPlayers && e instanceof Player) {
                return false;
            } else if (target instanceof Enemy && !(e instanceof Enemy)) {
                return false;
            } else {
                boolean var10000;
                if (e != user && e instanceof LivingEntity) {
                    LivingEntity le = (LivingEntity)e;
                    if (le.isAlive()) {
                        var10000 = true;
                        return var10000;
                    }
                }

                var10000 = false;
                return var10000;
            }
        };
    }

    static record CleaveValues(StepFunction chance, StepFunction targets) {
        public static final Codec<ScytheCleavingAffix.CleaveValues> CODEC = RecordCodecBuilder.create((inst) -> {
            return inst.group(StepFunction.CODEC.fieldOf("chance").forGetter((c) -> {
                return c.chance;
            }), StepFunction.CODEC.fieldOf("targets").forGetter((c) -> {
                return c.targets;
            })).apply(inst, ScytheCleavingAffix.CleaveValues::new);
        });

        CleaveValues(StepFunction chance, StepFunction targets) {
            this.chance = chance;
            this.targets = targets;
        }

        public StepFunction chance() {
            return this.chance;
        }

        public StepFunction targets() {
            return this.targets;
        }
    }

    public static class Builder extends AffixBuilder<ScytheCleavingAffix.Builder> {
        protected final Map<LootRarity, ScytheCleavingAffix.CleaveValues> values = new HashMap();

        public Builder() {
        }

        public ScytheCleavingAffix.Builder value(LootRarity rarity, float minChance, float maxChance, int minTargets, int maxTargets) {
            StepFunction chance = StepFunction.fromBounds(minChance, maxChance, 0.05F);
            StepFunction targets = StepFunction.fromBounds((float)minTargets, (float)maxTargets, 1.0F);
            this.values.put(rarity, new ScytheCleavingAffix.CleaveValues(chance, targets));
            return this;
        }

        public ScytheCleavingAffix build() {
            Preconditions.checkNotNull(this.definition);
            Preconditions.checkArgument(this.values.size() > 0);
            return new ScytheCleavingAffix(this.definition, this.values);
        }
    }
}
