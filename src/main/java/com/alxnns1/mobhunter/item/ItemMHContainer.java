package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.block.BlockBbq;
import com.alxnns1.mobhunter.block.BlockNatural;
import com.alxnns1.mobhunter.block.BlockOre;
import com.alxnns1.mobhunter.block.BlockResource;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 16/11/2016.
 */
public class ItemMHContainer extends Item {
    PouchInventory inventory = new PouchInventory("Field Pouch", true, 27);

    public ItemMHContainer(String itemName) {
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!worldIn.isRemote && !playerIn.isSneaking())
            playerIn.displayGUIChest(inventory);
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        CommonUtil.addTooltip(stack, tooltip);
    }

    public class PouchInventory implements IInventory {
        private String inventoryTitle;
        private final int slotsCount;
        private final ItemStack[] inventoryContents;
        private List<IInventoryChangedListener> changeListeners;
        private boolean hasCustomName;

        public PouchInventory(String title, boolean customName, int slotCount)
        {
            this.inventoryTitle = title;
            this.hasCustomName = customName;
            this.slotsCount = slotCount;
            this.inventoryContents = new ItemStack[slotCount];
        }

        /**
         * Add a listener that will be notified when any item in this inventory is modified.
         */
        public void addInventoryChangeListener(IInventoryChangedListener listener)
        {
            if (this.changeListeners == null)
            {
                this.changeListeners = Lists.<IInventoryChangedListener>newArrayList();
            }

            this.changeListeners.add(listener);
        }

        /**
         * removes the specified IInvBasic from receiving further change notices
         */
        public void removeInventoryChangeListener(IInventoryChangedListener listener)
        {
            this.changeListeners.remove(listener);
        }

        /**
         * Returns the stack in the given slot.
         */
        @javax.annotation.Nullable
        public ItemStack getStackInSlot(int index)
        {
            return index >= 0 && index < this.inventoryContents.length ? this.inventoryContents[index] : null;
        }

        /**
         * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
         */
        @javax.annotation.Nullable
        public ItemStack decrStackSize(int index, int count)
        {
            ItemStack itemstack = ItemStackHelper.getAndSplit(this.inventoryContents, index, count);

            if (itemstack != null)
            {
                this.markDirty();
            }

            return itemstack;
        }

        @javax.annotation.Nullable
        public ItemStack addItem(ItemStack stack)
        {
            ItemStack itemstack = stack.copy();

            for (int i = 0; i < this.slotsCount; ++i)
            {
                ItemStack itemstack1 = this.getStackInSlot(i);

                if (itemstack1 == null && isItemValidForSlot(i, itemstack))
                {
                    this.setInventorySlotContents(i, itemstack);
                    this.markDirty();
                    return null;
                }

                if (ItemStack.areItemsEqual(itemstack1, itemstack))
                {
                    int j = Math.min(this.getInventoryStackLimit(), itemstack1.getMaxStackSize());
                    int k = Math.min(itemstack.stackSize, j - itemstack1.stackSize);

                    if (k > 0)
                    {
                        itemstack1.stackSize += k;
                        itemstack.stackSize -= k;

                        if (itemstack.stackSize <= 0)
                        {
                            this.markDirty();
                            return null;
                        }
                    }
                }
            }

            if (itemstack.stackSize != stack.stackSize)
            {
                this.markDirty();
            }

            return itemstack;
        }

        /**
         * Removes a stack from the given slot and returns it.
         */
        @javax.annotation.Nullable
        public ItemStack removeStackFromSlot(int index)
        {
            if (this.inventoryContents[index] != null)
            {
                ItemStack itemstack = this.inventoryContents[index];
                this.inventoryContents[index] = null;
                return itemstack;
            }
            else
            {
                return null;
            }
        }

        /**
         * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
         */
        public void setInventorySlotContents(int index, @javax.annotation.Nullable ItemStack stack) {
            if(isItemValidForSlot(index, stack)) {
                this.inventoryContents[index] = stack;

                if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
                    stack.stackSize = this.getInventoryStackLimit();
                }

                this.markDirty();
            }
        }

        /**
         * Returns the number of slots in the inventory.
         */
        public int getSizeInventory()
        {
            return this.slotsCount;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return this.inventoryTitle;
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return this.hasCustomName;
        }

        /**
         * Sets the name of this inventory. This is displayed to the client on opening.
         */
        public void setCustomName(String inventoryTitleIn)
        {
            this.hasCustomName = true;
            this.inventoryTitle = inventoryTitleIn;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return (ITextComponent)(this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
        }

        /**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
         */
        public int getInventoryStackLimit()
        {
            return 64;
        }

        /**
         * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
         * hasn't changed and skip it.
         */
        public void markDirty() {}

        /**
         * Do not make give this method the name canInteractWith because it clashes with Container
         */
        public boolean isUseableByPlayer(EntityPlayer player)
        {
            return true;
        }

        public void openInventory(EntityPlayer player)
        {
        }

        public void closeInventory(EntityPlayer player)
        {
        }

        /**
         * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
         */
        public boolean isItemValidForSlot(int index, ItemStack stack) {
            if(stack.getItem() instanceof ItemMHConsumable ||
                    stack.getItem() instanceof ItemMHDrink ||
                    stack.getItem() instanceof ItemMHGlutton ||
                    stack.getItem() instanceof ItemMHResource) {
                return true;
            }else if(stack.getItem() instanceof ItemBlock) {
                if(((ItemBlock) stack.getItem()).getBlock() instanceof BlockBbq ||
                        ((ItemBlock) stack.getItem()).getBlock() instanceof BlockNatural ||
                        ((ItemBlock) stack.getItem()).getBlock() instanceof BlockOre ||
                        ((ItemBlock) stack.getItem()).getBlock() instanceof BlockResource) {
                    return true;
                }
            }
            return false;
        }

        public int getField(int id)
        {
            return 0;
        }

        public void setField(int id, int value)
        {
        }

        public int getFieldCount()
        {
            return 0;
        }

        public void clear()
        {
            for (int i = 0; i < this.inventoryContents.length; ++i)
            {
                this.inventoryContents[i] = null;
            }
        }
    }
}
