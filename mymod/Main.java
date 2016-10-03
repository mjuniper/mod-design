package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyPowderyBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.wolf.MyEntityWolf;
import mymod.entity.wolf.MyModelWolf;
import mymod.entity.wolf.MyRenderWolf;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "Miraj Mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */

 //  DECLARE SPONGY SWORD
        public static Item MySword_1;

 //  DECLARE SLICE AND DICE 
        public static Item MySword_2;

//  DECLARE THE PICKAXE 
        public static Item MyPickaxe_1;

//  DECLARE NEW TOOL MATERIAL
/** Harvest Level, Max Uses, Efficiency (f), Damage (f), Enchantability */
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Sponge Quartz", 3, 1581, 8.0F, 14.0F, 10);

//  DECLARE THE ITEM
        public static Item MyItem_1;

//  DECLARE THE FOOD
        public static Item MyFood_1;

    //  DECLARE THE BLOCK
        public static Block MyBlock_1;

//  DECLARE TIE DYE BLOCK
        public static Block MyBlock_2;

//  DECLARE THE ARMOR
        public static Item MyHelmet_1;
        public static Item MyChest_1;
        public static Item MyLeggings_1;
        public static Item MyBoots_1;
        
     //  DECLARE THE ARMOR MATERIAL
        															//maxDamageFactor, damageReductionAmountArray, enchantability
        public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Sponge Quartz", 30, new int[]{3, 7, 6, 3}, 17);   
        
        //  DECLARE THE MUSHY BIOME
        public static  BiomeGenBase MyBiome_1;  

        //  DECLARE THE POWDERY BIOME
        public static  BiomeGenBase MyPowderyBiome_1; 

        //  DECLARE THE MOB ID
        static int MyEntityID = 300;
    
    //  SEARCH FOR UNIQUE ID    
        public static int getUniqueEntityId() {
            do {
                MyEntityID++;
            }
            while (EntityList.getStringFromID(MyEntityID) != null);
            return MyEntityID++;
        }
    
    //  DECLARE A NEW EGG
        public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
            int id = getUniqueEntityId();
            EntityList.IDtoClassMapping.put(id, entity);
            EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD SPONGY SWORD
        MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1");
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Spongy Sword");

//  LOAD SLICE AND DICE
        MySword_2 = new MySword(2023, MyToolMaterial, "MySword_2");
        GameRegistry.registerItem(MySword_2, "MySword_2");
        LanguageRegistry.addName(MySword_2, "Slice and Dice");

//  LOAD THE PICKAXE
        MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
        LanguageRegistry.addName(MyPickaxe_1, "Rose Pickaxe");
	
//  LOAD THE ITEM
        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(32);
        GameRegistry.registerItem(MyItem_1, "MyItem_1");
        LanguageRegistry.addName(MyItem_1, "Sponge Quartz Shard");
	
//  LOAD THE FOOD
	/** itemID, healAmount, saturationModifier, (F), isWolfsFavoriteMeat, Texture Name */
        MyFood_1 = new MyFood(2040, 2, 3.0F, false, "MyFood_1").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Sponge Candy");
	
//  LOAD THE BLOCK 
        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1")
        	.setLightValue(0.2F)
        	.setResistance(11.5F)
        	.setHardness(10.0F)
        	.setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
        LanguageRegistry.addName(MyBlock_1, "Sponge Quartz Ore"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 2);
	
//  LOAD TIE DYE BLOCK 
        MyBlock_2 = new MyBlock(251, Material.cake, "MyBlock_2")
        	.setLightValue(0.3F)
        	.setResistance(10.0F)
        	.setHardness(10.0F)
        	.setStepSound(Block.soundPowderFootstep);
        GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
        LanguageRegistry.addName(MyBlock_2, "Tie Dye Block"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 2);
	
//  LOAD HELMET 
        MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor");
        GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
        LanguageRegistry.addName(MyHelmet_1, "Helmet of Awesomeness");      
    
//  LOAD CHESTPLATE
        MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor");
        GameRegistry.registerItem(MyChest_1, "MyChest_1");
        LanguageRegistry.addName(MyChest_1, "Chestplate of Awesomeness");

