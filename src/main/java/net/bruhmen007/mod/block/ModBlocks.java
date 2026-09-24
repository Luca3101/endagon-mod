package net.bruhmen007.mod.block;

import net.bruhmen007.mod.EndagonMod;
import net.bruhmen007.mod.block.custom.BlazingForgeBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;

public class ModBlocks {
    ///Blocks
    public static final Block VOID_CRYSTAL_ORE = registerBlock("void_crystal_ore",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block BLAZING_FORGE = registerBlock("blazing_forge",
            new BlazingForgeBlock(AbstractBlock.Settings.create().requiresTool().strength(4.0F).sounds(BlockSoundGroup.STONE)));





    ///init func
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EndagonMod.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EndagonMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }




    public static void registerModBlocks() {
        EndagonMod.LOGGER.info("Registring mod blocks for" + EndagonMod.MOD_ID);
    }
}
