
package net.mcreator.plc.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemFuelcell;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class FuelFuelcell2 extends ElementsPolarcraft.ModElement {
	public FuelFuelcell2(ElementsPolarcraft instance) {
		super(instance, 200);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemFuelcell.block, (int) (1)).getItem())
			return 1600;
		return 0;
	}
}
