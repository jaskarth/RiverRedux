package supercoder79.riverredux;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public final class BiomeMaps {
    // Mixin cannot handle aastore in initializers so it's been moved here
    public static final RegistryKey<Biome>[][] RR_RIVER_BIOMES = new RegistryKey[][]{
            // Handled by vanilla already
            {null, null, null, null, null},
            {RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY, RiverBiomes.GRAVELLY},
            {BiomeKeys.RIVER, BiomeKeys.RIVER, BiomeKeys.RIVER, BiomeKeys.RIVER, BiomeKeys.RIVER},
            {BiomeKeys.RIVER, BiomeKeys.RIVER, BiomeKeys.RIVER, RiverBiomes.TROPICAL, RiverBiomes.TROPICAL},
            {RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY, RiverBiomes.SANDY}
    }; // TODO: carved rivers
}
