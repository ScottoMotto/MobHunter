package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.quest.EnumQuestType;
import com.alxnns1.mobhunter.quest.MHQuest;
import com.alxnns1.mobhunter.reference.MetaRef;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuests
{
    private static List<MHQuest> QUESTS = new ArrayList<MHQuest>();

    public static MHQuest getQuest(String name)
    {
        for(MHQuest q : QUESTS)
            if(q.getUnlocName().equals(name))
                return q;
        return null;
    }

    public static void regQuest(MHQuest quest)
    {
        for(MHQuest q : QUESTS)
            if(q.isEqual(quest))
                throw new RuntimeException("A Quest with the name " + quest.getUnlocName() + " already exists!");
        QUESTS.add(quest);
    }

    public static void init()
    {
        //Register quests

        regQuest(new MHQuest(EnumQuestType.CRAFTING, "testCraft", 1, 0, 140).setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "megaPotion")));
        regQuest(new MHQuest(EnumQuestType.GATHERING, "testGather", 10, 0, 140).setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5)));
        regQuest(new MHQuest(EnumQuestType.HUNTING, "testHunt", 100, 0, 140).setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.MISC, "steelEgg")));
    }
}
