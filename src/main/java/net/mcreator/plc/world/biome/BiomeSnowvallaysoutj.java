
package net.mcreator.plc.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;

import net.mcreator.plc.block.BlockSnowice;
import net.mcreator.plc.ElementsPolarcraft;

import java.util.Random;

@ElementsPolarcraft.ModElement.Tag
public class BiomeSnowvallaysoutj extends ElementsPolarcraft.ModElement {
	@GameRegistry.ObjectHolder("plc:snowvallaysouth")
	public static final BiomeGenCustom biome = null;
	public BiomeSnowvallaysoutj(ElementsPolarcraft instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 10));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Snowvallaysouth").setRainfall(0.2F).setBaseHeight(0.1F).setHeightVariation(0.01F).setTemperature(-0.3F));
			setRegistryName("snowvallaysouth");
			topBlock = BlockSnowice.block.getDefaultState();
			fillerBlock = Blocks.PACKED_ICE.getDefaultState();
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
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
