package ianm1647.apothic_compats.util;

import io.redspace.irons_artifice.entity.ai.RangedGunAttackGoal;
import io.redspace.irons_artifice.registry.EntityRegistry;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;

public class MixinHelper {

    public static void registerGoals(Monster monster) {
        if (!(monster.getType().is((HolderSet<EntityType<?>>) EntityRegistry.GUNSLINGER.get())) &&
                !(monster.getType().is((HolderSet<EntityType<?>>) EntityRegistry.ILLIFICER.get()))) {
            monster.goalSelector.addGoal(2, new RangedGunAttackGoal<>(monster, 24, 15, 45, 40, 80));
        }
    }
}
