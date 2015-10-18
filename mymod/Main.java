package mymod;

import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;


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

 //  DECLARE THE SWORD 
        public static Item MySword_1;

//  DECLARE THE PICKAXE 
        public static Item MyPickaxe_1;

//  DECLARE NEW TOOL MATERIAL
/** Harvest Level, Max Uses, Efficiency (f), Damage (f), Enchantability */
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Mirajite", 3, 1581, 8.0F, 14.0F, 10);

//  DECLARE THE ITEM
        public static Item MyItem_1;

//  DECLARE THE FOOD
        public static Item MyFood_1;

    //  DECLARE THE BLOCK
        public static Block MyBlock_1;

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD THE SWORD
        MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1");
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Sword of Light");

//  LOAD THE PICKAXE
        MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
        LanguageRegistry.addName(MyPickaxe_1, "Light Pickaxe");
	
	//  LOAD THE ITEM
        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(32);
        GameRegistry.registerItem(MyItem_1, "MyItem_1");
        LanguageRegistry.addName(MyItem_1, "Rose Quartz Shard");
	
	//  LOAD THE FOOD
	/** itemID, healAmount, saturationModifier, (F), isWolfsFavoriteMeat, Texture Name */
        MyFood_1 = new MyFood(2040, 2, 3.0F, false, "MyFood_1").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Rock Candy");
	
	//  LOAD THE BLOCK 
        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1")
        	.setLightValue(0.7F)
        	.setResistance(8.0F)
        	.setHardness(10.0F)
        	.setStepSound(Block.soundGlassFootstep);
        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
        LanguageRegistry.addName(MyBlock_1, "Rose Quartz Ore"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 2);
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */


		//  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
        {
                " B ",
                " S ",
                " R ",
            'S', Item.stick,
            'B', Item.blazeRod,
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
                "SRS",
                " W ",
            'S', Item.sugar,
            'R', MyItem_1,
            'W', Item.bucketWater
        });

//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 1)), 16);

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
