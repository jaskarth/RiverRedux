package supercoder79.riverredux;

import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import supercoder79.riverredux.biome.CarvedRiverBiome;
import supercoder79.riverredux.biome.GravellyRiverBiome;
import supercoder79.riverredux.biome.SandyRiverBiome;
import supercoder79.riverredux.biome.TropicalRiverBiome;

public class RiverBiomes {
    public static Biome SANDY;
    public static Biome GRAVELLY;
    public static Biome TROPICAL;
    public static Biome CARVED;

    public static void init() {
        SANDY = Registry.register(Registry.BIOME, new Identifier("riverredux", "sandy_river"), new SandyRiverBiome());
        OverworldBiomes.setRiverBiome(Biomes.DESERT, SANDY);
        OverworldBiomes.setRiverBiome(Biomes.DESERT_LAKES, SANDY);
        OverworldBiomes.setRiverBiome(Biomes.DESERT_HILLS, SANDY);

        GRAVELLY = Registry.register(Registry.BIOME, new Identifier("riverredux", "gravelly_river"), new GravellyRiverBiome());
        OverworldBiomes.setRiverBiome(Biomes.TAIGA, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.TAIGA_HILLS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.TAIGA_MOUNTAINS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.GIANT_SPRUCE_TAIGA, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.GIANT_SPRUCE_TAIGA_HILLS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.GIANT_TREE_TAIGA, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.GIANT_TREE_TAIGA_HILLS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.MOUNTAINS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.MOUNTAIN_EDGE, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.WOODED_MOUNTAINS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.GRAVELLY_MOUNTAINS, GRAVELLY);
        OverworldBiomes.setRiverBiome(Biomes.MODIFIED_GRAVELLY_MOUNTAINS, GRAVELLY);

        TROPICAL = Registry.register(Registry.BIOME, new Identifier("riverredux", "tropical_river"), new TropicalRiverBiome());
        OverworldBiomes.setRiverBiome(Biomes.JUNGLE, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.JUNGLE_EDGE, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.JUNGLE_HILLS, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.BAMBOO_JUNGLE, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.BAMBOO_JUNGLE_HILLS, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.MODIFIED_JUNGLE, TROPICAL);
        OverworldBiomes.setRiverBiome(Biomes.MODIFIED_JUNGLE_EDGE, TROPICAL);

        CARVED = Registry.register(Registry.BIOME, new Identifier("riverredux", "carved_river"), new CarvedRiverBiome());
        OverworldBiomes.setRiverBiome(Biomes.BADLANDS, CARVED);
        OverworldBiomes.setRiverBiome(Biomes.BADLANDS_PLATEAU, CARVED);
        OverworldBiomes.setRiverBiome(Biomes.ERODED_BADLANDS, CARVED);
        OverworldBiomes.setRiverBiome(Biomes.MODIFIED_BADLANDS_PLATEAU, CARVED);
        OverworldBiomes.setRiverBiome(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, CARVED);
        OverworldBiomes.setRiverBiome(Biomes.WOODED_BADLANDS_PLATEAU, CARVED);
    }
}
