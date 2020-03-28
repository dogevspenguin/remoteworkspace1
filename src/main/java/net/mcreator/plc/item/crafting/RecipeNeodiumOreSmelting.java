
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemNeodiumIngot;
import net.mcreator.plc.block.BlockNeodiumOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeNeodiumOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeNeodiumOreSmelting(ElementsPolarcraft instance) {
		super(instance, 104);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockNeodiumOre.block, (int) (1)), new ItemStack(ItemNeodiumIngot.block, (int) (1)), 0F);
	}
}
