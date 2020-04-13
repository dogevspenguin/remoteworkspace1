
package net.mcreator.plc.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.block.state.IBlockState;

import net.mcreator.plc.ElementsPolarcraft;

import java.util.Random;

@ElementsPolarcraft.ModElement.Tag
public class EntityGiantpetrel extends ElementsPolarcraft.ModElement {
	public static final int ENTITYID = 18;
	public static final int ENTITYID_RANGED = 19;
	public EntityGiantpetrel(ElementsPolarcraft instance) {
		super(instance, 162);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("plc", "giantpetrel"), ENTITYID)
				.name("giantpetrel").tracker(64, 3, true).egg(-6737152, -1).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("plc:icevallaysouth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:snowvallaysouth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:snowvallaynorth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:icevallaynorth")),};
		EntityRegistry.addSpawn(EntityCustom.class, 10, 2, 5, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelgiant_petrel(), 1.2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("plc:textures/giant_petrel.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(2.7f, 1f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, true));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBabypenguin.EntityCustom.class, true, true));
			this.tasks.addTask(3, new EntityAIBase() {
				{
					this.setMutexBits(1);
				}
				public boolean shouldExecute() {
					if (EntityCustom.this.getAttackTarget() != null && !EntityCustom.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return EntityCustom.this.getMoveHelper().isUpdating() && EntityCustom.this.getAttackTarget() != null
							&& EntityCustom.this.getAttackTarget().isEntityAlive();
				}

				@Override
				public void startExecuting() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					Vec3d vec3d = livingentity.getPositionEyes(1);
					EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
				}

				@Override
				public void updateTask() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					double d0 = EntityCustom.this.getDistanceSq(livingentity);
					if (d0 <= getAttackReachSq(livingentity)) {
						EntityCustom.this.attackEntityAsMob(livingentity);
					} else if (d0 < 100) {
						Vec3d vec3d = livingentity.getPositionEyes(1);
						EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}

				protected double getAttackReachSq(EntityLivingBase attackTarget) {
					return EntityCustom.this.width * 1.5 * EntityCustom.this.height * 1.5 + attackTarget.height;
				}
			});
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(5, new EntityAIBase() {
				{
					this.setMutexBits(1);
				}
				@Override
				public boolean shouldExecute() {
					EntityMoveHelper entitymovehelper = EntityCustom.this.getMoveHelper();
					if (!entitymovehelper.isUpdating()) {
						return true;
					} else {
						double dx = entitymovehelper.getX() - EntityCustom.this.posX;
						double dy = entitymovehelper.getY() - EntityCustom.this.posY;
						double dz = entitymovehelper.getZ() - EntityCustom.this.posZ;
						double d = dx * dx + dy * dy + dz * dz;
						return d < 1 || d > 3600;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return false;
				}

				@Override
				public void startExecuting() {
					Random random = EntityCustom.this.getRNG();
					double dir_x = EntityCustom.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = EntityCustom.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = EntityCustom.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					EntityCustom.this.getMoveHelper().setMoveTo(dir_x, dir_y, dir_z, 1);
				}
			});
			this.tasks.addTask(6, new EntityAILookIdle(this));
			this.tasks.addTask(7, new EntityAIAvoidEntity(this, EntityPenguin.EntityCustom.class, (float) 6, 1, 1.2));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.FEATHER, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.parrot.fly"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.parrot.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.parrot.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.2);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelgiant_petrel extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer wing;
		private final ModelRenderer secondary1;
		private final ModelRenderer secondary2;
		private final ModelRenderer thirdayry1;
		private final ModelRenderer thirdayry2;
		public Modelgiant_petrel() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 5, -0.5F, -4.75F, -12.25F, 1, 1, 4, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 42, -2.5F, -6.0F, -8.0F, 5, 4, 5, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -2.75F, -6.75F, -5.0F, 5, 5, 12, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 28, 9, -2.0F, -6.0F, 7.0F, 4, 4, 8, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 0, -1.0F, -5.0F, 15.0F, 2, 2, 3, 0.0F, false));
			wing = new ModelRenderer(this);
			wing.setRotationPoint(0.0F, 24.0F, 0.0F);
			wing.cubeList.add(new ModelBox(wing, 40, 40, 2.75F, -6.0F, -3.0F, 4, 2, 8, 0.0F, false));
			wing.cubeList.add(new ModelBox(wing, 24, 33, -6.75F, -6.0F, -3.0F, 4, 2, 8, 0.0F, false));
			secondary1 = new ModelRenderer(this);
			secondary1.setRotationPoint(3.0F, 0.0F, 0.0F);
			setRotationAngle(secondary1, 0.0F, -0.1745F, 0.0F);
			wing.addChild(secondary1);
			secondary1.cubeList.add(new ModelBox(secondary1, 21, 25, 3.0F, -5.0F, -3.0F, 7, 1, 7, 0.0F, false));
			secondary2 = new ModelRenderer(this);
			secondary2.setRotationPoint(-16.0F, 0.0F, 3.0F);
			setRotationAngle(secondary2, 0.0F, 0.2618F, 0.0F);
			wing.addChild(secondary2);
			secondary2.cubeList.add(new ModelBox(secondary2, 0, 24, 3.0F, -5.0F, -3.0F, 7, 1, 7, 0.0F, false));
			thirdayry1 = new ModelRenderer(this);
			thirdayry1.setRotationPoint(0.0F, -4.0F, -5.0F);
			setRotationAngle(thirdayry1, 0.0F, 0.3491F, 0.0F);
			wing.addChild(thirdayry1);
			thirdayry1.cubeList.add(new ModelBox(thirdayry1, 22, 0, -25.0F, -1.0F, 0.0F, 11, 1, 6, 0.0F, false));
			thirdayry2 = new ModelRenderer(this);
			thirdayry2.setRotationPoint(37.0F, -4.0F, 8.0F);
			setRotationAngle(thirdayry2, 0.0F, -0.3491F, 0.0F);
			wing.addChild(thirdayry2);
			thirdayry2.cubeList.add(new ModelBox(thirdayry2, 0, 17, -25.0F, -1.0F, 0.0F, 11, 1, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			wing.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
