package supercoder79.riverredux;

import net.fabricmc.api.ModInitializer;

public class RiverRedux implements ModInitializer {
	@Override
	public void onInitialize() {
		RiverBiomes.init();
	}
}
