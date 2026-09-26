package ianm1647.apothic_compats.event;

import ianm1647.apothic_compats.Comp.Attributes.Artifice;
import io.redspace.irons_artifice.api.ComposeShotEvent;
import io.redspace.irons_artifice.data.*;
import io.redspace.irons_artifice.gun.ShotProfile;
import net.minecraft.core.Holder;
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
            addAttribute(Artifice.BULLET_SPREAD, ShotComponents.SPREAD, e.getShotProfile(), player);
            addAttribute(Artifice.FIRE_RATE, ShotComponents.FIRE_RATE, e.getShotProfile(), player);
            addAttribute(Artifice.GUN_DAMAGE, ShotComponents.DAMAGE, e.getShotProfile(), player);
            addAttribute(Artifice.BULLET_KNOCKBACK, ShotComponents.KNOCKBACK, e.getShotProfile(), player);
            addAttribute(Artifice.RELOAD_SPEED, ShotComponents.RELOAD_SPEED_MULTIPLIER, e.getShotProfile(), player);
            addAttribute(Artifice.BULLET_PIERCE, ShotComponents.PIERCING, e.getShotProfile(), player);
            addAttribute(Artifice.LEECH, ShotComponents.LEECH, e.getShotProfile(), player);
            addAttribute(Artifice.GUN_RECOIL, ShotComponents.CAMERA_RECOIL_MULTIPLIER, e.getShotProfile(), player);
        }
    }

    public static void applyAttribs(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(type ->
                addAll(type, e::add,
                        Artifice.BULLET_SPREAD,
                        Artifice.FIRE_RATE,
                        Artifice.GUN_DAMAGE,
                        Artifice.BULLET_KNOCKBACK,
                        Artifice.RELOAD_SPEED,
                        Artifice.BULLET_PIERCE,
                        Artifice.LEECH,
                        Artifice.GUN_RECOIL));
    }

    private static void addAttribute(Holder<Attribute> attribute, ComponentType<Value> component, ShotProfile profile, Player player) {
        AttributeInstance inst = player.getAttribute(attribute);
        if (inst == null) {
            return;
        }

        double baseMultiplier = 0.0;
        Value value = profile.peek(component);

        for (AttributeModifier modifier : inst.getModifiers()) {
            double amount = modifier.amount();

            switch (modifier.operation()) {
                case ADD_VALUE ->
                        value.addModifier(new ValueModifier(amount, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL));
                case ADD_MULTIPLIED_BASE ->
                        baseMultiplier += amount;
                case ADD_MULTIPLIED_TOTAL ->
                        value.addModifier(new ValueModifier(amount, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));
            }
        }

        if (baseMultiplier != 0.0) {
            value.addModifier(new ValueModifier(
                    value.base() * baseMultiplier,
                    ValueModifier.Operation.ADD,
                    ValueModifier.Type.BENEFICIAL
            ));
        }
    }

    @SafeVarargs
    private static void addAll(EntityType<? extends LivingEntity> type, BiConsumer<EntityType<? extends LivingEntity>, Holder<Attribute>> add, Holder<Attribute>... attribs) {
        for (Holder<Attribute> a : attribs)
            add.accept(type, a);
    }

}
