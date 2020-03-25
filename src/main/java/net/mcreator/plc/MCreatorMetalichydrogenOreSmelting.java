package net.mcreator.plc;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsplc.ModElement.Tag
public class MCreatorMetalichydrogenOreSmelting extends Elementsplc.ModElement {
	public MCreatorMetalichydrogenOreSmelting(Elementsplc instance) {
		super(instance, 92);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorMetalichydrogenOre.block, (int) (1)), new ItemStack(MCreatorMetalichydrogenDust.block,
				(int) (1)), 0.7F);
	}
}
