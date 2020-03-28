package net.mcreator.plc.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.mcreator.plc.block.BlockBackpack;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureBackpaceitemRightClickedOnBlock extends ElementsPolarcraft.ModElement {
	public ProcedureBackpaceitemRightClickedOnBlock(ElementsPolarcraft instance) {
		super(instance, 116);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BackpaceitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BackpaceitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BackpaceitemRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BackpaceitemRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BlockBackpack.block.getDefaultState(), 3);
		}
	}
}
