package com.example.nintendo_rober.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class LSD extends MobEffect {

    protected LSD(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity,int pAmplifier){
        if (!pLivingEntity.level.isClientSide)){

        }
        super.applyEffectTick(pLivingEntity,pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration,int pAmplifier){
        return true;
    }
}
