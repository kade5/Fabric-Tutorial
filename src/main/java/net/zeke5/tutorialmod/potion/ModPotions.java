package net.zeke5.tutorialmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zeke5.tutorialmod.TutorialMod;
import net.zeke5.tutorialmod.effect.ModEffects;
import net.zeke5.tutorialmod.item.ModItems;
import net.zeke5.tutorialmod.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {

    public static Potion FREEZE_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(TutorialMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));
    }

    public static  void registerPotion() {
        FREEZE_POTION = registerPotion("freeze_potion");
        registerPotionPotionRecipes();


    }

    private static void registerPotionPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.MYTHRIL_INGOT,
                ModPotions.FREEZE_POTION);
    }
}
