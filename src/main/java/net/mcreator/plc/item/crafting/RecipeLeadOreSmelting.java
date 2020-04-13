
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemLeadDust;
import net.mcreator.plc.block.BlockLeadOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeLeadOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeLeadOreSmelting(ElementsPolarcraft instance) {
		super(instance, 148);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockLeadOre.block, (int) (1)), new ItemStack(ItemLeadDust.block, (int) (1)), 0.7F);
	}
}
