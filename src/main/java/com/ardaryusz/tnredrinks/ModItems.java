package com.ardaryusz.tnredrinks;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.UseRemainderComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {
    private ModItems() {}

    private static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(TotallyNotRealEnergyDrinks.MOD_ID, path)
        );
        return Items.register(key, factory, settings);
    }

    public static final Item EMPTY_CAN = register(
            "empty_can",
            Item::new,
            new Item.Settings().maxCount(16)
    );

    public static final Item WATER_CAN = register(
            "water_can",
            settings -> new WaterCanItem(settings),
            new Item.Settings()
                    .maxCount(16)
                    // make it actually drinkable
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    // default contents (water) so /give works nicely
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    // after drinking, give back the empty can
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item ZEPZI_CAN = register(
            "zepzi_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    // default contents = water (so it behaves as the base for brewing)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    // after drinking, return the empty can
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item FANTASTIC_CAN = register(
            "fantastic_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item SPIRIT_CAN = register(
            "spirit_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item REDCOW_CAN = register(
            "redcow_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item MONSTROSITY_CAN = register(
            "monstrosity_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static final Item MONSTROSITYWHITE_CAN = register(
            "monstrositywhite_can",
            PotionItem::new,
            new Item.Settings()
                    .maxCount(16)
                    .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
                    .component(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER))
                    .component(DataComponentTypes.USE_REMAINDER, new UseRemainderComponent(new ItemStack(EMPTY_CAN)))
    );

    public static void init() {
        // classload trigger
    }
}
