package net.bruhmen007.mod.screen;

import net.bruhmen007.mod.EndagonMod;
import net.bruhmen007.mod.screen.custom.BlazingForgeScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static final ScreenHandlerType<BlazingForgeScreenHandler> BLAZING_FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(EndagonMod.MOD_ID, "blazing_forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(BlazingForgeScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        EndagonMod.LOGGER.info("Registring Screen Handlers for " + EndagonMod.MOD_ID);
    }
}
