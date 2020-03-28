
package net.mcreator.plc.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ItemCalmpen extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:calmpen")
	public static final Item block = null;
	public ItemCalmpen(ElementsPolarcraft instance) {
		super(instance, 107);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("plc:calmpen", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("calmpen", ElementsPolarcraft.sounds.get(new ResourceLocation("plc:penguinmusic")));
			setUnlocalizedName("calmpen");
			setRegistryName("calmpen");
			setCreativeTab(TabAntarcticraft.tab);
		}
	}
}
