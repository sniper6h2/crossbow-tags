package dev.crossbowtags.mixin;

import dev.crossbowtags.CrossbowKind;
import dev.crossbowtags.GraphicsCanvas;
import dev.crossbowtags.Overlay;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiGraphicsExtractor.class)
abstract class ItemRenderMixin {
	@Inject(method = "item(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;III)V", at = @At("HEAD"))
	private void crossbowTags$background(LivingEntity entity, Level level, ItemStack stack, int x, int y, int seed, CallbackInfo ci) {
		CrossbowKind kind = CrossbowKind.of(stack);
		if (kind != CrossbowKind.NONE) Overlay.slotBackground(new GraphicsCanvas((GuiGraphicsExtractor) (Object) this), kind, x, y);
	}
}
