package com.example.nintendo_rober.villager;

import com.example.nintendo_rober.block.ModBlocks;
import com.example.nintendo_rober.nintendo_rober;
import com.example.nintendo_rober.sounds.Sounds;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;


public class ModVillagers {

   public static String MyLifeSucks(){
       System.out.println("!!!!!!!!!! ITS NOT FUCKING WORKING !!!!" + ForgeRegistries.VILLAGER_PROFESSIONS);
       return null;
   }
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, nintendo_rober.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, nintendo_rober.MODID);

   // private static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, nintendo_rober.MODID);

    //private static RegistryObject<SoundEvent> Drug_Villager = SOUND_EVENT.register("drug_villager", () -> new SoundEvent(new ResourceLocation("nintendo_rober", "drug_villager")));


    //DRUG VIllAGER
    public static final RegistryObject<PoiType> DRUG_STORE_POI = POI_TYPES.register("drug_store_poi", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.DRUG_STORE.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> DRUG_SELLER = VILLAGER_PROFESSION.register("drug_seller", () ->
                    new VillagerProfession("drug_seller", x->x.get() == DRUG_STORE_POI.get(), x->x.get() == DRUG_STORE_POI.get(), ImmutableSet.of(),ImmutableSet.of(),
                            Sounds.DRUG_VILLAGER_REGISTRY.get()));

    //SECURITY VILLAGER(CASINO)

    public static final RegistryObject<PoiType> SECURITY_BLOCK_POI = POI_TYPES.register("security_block_poi", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SECURITY_BLOCK.get().getStateDefinition().getPossibleStates()),1,2));
    public static final RegistryObject<VillagerProfession> SECURITY_GUY = VILLAGER_PROFESSION.register("security_guy", () ->
            new VillagerProfession("security_guy", x->x.get() == SECURITY_BLOCK_POI.get(), x->x.get() == SECURITY_BLOCK_POI.get(), ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.VILLAGER_AMBIENT));



    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, DRUG_STORE_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, SECURITY_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);

    }


}

