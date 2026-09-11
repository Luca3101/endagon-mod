package net.bruhmen007.mod.datagen;

import net.bruhmen007.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.ENDAGONIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.ENDAGONIUM_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.ENDAGONIUM_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.ENDAGONIUM_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.ENDAGONIUM_HOE);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.ENDAGONIUM_PICKAXE)
                .add(ModItems.ENDAGONIUM_AXE)
                .add(ModItems.ENDAGONIUM_SHOVEL)
                .add(ModItems.ENDAGONIUM_HOE);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ENDAGONIUM_PICKAXE)
                .add(ModItems.ENDAGONIUM_AXE)
                .add(ModItems.ENDAGONIUM_SHOVEL)
                .add(ModItems.ENDAGONIUM_HOE)
                .add(ModItems.ENDAGONIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(ModItems.ENDAGONIUM_SWORD);
        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.ENDAGONIUM_SWORD)
                .add(ModItems.ENDAGONIUM_AXE);
    }
}
