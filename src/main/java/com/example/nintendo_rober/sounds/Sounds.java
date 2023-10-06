package com.example.nintendo_rober.sounds;

import com.example.nintendo_rober.nintendo_rober;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {
    public static final DeferredRegister<SoundEvent> CUSTOM_SOUNDS  = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, nintendo_rober.MODID);
    public static final RegistryObject<SoundEvent> DRUG_VILLAGER_REGISTRY = CUSTOM_SOUNDS.register("drug_villager_working", ()->new SoundEvent(new ResourceLocation("nintendo_rober","drug_villager_working")));

    public static final RegistryObject<SoundEvent> EMPIRE_OF_TOADS = CUSTOM_SOUNDS.register("empire_of_toads",()->new SoundEvent(new ResourceLocation("nintendo_rober","empire_of_toads")));



    public static void register(IEventBus eventBus){
        CUSTOM_SOUNDS.register(eventBus);
    }
}
