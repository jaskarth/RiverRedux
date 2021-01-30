package supercoder79.riverredux.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import supercoder79.riverredux.RiverBiomes;

import java.util.Optional;
import java.util.Random;

@Mixin(DrownedEntity.class)
public class MixinDrownedEntity {

    @Inject(method = "canSpawn(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)Z", at = @At("HEAD"), cancellable = true)
    private static void riverReduxCanSpawn(EntityType<DrownedEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        Optional<RegistryKey<Biome>> optional = world.method_31081(pos);
        boolean shouldSpawn = world.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(world, pos, random) && (spawnReason == SpawnReason.SPAWNER || world.getFluidState(pos).isIn(FluidTags.WATER));
        if (RiverBiomes.isRiver(optional)) {
            cir.setReturnValue(random.nextInt(15) == 0 && shouldSpawn);
        }
    }
}