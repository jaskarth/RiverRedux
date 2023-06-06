package supercoder79.riverredux.mixin;


import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import supercoder79.riverredux.BiomeMaps;
import supercoder79.riverredux.RiverBiomes;
import supercoder79.riverredux.util.StackWalk;

import java.util.function.Consumer;

@Mixin(VanillaBiomeParameters.class)
public abstract class MixinOverworldBiomeBuilder {
    @Shadow protected abstract void writeBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome);

    @Shadow @Final private MultiNoiseUtil.ParameterRange nonFrozenTemperatureParameters;
    @Shadow @Final private MultiNoiseUtil.ParameterRange coastContinentalness;
    @Shadow @Final private MultiNoiseUtil.ParameterRange defaultParameter;
    @Shadow @Final private MultiNoiseUtil.ParameterRange[] erosionParameters;
    @Shadow @Final private MultiNoiseUtil.ParameterRange farInlandContinentalness;
    @Shadow @Final private MultiNoiseUtil.ParameterRange[] temperatureParameters;
    @Shadow @Final private MultiNoiseUtil.ParameterRange[] humidityParameters;


    @Inject(method = "writeBiomeParameters", at = @At("HEAD"), cancellable = true)
    private void tryRemoveRiver(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome, CallbackInfo ci) {
        if (biome.equals(BiomeKeys.RIVER)) {
            if (temperature.equals(this.nonFrozenTemperatureParameters) && humidity.equals(this.defaultParameter)) {
                if (erosion.equals(MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[2], this.erosionParameters[5])) && continentalness.equals(MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness))) {
                    if (StackWalk.isVanillaInvocOfOBB()) {
//                        System.out.println("Injecting RiverRedux Biomes");
                        for(int i = 0; i < this.temperatureParameters.length; ++i) {
                            MultiNoiseUtil.ParameterRange parameterRange = this.temperatureParameters[i];

                            for(int j = 0; j < this.humidityParameters.length; ++j) {
                                MultiNoiseUtil.ParameterRange parameterRange2 = this.humidityParameters[j];

                                RegistryKey<Biome> riverKeyOrNull = BiomeMaps.RR_RIVER_BIOMES[i][j];
                                if (riverKeyOrNull != null) {
                                    this.writeCustomRivers(
                                            parameters,
                                            parameterRange,
                                            parameterRange2,
                                            MultiNoiseUtil.ParameterRange.combine(this.coastContinentalness, this.farInlandContinentalness),
                                            MultiNoiseUtil.ParameterRange.combine(this.erosionParameters[2], this.erosionParameters[5]),
                                            weirdness,
                                            0.0F,
                                            riverKeyOrNull
                                    );
                                }
                            }
                        }

                        ci.cancel();
                    }
                }
            }
        }
    }

    private void writeCustomRivers(
            Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters,
            MultiNoiseUtil.ParameterRange temperature,
            MultiNoiseUtil.ParameterRange humidity,
            MultiNoiseUtil.ParameterRange continentalness,
            MultiNoiseUtil.ParameterRange erosion,
            MultiNoiseUtil.ParameterRange weirdness,
            float offset,
            RegistryKey<Biome> biome
    ) {
        parameters.accept(
                Pair.of(
                        MultiNoiseUtil.createNoiseHypercube(temperature, humidity, continentalness, erosion, MultiNoiseUtil.ParameterRange.of(0.0F), weirdness, offset), biome
                )
        );
        parameters.accept(
                Pair.of(
                        MultiNoiseUtil.createNoiseHypercube(temperature, humidity, continentalness, erosion, MultiNoiseUtil.ParameterRange.of(1.0F), weirdness, offset), biome
                )
        );
    }
}
