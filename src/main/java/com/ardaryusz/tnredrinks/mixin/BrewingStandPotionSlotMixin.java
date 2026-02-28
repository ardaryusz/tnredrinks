package com.ardaryusz.tnredrinks.mixin;

import com.ardaryusz.tnredrinks.ModItems;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.screen.BrewingStandScreenHandler$PotionSlot")
public abstract class BrewingStandPotionSlotMixin {

	@Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
	private void tnredrinks$allowStackableCans(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (stack.isOf(ModItems.WATER_CAN)
				|| stack.isOf(ModItems.ZEPZI_CAN)
				|| stack.isOf(ModItems.FANTASTIC_CAN)
				|| stack.isOf(ModItems.SPIRIT_CAN)
				|| stack.isOf(ModItems.REDCOW_CAN)
				|| stack.isOf(ModItems.MONSTROSITY_CAN)
				|| stack.isOf(ModItems.MONSTROSITYWHITE_CAN)) {
			cir.setReturnValue(true);
		}
	}
}