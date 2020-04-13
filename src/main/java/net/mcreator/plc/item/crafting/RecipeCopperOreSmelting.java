
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemCopperGem;
import net.mcreator.plc.block.BlockCopperOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeCopperOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeCopperOreSmelting(ElementsPolarcraft instance) {
		super(instance, 158);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockCopperOre.block, (int) (1)), new ItemStack(ItemCopperGem.block, (int) (1)), 0.7F);
	}
}
