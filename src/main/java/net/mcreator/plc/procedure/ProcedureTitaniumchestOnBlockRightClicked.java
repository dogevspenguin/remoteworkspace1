package net.mcreator.plc.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.plc.gui.GuiTitaniumchest;
import net.mcreator.plc.Polarcraft;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureTitaniumchestOnBlockRightClicked extends ElementsPolarcraft.ModElement {
	public ProcedureTitaniumchestOnBlockRightClicked(ElementsPolarcraft instance) {
		super(instance, 132);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TitaniumchestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TitaniumchestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TitaniumchestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TitaniumchestOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TitaniumchestOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((world.isDaytime())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(Polarcraft.instance, GuiTitaniumchest.GUIID, world, x, y, z);
		}
	}
}
