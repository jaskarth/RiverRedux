package com.jaskarth.riverredux;


import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public final class BiomeMaps {
    // Mixin cannot handle aastore in initializers so it's been moved here
    public static final ResourceKey<Biome>[][] RR_RIVER_BIOMES = new ResourceKey[][]{
            // Handled by vanilla already
            {null, null, null, null, null},
            {RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, RiverBiomes.TROPICAL, RiverBiomes.TROPICAL},
            {RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY}
    }; // TODO: carved rivers
}
