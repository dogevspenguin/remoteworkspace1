package net.mcreator.plc;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsplc.ModElement.Tag
public class MCreatorCockedpenguinmeatrecipe extends Elementsplc.ModElement {
	public MCreatorCockedpenguinmeatrecipe(Elementsplc instance) {
		super(instance, 86);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorPenguinmeat.block, (int) (1)), new ItemStack(MCreatorCockedpenguinmeat.block, (int) (1)), 1F);
	}
}
