
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.plc.procedure.ProcedureCreeperticlePlayerCollidesWithThisEntity;
import net.mcreator.plc.item.ItemPopulsiongunammo;
import net.mcreator.plc.ElementsPolarcraft;

@ElementsPolarcraft.ModElement.Tag
public class EntityCreeperticle extends ElementsPolarcraft.ModElement {
	public static final int ENTITYID = 12;
	public static final int ENTITYID_RANGED = 13;
	public EntityCreeperticle(ElementsPolarcraft instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("plc", "creeperticle"), ENTITYID)
				.name("creeperticle").tracker(64, 3, true).egg(-3342337, -1).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("plc:icevallaysouth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:snowvallaysouth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:snowvallaynorth")),
				Biome.REGISTRY.getObject(new ResourceLocation("plc:icevallaynorth")),};
		EntityRegistry.addSpawn(EntityCustom.class, 100, 3, 30, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelcreeperticle(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("plc:textures/creeperticle.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemPopulsiongunammo.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.primed"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onCollideWithPlayer(EntityPlayer entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureCreeperticlePlayerCollidesWithThisEntity.executeProcedure($_dependencies);
			}
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
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelcreeperticle extends ModelBase {
		private final ModelRenderer leg2;
		private final ModelRenderer leg;
		private final ModelRenderer body;
		private final ModelRenderer HEAD;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		public Modelcreeperticle() {
			textureWidth = 64;
			textureHeight = 64;
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg2.cubeList.add(new ModelBox(leg2, 0, 32, 0.0F, -6.0F, -5.75F, 4, 6, 4, 0.0F, false));
			leg = new ModelRenderer(this);
			leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg.cubeList.add(new ModelBox(leg, 32, 0, -4.0F, -6.0F, -5.75F, 4, 6, 4, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -18.0F, -1.75F, 8, 12, 4, 0.0F, false));
			HEAD = new ModelRenderer(this);
			HEAD.setRotationPoint(0.0F, 24.0F, 0.0F);
			HEAD.cubeList.add(new ModelBox(HEAD, 0, 0, -4.0F, -26.0F, -3.5F, 8, 8, 8, 0.0F, false));
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg3.cubeList.add(new ModelBox(leg3, 24, 24, 0.0F, -6.0F, 2.25F, 4, 6, 4, 0.0F, false));
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg4.cubeList.add(new ModelBox(leg4, 28, 12, -4.0F, -6.0F, 2.25F, 4, 6, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			leg2.render(f5);
			leg.render(f5);
			body.render(f5);
			HEAD.render(f5);
			leg3.render(f5);
			leg4.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
