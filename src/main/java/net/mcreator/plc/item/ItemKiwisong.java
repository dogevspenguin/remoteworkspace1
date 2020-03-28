
package net.mcreator.plc.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

import java.util.List;

@ElementsPolarcraft.ModElement.Tag
public class ItemKiwisong extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:kiwisong")
	public static final Item block = null;
	public ItemKiwisong(ElementsPolarcraft instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("plc:kiwisong", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("kiwisong", ElementsPolarcraft.sounds.get(new ResourceLocation("plc:kiwi")));
			setUnlocalizedName("kiwisong");
			setRegistryName("kiwisong");
			setCreativeTab(TabAntarcticraft.tab);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("kwiwiiii");
		}
	}
}
