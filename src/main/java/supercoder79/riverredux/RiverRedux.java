package supercoder79.riverredux;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.Registry;

public class RiverRedux implements ModInitializer {
	@Override
	public void onInitialize() {
		RiverBiomes.init();
		ModCompatHolder.init();
	}
}
