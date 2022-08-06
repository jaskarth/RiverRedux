package supercoder79.riverredux;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import supercoder79.riverredux.biome.CarvedRiverBiome;
import supercoder79.riverredux.biome.GravellyRiverBiome;
import supercoder79.riverredux.biome.SandyRiverBiome;
import supercoder79.riverredux.biome.TropicalRiverBiome;

import java.util.Objects;
import java.util.Optional;

public class RiverBiomes {
    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static RegistryKey<Biome> SANDY;
    public static RegistryKey<Biome> GRAVELLY;
    public static RegistryKey<Biome> TROPICAL;
    public static RegistryKey<Biome> CARVED;

    public static void init() {
        Biome sandy = Registry.register(BuiltinRegistries.BIOME, new Identifier("riverredux", "sandy_river"), SandyRiverBiome.create());
        SANDY = BuiltinRegistries.BIOME.getKey(sandy).get();

//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_LAKES, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_HILLS, SANDY);

        Biome gravelly = Registry.register(BuiltinRegistries.BIOME, new Identifier("riverredux", "gravelly_river"), GravellyRiverBiome.create());
        GRAVELLY = BuiltinRegistries.BIOME.getKey(gravelly).get();

//        OverworldBiomes.setRiverBiome(BiomeKeys.TAIGA, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.TAIGA_HILLS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.TAIGA_MOUNTAINS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.GIANT_SPRUCE_TAIGA, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.GIANT_SPRUCE_TAIGA_HILLS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.GIANT_TREE_TAIGA, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.GIANT_TREE_TAIGA_HILLS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MOUNTAINS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MOUNTAIN_EDGE, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.WOODED_MOUNTAINS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.GRAVELLY_MOUNTAINS, GRAVELLY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_GRAVELLY_MOUNTAINS, GRAVELLY);

        Biome tropical = Registry.register(BuiltinRegistries.BIOME, new Identifier("riverredux", "tropical_river"), TropicalRiverBiome.create());
        TROPICAL = BuiltinRegistries.BIOME.getKey(tropical).get();

//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_EDGE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE_EDGE, TROPICAL);

        Biome carved = Registry.register(BuiltinRegistries.BIOME, new Identifier("riverredux", "carved_river"), CarvedRiverBiome.create());
        CARVED = BuiltinRegistries.BIOME.getKey(carved).get();

//        OverworldBiomes.setRiverBiome(BiomeKeys.BADLANDS, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.ERODED_BADLANDS, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.WOODED_BADLANDS_PLATEAU, CARVED);
    }

    public static boolean isRiver(Optional<RegistryKey<Biome>> optional) {
        return Objects.equals(optional, Optional.of(SANDY)) || Objects.equals(optional, Optional.of(GRAVELLY)) || Objects.equals(optional, Optional.of(TROPICAL)) || Objects.equals(optional, Optional.of(CARVED));
    }
}
