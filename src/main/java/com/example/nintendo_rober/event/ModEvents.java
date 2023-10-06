package com.example.nintendo_rober.event;

import com.example.nintendo_rober.items.Nintendo_Switch;
import com.example.nintendo_rober.nintendo_rober;
import com.example.nintendo_rober.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = nintendo_rober.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        //Trades on lvl 1
        if (event.getType() == ModVillagers.DRUG_SELLER.get()) {
            //Cocaine
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades_cocaine = event.getTrades();
            ItemStack cocaine = new ItemStack(Nintendo_Switch.COCAINE.get(), 1);
            int villagerLevel = 1;


            trades_cocaine.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64), cocaine, 10, 8, 1F));

            //Marijuana
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades_marijuana = event.getTrades();
            ItemStack marijuana = new ItemStack(Nintendo_Switch.MARIJUANA.get(),1);

            trades_marijuana.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,25),marijuana,10,8,1F));

          //Heroin
            Int2ObjectMap<List<VillagerTrades.ItemListing>>trades_heroin = event.getTrades();
            ItemStack heroin = new ItemStack(Nintendo_Switch.HEROIN.get(),1);

            trades_heroin.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD,32),heroin,10,8,1F));



        }
        if(event.getType() == ModVillagers.SECURITY_GUY.get()){
            int villagerLevel = 1;
            Int2ObjectMap<List<VillagerTrades.ItemListing>>security_guy_trade = event.getTrades();
            ItemStack casino_pass = new ItemStack(Nintendo_Switch.CASINO_PASS.get(),1);

            security_guy_trade.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),casino_pass,90,90,0.0001F));

        }


    }
}
