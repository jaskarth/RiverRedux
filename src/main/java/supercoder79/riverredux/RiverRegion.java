package supercoder79.riverredux;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.ParameterUtils.Temperature;
import terrablender.api.ParameterUtils.Humidity;
import terrablender.api.ParameterUtils.Continentalness;
import terrablender.api.ParameterUtils.Erosion;
import terrablender.api.ParameterUtils.Depth;
import terrablender.api.ParameterUtils.Weirdness;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

public class RiverRegion extends Region {
    public RiverRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            });

        // TODO: is this invoc needed?
//        List<MultiNoiseUtil.NoiseHypercube> riverTargetN_I = new ParameterUtils.ParameterPointListBuilder()
////                    .temperature(Temperature.UNFROZEN)
//                .temperature(Temperature.HOT)
//                .humidity(Humidity.FULL_RANGE)
//                .continentalness(Continentalness.NEAR_INLAND)
//                .erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_1))
//                .depth(Depth.SURFACE, Depth.FLOOR)
//                .weirdness(Weirdness.VALLEY)
//                .build();
//
//        riverTargetN_I.forEach(point -> addBiome(mapper, point, RiverBiomes.SANDY));

        List<MultiNoiseUtil.NoiseHypercube> riverTargetC2F = new ParameterUtils.ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.span(Continentalness.COAST, Continentalness.FAR_INLAND))
                .erosion(Erosion.span(Erosion.EROSION_2, Erosion.EROSION_5))
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.VALLEY)
                .build();

        riverTargetC2F.forEach(point -> addBiome(mapper, point, RiverBiomes.SANDY));

        List<MultiNoiseUtil.NoiseHypercube> riverTargetC2F2 = new ParameterUtils.ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.span(Continentalness.COAST, Continentalness.FAR_INLAND))
                .erosion(Erosion.span(Erosion.EROSION_2, Erosion.EROSION_5))
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.VALLEY)
                .build();

        riverTargetC2F2.forEach(point -> addBiome(mapper, point, RiverBiomes.TROPICAL));

        List<MultiNoiseUtil.NoiseHypercube> riverTargetC2F3 = new ParameterUtils.ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.HUMID)
                .continentalness(Continentalness.span(Continentalness.COAST, Continentalness.FAR_INLAND))
                .erosion(Erosion.span(Erosion.EROSION_2, Erosion.EROSION_5))
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.VALLEY)
                .build();

        riverTargetC2F3.forEach(point -> addBiome(mapper, point, RiverBiomes.GRAVELLY));
    }
}