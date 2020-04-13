
package net.mcreator.plc.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.plc.item.ItemKiwisong;
import net.mcreator.plc.item.ItemDeorbit;
import net.mcreator.plc.item.ItemCalmpen;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class OreDictMusicdisk extends ElementsPolarcraft.ModElement {
	public OreDictMusicdisk(ElementsPolarcraft instance) {
		super(instance, 149);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("musicdisk", new ItemStack(ItemCalmpen.block, (int) (1)));
		OreDictionary.registerOre("musicdisk", new ItemStack(ItemDeorbit.block, (int) (1)));
		OreDictionary.registerOre("musicdisk", new ItemStack(ItemKiwisong.block, (int) (1)));
	}
}
