package com.example.nintendo_rober.word.dimensions;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import com.example.nintendo_rober.nintendo_rober;
import net.minecraft.world.level.dimension.DimensionType;

import java.awt.*;


public class Nintendo_Dimension {
    public static final ResourceKey<Level> NS_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(nintendo_rober.MODID,"nsw"));
    public static final ResourceKey<DimensionType> NS_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,NS_KEY.registry());

    public static void register(){
        System.out.println("Registered new Dimension " + nintendo_rober.MODID);
    }
}
