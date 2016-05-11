package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.block.upgrading.ContainerWeaponUpgrade;
import com.alxnns1.mobhunter.init.MHBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

        //Server side - returns instance of the container
        if(block == MHBlocks.blockWeaponUpgrade)
            return new ContainerWeaponUpgrade(player.inventory, world, x, y, z);

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

        //Client side - returns instance of the gui
        if(block == MHBlocks.blockWeaponUpgrade)
            return new GuiWeaponUpgrade(player.inventory, world, x, y, z);

        return null;
    }
}