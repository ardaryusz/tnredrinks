package com.ardaryusz.tnredrinks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotallyNotRealEnergyDrinks implements ModInitializer {
	public static final String MOD_ID = "tnredrinks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModPotions.init();
		ModItems.init();
		ModCreativeFilters.register();
		ModCauldronBehaviors.register();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			((BrewingRecipeRegistry.Builder) builder).registerPotionType(ModItems.WATER_CAN);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
			entries.add(ModItems.EMPTY_CAN);
			entries.add(ModItems.WATER_CAN);
			entries.add(PotionContentsComponent.createStack(ModItems.ZEPZI_CAN, ModPotions.ZEPZI));
			entries.add(PotionContentsComponent.createStack(ModItems.FANTASTIC_CAN, ModPotions.FANTASTIC));
			entries.add(PotionContentsComponent.createStack(ModItems.SPIRIT_CAN, ModPotions.SPIRIT));
			entries.add(PotionContentsComponent.createStack(ModItems.REDCOW_CAN, ModPotions.REDCOW));
			entries.add(PotionContentsComponent.createStack(ModItems.MONSTROSITY_CAN, ModPotions.MONSTROSITY));
			entries.add(PotionContentsComponent.createStack(ModItems.MONSTROSITYWHITE_CAN, ModPotions.MONSTROSITYWHITE));
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			// Allow these items in brewing stand potion slots
			builder.registerPotionType(ModItems.WATER_CAN);

			builder.registerPotionType(ModItems.ZEPZI_CAN);
			// Step 1: Water Can + Sugar -> Zepzi Can (still water, just “packaged”)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.SUGAR), ModItems.ZEPZI_CAN);
			// Step 2: (Zepzi Can of Water) + Cocoa Beans -> Zepzi Base (no effects)
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.COCOA_BEANS), ModPotions.ZEPZI_BASE);
			// Step 3: Zepzi Base + Redstone -> Zepzi (Strength I 10s)
			builder.registerPotionRecipe(ModPotions.ZEPZI_BASE, Ingredient.ofItems(Items.REDSTONE), ModPotions.ZEPZI);

			builder.registerPotionType(ModItems.FANTASTIC_CAN);
			// Step 1: Water Can + Golden Carrot -> Fantastic Can (container swap)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.GOLDEN_CARROT), ModItems.FANTASTIC_CAN);
			// Step 2: Water + Chorus Fruit -> fantastic_base
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.CHORUS_FRUIT), ModPotions.FANTASTIC_BASE);
			// Step 3: fantastic_base + Sugar -> fantastic (Jump Boost I 10s)
			builder.registerPotionRecipe(ModPotions.FANTASTIC_BASE, Ingredient.ofItems(Items.SUGAR), ModPotions.FANTASTIC);

			builder.registerPotionType(ModItems.SPIRIT_CAN);
			// Step 1: Water Can + Apple -> Spirit Can (container swap)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.APPLE), ModItems.SPIRIT_CAN);
			// Step 2: Water + Soul Sand -> spirit_base
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.SOUL_SAND), ModPotions.SPIRIT_BASE);
			// Step 3: spirit_base + Rabbit's Foot -> spirit (Speed I 10s)
			builder.registerPotionRecipe(ModPotions.SPIRIT_BASE, Ingredient.ofItems(Items.RABBIT_FOOT), ModPotions.SPIRIT);

			builder.registerPotionType(ModItems.REDCOW_CAN);
			// Step 1: Water Can + Cooked Beef -> Redcow Can (container swap)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.COOKED_BEEF), ModItems.REDCOW_CAN);
			// Step 2: Water + Sugar -> redcow_base
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.SUGAR_CANE), ModPotions.REDCOW_BASE);
			// Step 3: redcow_base + Glistering Melon Slice -> redcow (Regen 5s)
			builder.registerPotionRecipe(ModPotions.REDCOW_BASE, Ingredient.ofItems(Items.GLISTERING_MELON_SLICE), ModPotions.REDCOW);

			builder.registerPotionType(ModItems.MONSTROSITY_CAN);
			// Step 1: Water Can + Ender Pearl -> Monstrosity Can (container swap)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.ENDER_PEARL), ModItems.MONSTROSITY_CAN);
			// Step 2: Water + Ink Sac -> monstrosity_base
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.INK_SAC), ModPotions.MONSTROSITY_BASE);
			// Step 3: monstrosity_base + Sugar -> monstrosity (Speed I + Strength I, 10s)
			builder.registerPotionRecipe(ModPotions.MONSTROSITY_BASE, Ingredient.ofItems(Items.SUGAR), ModPotions.MONSTROSITY);

			builder.registerPotionType(ModItems.MONSTROSITYWHITE_CAN);
			// Step 1: Water Can + Eye of Ender -> Monstrosity White Can (container swap)
			builder.registerItemRecipe(ModItems.WATER_CAN, Ingredient.ofItems(Items.ENDER_EYE), ModItems.MONSTROSITYWHITE_CAN);
			// Step 2: Water + Glow Ink Sac -> monstrositywhite_base
			builder.registerPotionRecipe(Potions.WATER, Ingredient.ofItems(Items.GLOW_INK_SAC), ModPotions.MONSTROSITYWHITE_BASE);
			// Step 3: monstrositywhite_base + Fermented Spider Eye -> monstrositywhite (Speed II 10s)
			builder.registerPotionRecipe(ModPotions.MONSTROSITYWHITE_BASE, Ingredient.ofItems(Items.FERMENTED_SPIDER_EYE), ModPotions.MONSTROSITYWHITE);
		});

	}
}
