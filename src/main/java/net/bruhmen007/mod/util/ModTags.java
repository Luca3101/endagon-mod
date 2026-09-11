package net.bruhmen007.mod.util;

import net.bruhmen007.mod.EndagonMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {



    public static class Blocks {

        public static final TagKey<Block> NEEDS_ENDAGONIUM_TOOL = createTag("needs_endagonium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENDAGONIUM_TOOL = createTag("incorrect_for_endagonium_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EndagonMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(EndagonMod.MOD_ID, name));
        }
    }
}
