package com.example.nintendo_rober.items;

import com.example.nintendo_rober.creative_tabs.Drugs;
import com.example.nintendo_rober.nintendo_rober;
import com.example.nintendo_rober.sounds.Sounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.CreativeModeTab.*;

public class Nintendo_Switch extends Items {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, nintendo_rober.MODID);

    public static final RegistryObject<Item> ITEM = ITEMS.register("nintendo_switch", () -> new SwordItem(Tiers.DIAMOND, 996, 3.5f, new Item.Properties().tab(TAB_COMBAT).setNoRepair().durability(1).food(new FoodProperties.Builder().alwaysEat().effect(new MobEffectInstance(MobEffects.HARM, 200, 10), 1f).build())));

//Drugs
    public static final DeferredRegister<Item> DRUGS = DeferredRegister.create(ForgeRegistries.ITEMS,nintendo_rober.MODID);
    public static final RegistryObject<Item> COCAINE = DRUGS.register("nintendo_cocaine",()->
        new Item(new Item.Properties().tab(Drugs.DRUG_TAB).food(new FoodProperties.Builder().alwaysEat().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1800,4),1f).effect(new MobEffectInstance(MobEffects.DIG_SPEED,1800,4),1f).effect(new MobEffectInstance(MobEffects.POISON,300,0),0.05f).build())));

    public static final RegistryObject<Item> MARIJUANA = DRUGS.register("nintendo_marijuana_cookie",()->
            new Item(new Item.Properties().tab(Drugs.DRUG_TAB).food(new FoodProperties.Builder().nutrition(3).alwaysEat().effect(new MobEffectInstance(MobEffects.HEAL,1200,0),1f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,1200,1),1f).effect(new MobEffectInstance(MobEffects.CONFUSION,1200,0),1f).effect(new MobEffectInstance(MobEffects.HUNGER,600,6),1f).effect(new MobEffectInstance(MobEffects.BLINDNESS,1200,255),0.05f)
                    .build())));

    public static final RegistryObject<Item> HEROIN = DRUGS.register("nintendo_heroin",()->new Item(new Item.Properties().tab(Drugs.DRUG_TAB).food(new FoodProperties.Builder().alwaysEat().effect(new MobEffectInstance(MobEffects.BLINDNESS,1200,255),1f).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,1200,2),1f).effect(new MobEffectInstance(MobEffects.REGENERATION,1200,0),1f).
            effect(new MobEffectInstance(MobEffects.WITHER,1200,0),1f).effect(new MobEffectInstance(MobEffects.HARM,1200,10),0.005f).build())));


    //Music
    public static final RegistryObject<Item> EMPIRE_OF_TOADS_MUSIC = ITEMS.register("empire_of_toads_disc",()-> new RecordItem(8, Sounds.EMPIRE_OF_TOADS,new Item.Properties().tab(Drugs.DRUG_TAB),3700));



    public static final RegistryObject<Item> CASINO_PASS = ITEMS.register("casino_pass",() -> new Item(new Item.Properties().tab(Drugs.DRUG_TAB)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        DRUGS.register(eventBus);
    }
}
