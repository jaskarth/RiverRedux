package supercoder79.riverredux.test;

import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;

import java.util.HashMap;
import java.util.Map;

public class BiomePainter {
    private static final Map<RegistryKey<Biome>, Integer> COLORS = new HashMap<>();
    static {
//        SharedConstants.createGameVersion();
//        Bootstrap.initialize();

        COLORS.put(BiomeKeys.PLAINS, 0x8DB360);
        COLORS.put(BiomeKeys.SUNFLOWER_PLAINS, 0xa4bf84);
        COLORS.put(BiomeKeys.FOREST, 0x056621);
        COLORS.put(BiomeKeys.DARK_FOREST, 0x40511A);
        COLORS.put(BiomeKeys.BIRCH_FOREST, 0x589C6C);
        COLORS.put(BiomeKeys.SWAMP, 0x2FFFDA);
        COLORS.put(BiomeKeys.SAVANNA, 0xBDB25F);
        COLORS.put(BiomeKeys.SAVANNA_PLATEAU, 0xbda95f);
        COLORS.put(BiomeKeys.BADLANDS, 0xD94515);
        COLORS.put(BiomeKeys.ERODED_BADLANDS, 0xCA8C65);
        COLORS.put(BiomeKeys.WOODED_BADLANDS, 0xB09765);
        COLORS.put(BiomeKeys.BEACH, 0xFADE55);
        COLORS.put(BiomeKeys.SNOWY_BEACH, 0xF7EBD2);
        COLORS.put(BiomeKeys.SNOWY_PLAINS, 0xFFFFFF);
        COLORS.put(BiomeKeys.SNOWY_TAIGA, 0x7CCCB2);
        COLORS.put(BiomeKeys.ICE_SPIKES, 0x8086bf);
        COLORS.put(BiomeKeys.TAIGA, 0x0B6659);
        COLORS.put(BiomeKeys.OLD_GROWTH_PINE_TAIGA, 0x596651);
        COLORS.put(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, 0x596651);
        COLORS.put(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, 0x76b889);
        COLORS.put(BiomeKeys.JUNGLE, 0x537B09);
        COLORS.put(BiomeKeys.BAMBOO_JUNGLE, 0x7BA331);
        COLORS.put(BiomeKeys.SPARSE_JUNGLE, 0x628B17);
        COLORS.put(BiomeKeys.DESERT, 0xFA9418);
        COLORS.put(BiomeKeys.RIVER, 0x3030AF);
        COLORS.put(BiomeKeys.FROZEN_RIVER, 0xA0A0FF);
        COLORS.put(BiomeKeys.FLOWER_FOREST, 0x2D8E49);

        COLORS.put(BiomeKeys.OCEAN, 0x000070);
        COLORS.put(BiomeKeys.WARM_OCEAN, 0x3ddbb6);
        COLORS.put(BiomeKeys.LUKEWARM_OCEAN, 0x3dbbdb);
        COLORS.put(BiomeKeys.COLD_OCEAN, 0x573ddb);
        COLORS.put(BiomeKeys.FROZEN_OCEAN, 0x928acf);

        COLORS.put(BiomeKeys.DEEP_OCEAN, 0x000030);
        COLORS.put(BiomeKeys.DEEP_LUKEWARM_OCEAN, 0x2e879e);
        COLORS.put(BiomeKeys.DEEP_COLD_OCEAN, 0x352585);
        COLORS.put(BiomeKeys.DEEP_FROZEN_OCEAN, 0x57527a);

        COLORS.put(BiomeKeys.MUSHROOM_FIELDS, 0x805f8a);

        COLORS.put(BiomeKeys.WINDSWEPT_SAVANNA, 0xe6dc95);
        COLORS.put(BiomeKeys.WINDSWEPT_HILLS, 0x606060);
        COLORS.put(BiomeKeys.WINDSWEPT_FOREST, 0x4d5c4b);
        COLORS.put(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS, 0x4a4a4a);

        COLORS.put(BiomeKeys.STONY_SHORE, 0x6b6b6b);
        COLORS.put(BiomeKeys.STONY_PEAKS, 0x858585);

        COLORS.put(BiomeKeys.MEADOW, 0x4a8f63);
        COLORS.put(BiomeKeys.GROVE, 0x4a8f63);
        COLORS.put(BiomeKeys.SNOWY_SLOPES, 0x8c8ea1);
        COLORS.put(BiomeKeys.FROZEN_PEAKS, 0xe2e1ed);
        COLORS.put(BiomeKeys.JAGGED_PEAKS, 0xababab);

        COLORS.put(BiomeKeys.LUSH_CAVES, 0x00FF00);
        COLORS.put(BiomeKeys.DRIPSTONE_CAVES, 0xFF0000);
    }
    public static void init() {
//         new VanillaBiomeParameters().
    }
}
