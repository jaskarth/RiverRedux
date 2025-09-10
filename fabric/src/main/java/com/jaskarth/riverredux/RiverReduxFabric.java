package com.jaskarth.riverredux;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class RiverReduxFabric implements ModInitializer, TerraBlenderApi {
    @Override
    public void onInitialize() {

    }

    @Override
    public void onTerraBlenderInitialized() {
        // Mainly just needed to support locatebiomes and such
        Regions.register(new RiverRegion(ResourceLocation.fromNamespaceAndPath("riverredux", "overworld"), 1));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "riverredux", RiverSurfaceRules.build());
    }
}
