
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemPenguinmeat;
import net.mcreator.plc.item.ItemCockedpenguinmeat;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeCockedpenguinmeatrecipe extends ElementsPolarcraft.ModElement {
	public RecipeCockedpenguinmeatrecipe(ElementsPolarcraft instance) {
		super(instance, 86);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemPenguinmeat.block, (int) (1)), new ItemStack(ItemCockedpenguinmeat.block, (int) (0)), 0F);
	}
}
