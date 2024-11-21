package com.disk.diskssimplemagic.datageneration;

import com.disk.diskssimplemagic.DisksSimpleMagic;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = DisksSimpleMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {       
    @SubscribeEvent
    public static void configureForgeDatagen(GatherDataEvent event) {
        event.getGenerator().addProvider(
            // Tell generator to run only when client assets are generating
            event.includeClient(),
            // Localizations for American English
            new LanguageProviderEN_US(event.getGenerator(), DisksSimpleMagic.MODID, "en_us")
        );
    }
}