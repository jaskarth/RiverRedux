package supercoder79.riverredux.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import supercoder79.riverredux.RiverBiomes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Mixin(BiomeSource.class)
public abstract class MixinBiomeSource {
    @Shadow @Final private Set<RegistryEntry<Biome>> biomes;

    @Shadow public abstract RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise);

    @Shadow public abstract Set<RegistryEntry<Biome>> getBiomes();
}
