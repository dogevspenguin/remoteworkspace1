package net.mcreator.plc.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ProcedureAntarcticsaladFoodEaten extends ElementsPolarcraft.ModElement {
	public ProcedureAntarcticsaladFoodEaten(ElementsPolarcraft instance) {
		super(instance, 106);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntarcticsaladFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), new ItemStack(Items.BOWL, (int) (1)));
	}
}
