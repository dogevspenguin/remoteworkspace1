
package net.mcreator.plc.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

import java.util.Set;
import java.util.HashMap;

@ElementsPolarcraft.ModElement.Tag
public class ItemMetalichydrogenShovel extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:metalichydrogenshovel")
	public static final Item block = null;
	public ItemMetalichydrogenShovel(ElementsPolarcraft instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("METALICHYDROGENSHOVEL", 2, 250, 6f, -2f, 14)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 2);
				return ret.keySet();
			}
		}.setUnlocalizedName("metalichydrogenshovel").setRegistryName("metalichydrogenshovel").setCreativeTab(TabAntarcticraft.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("plc:metalichydrogenshovel", "inventory"));
	}
}
