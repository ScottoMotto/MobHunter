package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.*;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHItems
{
    public static List<Item> ITEMS = new ArrayList<Item>();
    //This list will automatically get added to the fishable fish loot table
    public static Map<Item, Integer> FISHABLE = new HashMap<Item, Integer>();

    public static void regItem(Item item)
    {
        GameRegistry.register(item);
        ITEMS.add(item);
    }

    public static void regFish(Item item, int fishingChance)
    {
        regItem(item);
        FISHABLE.put(item, fishingChance);
    }

    public static ItemMHDrink
            itemDrink;
    public static ItemMHConsumable
            itemPlant,
            itemMushroom,
            itemBerry,
            itemBug;
    public static ItemMHResource
            itemMisc,
            itemTool,
            itemMiscDrop,
            itemHerbivoreDrop,
            itemLynianDrop,
            itemNeopteranDrop,
            itemPiscineWyvernDrop,
            itemBirdWyvernDrop,
            itemCarapaceonDrop,
            itemFangedBeastDrop,
            itemAmphibianDrop,
            itemSnakeWyvernDrop,
            itemBruteWyvernDrop,
            itemTrueWyvernDrop,
            itemPseudoWyvernDrop,
            itemFangedWyvernDrop,
            itemZenithWyvernDrop,
            itemLeviathonDrop,
            itemElderDragonDrop,
            itemOre,
            itemIcon;
    
    public static ItemArmor.ArmorMaterial derringArmourMaterial = EnumHelper.addArmorMaterial("Derring", Reference.MOD_ID + ":derring", 5, new int[]{1, 3, 2, 1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial hunterArmourMaterial = EnumHelper.addArmorMaterial("Hunter's", Reference.MOD_ID + ":hunter", 15, new int[]{2, 3, 3, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 17, new int[]{2, 5, 4, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial alloyArmourMaterial = EnumHelper.addArmorMaterial("Alloy", Reference.MOD_ID + ":alloy", 19, new int[]{2, 6, 5, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
    public static ItemArmor.ArmorMaterial jaggiArmourMaterial = EnumHelper.addArmorMaterial("Jaggi", Reference.MOD_ID + ":jaggi", 21, new int[]{3, 6, 5, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
    public static ItemArmor.ArmorMaterial velocipreyArmourMaterial = EnumHelper.addArmorMaterial("Velociprey", Reference.MOD_ID + ":velociprey", 23, new int[]{3, 7, 6, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
    public static ItemArmor.ArmorMaterial genpreyArmourMaterial = EnumHelper.addArmorMaterial("Genprey", Reference.MOD_ID + ":genprey", 23, new int[]{3, 7, 6, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);

    public static ItemArmor
            armourDerringHelmet, armourDerringChestplate, armourDerringLeggings, armourDerringBoots,
            armourHunterHelmet, armourHunterChestplate, armourHunterLeggings, armourHunterBoots,
            armourBoneHelmet, armourBoneChestplate, armourBoneLeggings, armourBoneBoots,
            armourAlloyHelmet, armourAlloyChestplate, armourAlloyLeggings, armourAlloyBoots,
            armourJaggiHelmet, armourJaggiChestplate, armourJaggiLeggings, armourJaggiBoots,
            armourVelocipreyHelmet, armourVelocipreyChestplate, armourVelocipreyLeggings, armourVelocipreyBoots,
            armourGenpreyHelmet, armourGenpreyChestplate, armourGenpreyLeggings, armourGenpreyBoots;

    public static ItemMHPouch
            itemFieldPouch;

    public static ItemMHResource
            itemRawMeat,
            itemWhetfish;

    public static ItemMHPickaxe
            itemMachalitePickaxe,
            itemDragonitePickaxe,
            itemGossamitePickaxe;

    public static ItemMHConsumable
            itemRareSteak,
            itemDoneSteak,
            itemGourmetSteak,
            itemBurntMeat,
            itemSushifish;

    public static ItemMHGlutton
            itemGluttonTuna,
            itemGastronomeTuna;

    public static ItemMHSword
            weaponHuntersKnife,
            weaponSoldiersDagger,
            weaponCommandersDagger,
            weaponDeadlyKnife,
            weaponDeadlyKnifePlus,
            weaponSerpentBite,
            weaponSerpentBitePlus,
            weaponDeadlock,
            weaponVelocidromeBite,
            weaponVelocidromeBitePlus,
            weaponVelocidromeFang,
            weaponVelocidromeFangPlus,
            weaponDromeRushDagger,
            weaponGreatStabberdag,
            weaponSnakeBite,
            weaponSnakeBitePlus,
            weaponDeathlyCold,
            weaponViperBite,
            weaponViperBitePlus,
            weaponDeathprize,
            weaponGendromeBite,
            weaponGendromeBitePlus,
            weaponGendromeFang,
            weaponGendromeFangPlus,
            weaponDromeToxinDagger,
            weaponGreatParadag,
            weaponHydraBite,
            weaponHydraBitePlus,
            weaponDeadlyPoison,
            weaponHuntersKnifePlus,
            weaponHuntersDagger,
            weaponAssassinsDagger,
            weaponBoneKris,
            weaponBoneKrisPlus,
            weaponChiefKris,
            weaponRottonSword,
            weaponPlaguedSword,
            weaponInfestedSword,
            weaponSkeletalSword,
            weaponSkeletalSwordPlus,
            weaponWitheredSword,
            weaponWitheredSwordPlus,
            weaponNecrosisBlade,
            weaponMandiblade,
            weaponMandibladePlus,
            weaponStingingMandiblade,
            weaponPoisonStingblade,
            weaponFearSword,
            weaponTerrorSword,
            weaponDreadSword,
            weaponXenoblade,
            weaponXenobladePlus,
            weaponAstralSword,
            weaponAstralEndsword,
            weaponSlimySword,
            weaponSlimySwordPlus,
            weaponCrystalizedSlimeblade,
            weaponMagmaticSlimeblade,
            weaponBlazingSword,
            weaponBlazingTempest,
            weaponBlazingInferno;

    public static ItemMHBow weaponTestBow;

    public static ItemMHQuest itemQuest;
    public static ItemMHQuestList itemQuestList;

    public static ItemMHDebug itemDebug;

    /**
     * Registers the items
     */
    public static void regItems()
    {
        regItem(itemDrink = new ItemMHDrink("drink",
                Names.Items.POTION,
                Names.Items.MEGA_POTION,
                Names.Items.NUTRIENTS,
                Names.Items.MEGA_NUTRIENTS,
                Names.Items.ANTIDOTE,
                Names.Items.IMMUNIZER,
                Names.Items.DASH_JUICE,
                Names.Items.MEGA_DASH_JUICE,
                Names.Items.DEMONDRUG,
                Names.Items.MEGA_DEMONDRUG,
                Names.Items.MIGHT_PILL,
                Names.Items.ARMOURSKIN,
                Names.Items.MEGA_ARMOURSKIN)
                .addToMetaRef(MetaRef.EnumItemType.DRINK));
        regItem(itemMisc = new ItemMHResource("misc",
                Names.Items.CATALYST,
                Names.Items.TRANQUILIZER,
                Names.Items.BOMB_CASING,
                Names.Items.DUNG,
                Names.Items.TERRITORIAL_DUNG,
                Names.Items.TERRITORIAL_DUNG_PLUS,
                Names.Items.NET,
                Names.Items.TRAP_TOOL,
                Names.Items.STEEL_EGG)
                .addToMetaRef(MetaRef.EnumItemType.MISC));
        regItem(itemTool = new ItemMHResource("tool",
                Names.Items.CLEANSER,
                Names.Items.DEODORANT,
                Names.Items.DISPOSABLE_EARPLUGS,
                Names.Items.POWERCHARM,
                Names.Items.POWERTALON,
                Names.Items.ARMOURCHARM,
                Names.Items.ARMOURTALON,
                Names.Items.BOOMERANG,
                Names.Items.THROWING_KNIFE,
                Names.Items.POISON_KNIFE,
                Names.Items.SLEEP_KNIFE,
                Names.Items.PARALYSIS_KNIFE,
                Names.Items.TRANQUILIZER_KNIFE,
                Names.Items.PAINTBALL,
                Names.Items.FLASH_BOMB,
                Names.Items.SONIC_BOMB,
                Names.Items.DUNG_BOMB,
                Names.Items.SMOKE_BOMB,
                Names.Items.POISON_SMOKE_BOMB,
                Names.Items.FARCASTER,
                Names.Items.PORTABLE_STEAM_BOMB,
                Names.Items.TRANQUILIZER_BOMB,
                Names.Items.WHETSTONE,
                Names.Items.MINI_WHETSTONE)
                .addToMetaRef(MetaRef.EnumItemType.TOOL));
        regItem(itemPlant = new ItemMHConsumable("plant",
                Names.Items.HONEY,
                Names.Items.HERB,
                Names.Items.ANTIDOTE_HERB,
                Names.Items.FIRE_HERB,
                Names.Items.IVY,
                Names.Items.SLEEP_HERB,
                Names.Items.SAP_PLANT,
                Names.Items.FELVINE,
                Names.Items.GLOAMGRASS_ROOT,
                Names.Items.GLOAMGRASS_BUD,
                Names.Items.HOT_PEPPER)
                .addToMetaRef(MetaRef.EnumItemType.PLANT));
        regItem(itemMushroom = new ItemMHConsumable("mushroom",
                Names.Items.BLUE_MUSHROOM,
                Names.Items.NITROSHROOM,
                Names.Items.PARASHROOM,
                Names.Items.TOADSTOOL,
                Names.Items.EXCITESHROOM,
                Names.Items.MOPESHROOM,
                Names.Items.DRAGON_TOADSTOOL)
                .addToMetaRef(MetaRef.EnumItemType.MUSHROOM));
        regItem(itemBerry = new ItemMHConsumable("berry",
                Names.Items.HUSKBERRY,
                Names.Items.PAINTBERRY,
                Names.Items.MIGHT_SEED,
                Names.Items.ADAMANT_SEED,
                Names.Items.NULBERRY,
                Names.Items.DRAGONFELL_BERRY,
                Names.Items.SCATTERNUT,
                Names.Items.NEEDLEBERRY,
                Names.Items.LATCHBERRY,
                Names.Items.BOMBERRY)
                .addToMetaRef(MetaRef.EnumItemType.BERRY));
        regItem(itemBug = new ItemMHConsumable("bug",
                Names.Items.INSECT_HUSK,
                Names.Items.STINKHOPPER,
                Names.Items.SNAKEBEE_LARVA,
                Names.Items.GODBUG,
                Names.Items.BITTERBUG,
                Names.Items.FLASHBUG,
                Names.Items.THUNDERBUG,
                Names.Items.GLUEGLOPPER,
                Names.Items.KILLER_BEETLE,
                Names.Items.HERCUDROME,
                Names.Items.FULGURBUG,
                Names.Items.RARE_SCARAB)
                .addToMetaRef(MetaRef.EnumItemType.BUG));
        regItem(itemOre = new ItemMHResource("ore",
                Names.Items.EARTH_CRYSTAL,
                Names.Items.MACHALITE_INGOT,
                Names.Items.DRAGONITE_INGOT,
                Names.Items.LIGHT_CRYSTAL,
                Names.Items.ICE_CRYSTAL,
                Names.Items.FIRESTONE,
                Names.Items.GOSSAMITE_INGOT,
                Names.Items.HEAVENLY_CRYSTAL,
                Names.Items.METEOR_CRYSTAL,
                Names.Items.CARBALITE_INGOT,
                Names.Items.NOVACRYSTAL,
                Names.Items.FUCIUM_INGOT,
                Names.Items.ELTALITE_INGOT,
                Names.Items.MELDSPAR_INGOT)
                .addToMetaRef(MetaRef.EnumItemType.ORE));
        regItem(itemMiscDrop = new ItemMHResource("miscDrop",
                Names.Items.BONE_HUSK,
                Names.Items.MONSTER_BONE_S,
                Names.Items.MONSTER_BONE_M,
                Names.Items.MONSTER_BONE_L,
                Names.Items.MYSTERY_BONE,
                Names.Items.UNKNOWN_SKULL,
                Names.Items.MONSTER_BONE_PLUS,
                Names.Items.MONSTER_KEENBONE,
                Names.Items.MONSTER_HARDBONE,
                Names.Items.MONSTER_SLOGBONE,
                Names.Items.BRUTE_BONE,
                Names.Items.JUMBO_BONE,
                Names.Items.STOUTBONE,
                Names.Items.MASSIVE_BONE,
                Names.Items.WYVERN_FANG,
                Names.Items.WYVERN_CLAW,
                Names.Items.WYVERN_GEM,
                Names.Items.LARGE_WYVERN_GEM,
                Names.Items.SCREAMER_SAC,
                Names.Items.POISON_SAC,
                Names.Items.TOXIN_SAC,
                Names.Items.DEADLY_POISON_SAC,
                Names.Items.PARALYSIS_SAC,
                Names.Items.OMNIPLEGIA_SAC,
                Names.Items.SLEEP_SAC,
                Names.Items.COMA_SAC,
                Names.Items.FLAME_SAC,
                Names.Items.INFERNO_SAC,
                Names.Items.CONFLAGRANT_SAC,
                Names.Items.ELECTRO_SAC,
                Names.Items.THUNDER_SAC,
                Names.Items.LIGHTNING_SAC,
                Names.Items.FROST_SAC,
                Names.Items.FREEZER_SAC,
                Names.Items.CRYO_SAC,
                Names.Items.AQUA_SAC,
                Names.Items.TORRENT_SAC,
                Names.Items.FLOOD_SAC,
                Names.Items.DASH_EXTRACT,
                Names.Items.PALE_EXTRACT,
                Names.Items.WYVERN_EGG,
                Names.Items.WYVERN_TEAR,
                Names.Items.LARGE_WYVERN_TEAR,
                Names.Items.WYVERN_SCALP,
                Names.Items.MONSTER_FLUID)
                .addToMetaRef(MetaRef.EnumItemType.MISC_DROP));
        regItem(itemHerbivoreDrop = new ItemMHResource("herbivoreDrop",
                Names.Items.GARGWA_FEATHER,
                Names.Items.GARGWA_EGG,
                Names.Items.GOLD_GARGWA_EGG,
                Names.Items.GARGWA_GUANO,
                Names.Items.KELBI_HORN,
                Names.Items.BLUE_KELBI_HORN,
                Names.Items.WARM_PELT)
                .addToMetaRef(MetaRef.EnumItemType.HERBIVORE_DROP));
        regItem(itemNeopteranDrop = new ItemMHResource("neopteranDrop",
                Names.Items.BNAHABRA_SHELL,
                Names.Items.BNAHABRA_CARAPACE,
                Names.Items.BNAHABRA_WING,
                Names.Items.BNAHABRA_RAZORWING,
                Names.Items.ALTAROTH_JAW,
                Names.Items.ALTAROTH_STOMACH)
                .addToMetaRef(MetaRef.EnumItemType.NEOPTERAN_DROP));
        regItem(itemBirdWyvernDrop = new ItemMHResource("birdWyvernDrop",
                Names.Items.BIRD_WYVERN_FANG,
                Names.Items.TOUGH_BIRD_WYVERN_HIDE,
                Names.Items.AVIAN_FINEBONE,
                Names.Items.AVIAN_STOUTBONE,
                Names.Items.BIRD_WYVERN_GEM,
                Names.Items.FEY_WYVERN_GEM,
                Names.Items.JAGGI_SCALE,
                Names.Items.JAGGI_SCALE_PLUS,
                Names.Items.JAGGI_HIDE,
                Names.Items.JAGGI_FANG,
                Names.Items.GREAT_JAGGI_HIDE,
                Names.Items.GREAT_JAGGI_HIDE_PLUS,
                Names.Items.GREAT_JAGGI_CLAW,
                Names.Items.GREAT_JAGGI_CLAW_PLUS,
                Names.Items.KINGS_FRILL,
                Names.Items.GREAT_JAGGI_HEAD,
                Names.Items.VELOCIPREY_SCALE,
                Names.Items.VELOCIPREY_SCALE_PLUS,
                Names.Items.VELOCIPREY_HIDE,
                Names.Items.VELOCIPREY_HIDE_PLUS,
                Names.Items.VELOCIPREY_FANG,
                Names.Items.VELOCIDROME_HIDE,
                Names.Items.VELOCIDROME_CLAW,
                Names.Items.VELOCIDROME_CLAW_PLUS,
                Names.Items.VELOCIDROME_HARDCLAW,
                Names.Items.VELOCIDROME_HEAD,
                Names.Items.GIAPREY_SCALE,
                Names.Items.GIAPREY_SCALE_PLUS,
                Names.Items.GIAPREY_HIDE,
                Names.Items.GIAPREY_HIDE_PLUS,
                Names.Items.GIAPREY_FANG,
                Names.Items.GIADROME_HIDE,
                Names.Items.GIADROME_CLAW,
                Names.Items.GIADROME_CLAW_PLUS,
                Names.Items.GIADROME_HARDCLAW,
                Names.Items.GIADROME_HEAD,
                Names.Items.GENPREY_SCALE,
                Names.Items.GENPREY_SCALE_PLUS,
                Names.Items.GENPREY_HIDE,
                Names.Items.GENPREY_HIDE_PLUS,
                Names.Items.GENPREY_FANG,
                Names.Items.GENDROME_HIDE,
                Names.Items.GENDROME_CLAW,
                Names.Items.GENDROME_CLAW_PLUS,
                Names.Items.GENDROME_HARDCLAW,
                Names.Items.GENDROME_HEAD,
                Names.Items.IOPREY_SCALE,
                Names.Items.IOPREY_SCALE_PLUS,
                Names.Items.IOPREY_HIDE,
                Names.Items.IOPREY_HIDE_PLUS,
                Names.Items.IOPREY_FANG)
                .addToMetaRef(MetaRef.EnumItemType.BIRD_DROP));
        regItem(itemFangedBeastDrop = new ItemMHResource("fangedBeastDrop",
                Names.Items.SHARP_FANG)
                .addToMetaRef(MetaRef.EnumItemType.BEAST_DROP));
        regItem(itemIcon = new ItemMHResource("icon", false,
                Names.Items.ICON_GREAT_JAGGI,
                Names.Items.ICON_GREAT_BAGGI,
                Names.Items.ICON_GREAT_WROGGI,
                Names.Items.ICON_GREAT_MACCAO,
                Names.Items.ICON_GENDROME,
                Names.Items.ICON_IODROME,
                Names.Items.ICON_VELOCIDROME,
                Names.Items.ICON_KIRIN)
                .addToMetaRef(MetaRef.EnumItemType.ICON));

        regItem(armourDerringHelmet = new ItemMHArmour(derringArmourMaterial, EntityEquipmentSlot.HEAD,Names.Items.DERRING_HELMET));
        regItem(armourDerringChestplate = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.DERRING_CHESTPLATE));
        regItem(armourDerringLeggings = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.DERRING_LEGGINGS));
        regItem(armourDerringBoots = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.DERRING_BOOTS));

        regItem(armourHunterHelmet = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.HUNTER_HELMET));
        regItem(armourHunterChestplate = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.HUNTER_CHESTPLATE));
        regItem(armourHunterLeggings = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.HUNTER_LEGGINGS));
        regItem(armourHunterBoots = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.HUNTER_BOOTS));

        regItem(armourBoneHelmet = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.BONE_HELMET));
        regItem(armourBoneChestplate = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.BONE_CHESTPLATE));
        regItem(armourBoneLeggings = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.BONE_LEGGINGS));
        regItem(armourBoneBoots = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.BONE_BOOTS));

        regItem(armourAlloyHelmet = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.ALLOY_HELMET));
        regItem(armourAlloyChestplate = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.ALLOY_CHESTPLATE));
        regItem(armourAlloyLeggings = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.ALLOY_LEGGINGS));
        regItem(armourAlloyBoots = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.ALLOY_BOOTS));

        regItem(armourJaggiHelmet = new ItemMHArmour(jaggiArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.JAGGI_HELMET));
        regItem(armourJaggiChestplate = new ItemMHArmour(jaggiArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.JAGGI_CHESTPLATE));
        regItem(armourJaggiLeggings = new ItemMHArmour(jaggiArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.JAGGI_LEGGINGS));
        regItem(armourJaggiBoots = new ItemMHArmour(jaggiArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.JAGGI_BOOTS));

        regItem(armourVelocipreyHelmet = new ItemMHArmour(velocipreyArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.VELOCIPREY_HELMET));
        regItem(armourVelocipreyChestplate = new ItemMHArmour(velocipreyArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.VELOCIPREY_CHESTPLATE));
        regItem(armourVelocipreyLeggings = new ItemMHArmour(velocipreyArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.VELOCIPREY_LEGGINGS));
        regItem(armourVelocipreyBoots = new ItemMHArmour(velocipreyArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.VELOCIPREY_BOOTS));

        regItem(armourGenpreyHelmet = new ItemMHArmour(genpreyArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.GENPREY_HELMET));
        regItem(armourGenpreyChestplate = new ItemMHArmour(genpreyArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.GENPREY_CHESTPLATE));
        regItem(armourGenpreyLeggings = new ItemMHArmour(genpreyArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.GENPREY_LEGGINGS));
        regItem(armourGenpreyBoots = new ItemMHArmour(genpreyArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.GENPREY_BOOTS));

        regItem(itemFieldPouch = new ItemMHPouch());

        regItem(itemMachalitePickaxe = new ItemMHPickaxe(Names.Items.MACHALITE_PICKAXE, 2, 500, 7.0f, 3f));
        regItem(itemDragonitePickaxe = new ItemMHPickaxe(Names.Items.DRAGONITE_PICKAXE, 3, 750, 7.0f, 4f));
        regItem(itemGossamitePickaxe = new ItemMHPickaxe(Names.Items.GOSSAMITE_PICKAXE, 3, 1000, 8.0f, 5f));

        regItem(itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT));
        regItem(itemRareSteak = new ItemMHConsumable(5, 0.4F, true, Names.Items.RARE_STEAK));
        regItem(itemDoneSteak = new ItemMHConsumable(10, 1.0F, true, Names.Items.DONE_STEAK));
        regItem(itemGourmetSteak = new ItemMHConsumable(16, 1.5F, true, Names.Items.GOURMET_STEAK));
        regItem(itemBurntMeat = new ItemMHConsumable(5, 0.3F, true, Names.Items.BURNT_MEAT));

        regFish(itemWhetfish = new ItemMHResource(Names.Items.WHETFISH),53);
        regFish(itemSushifish = new ItemMHConsumable(5, 0.4F, false, Names.Items.SUSHIFISH),46);
        regFish(itemGluttonTuna = new ItemMHGlutton(5, 0.4F, false, Names.Items.GLUTTON_TUNA),56);
        regFish(itemGastronomeTuna = new ItemMHGlutton(10, 1.0F, false, Names.Items.GASTRONOME_TUNA),25);

        regItem(weaponHuntersKnife = new ItemMHSword(Names.Items.HUNTERS_KNIFE, 6f, 140, 280, 400));
        regItem(weaponSoldiersDagger = new ItemMHSword(Names.Items.SOLDIERS_DAGGER, 8f, 100, 160, 420, 500));
        regItem(weaponCommandersDagger = new ItemMHSword(Names.Items.COMMANDERS_DAGGER, 10f, 100, 240, 400, 500));
        regItem(weaponDeadlyKnife = new ItemMHSword(Names.Items.DEADLY_KNIFE, 12f, 150, 250, 370, 620));
        regItem(weaponDeadlyKnifePlus = new ItemMHSword(Names.Items.DEADLY_KNIFE_PLUS, 14f, 170, 270, 400, 750));
        regItem(weaponSerpentBite = new ItemMHSword(Names.Items.SERPENT_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponSerpentBitePlus = new ItemMHSword(Names.Items.SERPENT_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeadlock = new ItemMHSword(Names.Items.DEADLOCK, 20f, 140, 200, 400, 580, 600));
        regItem(weaponVelocidromeBite = new ItemMHSword(Names.Items.VELOCIDROME_BITE, 11f, 220, 400, 500));
        regItem(weaponVelocidromeBitePlus = new ItemMHSword(Names.Items.VELOCIDROME_BITE_PLUS, 13f, 220, 320, 500));
        regItem(weaponVelocidromeFang = new ItemMHSword(Names.Items.VELOCIDROME_FANG, 15f, 150, 250, 550, 620));
        regItem(weaponVelocidromeFangPlus = new ItemMHSword(Names.Items.VELOCIDROME_FANG_PLUS, 17f, 420, 470, 670, 750));
        regItem(weaponDromeRushDagger = new ItemMHSword(Names.Items.DROME_RUSH_DAGGER, 19f, 500, 650, 670, 720, 750));
        regItem(weaponGreatStabberdag = new ItemMHSword(Names.Items.GREAT_STABBERDAG, 21f, 500, 650, 670, 720, 850, 870));
        regItem(weaponSnakeBite = new ItemMHSword(Names.Items.SNAKE_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponSnakeBitePlus = new ItemMHSword(Names.Items.SNAKE_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeathlyCold = new ItemMHSword(Names.Items.DEATHLY_COLD, 20f, 140, 200, 400, 580, 600));
        regItem(weaponHydraBite = new ItemMHSword(Names.Items.HYDRA_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponHydraBitePlus = new ItemMHSword(Names.Items.HYDRA_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeadlyPoison = new ItemMHSword(Names.Items.DEADLY_POISON, 20f, 140, 200, 400, 580, 600));
        regItem(weaponViperBite = new ItemMHSword(Names.Items.VIPER_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponViperBitePlus = new ItemMHSword(Names.Items.VIPER_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeathprize = new ItemMHSword(Names.Items.DEATHPRIZE, 20f, 140, 200, 400, 580, 600));
        regItem(weaponGendromeBite = new ItemMHSword(Names.Items.GENDROME_BITE, 11f, 220, 400, 500));
        regItem(weaponGendromeBitePlus = new ItemMHSword(Names.Items.GENDROME_BITE_PLUS, 13f, 220, 320, 500));
        regItem(weaponGendromeFang = new ItemMHSword(Names.Items.GENDROME_FANG, 15f, 150, 250, 550, 620));
        regItem(weaponGendromeFangPlus = new ItemMHSword(Names.Items.GENDROME_FANG_PLUS, 17f, 420, 470, 670, 750));
        regItem(weaponDromeToxinDagger = new ItemMHSword(Names.Items.DROME_TOXIN_DAGGER, 19f, 500, 650, 670, 720, 750));
        regItem(weaponGreatParadag = new ItemMHSword(Names.Items.GREAT_PARADAG, 21f, 500, 650, 670, 720, 850, 870));
        regItem(weaponHuntersKnifePlus = new ItemMHSword(Names.Items.HUNTERS_KNIFE_PLUS, 7f, 60, 200, 400));
        regItem(weaponHuntersDagger = new ItemMHSword(Names.Items.HUNTERS_DAGGER, 8f, 140, 280, 400));
        regItem(weaponAssassinsDagger = new ItemMHSword(Names.Items.ASSASSINS_DAGGER, 9f, 120, 200, 400));

        regItem(weaponBoneKris = new ItemMHSword(Names.Items.BONE_KRIS, 4f, 300, 340, 400));
        regItem(weaponBoneKrisPlus = new ItemMHSword(Names.Items.BONE_KRIS_PLUS, 7f, 180, 320, 400));
        regItem(weaponChiefKris = new ItemMHSword(Names.Items.CHIEF_KRIS, 10f, 200, 280, 400));
        regItem(weaponRottonSword = new ItemMHSword(Names.Items.ROTTEN_SWORD, 6f, 300, 400));
        regItem(weaponPlaguedSword = new ItemMHSword(Names.Items.PLAGUED_SWORD, 8f, 200, 300, 400));
        regItem(weaponInfestedSword = new ItemMHSword(Names.Items.INFESTED_SWORD, 10f, 100, 200, 300, 400));
        regItem(weaponSkeletalSword = new ItemMHSword(Names.Items.SKELETAL_SWORD, 6f, 50, 100, 150, 200));
        regItem(weaponSkeletalSwordPlus = new ItemMHSword(Names.Items.SKELETAL_SWORD_PLUS, 8f, 40, 80, 120, 160, 200));
        regItem(weaponWitheredSword = new ItemMHSword(Names.Items.WITHERED_SWORD, 11f, 30, 60, 120, 240, 480));
        regItem(weaponWitheredSwordPlus = new ItemMHSword(Names.Items.WITHERED_SWORD_PLUS, 14f, 20, 40, 80, 160, 320, 640));
        regItem(weaponNecrosisBlade = new ItemMHSword(Names.Items.NECROSIS_BLADE, 18f, 30, 60, 110, 200, 370, 700));
        regItem(weaponMandiblade = new ItemMHSword(Names.Items.MANDIBLADE, 6f, 80, 180, 300, 400));
        regItem(weaponMandibladePlus = new ItemMHSword(Names.Items.MANDIBLADE_PLUS, 8f, 80, 200, 340, 500));
        regItem(weaponStingingMandiblade = new ItemMHSword(Names.Items.STINGING_MANDIBLADE, 11f, 80, 160, 320, 400, 480));
        regItem(weaponPoisonStingblade = new ItemMHSword(Names.Items.POISON_STINGBLADE, 14f, 80, 185, 290, 395, 500));
        regItem(weaponFearSword = new ItemMHSword(Names.Items.FEAR_SWORD, 6f, 200, 400));
        regItem(weaponTerrorSword = new ItemMHSword(Names.Items.TERROR_SWORD, 8f, 200, 400, 600));
        regItem(weaponDreadSword = new ItemMHSword(Names.Items.DREAD_SWORD, 10f, 200, 400, 600, 800));
        regItem(weaponXenoblade = new ItemMHSword(Names.Items.XENOBLADE, 6f, 20, 40, 60, 80, 100, 120));
        regItem(weaponXenobladePlus = new ItemMHSword(Names.Items.XENOBLADE_PLUS, 8f, 30, 60, 90, 120, 150, 180));
        regItem(weaponAstralSword = new ItemMHSword(Names.Items.ASTRAL_SWORD, 11f, 40, 80, 120, 160, 200, 240));
        regItem(weaponAstralEndsword = new ItemMHSword(Names.Items.ASTRAL_ENDSWORD, 15f, 50, 100, 150, 200, 250, 300));
        regItem(weaponSlimySword = new ItemMHSword(Names.Items.SLIMY_SWORD, 6f, 300, 500));
        regItem(weaponSlimySwordPlus = new ItemMHSword(Names.Items.SLIMY_SWORD_PLUS, 8f, 200, 600));
        regItem(weaponCrystalizedSlimeblade = new ItemMHSword(Names.Items.CRYSTALIZED_SLIMEBLADE, 11f, 200, 400, 600, 800));
        regItem(weaponMagmaticSlimeblade = new ItemMHSword(Names.Items.MAGMATIC_SLIMEBLADE, 14f, 200, 400, 600, 800, 1000));
        regItem(weaponBlazingSword = new ItemMHSword(Names.Items.BLAZING_SWORD, 6f, 200, 300, 400));
        regItem(weaponBlazingTempest = new ItemMHSword(Names.Items.BLAZING_TEMPEST, 8f, 120, 240, 360, 480));
        regItem(weaponBlazingInferno = new ItemMHSword(Names.Items.BLAZING_INFERNO, 10f, 100, 200, 300, 400, 500));

        regItem(weaponTestBow = new ItemMHBow("weaponTestBow", EnumBowCharge.PIERCE, 1));

        regItem(itemQuest = new ItemMHQuest());
        regItem(itemQuestList = new ItemMHQuestList());

        regItem(itemDebug = new ItemMHDebug());

        OreDictionary.registerOre("gemEarthCrystal", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));
        OreDictionary.registerOre("ingotMachalite", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT));
        OreDictionary.registerOre("ingotDragonite", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT));
        OreDictionary.registerOre("ingotGossamite", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT));
        OreDictionary.registerOre("gemLightCrystal", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL));
        OreDictionary.registerOre("gemIceCrystal", MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL));
    }

    /**
     * Registers the item models for the items
     * Only run this client-side!
     */
    public static void regModels()
    {
        for(Item item : ITEMS)
        {
            if(item instanceof ISubTypes && item.getHasSubtypes())
                for(int meta = 0; meta < ((ISubTypes) item).getSubNames().length; meta++)
                    ClientUtil.regModel(item, meta);
            else
                ClientUtil.regModel(item);
        }
    }
}
