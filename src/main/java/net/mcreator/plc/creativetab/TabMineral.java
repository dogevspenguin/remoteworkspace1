
package net.mcreator.plc.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.plc.item.ItemTitaniumIngot;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class TabMineral extends ElementsPolarcraft.ModElement {
	public TabMineral(ElementsPolarcraft instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabmineral") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemTitaniumIngot.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
