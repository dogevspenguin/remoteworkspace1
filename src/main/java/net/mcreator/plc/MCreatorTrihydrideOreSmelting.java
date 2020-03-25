package net.mcreator.plc;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsplc.ModElement.Tag
public class MCreatorTrihydrideOreSmelting extends Elementsplc.ModElement {
	public MCreatorTrihydrideOreSmelting(Elementsplc instance) {
		super(instance, 75);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorTrihydrideOre.block, (int) (1)), new ItemStack(MCreatorTrihydrideIngot.block, (int) (1)),
				2.0999999999999996F);
	}
}
