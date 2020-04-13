
package net.mcreator.plc.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class LootTableFuelcellloot extends ElementsPolarcraft.ModElement {
	public LootTableFuelcellloot(ElementsPolarcraft instance) {
		super(instance, 195);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("plc", "fuelcellloot"));
	}
}
