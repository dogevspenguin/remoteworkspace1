package net.mcreator.plc.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureFusionprocedure extends ElementsPolarcraft.ModElement {
	public ProcedureFusionprocedure(ElementsPolarcraft instance) {
		super(instance, 110);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Fusionprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).addExperience((int) 5);
	}
}
