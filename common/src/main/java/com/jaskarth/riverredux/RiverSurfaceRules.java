package com.jaskarth.riverredux;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public final class RiverSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);

    public static SurfaceRules.RuleSource build() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource biomeSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RiverBiomes.SANDY, RiverBiomes.TROPICAL), SAND),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(RiverBiomes.GRAVELLY), GRAVEL)
        );

        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, biomeSurface),
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, biomeSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}