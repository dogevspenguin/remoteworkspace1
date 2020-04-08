
package net.mcreator.plc.item;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.plc.procedure.ProcedurePenguingunBullet;
import net.mcreator.plc.creativetab.TabAntarcticraft;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class ItemPenguingun extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:penguingun")
	public static final Item block = null;
	public static final int ENTITYID = 6;
	public ItemPenguingun(ElementsPolarcraft instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new RangedItem());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("plc", "entitybulletpenguingun"), ENTITYID).name("entitybulletpenguingun").tracker(64, 1, true).build());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("plc:penguingun", "inventory"));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderCustom(renderManager);
		});
	}
	public static class RangedItem extends Item {
		public RangedItem() {
			super();
			setMaxDamage(198);
			setFull3D();
			setUnlocalizedName("penguingun");
			setRegistryName("penguingun");
			maxStackSize = 1;
			setCreativeTab(TabAntarcticraft.tab);
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityLivingBase entityLivingBase, int timeLeft) {
			if (!world.isRemote && entityLivingBase instanceof EntityPlayerMP) {
				EntityPlayerMP entity = (EntityPlayerMP) entityLivingBase;
				float power = 1f;
				EntityArrowCustom entityarrow = new EntityArrowCustom(world, entity);
				entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
				entityarrow.setSilent(true);
				entityarrow.setIsCritical(false);
				entityarrow.setDamage(5);
				entityarrow.setKnockbackStrength(5);
				itemstack.damageItem(1, entity);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				world.playSound((EntityPlayer) null, (double) x, (double) y, (double) z,
						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
								.getObject(new ResourceLocation(("entity.arrow.shoot"))),
						SoundCategory.NEUTRAL, 1, 1f / (itemRand.nextFloat() * 0.5f + 1f) + (power / 2));
				entityarrow.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
				if (!world.isRemote)
					world.spawnEntity(entityarrow);
			}
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(EnumActionResult.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public EnumAction getItemUseAction(ItemStack itemstack) {
			return EnumAction.BOW;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 72000;
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}

		@Override
		public void onCollideWithPlayer(EntityPlayer entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedurePenguingunBullet.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void arrowHit(EntityLivingBase entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedurePenguingunBullet.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			World world = this.world;
			Entity entity = (Entity) shootingEntity;
			if (this.inGround) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					ProcedurePenguingunBullet.executeProcedure($_dependencies);
				}
				this.world.removeEntity(this);
			}
		}
	}

	public static class RenderCustom extends Render {
		private static final ResourceLocation texture = new ResourceLocation("plc:textures/babypenguin.png");
		public RenderCustom(RenderManager renderManager) {
			super(renderManager);
			shadowSize = 0.1f;
		}

		@Override
		public void doRender(Entity bullet, double d, double d1, double d2, float f, float f1) {
			bindEntityTexture(bullet);
			GL11.glPushMatrix();
			GL11.glTranslatef((float) d, (float) d1, (float) d2);
			GL11.glRotatef(f, 0, 1, 0);
			GL11.glRotatef(90f - bullet.prevRotationPitch - (bullet.rotationPitch - bullet.prevRotationPitch) * f1, 1, 0, 0);
			ModelBase model = new Modelbabypenguin();
			model.render(bullet, 0, 0, 0, 0, 0, 0.0625f);
			GL11.glPopMatrix();
		}

		@Override
		protected ResourceLocation getEntityTexture(Entity entity) {
			return texture;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelbabypenguin extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer left_flap;
		private final ModelRenderer right_flap;
		private final ModelRenderer head;
		private final ModelRenderer head1;
		public Modelbabypenguin() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 15, 19, -2.75F, -2.0F, -2.5F, 5, 1, 5, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -11.0F, -3.0F, 6, 9, 6, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 3, -2.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 0, 1.0F, -1.0F, -1.0F, 1, 1, 2, 0.0F, false));
			left_flap = new ModelRenderer(this);
			left_flap.setRotationPoint(0.0F, 24.0F, 0.0F);
			left_flap.cubeList.add(new ModelBox(left_flap, 0, 24, -3.5F, -10.0F, -1.0F, 1, 7, 2, 0.0F, false));
			right_flap = new ModelRenderer(this);
			right_flap.setRotationPoint(0.0F, 24.0F, 0.0F);
			right_flap.cubeList.add(new ModelBox(right_flap, 6, 24, 2.5F, -10.0F, -1.0F, 1, 7, 2, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 15, -2.5F, -15.0F, -3.25F, 5, 4, 5, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 15, 15, -0.5F, -13.0F, -5.0F, 1, 1, 2, 0.0F, false));
			head1 = new ModelRenderer(this);
			head1.setRotationPoint(0.0F, 0.4545F, 0.5417F);
			setRotationAngle(head1, 0.0873F, 0.0F, 0.0F);
			head.addChild(head1);
			head1.cubeList.add(new ModelBox(head1, 18, 0, -2.75F, -12.0F, -2.75F, 5, 1, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			left_flap.render(f5);
			right_flap.render(f5);
			head.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