//  LOAD LEGGINGS    
        MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor");
        GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
        LanguageRegistry.addName(MyLeggings_1, "Leggings of Awesomeness");

//  LOAD BOOTS   
        MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor");
        GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
        LanguageRegistry.addName(MyBoots_1, "Boots of Awesomeness");
	
//  LOAD MUSHY BIOME
        MyBiome_1 = new MyBiome(30);
        GameRegistry.removeBiome(MyBiome_1);
        
//  LOAD POWDERY BIOME
        MyPowderyBiome_1 = new MyPowderyBiome(31);
        GameRegistry.addBiome(MyPowderyBiome_1);
        
//  REMOVE OTHER BIOMES
        GameRegistry.removeBiome(BiomeGenBase.beach);
        GameRegistry.removeBiome(BiomeGenBase.desert);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
        GameRegistry.removeBiome(BiomeGenBase.forest);
        GameRegistry.removeBiome(BiomeGenBase.forestHills);
        GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
        GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
        GameRegistry.removeBiome(BiomeGenBase.iceMountains);
        GameRegistry.removeBiome(BiomeGenBase.icePlains);
        GameRegistry.removeBiome(BiomeGenBase.jungle);
        GameRegistry.removeBiome(BiomeGenBase.jungleHills);
        GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
        GameRegistry.removeBiome(BiomeGenBase.ocean);
        GameRegistry.removeBiome(BiomeGenBase.plains);
        GameRegistry.removeBiome(BiomeGenBase.river);
        GameRegistry.removeBiome(BiomeGenBase.swampland);
        GameRegistry.removeBiome(BiomeGenBase.taiga);
        GameRegistry.removeBiome(BiomeGenBase.taigaHills);
        
        //  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityWolf.class, "Chocodog", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityWolf.class, 15, 1, 5, EnumCreatureType.monster, BiomeGenBase.jungle);
        EntityRegistry.addSpawn(MyEntityWolf.class, 14, 1, 5, EnumCreatureType.monster, BiomeGenBase.jungleHills);
        EntityRegistry.addSpawn(MyEntityWolf.class, 13, 1, 5, EnumCreatureType.monster, BiomeGenBase.river);
        EntityRegistry.addSpawn(MyEntityWolf.class, 16, 1, 5, EnumCreatureType.monster, MyBiome_1);     
        registerEntityEgg(MyEntityWolf.class, (new Color(246, 242, 237)).getRGB(), (new Color(207, 153, 90)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityWolf.class, new MyRenderWolf(new MyModelWolf(), 0.3F));
        ModLoader.addLocalization("entity.Chocodog.name", "Chocodog");
        
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */


		//  SPONGY SWORD  
        GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
        {
                " B ",
                " S ",
                " R ",
            'S', Item.stick,
            'B', Item.blazeRod,
            'R', MyItem_1
        });
	
	//  SLICE AND DICE SWORD  
        GameRegistry.addRecipe(new ItemStack(MySword_2, 1), new Object[]
        {
                "III",
                "RIR",
                " S ",
            'S', Item.stick,
            'I', Item.ingotIron,
            'R', MyItem_1
        });
	
        //  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
        {
                "BRB",
                "ISI",
                " S ",
            'S', Item.stick,
            'B', Item.blazeRod,
            'I', Item.ingotIron,
            'R', MyItem_1
        });

//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_1, 1), new Object[]
        {
                " R ",
                "RQR",
                " R ",
            'Q', Item.netherQuartz,
            'R', new ItemStack(Item.dyePowder, 1, 1)
        });

//  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
        {
                " W ",
                " R ",
                " S ",
            'S', Item.stick,
            'R', MyItem_1,
            'W', Item.bucketWater
        });

//  TIE DYE BLOCK RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyBlock_2, 1), new Object[]
        {
                "KOK",
                "OKO",
                "KOK",
            'K', Item.cake,
            'O', Item.cookie
        });

//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 1)), 16);

//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_1,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_1,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_1,
    });

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
