package com.ardaryusz.tnredrinks;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public final class ModPotions {
    private ModPotions() {}

    public static final Identifier ZEPZI_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "zepzi_base");
    public static final Identifier ZEPZI_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "zepzi");

    public static final Identifier FANTASTIC_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "fantastic_base");
    public static final Identifier FANTASTIC_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "fantastic");

    public static final Identifier SPIRIT_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "spirit_base");
    public static final Identifier SPIRIT_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "spirit");

    public static final Identifier REDCOW_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "redcow_base");
    public static final Identifier REDCOW_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "redcow");

    public static final Identifier MONSTROSITY_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "monstrosity_base");
    public static final Identifier MONSTROSITY_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "monstrosity");

    public static final Identifier MONSTROSITYWHITE_BASE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "monstrositywhite_base");
    public static final Identifier MONSTROSITYWHITE_ID =
            Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, "monstrositywhite");

    public static RegistryEntry.Reference<Potion> MONSTROSITYWHITE_BASE;
    public static RegistryEntry.Reference<Potion> MONSTROSITYWHITE;

    public static RegistryEntry.Reference<Potion> MONSTROSITY_BASE;
    public static RegistryEntry.Reference<Potion> MONSTROSITY;

    public static RegistryEntry.Reference<Potion> REDCOW_BASE;
    public static RegistryEntry.Reference<Potion> REDCOW;

    public static RegistryEntry.Reference<Potion> SPIRIT_BASE;
    public static RegistryEntry.Reference<Potion> SPIRIT;

    public static RegistryEntry.Reference<Potion> FANTASTIC_BASE;
    public static RegistryEntry.Reference<Potion> FANTASTIC;

    public static RegistryEntry.Reference<Potion> ZEPZI_BASE;
    public static RegistryEntry.Reference<Potion> ZEPZI;

    public static void init() {
        // Base: no effects
        Registry.register(Registries.POTION, ZEPZI_BASE_ID,
                new Potion("zepzi_base", new StatusEffectInstance[]{}));
        // Final: Strength I for 10 seconds
        Registry.register(Registries.POTION, ZEPZI_ID,
                new Potion("zepzi", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.STRENGTH, 10 * 20, 0)
                }));

        // Base: no effects
        Registry.register(Registries.POTION, FANTASTIC_BASE_ID,
                new Potion("fantastic_base", new StatusEffectInstance[]{}));
        // Final: Jump Boost I for 10 seconds
        Registry.register(Registries.POTION, FANTASTIC_ID,
                new Potion("fantastic", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.JUMP_BOOST, 10 * 20, 0)
                }));

        // Base: no effects
        Registry.register(Registries.POTION, SPIRIT_BASE_ID,
                new Potion("spirit_base", new StatusEffectInstance[]{}));
        // Final: Speed I for 10 seconds
        Registry.register(Registries.POTION, SPIRIT_ID,
                new Potion("spirit", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 0)
                }));

        // Base: no effects
        Registry.register(Registries.POTION, REDCOW_BASE_ID,
                new Potion("redcow_base", new StatusEffectInstance[]{}));
        // Final: Regeneration I for 5 seconds (5*20 ticks)
        Registry.register(Registries.POTION, REDCOW_ID,
                new Potion("redcow", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0)
                }));

        // Base: no effects
        Registry.register(Registries.POTION, MONSTROSITY_BASE_ID,
                new Potion("monstrosity_base", new StatusEffectInstance[]{}));
        // Final: Speed I + Strength I for 10 seconds
        Registry.register(Registries.POTION, MONSTROSITY_ID,
                new Potion("monstrosity", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 0),
                        new StatusEffectInstance(StatusEffects.STRENGTH, 10 * 20, 0)
                }));

        // Base: no effects
        Registry.register(Registries.POTION, MONSTROSITYWHITE_BASE_ID,
                new Potion("monstrositywhite_base", new StatusEffectInstance[]{}));
        // Final: Speed II for 10 seconds (amplifier 1)
        Registry.register(Registries.POTION, MONSTROSITYWHITE_ID,
                new Potion("monstrositywhite", new StatusEffectInstance[]{
                        new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 1)
                }));

        MONSTROSITYWHITE_BASE = Registries.POTION.getEntry(MONSTROSITYWHITE_BASE_ID).orElseThrow();
        MONSTROSITYWHITE = Registries.POTION.getEntry(MONSTROSITYWHITE_ID).orElseThrow();

        MONSTROSITY_BASE = Registries.POTION.getEntry(MONSTROSITY_BASE_ID).orElseThrow();
        MONSTROSITY = Registries.POTION.getEntry(MONSTROSITY_ID).orElseThrow();

        REDCOW_BASE = Registries.POTION.getEntry(REDCOW_BASE_ID).orElseThrow();
        REDCOW = Registries.POTION.getEntry(REDCOW_ID).orElseThrow();

        SPIRIT_BASE = Registries.POTION.getEntry(SPIRIT_BASE_ID).orElseThrow();
        SPIRIT = Registries.POTION.getEntry(SPIRIT_ID).orElseThrow();

        FANTASTIC_BASE = Registries.POTION.getEntry(FANTASTIC_BASE_ID).orElseThrow();
        FANTASTIC = Registries.POTION.getEntry(FANTASTIC_ID).orElseThrow();

        ZEPZI_BASE = Registries.POTION.getEntry(ZEPZI_BASE_ID).orElseThrow();
        ZEPZI = Registries.POTION.getEntry(ZEPZI_ID).orElseThrow();
    }

    public static boolean isTnredPotion(PotionContentsComponent contents) {
        if (contents == null) return false;

        // Include BOTH bases and finals (so base cans also don't appear as bottles/splash/lingering)
        return contents.matches(ZEPZI_BASE) || contents.matches(ZEPZI)
                || contents.matches(FANTASTIC_BASE) || contents.matches(FANTASTIC)
                || contents.matches(SPIRIT_BASE) || contents.matches(SPIRIT)
                || contents.matches(REDCOW_BASE) || contents.matches(REDCOW)
                || contents.matches(MONSTROSITY_BASE) || contents.matches(MONSTROSITY)
                || contents.matches(MONSTROSITYWHITE_BASE) || contents.matches(MONSTROSITYWHITE);
    }
}