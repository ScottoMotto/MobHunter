package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 11/05/2016.
 */
public class BlockBone extends BlockNatural
{
    public BlockBone(){
        super(Names.Blocks.BONE, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
    }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.11303959131545338441890166028097)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"));
        else if (chance < 0.36528735632183908045977011494252)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone"));
        else if (chance < 0.81)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull"));
        else if (chance < 0.91)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.13666666666666666666666666666667)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"));
        else if (chance < 0.44)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone"));
        else if (chance < 0.81)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull"));
        else if (chance < 0.91)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.17652173913043478260869565217392)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"));
        else if (chance < 0.45086956521739130434782608695652)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone"));
        else if (chance < 0.81)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull"));
        else if (chance < 0.91)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.14319848293299620733249051833123)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"));
        else if (chance < 0.26490518331226295828065739570165)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneM"));
        else if (chance < 0.65968394437420986093552465233883)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone"));
        else if (chance < 0.83)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull"));
        else if (chance < 0.88)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.25305084745762711864406779661017)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"));
        else if (chance < 0.65525423728813559322033898305083)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone"));
        else if (chance < 0.81)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull"));
        else if (chance < 0.91)                                 drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung"));
        return drops;
    }
}
