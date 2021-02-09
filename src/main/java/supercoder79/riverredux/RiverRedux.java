package supercoder79.riverredux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class RiverRedux implements ModInitializer {
	@Override
	public void onInitialize() {
		RiverConfiguredFeatures.init();
		RiverBiomes.init();
		ModCompatHolder.init();
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER), GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("riverredux", "river_waterfalls")));
	}
}
