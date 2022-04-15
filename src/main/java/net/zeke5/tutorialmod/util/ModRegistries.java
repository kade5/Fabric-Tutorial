package net.zeke5.tutorialmod.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.zeke5.tutorialmod.TutorialMod;
import net.zeke5.tutorialmod.block.ModBlocks;
import net.zeke5.tutorialmod.commands.ReturnHomeCommand;
import net.zeke5.tutorialmod.commands.SetHomeCommand;
import net.zeke5.tutorialmod.event.ModPlayerEventCopyFrom;
import net.zeke5.tutorialmod.item.ModItems;

public class ModRegistries {

    public static void registerModStuffs() {
        registerFuels();
        registerCommands();
        registerEvents();
        registerFlammableBlock();
        registerStrippables();
    }
        private static void registerFuels() {
            TutorialMod.LOGGER.info("Registering Fuels for " + TutorialMod.MOD_ID);
            FuelRegistry registry = FuelRegistry.INSTANCE;

            registry.add(ModItems.LILAC_FLOWER_BULB, 200);
        }

        private static void registerCommands() {
            CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
            CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
        }

    private static void registerFlammableBlock() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlocks.JACARANDA_LOG, 5, 5);
        instance.add(ModBlocks.STRIPPED_JACARANDA_LOG, 5, 5);
        instance.add(ModBlocks.JACARANDA_WOOD, 5, 5);
        instance.add(ModBlocks.STRIPPED_JACARANDA_WOOD, 5, 5);
        instance.add(ModBlocks.JACARANDA_PLANKS, 5, 20);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.JACARANDA_LOG, ModBlocks.STRIPPED_JACARANDA_LOG);
        StrippableBlockRegistry.register(ModBlocks.JACARANDA_WOOD, ModBlocks.STRIPPED_JACARANDA_WOOD);
    }

        private static void registerEvents() {
            ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
        }

}
