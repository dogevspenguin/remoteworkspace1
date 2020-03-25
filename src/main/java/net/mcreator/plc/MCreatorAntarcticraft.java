package net.mcreator.plc;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;

@Elementsplc.ModElement.Tag
public class MCreatorAntarcticraft extends Elementsplc.ModElement {
	public MCreatorAntarcticraft(Elementsplc instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabpolarcraft") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Blocks.ICE, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
