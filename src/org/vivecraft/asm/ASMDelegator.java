package org.vivecraft.asm;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ASMDelegator {
	public static boolean containerCreativeMouseDown(int eatTheStack) {
		//return Mouse.isButtonDown(0) || Screen.mouseDown;
		return false;
	}

	public static void addCreativeItems(ItemGroup tab, NonNullList<ItemStack> list) {
		if (tab == ItemGroup.FOOD || tab == null) {
			ItemStack eatMe = new ItemStack(Items.PUMPKIN_PIE).setDisplayName(new StringTextComponent("EAT ME"));
			ItemStack drinkMe = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER).setDisplayName(new StringTextComponent("DRINK ME"));
			drinkMe.getTag().putInt("HideFlags", 32);
			list.add(eatMe);
			list.add(drinkMe);
		}
		if (tab == ItemGroup.TOOLS || tab == null) {
			ItemStack jumpBoots = new ItemStack(Items.LEATHER_BOOTS).setDisplayName(new TranslationTextComponent("vivecraft.item.jumpboots"));
			jumpBoots.getTag().putBoolean("Unbreakable", true);
			jumpBoots.getTag().putInt("HideFlags", 4);
			ItemStack climbClaws = new ItemStack(Items.SHEARS).setDisplayName(new TranslationTextComponent("vivecraft.item.climbclaws"));
			climbClaws.getTag().putBoolean("Unbreakable", true);
			climbClaws.getTag().putInt("HideFlags", 4);
			ItemStack telescope = new ItemStack(Items.ENDER_EYE).setDisplayName(new TranslationTextComponent("vivecraft.item.telescope"));
			telescope.getTag().putBoolean("Unbreakable", true);
			telescope.getTag().putInt("HideFlags", 4);
			list.add(telescope);
			list.add(jumpBoots);
			list.add(climbClaws);
		}
	}

	public static void addCreativeSearch(String query, NonNullList<ItemStack> list) {
		NonNullList<ItemStack> myList = NonNullList.create();
		addCreativeItems(null, myList);
		for (ItemStack stack : myList) {
			if (query.isEmpty() || stack.getDisplayName().toString().toLowerCase().contains(query.toLowerCase()))
				list.add(stack);
		}
	}
	
	public static void dummy(float f) {
		// does nothing
	}
}
