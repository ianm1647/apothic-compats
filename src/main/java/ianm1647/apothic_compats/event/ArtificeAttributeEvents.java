package ianm1647.apothic_compats.event;

import ianm1647.apothic_compats.Comp.Attributes.Artifice;
import io.redspace.irons_artifice.api.ComposeShotEvent;
import io.redspace.irons_artifice.data.*;
import io.redspace.irons_artifice.gun.ShotProfile;
import io.redspace.irons_artifice.item.GunplayManager;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

import java.util.function.BiConsumer;

public class ArtificeAttributeEvents {

    @SubscribeEvent
    public void composeShot(ComposeShotEvent e) {
        if (e.getEntity() instanceof Player player) {
            addAttribute(Artifice.BULLET_SPREAD, ShotComponents.SPREAD, 0, e.getShotProfile(), player);
            addAttribute(Artifice.FIRE_RATE, ShotComponents.FIRE_RATE, 0, e.getShotProfile(), player);
            addAttribute(Artifice.GUN_DAMAGE, ShotComponents.DAMAGE, 0, e.getShotProfile(), player);
            addAttribute(Artifice.BULLET_KNOCKBACK, ShotComponents.KNOCKBACK, 0, e.getShotProfile(), player);
            addAttribute(Artifice.RELOAD_SPEED, ShotComponents.RELOAD_SPEED_MULTIPLIER, 1, e.getShotProfile(), player);
            addAttribute(Artifice.BULLET_PIERCE, ShotComponents.PIERCING, 0, e.getShotProfile(), player);
            addAttribute(Artifice.LEECH, ShotComponents.LEECH, 0, e.getShotProfile(), player);
            addAttribute(Artifice.GUN_RECOIL, ShotComponents.CAMERA_RECOIL_MULTIPLIER, 1, e.getShotProfile(), player);
        }
    }

    public static void applyAttribs(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(type -> {
            addAll(type, e::add,
                    Artifice.BULLET_SPREAD,
                    Artifice.FIRE_RATE,
                    Artifice.GUN_DAMAGE,
                    Artifice.BULLET_KNOCKBACK,
                    Artifice.RELOAD_SPEED,
                    Artifice.BULLET_PIERCE,
                    Artifice.LEECH,
                    Artifice.GUN_RECOIL);
        });
    }

    private static void addAttribute(Holder<Attribute> attribute, ComponentType<Value> component, int offset, ShotProfile profile, Player player) {
        AttributeInstance inst = player.getAttribute(attribute);
        if (inst != null) {
            boolean hasMultiplyBase = inst.getModifiers().stream()
                    .anyMatch(modifier ->
                            modifier.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_BASE ||
                                    modifier.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

            boolean hasAddValue = inst.getModifiers().stream()
                    .anyMatch(modifier ->
                            modifier.operation() == AttributeModifier.Operation.ADD_VALUE);

            double value = inst.getValue() - offset;

            if (hasMultiplyBase) {
                multiplyValue(profile, component, value);
            } else if (hasAddValue) {
                addValue(profile, component, value);
            }
        }
    }

    private static void fromGunToPlayer(Holder<Attribute> attribute, ComponentType<Value> component, ShotProfile profile, Player player) {
        AttributeInstance inst = player.getAttribute(attribute);
        double componentValue = profile.peek(component).base();
        if (inst != null) {
            if (player.getMainHandItem().is(profile.itemStack().getItem())) {
                inst.addOrUpdateTransientModifier(new AttributeModifier(Identifier.parse(attribute.getRegisteredName()), componentValue, AttributeModifier.Operation.ADD_VALUE));
            } else {
                inst.removeModifier(Identifier.parse(attribute.getRegisteredName()));
            }
        }
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
