package ianm1647.apothic_compats.mixin;

import dev.shadowsoffire.apothic_enchanting.api.EnchantmentStatBlock;
import net.mehvahdjukaar.amendments.common.block.DoubleSkullBlock;
import net.mehvahdjukaar.amendments.common.tile.DoubleSkullBlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = DoubleSkullBlock.class, remap = false)
public abstract class DoubleSkullBlockMixin extends SkullBlock implements EnchantmentStatBlock {

    protected DoubleSkullBlockMixin(Properties pProperties) {
        super(Types.SKELETON, pProperties);
    }

    @Override
    public float getQuantaBonus(BlockState state, LevelReader world, BlockPos pos) {
        if (world.getBlockEntity(pos) instanceof DoubleSkullBlockTile tile) {
            if (tile.getSkull().getBlock() == Blocks.WITHER_SKELETON_SKULL &&
                    tile.getSkullTileUp().getBlockState().getBlock() == Blocks.WITHER_SKELETON_SKULL) {
                return 20.0F;
            } else if (!(tile.getSkull().getBlock() == Blocks.WITHER_SKELETON_SKULL) &&
                    tile.getSkullTileUp().getBlockState().getBlock() == Blocks.WITHER_SKELETON_SKULL) {
                return 15.0F;
            } else if (tile.getSkull().getBlock() == Blocks.WITHER_SKELETON_SKULL &&
                    !(tile.getSkullTileUp().getBlockState().getBlock() == Blocks.WITHER_SKELETON_SKULL)) {
                return 15.0F;
            }
        }
        return 10.0F;
    }

}
