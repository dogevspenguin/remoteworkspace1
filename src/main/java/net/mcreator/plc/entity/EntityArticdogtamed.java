
package net.mcreator.plc.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.plc.ElementsPolarcraft;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsPolarcraft.ModElement.Tag
public class EntityArticdogtamed extends ElementsPolarcraft.ModElement {
	public static final int ENTITYID = 14;
	public static final int ENTITYID_RANGED = 15;
	public EntityArticdogtamed(ElementsPolarcraft instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("plc", "articdogtamed"), ENTITYID)
				.name("articdogtamed").tracker(64, 3, true).egg(-1, -1).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelarticdog(), 1.4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("plc:textures/articdog_1.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.7f, 0.7f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCreeperticle.EntityCustom.class, true, true));
			this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(6, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(7, new EntityAIFollow(this, (float) 1, 100, 5));
			this.tasks.addTask(8, new EntityAITempt(this, 1, new ItemStack(Items.FISH, (int) (1), 0).getItem(), false));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wolf.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wolf.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wolf.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
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
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class Modelarticdog extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer regl1;
		private final ModelRenderer legr1;
		private final ModelRenderer legl2;
		private final ModelRenderer legr2;
		private final ModelRenderer head;
		private final ModelRenderer earright;
		private final ModelRenderer earleft;
		public Modelarticdog() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 28, 0, -1.0F, -9.0F, 5.0F, 2, 2, 6, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -12.0F, -6.0F, 8, 7, 12, 0.0F, false));
			regl1 = new ModelRenderer(this);
			regl1.setRotationPoint(0.0F, 24.0F, -1.0F);
			regl1.cubeList.add(new ModelBox(regl1, 16, 31, -3.5F, -5.0F, -4.0F, 2, 5, 2, 0.0F, false));
			legr1 = new ModelRenderer(this);
			legr1.setRotationPoint(0.0F, 24.0F, 0.0F);
			legr1.cubeList.add(new ModelBox(legr1, 0, 0, 1.5F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false));
			legl2 = new ModelRenderer(this);
			legl2.setRotationPoint(0.0F, 24.0F, 0.0F);
			legl2.cubeList.add(new ModelBox(legl2, 8, 31, -3.5F, -5.0F, 3.0F, 2, 5, 2, 0.0F, false));
			legr2 = new ModelRenderer(this);
			legr2.setRotationPoint(0.0F, 24.0F, 8.0F);
			legr2.cubeList.add(new ModelBox(legr2, 0, 31, 1.5F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 19, -3.0F, -11.5F, -12.0F, 6, 6, 6, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 24, 24, -4.5F, -12.5F, -9.0F, 9, 8, 3, 0.0F, false));
			earright = new ModelRenderer(this);
			earright.setRotationPoint(0.0F, 0.25F, 0.0F);
			setRotationAngle(earright, 0.0F, 0.0F, 0.1745F);
			head.addChild(earright);
			earright.cubeList.add(new ModelBox(earright, 0, 7, -1.0F, -13.5F, -11.0F, 2, 2, 1, 0.0F, false));
			earleft = new ModelRenderer(this);
			earleft.setRotationPoint(2.0F, 0.0F, 1.0F);
			setRotationAngle(earleft, 0.0F, 0.0F, -0.1745F);
			head.addChild(earleft);
			earleft.cubeList.add(new ModelBox(earleft, 6, 7, -3.0F, -13.5F, -12.0F, 2, 2, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			regl1.render(f5);
			legr1.render(f5);
			legl2.render(f5);
			legr2.render(f5);
			head.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
