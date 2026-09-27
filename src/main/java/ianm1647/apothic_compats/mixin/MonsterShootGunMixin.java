package ianm1647.apothic_compats.mixin;

import io.redspace.irons_artifice.entity.ai.RangedGunAttackGoal;
import io.redspace.irons_artifice.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Monster.class)
public class MonsterShootGunMixin extends PathfinderMob implements Enemy {
    protected MonsterShootGunMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        if (!(this.getType().builtInRegistryHolder().is(EntityRegistry.GUNSLINGER)) ||
                !(this.getType().builtInRegistryHolder().is(EntityRegistry.ILLIFICER))) {
            super.registerGoals();
            this.goalSelector.addGoal(2, new RangedGunAttackGoal<>(this, 24, 15, 45, 40, 80));
        }
    }
}
