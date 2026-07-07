package woodisdaniel.notreepunchingremastered;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import woodisdaniel.notreepunchingremastered.common.crafting.ModRecipeTypes;
import woodisdaniel.notreepunchingremastered.common.block.ModBlocks;
import woodisdaniel.notreepunchingremastered.common.ModCreativeModeTabs;
import woodisdaniel.notreepunchingremastered.gui.menu.ModMenuTypes;
import woodisdaniel.notreepunchingremastered.common.item.ModItems;

import woodisdaniel.notreepunchingremastered.gui.screen.VesselScreen;

@Mod(NoTreePunchingRemastered.MOD_ID)
public class NoTreePunchingRemastered {
    public static final String MOD_ID = "notreepunchingremastered";

    public NoTreePunchingRemastered(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModRecipeTypes.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {

        }

        // Screen Register
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.VESSEL_MENU.get(), VesselScreen::new);
        }
    }
}