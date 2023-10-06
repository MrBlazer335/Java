package com.example.nintendo_rober.creative_tabs;

import com.example.nintendo_rober.items.Nintendo_Switch;
import com.example.nintendo_rober.nintendo_rober;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.units.qual.C;


public class Drugs extends CreativeModeTab {

    public Drugs(int index, String label) {
        super(index,label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Nintendo_Switch.COCAINE.get());
    }

    public static final CreativeModeTab DRUG_TAB = new CreativeModeTab(nintendo_rober.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Nintendo_Switch.COCAINE.get());
        }
    };





}
