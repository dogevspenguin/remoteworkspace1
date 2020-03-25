package net.mcreator.plc;

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

@Elementsplc.ModElement.Tag
public class MCreatorTitaniumArmor extends Elementsplc.ModElement {
	@GameRegistry.ObjectHolder("plc:titaniumarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("plc:titaniumarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("plc:titaniumarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("plc:titaniumarmorboots")
	public static final Item boots = null;

	public MCreatorTitaniumArmor(Elementsplc instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("TITANIUMARMOR", "plc:titanium", 30, new int[]{4, 12, 10, 4}, 18,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 1.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("titaniumarmorhelmet")
				.setRegistryName("titaniumarmorhelmet").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("titaniumarmorbody")
				.setRegistryName("titaniumarmorbody").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("titaniumarmorlegs")
				.setRegistryName("titaniumarmorlegs").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("titaniumarmorboots")
				.setRegistryName("titaniumarmorboots").setCreativeTab(MCreatorAntarcticraft.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("plc:titaniumarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("plc:titaniumarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("plc:titaniumarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("plc:titaniumarmorboots", "inventory"));
	}
}
