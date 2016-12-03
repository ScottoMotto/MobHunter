package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 10/05/2016.
 */
public class BlockBerry extends BlockNatural
{
    public BlockBerry()
    {
        super(Names.Blocks.BERRY, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
    }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.13657056145675265553869499241275)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "huskberry"));
        else if (chance < 0.22761760242792109256449165402125)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "paintberry"));
        else if (chance < 0.37936267071320182094081942336874)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "mightSeed"));
        else if (chance < 0.66767830045523520485584218512898)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "nullberry"));
        else if (chance < 0.7814871016691957511380880121396)    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "needleberry"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "bomberry"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.069615663524292965917331399564906)       drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "mightSeed"));
        else if (chance < 0.31109499637418419144307469180568)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "adamantSeed"));
        else if (chance < 0.46337926033357505438723712835391)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "nullberry"));
        else if (chance < 0.66932559825960841189267585206675)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "dragonfellBerry"));
        else if (chance < 0.79985496736765772298767222625095)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "scatternut"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "latchberry"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.1465230476793917313480120386504)         drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "huskberry"));
        else if (chance < 0.31126247425946459686361476318707)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "paintberry"));
        else if (chance < 0.47726912719784571519087597022018)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "mightSeed"));
        else if (chance < 0.68002534452716616505623316964993)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "nullberry"));
        else if (chance < 0.83209250752415650245525106922224)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "needleberry"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "bomberry"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.092390183542998556403382140647556)       drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "huskberry"));
        else if (chance < 0.20622808826562177768612084965973)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "paintberry"));
        else if (chance < 0.33986388946174468962672716023923)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "mightSeed"));
        else if (chance < 0.4229738090327902660342338626521)    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "adamantSeed"));
        else if (chance < 0.61146628170756857083934831924109)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "nullberry"));
        else if (chance < 0.69808207877912971746751907609818)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "needleberry"));
        else if (chance < 0.85151577644875232006599298824502)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "latchberry"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "bomberry"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.11499459873854409868627382653239)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "huskberry"));
        else if (chance < 0.20232080008363243544621388995365)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "paintberry"));
        else if (chance < 0.35564693173502456702791232533017)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "mightSeed"));
        else if (chance < 0.49985015855315886678049970380179)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "nullberry"));
        else if (chance < 0.58302958497403909816357110499355)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "scatternut"));
        else if (chance < 0.66881555563299299578353137958671)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "needleberry"));
        else if (chance < 0.82980799386695473394431473673206)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, "latchberry"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "bomberry"));
        return drops;
    }
}
