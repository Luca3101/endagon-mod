package net.bruhmen007.mod.block;

import net.bruhmen007.mod.EndagonMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block VOID_CRYSTAL_ORE = registerBlock("void_crystal_ore",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EndagonMod.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EndagonMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }



    public static void registerModBlocks() {
        EndagonMod.LOGGER.info("Registring mod blocks for" + EndagonMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.VOID_CRYSTAL_ORE);
        });
    }
}
