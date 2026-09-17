package ianm1647.apothic_compats.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.shadowsoffire.apotheosis.AdventureEvents;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import ianm1647.apothic_compats.Comp;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AdventureEvents.class)
public class AdventureEventsMixin {

    @WrapOperation(method = "fireProjectile", at = @At(value = "INVOKE", target = "Ldev/shadowsoffire/apotheosis/loot/LootCategory;isRanged()Z"))
    public boolean fireProjectile(LootCategory instance, Operation<Boolean> original) {
        return original.call(instance) || Comp.LootCategories.Artifice.isGun(instance);
    }
}
