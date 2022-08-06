package supercoder79.riverredux.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.WorldView;
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

    /**
     * @author SuperCoder79
     * @reason Strictly debug only
     */
    @Nullable
    public Pair<BlockPos, RegistryEntry<Biome>> locateBiome(
            BlockPos origin,
            int radius,
            int horizontalBlockCheckInterval,
            int verticalBlockCheckInterval,
            Predicate<RegistryEntry<Biome>> predicate,
            MultiNoiseUtil.MultiNoiseSampler noiseSampler,
            WorldView world
    ) {
        Set<RegistryEntry<Biome>> set = this.getBiomes().stream().filter(predicate).collect(Collectors.toUnmodifiableSet());
        if (set.isEmpty() && false) {
            return null;
        } else {
            int i = Math.floorDiv(radius, horizontalBlockCheckInterval);
            int[] is = MathHelper.stream(origin.getY(), world.getBottomY() + 1, world.getTopY(), verticalBlockCheckInterval).toArray();

            for(BlockPos.Mutable mutable : BlockPos.iterateInSquare(BlockPos.ORIGIN, i, Direction.EAST, Direction.SOUTH)) {
                int j = origin.getX() + mutable.getX() * horizontalBlockCheckInterval;
                int k = origin.getZ() + mutable.getZ() * horizontalBlockCheckInterval;
                int l = BiomeCoords.fromBlock(j);
                int m = BiomeCoords.fromBlock(k);

                for(int n : is) {
                    int o = BiomeCoords.fromBlock(n);
                    RegistryEntry<Biome> registryEntry = this.getBiome(l, o, m, noiseSampler);
                    if (set.contains(registryEntry) || predicate.test(registryEntry)) {
                        return Pair.of(new BlockPos(j, n, k), registryEntry);
                    }
                }
            }

            return null;
        }
    }
}
