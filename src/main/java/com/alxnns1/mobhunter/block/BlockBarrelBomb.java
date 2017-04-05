package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.EntityBarrelBomb;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Mark on 05/04/2017.
 */
public class BlockBarrelBomb extends Block
{
    public static final PropertyEnum<EnumBarrel> BARREL = PropertyEnum.create("barrel", EnumBarrel.class);

    public BlockBarrelBomb()
    {
        super(Material.TNT);
        setUnlocalizedName(Names.Blocks.BARREL_BOMB);
        setRegistryName(Names.Blocks.BARREL_BOMB);
        setCreativeTab(MobHunter.MHBLOCK_TAB);
        setHardness(3.0F);
        setResistance(5.0F);
        setDefaultState(blockState.getBaseState().withProperty(BARREL, EnumBarrel.LARGE));
    }

    /**
     * Spawns the primed barrel bomb with a default fuse time
     */
    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter)
    {
        explode(worldIn, pos, state, igniter, -1);
    }

    /**
     * Spawns the primed barrel bomb
     */
    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter, int fuse)
    {
        if(!worldIn.isRemote)
        {
            EntityBarrelBomb entityBomb = new EntityBarrelBomb(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), igniter);
            if(fuse >= 0) entityBomb.setFuse(fuse);
            if(state.getValue(BARREL) == EnumBarrel.BOUNCING) entityBomb.setBounce();
            worldIn.spawnEntity(entityBomb);
            worldIn.playSound(null, entityBomb.posX, entityBomb.posY, entityBomb.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            worldIn.setBlockToAir(pos);
        }
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        if(worldIn.isBlockPowered(pos))
            explode(worldIn, pos, state, null);

        //If small or bouncing bomb, then start exploding
        switch(state.getValue(BARREL))
        {
            case SMALL:
            case BOUNCING:
                explode(worldIn, pos, state, null);
                break;
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        super.neighborChanged(state, worldIn, pos, blockIn);
        if(worldIn.isBlockPowered(pos))
            explode(worldIn, pos, state, null);
    }

    /**
     * Called when a player destroys this Block
     */
    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        //explode(worldIn, pos, state, null);
    }

    /**
     * Called when this Block is destroyed by an Explosion
     */
    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
        explode(worldIn, pos, worldIn.getBlockState(pos), null, 20);
    }

    /**
     * Called When an Entity Collided with the Block
     */
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (!worldIn.isRemote)
        {
            if(entityIn instanceof EntityArrow)
            {
                //If hit by an arrow, explode
                EntityArrow arrow = (EntityArrow)entityIn;
                explode(worldIn, pos, state, arrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)arrow.shootingEntity : null, 0);
            }
            if(entityIn instanceof EntityLivingBase)
            {
                //If hit by a fast moving entity, explode
                EntityLivingBase living = (EntityLivingBase) entityIn;
                double velocity = Math.sqrt(Math.pow(living.motionX, 2) + Math.pow(living.motionY, 2) + Math.pow(living.motionZ, 2));
                if(velocity >= 6d) explode(worldIn, pos, state, living, 0);
            }
        }
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(BARREL, EnumBarrel.values()[meta]);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(BARREL).ordinal();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BARREL});
    }

    /**
     * Returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for(EnumBarrel barrelType : EnumBarrel.values())
            list.add(new ItemStack(itemIn, 1, barrelType.ordinal()));
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return state.getValue(BARREL).ordinal();
    }
}
