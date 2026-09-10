package net.bruhmen007.mod.datagen;

import net.bruhmen007.mod.block.ModBlocks;
import net.bruhmen007.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_CRYSTAL_ORE);
        ///blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLAZING_FORGE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VOID_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_CRYSTAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDAGONIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDAGONIUM_TEMPLATE, Models.GENERATED);
    }
}
