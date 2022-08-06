package supercoder79.riverredux;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
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
		// Mainly just needed to support locatebiomes and such
		Regions.register(new RiverRegion(new Identifier("riverredux", "overworld"), 1));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "riverredux", RiverSurfaceRules.build());
	}
}
