package net.mcreator.plc.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureFrostPotionStartedapplied extends ElementsPolarcraft.ModElement {
	public ProcedureFrostPotionStartedapplied(ElementsPolarcraft instance) {
		super(instance, 129);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FrostPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		for (int index0 = 0; index0 < (int) (5); index0++) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
		}
	}
}
