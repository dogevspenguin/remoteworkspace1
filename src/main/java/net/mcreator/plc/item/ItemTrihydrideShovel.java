
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
public class ItemTrihydrideShovel extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:trihydrideshovel")
	public static final Item block = null;
	public ItemTrihydrideShovel(ElementsPolarcraft instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("TRIHYDRIDESHOVEL", 6, 1164, 12f, 2f, 42)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 6);
				return ret.keySet();
			}
		}.setUnlocalizedName("trihydrideshovel").setRegistryName("trihydrideshovel").setCreativeTab(TabAntarcticraft.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("plc:trihydrideshovel", "inventory"));
	}
}
