
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemTitaniumIngot;
import net.mcreator.plc.block.BlockTitaniumOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeTitaniumOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeTitaniumOreSmelting(ElementsPolarcraft instance) {
		super(instance, 53);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockTitaniumOre.block, (int) (1)), new ItemStack(ItemTitaniumIngot.block, (int) (1)), 0F);
	}
}
