package ianm1647.apothic_compats.mixin;

import ianm1647.apothic_compats.util.MixinHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Monster.class)
public class MonsterShootGunMixin extends PathfinderMob implements Enemy {
    protected MonsterShootGunMixin(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        if (ModList.get().isLoaded("irons_artifice")) {
            MixinHelper.registerGoals((Monster) (Object) this);
        }
    }
}