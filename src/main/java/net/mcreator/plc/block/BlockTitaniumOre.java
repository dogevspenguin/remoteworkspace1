
package net.mcreator.plc.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.plc.world.WorldSouthpole;
import net.mcreator.plc.world.WorldNorthpole;
import net.mcreator.plc.item.ItemTitaniumIngot;
import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

import java.util.Random;

@ElementsPolarcraft.ModElement.Tag
public class BlockTitaniumOre extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:titaniumore")
	public static final Block block = null;
	public BlockTitaniumOre(ElementsPolarcraft instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("titaniumore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("plc:titaniumore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldSouthpole.DIMID)
			dimensionCriteria = true;
		if (dimID == WorldNorthpole.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		for (int i = 0; i < 5; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(32) + 1;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 3, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == BlockCompressice.block.getDefaultState().getBlock())
						blockCriteria = true;
					if (blockAt.getBlock() == Blocks.PACKED_ICE.getDefaultState().getBlock())
						blockCriteria = true;
					require = Blocks.STONE.getStateFromMeta(0);
					try {
						if ((blockAt.getBlock() == require.getBlock())
								&& (blockAt.getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require)))
							blockCriteria = true;
					} catch (Exception e) {
						if (blockAt.getBlock() == require.getBlock())
							blockCriteria = true;
					}
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("titaniumore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 4);
			setHardness(6F);
			setResistance(8.705505632961241F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabAntarcticraft.tab);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemTitaniumIngot.block, (int) (1)));
		}
	}
}
