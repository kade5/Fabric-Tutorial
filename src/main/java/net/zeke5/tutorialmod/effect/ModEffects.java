package net.zeke5.tutorialmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zeke5.tutorialmod.TutorialMod;


public class ModEffects {

    public static StatusEffect FREEZE;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(TutorialMod.MOD_ID, name),
                new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        FREEZE = registerStatusEffect("freeze");
    }
}
