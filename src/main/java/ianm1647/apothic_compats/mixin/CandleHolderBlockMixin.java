package ianm1647.apothic_compats.mixin;

import dev.shadowsoffire.apothic_enchanting.api.EnchantmentStatBlock;
import net.mehvahdjukaar.supplementaries.common.block.blocks.CandleHolderBlock;
import net.mehvahdjukaar.supplementaries.common.block.blocks.LightUpWaterBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = CandleHolderBlock.class, remap = false)
public abstract class CandleHolderBlockMixin extends LightUpWaterBlock implements EnchantmentStatBlock {

    protected CandleHolderBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public float getArcanaBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.25F * state.getValue(CandleHolderBlock.CANDLES).intValue();
    }

}
