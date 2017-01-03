package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.EntitySpit;
import com.alxnns1.mobhunter.entity.RenderSpit;
import com.alxnns1.mobhunter.entity.monsters.*;
import com.alxnns1.mobhunter.entity.monsters.render.*;
import com.alxnns1.mobhunter.reference.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 04/05/2016.
 */
public class MHEntities
{
    private static int modEntityID = 0;

    private static void registerEntity(Class<? extends Entity> entityClass, String name)
    {
        EntityRegistry.registerModEntity(entityClass, name, ++modEntityID, MobHunter.instance, 64, 1, false);
    }

    private static void registerMobWithEgg(Class<? extends Entity> entityClass, String name, int eggColour, int eggSpotColour)
    {
        EntityRegistry.registerModEntity(entityClass, name, ++modEntityID, MobHunter.instance, 64, 1, false, eggColour, eggSpotColour);
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, BiomeDictionary.Type[] biomeTypes)
    {
        addSpawn(entityClass, rarity, 3, 5, biomeTypes);
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, int min, int max, BiomeDictionary.Type[] biomeTypes)
    {
        for(BiomeDictionary.Type biome : biomeTypes)
            EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(biome));
    }

    private static <T extends Entity> void registerRender(Class<T> entityClass, IRenderFactory<? super T> renderFactory)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }

    public static void init(boolean isClientSide)
    {
        registerMobWithEgg(EntityAptonoth.class, "Aptonoth", 0x7f6d59, 0x382c1e);
        addSpawn(EntityAptonoth.class, Config.aptonothSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityAltaroth.class, "Altaroth", 0x8fbf60, 0xbfbf60);
        addSpawn(EntityAltaroth.class, Config.altarothSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityPopo.class, "Popo", 0x402a00, 0x403400);
        addSpawn(EntityPopo.class, Config.popoSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.MOUNTAIN});
        registerMobWithEgg(EntityKelbi.class, "Kelbi", 0x20402b, 0xbfbf8f);
        addSpawn(EntityKelbi.class, Config.kelbiSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityGargwa.class, "Gargwa", 0x804000, 0x0000ff);
        addSpawn(EntityGargwa.class, Config.gargwaSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS});
        registerMobWithEgg(EntityJaggi.class, "Jaggi", 0xd56a00, 0xbf80ff);
        registerMobWithEgg(EntityJaggia.class, "Jaggia", 0xff8000, 0x9f40ff);
        addSpawn(EntityJaggi.class, Config.jaggiSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityVelociprey.class, "Velociprey", 0x0080ff, 0x402000);
        addSpawn(EntityVelociprey.class, Config.velocipreySpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.WASTELAND});
        registerMobWithEgg(EntityGiaprey.class, "Giaprey", 0x9fbfdf, 0x476078);
        addSpawn(EntityGiaprey.class, Config.giapreySpawnChance, new BiomeDictionary.Type[]{
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SNOWY});
        registerMobWithEgg(EntityGenprey.class, "Genprey", 0x408040, 0x806040);
        addSpawn(EntityGenprey.class, Config.genpreySpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND});
        registerMobWithEgg(EntityIoprey.class, "Ioprey", 0xdf2020, 0x0a0a0a);
        addSpawn(EntityIoprey.class, Config.iopreySpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.SWAMP});

        registerMobWithEgg(EntityGreatJaggi.class, "GreatJaggi", 0xe2aa72, 0x9f40ff);
        addSpawn(EntityGreatJaggi.class, Config.greatJaggiSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityVelocidrome.class, "Velocidrome", 0x0080ff, 0x402000);
        addSpawn(EntityVelocidrome.class, Config.velocidromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.WASTELAND});
        /*
        registerMobWithEgg(EntityGiadrome.class, "Giadrome", 0x9fbfdf, 0x476078);
        addSpawn(EntityGiadrome.class, Config.giadromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SNOWY});
        */
        registerMobWithEgg(EntityGendrome.class, "Gendrome", 0x408040, 0x806040);
        addSpawn(EntityGendrome.class, Config.gendromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND});
        /*
        registerMobWithEgg(EntityIondrome.class, "Iodrome", 0xdf2020, 0x0a0a0a);
        addSpawn(EntityIodrome.class, Config.iodromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.SWAMP});
        */

        registerEntity(EntitySpit.class, "Spit");

        if(isClientSide)
            regClientStuff();
    }

    @SideOnly(Side.CLIENT)
    private static void regClientStuff()
    {
        registerRender(EntityAptonoth.class, RenderAptonoth.FACTORY);
        registerRender(EntityAltaroth.class, RenderAltaroth.FACTORY);
        registerRender(EntityPopo.class, RenderPopo.FACTORY);
        registerRender(EntityKelbi.class, RenderKelbi.FACTORY);
        registerRender(EntityGargwa.class, RenderGargwa.FACTORY);
        registerRender(EntityJaggi.class, RenderJaggi.FACTORY);
        registerRender(EntityJaggia.class, RenderJaggia.FACTORY);
        registerRender(EntityVelociprey.class, RenderVelociprey.FACTORY);
        registerRender(EntityGiaprey.class, RenderGiaprey.FACTORY);
        registerRender(EntityGenprey.class, RenderGenprey.FACTORY);
        registerRender(EntityIoprey.class, RenderIoprey.FACTORY);

        registerRender(EntityGreatJaggi.class, RenderGreatJaggi.FACTORY);
        registerRender(EntityVelocidrome.class, RenderVelocidrome.FACTORY);
        //registerRender(EntityGiadrome.class, RenderGiadrome.FACTORY);
        registerRender(EntityGendrome.class, RenderGendrome.FACTORY);
        //registerRender(EntityIodrome.class, RenderIodrome.FACTORY);

        registerRender(EntitySpit.class, RenderSpit.FACTORY);
    }
}
