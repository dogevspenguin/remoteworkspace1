package net.mcreator.plc.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedurePenguinmeatFoodEaten extends ElementsPolarcraft.ModElement {
	public ProcedurePenguinmeatFoodEaten(ElementsPolarcraft instance) {
		super(instance, 85);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PenguinmeatFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 60, (int) 1));
	}
}
