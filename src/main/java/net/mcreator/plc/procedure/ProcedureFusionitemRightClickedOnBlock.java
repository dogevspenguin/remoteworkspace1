package net.mcreator.plc.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.plc.item.ItemFusionblock;
import net.mcreator.plc.block.BlockFusionreactor;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureFusionitemRightClickedOnBlock extends ElementsPolarcraft.ModElement {
	public ProcedureFusionitemRightClickedOnBlock(ElementsPolarcraft instance) {
		super(instance, 89);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FusionitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FusionitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FusionitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FusionitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FusionitemRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 2), (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.AIR.getDefaultState()
						.getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockFusionreactor.block.getDefaultState(), 3);
		}
		if ((!((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemFusionblock.block, (int) (1)).getItem(), -1, (int) 1, null);
		}
	}
}
