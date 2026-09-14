package net.bruhmen007.mod.block.entity;

import net.bruhmen007.mod.EndagonMod;
import net.bruhmen007.mod.block.ModBlocks;
import net.bruhmen007.mod.block.entity.custom.BlazingForgeBlockEntity;
import net.minecraft.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<BlazingForgeBlockEntity> BLAZING_FORGE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(EndagonMod.MOD_ID, "blazing_forge_be"),
                    BlockEntityType.Builder.create(BlazingForgeBlockEntity::new, ModBlocks.BLAZING_FORGE).build(null));


    public static void registerBlockEntities() {
        EndagonMod.LOGGER.info("Registring Block Entities for " + EndagonMod.MOD_ID);
    }
}
