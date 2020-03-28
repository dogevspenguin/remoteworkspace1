
package net.mcreator.plc.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemMetalichydrogenDust;
import net.mcreator.plc.block.BlockMetalichydrogenOre;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class RecipeMetalichydrogenOreSmelting extends ElementsPolarcraft.ModElement {
	public RecipeMetalichydrogenOreSmelting(ElementsPolarcraft instance) {
		super(instance, 92);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockMetalichydrogenOre.block, (int) (1)), new ItemStack(ItemMetalichydrogenDust.block, (int) (1)),
				0F);
	}
}
