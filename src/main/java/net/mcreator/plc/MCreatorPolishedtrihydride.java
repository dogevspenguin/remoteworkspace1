package net.mcreator.plc;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

@Elementsplc.ModElement.Tag
public class MCreatorPolishedtrihydride extends Elementsplc.ModElement {
	@GameRegistry.ObjectHolder("plc:polishedtrihydride")
	public static final Block block = null;

	public MCreatorPolishedtrihydride(Elementsplc instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("plc:polishedtrihydride", "inventory"));
	}

	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.IRON);
			setRegistryName("polishedtrihydride");
			setUnlocalizedName("polishedtrihydride");
			setSoundType(SoundType.METAL);
			setHardness(1.5F);
			setResistance(16.5F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(MCreatorAntarcticraft.tab);
		}
	}
}
