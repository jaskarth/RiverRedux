package supercoder79.riverredux.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import supercoder79.riverredux.RiverBiomes;

public class GravellyRiverBiome {
    public static Biome create() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder()
                .addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));


        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 100, 1, 1));
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();//.surfaceBuilder(ConfiguredSurfaceBuilders.BADLANDS);
//        generationSettings.structureFeature(ConfiguredStructureFeatures.MINESHAFT);
//        generationSettings.structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
//        BiomeDefaultFeatures.addDefaultLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addWaterTrees(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);

        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
//        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, RiverConfiguredFeatures.RIVER_WATERFALLS);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
//                .category(Biome.Category.RIVER)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(RiverBiomes.getSkyColor(0.5F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}
