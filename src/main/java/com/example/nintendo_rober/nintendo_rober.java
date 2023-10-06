package com.example.nintendo_rober;

import com.example.nintendo_rober.block.ModBlocks;
import com.example.nintendo_rober.effects.Effects;
import com.example.nintendo_rober.items.Nintendo_Switch;
import com.example.nintendo_rober.sounds.Sounds;
import com.example.nintendo_rober.villager.ModVillagers;
import com.example.nintendo_rober.word.dimensions.Nintendo_Dimension;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(nintendo_rober.MODID)
public class nintendo_rober {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "nintendo_rober";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "nintendo_rober" namespace



    public nintendo_rober() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        Nintendo_Switch.register(modEventBus);

        Nintendo_Dimension.register();

        //villager
        ModVillagers.register(modEventBus);
        Sounds.register(modEventBus);
        Effects.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

event.enqueueWork(() -> {
    ModVillagers.registerPOIs();
        });
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }




    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info(ModVillagers.MyLifeSucks());
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info(ModVillagers.MyLifeSucks());
            LOGGER.info(ModVillagers.MyLifeSucks(), Minecraft.getInstance().getUser().getName());
        }
    }
}
