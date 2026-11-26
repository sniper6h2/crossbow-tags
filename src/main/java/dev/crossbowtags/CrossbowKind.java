package dev.crossbowtags;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public enum CrossbowKind {
	NONE,
	PIERCING,
	MULTISHOT;

	public static CrossbowKind of(ItemStack stack) {
		if (stack == null || stack.isEmpty() || !(stack.getItem() instanceof CrossbowItem)) {
			return NONE;
		}
		ItemEnchantments enchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
		for (Holder<Enchantment> holder : enchantments.keySet()) {
			if (holder.is(Enchantments.PIERCING)) return PIERCING;
			if (holder.is(Enchantments.MULTISHOT)) return MULTISHOT;
		}
		return NONE;
	}
}
