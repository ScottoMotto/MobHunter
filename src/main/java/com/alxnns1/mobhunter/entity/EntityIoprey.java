package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.potion.PotionEffectParalyse;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Alex on 10/06/2016.
 */
public class EntityIoprey extends EntityMHBirdWyvern {
    public EntityIoprey(World worldIn)
    {
        super(worldIn);
        this.setSize(1.5F, 1.8125F);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMHHerbivore.class, true));
    }

    @Override
    public float getEyeHeight()
    {
        return 2.5625F;
    }

    protected Item getDropItem()
    {
        return MHItems.itemRawMeat;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.BIRD_WYVERN_FANG));
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<40){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_FANG));
                }else if(i<69){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_SCALE));
                }else if(i<92){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_HIDE));
                }else{
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
                }
            }
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        setBaseHealth(15);
        setBaseAttack(3);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
        /*
        double rand = Math.random();
        if(rand<0.1){
            EntityIodrome drome = new EntityIodrome(worldObj);
            worldObj.spawnEntityInWorld(drome);
            drome.setPosition(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ());
            this.setDead();
        }
        */
        return super.onInitialSpawn(difficulty, livingdata);
    }

}