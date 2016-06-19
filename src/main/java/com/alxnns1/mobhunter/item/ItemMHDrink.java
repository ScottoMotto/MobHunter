package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

/**
 * Created by Mark on 14/05/2016.
 */
public class ItemMHDrink extends ItemMHConsumable
{
    public ItemMHDrink(String itemName)
    {
        super(itemName);
        setMaxStackSize(1);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            Item item = stack.getItem();
            if(item.equals(MHItems.itemPotion))
                player.heal(5f);
            else if(item.equals(MHItems.itemMegaPotion))
                player.heal(10f);
            //else if(item.equals(MHItems.itemNutrients))
            //else if(item.equals(MHItems.itemMegaNutrients))
            else if(item.equals(MHItems.itemAntidote) && player.isPotionActive(MobEffects.POISON))
                player.removePotionEffect(MobEffects.POISON);
            else if(item.equals(MHItems.itemImmunizer))
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200));
            else if(item.equals(MHItems.itemDashJuice))
            {
                FoodStats food = player.getFoodStats();
                food.setFoodSaturationLevel(Math.min(food.getSaturationLevel() + 10f, 40f));
            }
            else if(item.equals(MHItems.itemMegaDashJuice))
            {
                FoodStats food = player.getFoodStats();
                food.setFoodSaturationLevel(Math.min(food.getSaturationLevel() + 20f, 40f));
            }
            else if(item.equals(MHItems.itemDemondrug))
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 1));
            else if(item.equals(MHItems.itemMegaDemondrug))
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 400, 1));
            else if(item.equals(MHItems.itemArmourskin))
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 1));
            else if(item.equals(MHItems.itemMegaArmourskin))
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 400, 1));
        }

        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
            if (stack.stackSize <= 0)
                return new ItemStack(Items.GLASS_BOTTLE);
            player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        }

        return stack;
    }

    /**
     * Returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
