package ianm1647.apothic_compats.mixin;

import dev.shadowsoffire.apothic_enchanting.api.EnchantmentStatBlock;
import net.mehvahdjukaar.amendments.common.block.AbstractCandleSkullBlock;
import net.mehvahdjukaar.amendments.common.tile.CandleSkullBlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.world.level.block.Blocks.WITHER_SKELETON_SKULL;
import static net.minecraft.world.level.block.Blocks.WITHER_SKELETON_WALL_SKULL;

@Mixin(value = AbstractCandleSkullBlock.class, remap = false)
public abstract class SkullCandleBlockMixin extends AbstractCandleBlock implements EnchantmentStatBlock {

    protected SkullCandleBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public float getArcanaBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1.25F * state.getValue(AbstractCandleSkullBlock.CANDLES).intValue();
    }

    @Override
    public float getQuantaBonus(BlockState state, LevelReader world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof CandleSkullBlockTile tile) {
            if (tile.getSkull().getBlock() == WITHER_SKELETON_SKULL) {
                return 10.0F;
            }
            if (tile.getSkull().getBlock() == WITHER_SKELETON_WALL_SKULL) {
                return 10.0F;
            }
        }
        return 5.0F;
    }
}
