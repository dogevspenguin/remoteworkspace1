
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemTrihydrideIngot;
import net.mcreator.plc.block.BlockTrihydrideOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeTrihydrideOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeTrihydrideOreSmelting(ElementsPolarcraft instance) {
		super(instance, 93);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockTrihydrideOre.block, (int) (1)), new ItemStack(ItemTrihydrideIngot.block, (int) (1)), 0F);
	}
}
