package com.example.nintendo_rober.effects;

import com.example.nintendo_rober.nintendo_rober;
import com.google.j2objc.annotations.Weak;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Effects {
    public static DeferredRegister<MobEffects> MOB_EFFECTS = DeferredRegister.create((ResourceLocation) ForgeRegistries.MOB_EFFECTS, nintendo_rober.MODID);

    public static final RegistryObject<MobEffects>

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
