package net.bruhmen007.mod;

import net.bruhmen007.mod.block.ModBlocks;
import net.bruhmen007.mod.item.ModItemGroups;
import net.bruhmen007.mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndagonMod implements ModInitializer {
	public static final String MOD_ID = "endagon-mod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}





	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
