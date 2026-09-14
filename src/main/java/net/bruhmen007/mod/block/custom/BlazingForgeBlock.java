package net.bruhmen007.mod.block.custom;

import com.mojang.serialization.MapCodec;
import net.bruhmen007.mod.block.entity.ModBlockEntities;
import net.bruhmen007.mod.block.entity.custom.BlazingForgeBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlazingForgeBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;
    public static final MapCodec<BlazingForgeBlock> CODEC = BlazingForgeBlock.createCodec(BlazingForgeBlock::new);

    public BlazingForgeBlock(Settings settings) {
        super(settings);
        // Default state must match all properties added in appendProperties
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(LIT, false));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        // MUST register BOTH properties here
        builder.add(FACING, LIT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(LIT, false);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlazingForgeBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) {
            return; // Don't spawn particles if the forge is off
        }

        double x = (double) pos.getX() + 0.5;
        double y = (double) pos.getY();
        double z = (double) pos.getZ() + 0.5;

        // Play subtle crackling furnace sound occasionally
        if (random.nextInt(10) == 0) {
            world.playSound(x, y, z, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        }

        Direction direction = state.get(FACING);
        Direction.Axis axis = direction.getAxis();

        // Position particles on the front face of the block
        double offset = 0.52;
        double randomOffset = random.nextDouble() * 0.6 - 0.3;

        double particleX = axis == Direction.Axis.X ? (double) direction.getOffsetX() * offset : randomOffset;
        double particleY = random.nextDouble() * 6.0 / 16.0;
        double particleZ = axis == Direction.Axis.Z ? (double) direction.getOffsetZ() * offset : randomOffset;

        // Spawn smoke and flame particles on the client
        world.addParticle(ParticleTypes.SMOKE, x + particleX, y + particleY, z + particleZ, 0.0, 0.0, 0.0);
        world.addParticle(ParticleTypes.FLAME, x + particleX, y + particleY, z + particleZ, 0.0, 0.0, 0.0);
    }

    /*@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.BLAZING_FORGE_BE,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }*/
}



