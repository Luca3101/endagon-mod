package net.bruhmen007.mod;

import net.bruhmen007.mod.screen.ModScreenHandlers;
import net.bruhmen007.mod.screen.custom.BlazingForgeScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class EndagonModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        HandledScreens.register(ModScreenHandlers.BLAZING_FORGE_SCREEN_HANDLER, BlazingForgeScreen::new);
    }
}
