package com.jaskarth.riverredux.forge;

import com.jaskarth.riverredux.RiverRedux;
import com.jaskarth.riverredux.RiverRegion;
import com.jaskarth.riverredux.RiverSurfaceRules;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(RiverRedux.ID)
public class RiverReduxForge {

    public RiverReduxForge(IEventBus eventBus, ModContainer container) {
        IEventBus modEventBus = eventBus;

        modEventBus.addListener(this::commonSetup);

//        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new RiverRegion(ResourceLocation.fromNamespaceAndPath("riverredux", "overworld"), 1));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "riverredux", RiverSurfaceRules.build());
        });
    }
}
