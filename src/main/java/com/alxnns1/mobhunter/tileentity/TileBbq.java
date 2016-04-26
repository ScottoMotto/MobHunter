package com.alxnns1.mobhunter.tileentity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by Mark on 26/04/2016.
 */
public class TileBbq extends TileEntity implements ITickable
{
    private int cookTime = 0;
    private int RARE_TIME = 120; //6 secs
    private int DONE_TIME = 180; //9 secs
    private int BURN_TIME = 200; //10 secs
    private boolean isCooking = false;


    public TileBbq() {}

    /**
     * If not already cooking, will start the cooking of a piece of raw meat.
     * @return If a new cooking process has started.
     */
    public boolean putRawMeat()
    {
        if(!isCooking)
            isCooking = true;
        return isCooking;
    }

    /**
     * Gets the meat at the current cooking time.
     * This is ONLY used to see the item. Use retrieveItem() to take the item out.
     * @return
     */
    public Item getMeat()
    {
        //If not cooking, then return null
        if(!isCooking)
            return null;
        //If cooking, then return relevant item
        if(cookTime < RARE_TIME)
            return MHItems.itemRawMeat;
        else if(cookTime < DONE_TIME)
            return MHItems.itemRareSteak;
        else if(cookTime < BURN_TIME)
            return MHItems.itemDoneSteak;
        else
            return MHItems.itemBurntMeat;
    }

    /**
     * Gets the meat from the bbq at whatever stage of cooking it's at.
     * @return
     */
    public Item retrieveItem()
    {
        isCooking = false;
        cookTime = 0;
        return getMeat();
    }

    public void readFromNBT(NBTTagCompound tag)
    {

    }

    public void writeToNBT(NBTTagCompound tag)
    {

    }

    /**
     * Use this to send data about the block. In this case, the NBTTagCompound.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(pos, 0, nbt);
    }

    /**
     * Use this to update the block when a packet is received.
     */
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.S35PacketUpdateTileEntity pkt)
    {
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void update()
    {
        if(isCooking)
            cookTime++;
    }
}
