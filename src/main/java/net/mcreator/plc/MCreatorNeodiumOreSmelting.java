package net.mcreator.plc;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsplc.ModElement.Tag
public class MCreatorNeodiumOreSmelting extends Elementsplc.ModElement {
	public MCreatorNeodiumOreSmelting(Elementsplc instance) {
		super(instance, 104);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorNeodiumOre.block, (int) (1)), new ItemStack(MCreatorNeodiumIngot.block, (int) (1)), 0.7F);
	}
}
