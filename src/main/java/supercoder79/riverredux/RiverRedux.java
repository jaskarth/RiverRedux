package supercoder79.riverredux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class RiverRedux implements ModInitializer, TerraBlenderApi {
	@Override
	public void onInitialize() {
		RiverConfiguredFeatures.init();
		RiverBiomes.init();
//		ModCompatHolder.init();
//		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER), GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("riverredux", "river_waterfalls")));
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new TestRegion(new Identifier("riverredux", "overworld"), 6));
	}
}
