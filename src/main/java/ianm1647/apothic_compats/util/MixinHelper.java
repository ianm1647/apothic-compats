package ianm1647.apothic_compats.util;

import io.redspace.irons_artifice.entity.ai.RangedGunAttackGoal;
import io.redspace.irons_artifice.registry.EntityRegistry;
import net.minecraft.world.entity.monster.Monster;

public class MixinHelper {

    public static void registerGoals(Monster monster) {
        if (!(monster.getType().builtInRegistryHolder().is(EntityRegistry.GUNSLINGER)) &&
                !(monster.getType().builtInRegistryHolder().is(EntityRegistry.ILLIFICER))) {
            monster.goalSelector.addGoal(2, new RangedGunAttackGoal<>(monster, 24, 15, 45, 40, 80));
        }
    }
}