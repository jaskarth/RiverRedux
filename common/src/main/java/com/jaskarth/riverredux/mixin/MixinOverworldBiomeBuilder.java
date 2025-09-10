package com.jaskarth.riverredux.mixin;


import com.jaskarth.riverredux.BiomeMaps;
import com.jaskarth.riverredux.util.StackWalk;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public abstract class MixinOverworldBiomeBuilder {

    @Shadow @Final private Climate.Parameter FULL_RANGE;

    @Shadow @Final private Climate.Parameter UNFROZEN_RANGE;

    @Shadow @Final private Climate.Parameter[] erosions;

    @Shadow @Final private Climate.Parameter coastContinentalness;

    @Shadow @Final private Climate.Parameter farInlandContinentalness;

    @Shadow @Final private Climate.Parameter[] temperatures;

    @Shadow @Final private Climate.Parameter[] humidities;

    // Sorry for the crimes
    @Inject(method = "addSurfaceBiome", at = @At("HEAD"), cancellable = true)
    private void tryRemoveRiver(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome, CallbackInfo ci) {
        if (biome.equals(Biomes.RIVER)) {
            if (temperature.equals(this.UNFROZEN_RANGE) && humidity.equals(this.FULL_RANGE)) {
                if (erosion.equals(Climate.Parameter.span(this.erosions[2], this.erosions[5])) && continentalness.equals(Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness))) {
                    if (StackWalk.isVanillaInvocOfOBB()) {
//                        System.out.println("Injecting RiverRedux Biomes");
//                        Thread.dumpStack();
                        for(int i = 0; i < this.temperatures.length; ++i) {
                            Climate.Parameter parameterRange = this.temperatures[i];

                            for(int j = 0; j < this.humidities.length; ++j) {
                                Climate.Parameter parameterRange2 = this.humidities[j];

                                ResourceKey<Biome> riverKeyOrNull = BiomeMaps.RR_RIVER_BIOMES[i][j];
                                if (riverKeyOrNull != null) {
                                    this.writeCustomRivers(
                                            parameters,
                                            parameterRange,
                                            parameterRange2,
                                            Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness),
                                            Climate.Parameter.span(this.erosions[2], this.erosions[5]),
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
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters,
            Climate.Parameter temperature,
            Climate.Parameter humidity,
            Climate.Parameter continentalness,
            Climate.Parameter erosion,
            Climate.Parameter weirdness,
            float offset,
            ResourceKey<Biome> biome
    ) {
        parameters.accept(
                Pair.of(
                        Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome
                )
        );
        parameters.accept(
                Pair.of(
                        Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome
                )
        );
    }
}
