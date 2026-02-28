package com.ardaryusz.tnredrinks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ModCauldronBehaviors {

    private ModCauldronBehaviors() {}

    public static void register() {
        CauldronBehavior.WATER_CAULDRON_BEHAVIOR.map()
                .put(ModItems.EMPTY_CAN, ModCauldronBehaviors::fillEmptyCanFromWaterCauldron);
    }

    private static ActionResult fillEmptyCanFromWaterCauldron(
            BlockState state, World world, BlockPos pos,
            PlayerEntity player, Hand hand, ItemStack stack
    ) {
        if (stack.isEmpty()) {
            return ActionResult.PASS;
        }

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        // Create one filled can (with water potion contents)
        ItemStack filled = PotionContentsComponent.createStack(ModItems.WATER_CAN, Potions.WATER);

        // Exchange ONE empty can for ONE filled can (handles stacks + inventory like vanilla bottles)
        player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, filled));

        // Drain cauldron by 1 level
        LeveledCauldronBlock.decrementFluidLevel(state, world, pos);

        world.playSound(
                null, pos,
                SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS,
                1.0f, 1.0f
        );

        return ActionResult.SUCCESS;
    }
}
