
package net.mcreator.plc.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;
import net.minecraft.entity.monster.EntityPolarBear;

import net.mcreator.plc.entity.EntityPolarcod;
import net.mcreator.plc.entity.EntityGiantpetrel;
import net.mcreator.plc.entity.EntityCreeperticle;
import net.mcreator.plc.entity.EntityArticdog;
import net.mcreator.plc.block.BlockCompacice;
import net.mcreator.plc.ElementsPolarcraft;

import java.util.Random;

@ElementsPolarcraft.ModElement.Tag
public class BiomeIcevallaynorth extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:icevallaynorth")
	public static final BiomeGenCustom biome = null;
	public BiomeIcevallaynorth(ElementsPolarcraft instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Icevallaynorth").setRainfall(0.01F).setBaseHeight(0.1F).setHeightVariation(0.01F).setTemperature(-0.5F));
			setRegistryName("icevallaynorth");
			topBlock = Blocks.ICE.getDefaultState();
			fillerBlock = BlockCompacice.block.getDefaultState();
			decorator.generateFalls = true;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeperticle.EntityCustom.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityArticdog.EntityCustom.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantpetrel.EntityCustom.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarcod.EntityCustom.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 40, 1, 5));
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
