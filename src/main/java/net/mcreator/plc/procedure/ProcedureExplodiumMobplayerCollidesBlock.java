package net.mcreator.plc.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureExplodiumMobplayerCollidesBlock extends ElementsPolarcraft.ModElement {
	public ProcedureExplodiumMobplayerCollidesBlock(ElementsPolarcraft instance) {
		super(instance, 142);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ExplodiumMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ExplodiumMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ExplodiumMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ExplodiumMobplayerCollidesBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, true);
		}
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, y, z, (int) 5, 3, 3, 3, 1, new int[0]);
	}
}
