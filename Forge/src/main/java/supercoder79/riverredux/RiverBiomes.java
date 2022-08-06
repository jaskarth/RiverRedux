package supercoder79.riverredux;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import supercoder79.riverredux.biome.CarvedRiverBiome;
import supercoder79.riverredux.biome.GravellyRiverBiome;
import supercoder79.riverredux.biome.SandyRiverBiome;
import supercoder79.riverredux.biome.TropicalRiverBiome;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class RiverBiomes {
    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }


    public static final ResourceKey<Biome> SANDY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("riverredux", "sandy_river"));
    public static final ResourceKey<Biome> GRAVELLY = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("riverredux", "gravelly_river"));
    public static final ResourceKey<Biome> TROPICAL = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("riverredux", "tropical_river"));
    public static final  ResourceKey<Biome> CARVED = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("riverredux", "carved_river"));

    protected static DeferredRegister<Biome> BIOME_REGISTER = DeferredRegister.create(Registry.BIOME_REGISTRY, "riverredux");

    public static void init() {
        register(SANDY, SandyRiverBiome::create);
        register(GRAVELLY, GravellyRiverBiome::create);
        register(TROPICAL, TropicalRiverBiome::create);
        register(CARVED, CarvedRiverBiome::create);
    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier) {
        return BIOME_REGISTER.register(key.location().getPath(), biomeSupplier);
    }

    public static boolean isRiver(Optional<ResourceKey<Biome>> optional) {
        return Objects.equals(optional, Optional.of(SANDY)) || Objects.equals(optional, Optional.of(GRAVELLY)) || Objects.equals(optional, Optional.of(TROPICAL)) || Objects.equals(optional, Optional.of(CARVED));
    }
}
