
package net.mcreator.plc.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ItemTrihydrideArmor extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:trihydridearmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("plc:trihydridearmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("plc:trihydridearmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("plc:trihydridearmorboots")
	public static final Item boots = null;
	public ItemTrihydrideArmor(ElementsPolarcraft instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("TRIHYDRIDEARMOR", "plc:trihydride", 45, new int[]{6, 18, 15, 6}, 27,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 4f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("trihydridearmorhelmet")
				.setRegistryName("trihydridearmorhelmet").setCreativeTab(TabAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("trihydridearmorbody")
				.setRegistryName("trihydridearmorbody").setCreativeTab(TabAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("trihydridearmorlegs")
				.setRegistryName("trihydridearmorlegs").setCreativeTab(TabAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("trihydridearmorboots")
				.setRegistryName("trihydridearmorboots").setCreativeTab(TabAntarcticraft.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("plc:trihydridearmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("plc:trihydridearmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("plc:trihydridearmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("plc:trihydridearmorboots", "inventory"));
	}
}
