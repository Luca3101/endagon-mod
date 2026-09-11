package net.bruhmen007.mod.item;

import net.bruhmen007.mod.EndagonMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item VOID_CRYSTAL = registerItem("void_crystal", new Item(new Item.Settings()));
    public static final Item VOID_CRYSTAL_DUST = registerItem("void_crystal_dust", new Item((new Item.Settings())));
    public static final Item ENDAGONIUM_INGOT = registerItem("endagonium_ingot", new Item((new Item.Settings())));
    public static final Item ENDAGONIUM_TEMPLATE = registerItem("endagonium_template", new Item(new Item.Settings()));



    public static final Item ENDAGONIUM_SWORD = registerItem("endagonium_sword",
            new SwordItem(ModToolMaterials.ENDAGONIUM,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDAGONIUM, 4, -2.4f))));
    public static final Item ENDAGONIUM_PICKAXE = registerItem("endagonium_pickaxe",
            new PickaxeItem(ModToolMaterials.ENDAGONIUM,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ENDAGONIUM, 1, -2.8f))));
    public static final Item ENDAGONIUM_SHOVEL = registerItem("endagonium_shovel",
            new ShovelItem(ModToolMaterials.ENDAGONIUM,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ENDAGONIUM, 0.5f, -3.0f))));
    public static final Item ENDAGONIUM_AXE = registerItem("endagonium_axe",
            new AxeItem(ModToolMaterials.ENDAGONIUM,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ENDAGONIUM, 6, -3.0f))));
    public static final Item ENDAGONIUM_HOE = registerItem("endagonium_hoe",
            new HoeItem(ModToolMaterials.ENDAGONIUM,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ENDAGONIUM, -5, 0f))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EndagonMod.MOD_ID, name), item);
    }



    public static void registerModItems() {
        EndagonMod.LOGGER.info("Registring mod items for" + EndagonMod.MOD_ID);


    }
}
