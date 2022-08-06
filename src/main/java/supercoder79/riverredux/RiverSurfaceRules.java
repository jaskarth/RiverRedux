package supercoder79.riverredux;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public final class RiverSurfaceRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule SAND = makeStateRule(Blocks.SAND);
    private static final MaterialRules.MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);

    public static MaterialRules.MaterialRule build() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialRule biomeSurface = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(RiverBiomes.SANDY, RiverBiomes.TROPICAL), SAND),
                MaterialRules.condition(MaterialRules.biome(RiverBiomes.GRAVELLY), GRAVEL)
        );

        return MaterialRules.sequence(
            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, biomeSurface),
            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, biomeSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}