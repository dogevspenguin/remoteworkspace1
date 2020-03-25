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
public class MCreatorMetalichydrogenArmor extends Elementsplc.ModElement {
	@GameRegistry.ObjectHolder("plc:metalichydrogenarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("plc:metalichydrogenarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("plc:metalichydrogenarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("plc:metalichydrogenarmorboots")
	public static final Item boots = null;

	public MCreatorMetalichydrogenArmor(Elementsplc instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("METALICHYDROGENARMOR", "plc:metalichydrogen", 15, new int[]{2, 6, 5, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("metalichydrogenarmorhelmet")
				.setRegistryName("metalichydrogenarmorhelmet").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("metalichydrogenarmorbody")
				.setRegistryName("metalichydrogenarmorbody").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("metalichydrogenarmorlegs")
				.setRegistryName("metalichydrogenarmorlegs").setCreativeTab(MCreatorAntarcticraft.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("metalichydrogenarmorboots")
				.setRegistryName("metalichydrogenarmorboots").setCreativeTab(MCreatorAntarcticraft.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("plc:metalichydrogenarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("plc:metalichydrogenarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("plc:metalichydrogenarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("plc:metalichydrogenarmorboots", "inventory"));
	}
}
