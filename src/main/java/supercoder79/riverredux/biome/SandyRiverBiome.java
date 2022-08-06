package supercoder79.riverredux.biome;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.GenerationStep;
import supercoder79.riverredux.RiverBiomes;
import supercoder79.riverredux.RiverConfiguredFeatures;

public class SandyRiverBiome {
    // TODO: lilypads
    public static Biome create() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder()
                .spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 2, 1, 4))
                .spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 5, 1, 5));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 100, 1, 1));
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();//.surfaceBuilder(ConfiguredSurfaceBuilders.DESERT);
//        generationSettings.structureFeature(ConfiguredStructureFeatures.MINESHAFT);
//        generationSettings.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
//        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addWaterBiomeOakTrees(generationSettings);
        DefaultBiomeFeatures.addDefaultFlowers(generationSettings);
        DefaultBiomeFeatures.addDefaultGrass(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_RIVER);

        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

//        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, RiverConfiguredFeatures.RIVER_WATERFALLS);
//        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, RiverConfiguredFeatures.RIVER_SUGARCANE);

        return new Biome.Builder()
                .precipitation(Biome.Precipitation.RAIN)
//                .category(Biome.Category.RIVER)
//                .depth(-0.5F)
//                .scale(0.0F)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(RiverBiomes.getSkyColor(0.5F))
                        .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}
