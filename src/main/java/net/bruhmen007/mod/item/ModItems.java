package net.bruhmen007.mod.item;

import net.bruhmen007.mod.EndagonMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VOID_CRYSTAL = registerItem("void_crystal", new Item(new Item.Settings()));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EndagonMod.MOD_ID, name), item);
    }



    public static void registerModItems() {
        EndagonMod.LOGGER.info("Registring mod items for" + EndagonMod.MOD_ID);


    }
}
