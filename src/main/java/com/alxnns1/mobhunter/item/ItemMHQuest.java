package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.handler.EnumGuiID;
import com.alxnns1.mobhunter.capability.quest.MHQuestObject;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemMHQuest extends ItemMHBasic
{
    public ItemMHQuest()
    {
        super(Names.Items.QUEST);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(worldIn.isRemote)
        {
            if(playerIn.getCapability(MHCapabilities.QUESTS, null).getCurrentQuest() != null)
                CommonUtil.openGui(playerIn, worldIn, EnumGuiID.QUEST);
            else
                playerIn.sendMessage(new TextComponentString("No Quest Accepted."));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        //Show quest name on tooltip
        MHQuestObject quest = playerIn.getCapability(MHCapabilities.QUESTS, null).getCurrentQuest();
        String questName = quest == null ? "No quest accepted" : quest.getQuest().getLocalName();
        tooltip.add("Current quest:");
        tooltip.add(questName);
    }
}
