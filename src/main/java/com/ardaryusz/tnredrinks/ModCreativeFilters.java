package com.ardaryusz.tnredrinks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Predicate;

public final class ModCreativeFilters {

    private ModCreativeFilters() {}

    public static void register() {
        // Food & Drink: regular potions
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register(ModCreativeFilters::removeVanillaStacksThatContainOurPotions);

        // Combat: splash + lingering often live here
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(ModCreativeFilters::removeVanillaStacksThatContainOurPotions);

        // Search: the “everything bagel” tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH)
                .register(ModCreativeFilters::removeVanillaStacksThatContainOurPotions);
    }

    private static void removeVanillaStacksThatContainOurPotions(FabricItemGroupEntries entries) {
        Predicate<ItemStack> shouldHide = stack -> {
            // Only touch VANILLA containers
            if (!(stack.isOf(Items.POTION) || stack.isOf(Items.SPLASH_POTION) || stack.isOf(Items.LINGERING_POTION))) {
                return false;
            }

            PotionContentsComponent contents = stack.get(DataComponentTypes.POTION_CONTENTS);
            return ModPotions.isTnredPotion(contents);
        };

        // Remove from the visible tab
        entries.getDisplayStacks().removeIf(shouldHide);

        // Remove from creative search results too
        entries.getSearchTabStacks().removeIf(shouldHide);
    }
}