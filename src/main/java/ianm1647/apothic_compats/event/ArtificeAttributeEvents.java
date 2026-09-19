package ianm1647.apothic_compats.event;

import ianm1647.apothic_compats.Comp.Attributes.Artifice;
import io.redspace.irons_artifice.api.GunShootEvent;
import io.redspace.irons_artifice.data.ComponentType;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.Value;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.gun.ShotProfile;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

import java.util.function.BiConsumer;

public class ArtificeAttributeEvents {

    @SubscribeEvent
    public void preGunShoot(GunShootEvent.Pre e) {
        ShotProfile profile = e.getShotProfile();
        if (e.getEntity() instanceof Player player) {
            AttributeInstance attribute;
            attribute = player.getAttribute(Artifice.PROJECTILE_COUNT);
            if (attribute != null) {
                double projCount = attribute.getValue() - 1;
                addValue(profile, ShotComponents.PROJECTILE_COUNT, projCount);
            }
            attribute = player.getAttribute(Artifice.BULLET_SPREAD);
            if (attribute != null) {
                double spread = attribute.getValue();
                addValue(profile, ShotComponents.SPREAD, spread);
            }
            attribute = player.getAttribute(Artifice.IN_AIR_PENALTY);
            if (attribute != null) {
                double penalty = attribute.getValue() - 1.5;
                addValue(profile, ShotComponents.SPREAD, penalty);
            }
            attribute = player.getAttribute(Artifice.FIRE_DELAY);
            if (attribute != null) {
                double delay = attribute.getValue() - 1;
                addValue(profile, ShotComponents.FIRE_DELAY, delay);
            }
            attribute = player.getAttribute(Artifice.FIRE_RATE);
            if (attribute != null) {
                double rate = attribute.getValue() - 1;
                addValue(profile, ShotComponents.FIRE_RATE, rate);
            }
            attribute = player.getAttribute(Artifice.AMMO_CONSUME_CHANCE);
            if (attribute != null) {
                double chance = attribute.getValue() - 1;
                addValue(profile, ShotComponents.AMMO_CONSUME_CHANCE, chance);
            }
            attribute = player.getAttribute(Artifice.GUN_DAMAGE);
            if (attribute != null) {
                double damage = attribute.getValue();
                addValue(profile, ShotComponents.DAMAGE, damage);
            }
            attribute = player.getAttribute(Artifice.BULLET_SPEED);
            if (attribute != null) {
                double damage = attribute.getValue();
                addValue(profile, ShotComponents.BULLET_SPEED, damage);
            }
            attribute = player.getAttribute(Artifice.BULLET_GRAVITY);
            if (attribute != null) {
                double damage = attribute.getValue() - 0.05;
                addValue(profile, ShotComponents.GRAVITY, damage);
            }
            attribute = player.getAttribute(Artifice.BULLET_KNOCKBACK);
            if (attribute != null) {
                double damage = attribute.getValue();
                addValue(profile, ShotComponents.KNOCKBACK, damage);
            }
            attribute = player.getAttribute(Artifice.BULLET_DRAG);
            if (attribute != null) {
                double damage = attribute.getValue() - 0.98;
                addValue(profile, ShotComponents.BULLET_DRAG, damage);
            }
            attribute = player.getAttribute(Artifice.UNDERWATER_DRAG);
            if (attribute != null) {
                double damage = attribute.getValue() - 0.95;
                addValue(profile, ShotComponents.UNDERWATER_DRAG, damage);
            }
            attribute = player.getAttribute(Artifice.BLOCK_DAMAGE);
            if (attribute != null) {
                double block = attribute.getValue() - 1;
                addValue(profile, ShotComponents.BLOCK_DAMAGE_MULTIPLIER, block);
            }
            attribute = player.getAttribute(Artifice.RELOAD_SPEED);
            if (attribute != null) {
                double speed = attribute.getValue() - 1;
                addValue(profile, ShotComponents.RELOAD_SPEED_MULTIPLIER, speed);
            }
            attribute = player.getAttribute(Artifice.BULLET_PIERCE);
            if (attribute != null) {
                double pierce = attribute.getValue();
                addValue(profile, ShotComponents.PIERCING, pierce);
            }
            attribute = player.getAttribute(Artifice.LEECH);
            if (attribute != null) {
                double leech = attribute.getValue();
                addValue(profile, ShotComponents.LEECH, leech);
            }
            attribute = player.getAttribute(Artifice.GUN_RECOIL);
            if (attribute != null) {
                double recoil = attribute.getValue() - 1;
                addValue(profile, ShotComponents.CAMERA_RECOIL_MULTIPLIER, recoil);
            }
            attribute = player.getAttribute(Artifice.BLOWBACK);
            if (attribute != null) {
                double blowback = attribute.getValue();
                addValue(profile, ShotComponents.CHARACTER_BLOWBACK, blowback);
            }
        }
    }

    @SubscribeEvent
    public void postGunShoot(GunShootEvent.Post e) {
    }

    public static void applyAttribs(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(type -> {
            addAll(type, e::add,
                    Artifice.PROJECTILE_COUNT,
                    Artifice.BULLET_SPREAD,
                    Artifice.IN_AIR_PENALTY,
                    Artifice.FIRE_DELAY,
                    Artifice.FIRE_RATE,
                    Artifice.AMMO_CONSUME_CHANCE,
                    Artifice.GUN_DAMAGE,
                    Artifice.BULLET_SPEED,
                    Artifice.BULLET_GRAVITY,
                    Artifice.BULLET_KNOCKBACK,
                    Artifice.BULLET_DRAG,
                    Artifice.UNDERWATER_DRAG,
                    Artifice.BLOCK_DAMAGE,
                    Artifice.RELOAD_SPEED,
                    Artifice.BULLET_PIERCE,
                    Artifice.LEECH,
                    Artifice.GUN_RECOIL,
                    Artifice.BLOWBACK);
        });
    }

    private static void addValue(ShotProfile profile, ComponentType<Value> component, double value) {
        profile.components().modifyValue(component, new ValueModifier(value, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL));
    }

    private static void multiplyValue(ShotProfile profile, ComponentType<Value> component, double value) {
        profile.components().modifyValue(component, new ValueModifier(value, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));
    }

    @SafeVarargs
    private static void addAll(EntityType<? extends LivingEntity> type, BiConsumer<EntityType<? extends LivingEntity>, Holder<Attribute>> add, Holder<Attribute>... attribs) {
        for (Holder<Attribute> a : attribs)
            add.accept(type, a);
    }

}
