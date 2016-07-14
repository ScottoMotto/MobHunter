package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.WeaponUpgradeManager;
import com.alxnns1.mobhunter.crafting.WeaponUpgradeRecipe;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 10/05/2016.
 */
public class ContainerWeaponUpgrade extends MHContainer
{
    /** Used to store the currently viewable recipes for the buttons */
    public List<WeaponUpgradeRecipe> recipes;
    public List<Boolean> recipesValid;

    public ContainerWeaponUpgrade(InventoryPlayer invPlayer, World worldIn)
    {
        super(invPlayer, null, worldIn);
        recipes = new ArrayList<WeaponUpgradeRecipe>(5);
        recipesValid = new ArrayList<Boolean>(5);
    }

    @Override
    protected void init()
    {
        invStartX = 48;
        invStartY = 122;
        inventory = new InventoryCrafting(this, 1, 1);
    }

    @Override
    protected void addSlots()
    {
        addSlotToContainer(new Slot(inventory, 0, 14, 53)
        {
            /**
             * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
             * of armor slots)
             */
            public int getSlotStackLimit()
            {
                return 1;
            }
        });
    }

    public boolean checkHasAllItems(IInventory inv, ArrayList<Object> input)
    {
        return checkPlayerInv(inv, input).isEmpty();
    }

    /**
     * Checks the player's inventory for all of the input items, and returns true if they're all present.
     * False if at least 1 item is not there.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Object> checkPlayerInv(IInventory inv, ArrayList<Object> input)
    {
        ArrayList<Object> required = new ArrayList<Object>(input.size());
        //Go through all of the ingredients
        for(int r = 0; r < input.size(); r++)
        {
            Object o = input.get(r);
            if(o instanceof ItemStack)
            {
                required.add(((ItemStack) o).copy()); //Want a copy, not a reference
                o = required.get(r);
            }
            else
                required.add(o);
            //Check if each ingredient is in the player inventory
            for(int i = 0; i < inv.getSizeInventory(); i++)
            {
                ItemStack stack = inv.getStackInSlot(i);
                if(stack == null) continue;

                if(o instanceof ItemStack)
                {
                    ItemStack oStack = (ItemStack) o;
                    if(OreDictionary.itemMatches(oStack, stack, false))
                    {
                        oStack.stackSize -= stack.stackSize;
                        if(oStack.stackSize > 0)
                            required.set(r, oStack);
                        else
                            required.set(r, null);
                    }
                }
                else if(o instanceof List)
                {
                    if(OreDictionary.containsMatch(false, (List<ItemStack>) o, stack))
                    {
                        required.set(r, null);
                        break;
                    }
                }
                //If all of this ingredient is in inventory, then skip to the next one
                if(required.get(r) == null)
                    break;
            }
        }
        //Remove all null items
        for(int i = 0; i < required.size(); i++)
        {
            if(required.get(i) == null)
            {
                required.remove(i);
                i -= 1;
            }
        }
        return required;
    }

    private void reloadRecipes()
    {
        recipes = WeaponUpgradeManager.getInstance().findMatchingRecipes(inventory, inventoryPlayer, world);
        recipesValid = new ArrayList<Boolean>(5);
        for(WeaponUpgradeRecipe r : recipes)
            recipesValid.add(checkHasAllItems(inventoryPlayer, r.getInput()));
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        reloadRecipes();
        String log = "Recipes:\n";
        for(int i = 0; i < recipes.size(); i++)
        {
            if(recipesValid.get(i))
                log += "Y - ";
            else
                log += "N - ";
            log += recipes.get(i).toString();
        }
        //LogHelper.info(log);
        detectAndSendChanges();
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     * I am using this to upgrade the item (i.e. remove old item and create new one)
     */
    @Override
    @SuppressWarnings("all")
    public boolean enchantItem(EntityPlayer playerIn, int id)
    {
        ItemStack stack = inventory.getStackInSlot(0);

        if(stack == null || recipes.isEmpty() || recipes.get(id) == null) return false;
        if(playerIn.capabilities.isCreativeMode || checkHasAllItems(inventoryPlayer, recipes.get(id).getInput()))
        {
            if(!world.isRemote)
            {
                WeaponUpgradeRecipe recipe = recipes.get(id);

                if(!playerIn.capabilities.isCreativeMode)
                {
                    //Remove ingredients from player inventory
                    for(Object item : recipe.getInput())
                    {
                        if(item instanceof ItemStack)
                        {
                            ItemStack toRemove = (ItemStack) item;
                            playerIn.inventory.clearMatchingItems(toRemove.getItem(), toRemove.getMetadata(), toRemove.stackSize, null);
                        }
                        else if(item instanceof List)
                        {
                            List<ItemStack> toRemove = (List<ItemStack>) item;
                            for(ItemStack s : toRemove)
                                if(playerIn.inventory.clearMatchingItems(s.getItem(), s.getMetadata(), 1, null) > 0)
                                    break;
                        }
                    }
                }

                //Change key item to recipe output
                ItemStack newItem = recipe.getRecipeOutput();
                if(stack.isItemEnchanted())
                    //Copy over enchantments
                    EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), newItem);
                inventory.setInventorySlotContents(0, newItem);
                inventory.markDirty();
                reloadRecipes();
            }
            return true;
        }
        else
            return false;
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = this.listeners.get(i);
            for(int j = 0; j < recipesValid.size(); j++)
                if(recipesValid.get(j) != null)
                    listener.sendProgressBarUpdate(this, j, recipesValid.get(j) ? 1 : 0);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data)
    {
        if(id >= 0 && id <= 4)
            recipesValid.set(id, data == 1);
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if(world.isRemote) return;
        ItemStack stack = inventory.removeStackFromSlot(0);
        if(stack != null) playerIn.dropItem(stack, false);
    }
}
