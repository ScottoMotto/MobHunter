package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by Alex on 20/04/2016.
 */
public class ItemResource extends Item {

    private ModelResourceLocation model;

    public ItemResource(String itemName){
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        model = new ModelResourceLocation(Reference.MOD_ID + ":" + itemName,"inventory");
    }

}
