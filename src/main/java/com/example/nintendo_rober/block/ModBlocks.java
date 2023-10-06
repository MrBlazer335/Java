package com.example.nintendo_rober.block;

import com.example.nintendo_rober.items.Nintendo_Switch;
import com.example.nintendo_rober.nintendo_rober;
import com.example.nintendo_rober.word.dimensions.Nintendo_Dimension;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, nintendo_rober.MODID);

    public static final RegistryObject<Block> DRUG_STORE = registerBlock("drug_store", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).explosionResistance(-1).requiresCorrectToolForDrops().color(MaterialColor.COLOR_LIGHT_GREEN).strength(5f)),CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> SECURITY_BLOCK  = registerBlock("security_block",()-> new Block(BlockBehaviour.Properties.of(Material.METAL).explosionResistance(5).requiresCorrectToolForDrops().color(MaterialColor.COLOR_LIGHT_GREEN).strength(5f)),CreativeModeTab.TAB_BUILDING_BLOCKS);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name ,block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return Nintendo_Switch.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
