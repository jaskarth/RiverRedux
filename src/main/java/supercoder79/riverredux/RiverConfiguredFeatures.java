package supercoder79.riverredux;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SpringFeatureConfig;

public class RiverConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> RIVER_WATERFALLS = Feature.SPRING_FEATURE.configure(
            new SpringFeatureConfig(Blocks.WATER.getDefaultState().getFluidState(), true, 4, 1,
                    ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.GRAVEL, Blocks.DIRT)))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(64, 64, 128)))
            .spreadHorizontally().repeat(128).repeat(8);

    public static void init() {
        register("river_waterfalls", RIVER_WATERFALLS);
    }

    private static void register(String id, ConfiguredFeature<?, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("riverredux", id), feature);
    }
}
