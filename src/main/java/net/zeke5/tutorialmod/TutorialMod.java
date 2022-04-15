package net.zeke5.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.zeke5.tutorialmod.block.ModBlocks;
import net.zeke5.tutorialmod.item.ModItems;
import net.zeke5.tutorialmod.util.ModLootTableModifiers;
import net.zeke5.tutorialmod.util.ModRegistries;
import net.zeke5.tutorialmod.world.feature.ModConfiguredFeatures;
import net.zeke5.tutorialmod.world.feature.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModWorldGen.generateModWorldGen();

		ModLootTableModifiers.modifyLootTables();
	}
}
