package net.bruhmen007.mod.item;

import net.bruhmen007.mod.EndagonMod;
import net.bruhmen007.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ENDAGON_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EndagonMod.MOD_ID, "endagon_mod"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.VOID_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.endagon-mod.void_crystal"))
                    .entries((displayContext, entries) -> {
                                     /// ADD all items in the menu
                        entries.add(ModItems.VOID_CRYSTAL);
                        entries.add(ModBlocks.VOID_CRYSTAL_ORE);
                    })
                    .build());


    public static void registerItemGroups() {
        EndagonMod.LOGGER.info("Registring item groups for " + EndagonMod.MOD_ID);
    }
}
