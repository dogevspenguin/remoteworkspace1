package net.mcreator.plc;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsplc.ModElement.Tag
public class MCreatorTitaniumOreSmelting extends Elementsplc.ModElement {
	public MCreatorTitaniumOreSmelting(Elementsplc instance) {
		super(instance, 53);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorTitaniumOre.block, (int) (1)), new ItemStack(MCreatorTitaniumIngot.block, (int) (1)), 1.4F);
	}
}
