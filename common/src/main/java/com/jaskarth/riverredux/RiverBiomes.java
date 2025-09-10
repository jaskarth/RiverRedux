package com.jaskarth.riverredux;


import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.intellij.lang.annotations.Identifier;

import java.util.Objects;
import java.util.Optional;

public class RiverBiomes {
    public static final ResourceKey<Biome> SANDY = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("riverredux", "sandy_river"));
    public static final ResourceKey<Biome> GRAVELLY = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("riverredux", "gravelly_river"));
    public static final ResourceKey<Biome> TROPICAL = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("riverredux", "tropical_river"));
    public static final  ResourceKey<Biome> CARVED = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("riverredux", "carved_river"));

    public static void init() {
//        Biome sandy = Registry.register(BuiltinRegistries.BIOME, SANDY, SandyRiverBiome.create());

//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_LAKES, SANDY);
//        OverworldBiomes.setRiverBiome(BiomeKeys.DESERT_HILLS, SANDY);

//        Biome gravelly = Registry.register(BuiltinRegistries.BIOME, GRAVELLY, GravellyRiverBiome.create());

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

//        Biome tropical = Registry.register(BuiltinRegistries.BIOME, TROPICAL, TropicalRiverBiome.create());

//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_EDGE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BAMBOO_JUNGLE_HILLS, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE, TROPICAL);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_JUNGLE_EDGE, TROPICAL);

//        Biome carved = Registry.register(BuiltinRegistries.BIOME, CARVED, CarvedRiverBiome.create());

//        OverworldBiomes.setRiverBiome(BiomeKeys.BADLANDS, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.ERODED_BADLANDS, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.MODIFIED_WOODED_BADLANDS_PLATEAU, CARVED);
//        OverworldBiomes.setRiverBiome(BiomeKeys.WOODED_BADLANDS_PLATEAU, CARVED);
    }
}
