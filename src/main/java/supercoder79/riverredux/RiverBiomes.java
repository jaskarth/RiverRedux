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

    public static final RegistryKey<Biome> SANDY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("riverredux", "sandy_river"));
    public static final RegistryKey<Biome> GRAVELLY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("riverredux", "gravelly_river"));
    public static final RegistryKey<Biome> TROPICAL = RegistryKey.of(Registry.BIOME_KEY, new Identifier("riverredux", "tropical_river"));
    public static final  RegistryKey<Biome> CARVED = RegistryKey.of(Registry.BIOME_KEY, new Identifier("riverredux", "carved_river"));

    public static void init() {
        Biome sandy = Registry.register(BuiltinRegistries.BIOME, SANDY, SandyRiverBiome.create());

//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_LAKES, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_HILLS, SANDY);

        Biome gravelly = Registry.register(BuiltinRegistries.BIOME, GRAVELLY, GravellyRiverBiome.create());

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

        Biome tropical = Registry.register(BuiltinRegistries.BIOME, TROPICAL, TropicalRiverBiome.create());

//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_EDGE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE_EDGE, TROPICAL);

        Biome carved = Registry.register(BuiltinRegistries.BIOME, CARVED, CarvedRiverBiome.create());

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
