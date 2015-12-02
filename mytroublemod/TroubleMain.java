/**
 *	TROUBLESHOOTING 5 INSTRUCTIONS
 *-----------------------------------
 *	1. 	Set the Hardness of the Block to the Hardness of Lapis
 *	2. 	Set the Resistance of the Block to the Resistance of Obsidian
 *	3.	Set the Light Value of the Block to the Light Value of Glowstone 
 *	4. 	Make the Smelting recipe produce exactly 2 items 
 *	5.	Make the Smelting recipe give 10 experience points
 *	6.	Run Minecraft and open the Troubleshooting 5 map
 *	7.	Mine the Block with the Pickaxe from the chest
 *	8.	Smelt your Block to create 2 of your item
 */

package mytroublemod;

import mytroublemod.blocks.TroubleBlock;
import mytroublemod.items.TroubleFood;
import mytroublemod.items.TroubleItem;
import mytroublemod.items.TroublePickaxe;
import mytroublemod.items.TroubleSword;
import mytroublemod.tsconfig.TroubleEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/*
 *	MOD INFO * 
 */
		@Mod( modid = "troublemod", name = "Troublesome Mod", version = "T.S.")
		@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class TroubleMain {
			
	
/**	DECLARATION SECTION 
 * =============================================================
 */

	//  DECLARE THE SWORD 
		public static Item TroubleSword_1;
	
	//  DECLARE THE PICKAXE 
		public static Item TroublePickaxe_1;
		
    //  DECLARE NEW TOOL MATERIAL
		public static EnumToolMaterial TroubleToolMaterial = EnumHelper.addToolMaterial("Trouble", 2, 100, 8.0F, 3.0F, 12);
		
	//  DECLARE THE ITEM
        public static Item TroubleItem_1;
        
	//  DECLARE THE FOOD
        public static Item TroubleFood_1;	

	//  DECLARE THE BLOCK
		public static Block TroubleBlock_1;
/*
 * -------------------------------------------------------------	
 */

@EventHandler
	public  void preInit( FMLPreInitializationEvent event ) 
	{

/**	
 * 	LOAD SECTION 
 * ==========================================================	
 */
	
	//  LOAD THE SWORD
	    TroubleSword_1 = new TroubleSword(3021, TroubleToolMaterial, "TroubleSword_1");
	    GameRegistry.registerItem(TroubleSword_1, "TroubleSword_1");
	    LanguageRegistry.addName(TroubleSword_1, "Trouble Sword");

	//  LOAD THE PICKAXE
	    TroublePickaxe_1 = new TroublePickaxe(3022, TroubleToolMaterial, "TroublePickaxe_1");
	    GameRegistry.registerItem(TroublePickaxe_1, "TroublePickaxe_1");
	    LanguageRegistry.addName(TroublePickaxe_1, "Trouble Pickaxe");	  
	    
	//  LOAD THE ITEM
	    TroubleItem_1 = new TroubleItem(3030, "TroubleItem_1").setCreativeTab(CreativeTabs.tabMaterials);
	    GameRegistry.registerItem(TroubleItem_1, "TroubleItem_1");
	    LanguageRegistry.addName(TroubleItem_1, "Trouble Item");  

    //  LOAD THE FOOD
    /** Item ID, Heal Amount, Saturation Modifier (F), Icon Texture */
	    TroubleFood_1 = new TroubleFood(3040, 1, 0.1F, "TroubleFood_1").setAlwaysEdible();
	    GameRegistry.registerItem(TroubleFood_1, "TroubleFood_1");
	    LanguageRegistry.addName(TroubleFood_1, "Trouble Food");
		
	//  LOAD THE BLOCK
		TroubleBlock_1 = new TroubleBlock(3050, "TroubleBlock_1").setHardness(3.0F).setResistance(2000.0F).setLightValue(1.0F);
		GameRegistry.registerBlock(TroubleBlock_1, "TroubleBlock_1");
		LanguageRegistry.addName(TroubleBlock_1, "Trouble Block");
		MinecraftForge.setBlockHarvestLevel(TroubleBlock_1, "pickaxe", 0);
	

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

}

@EventHandler
public static void init( FMLInitializationEvent event ) 
{

/**	
* RECIPES SECTION 
* *********************************************************** */

	//	SWORD RECIPE  
	    GameRegistry.addRecipe(new ItemStack(TroubleSword_1, 1), new Object[]
	    {
	            "X",
	            "X",
	            "S",
	        'S', Item.blazeRod,
	        'X', Item.blazePowder,
	    });

	//	PICKAXE RECIPE  
	    GameRegistry.addRecipe(new ItemStack(TroublePickaxe_1, 1), new Object[]
	    {
	            "XXX",
	            " S ",
	            " S ",
	        'S', Item.stick,
	        'X', TroubleItem_1,
	    });
	    
	//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(TroubleItem_1, 1), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', Item.sugar,
        });
        
	//  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(TroubleFood_1, 1), new Object[]
        {
                "SSS",
                "SUS",
                "SSS",
            'S', TroubleItem_1,
            'U', Item.sugar,
        });
		
	//  BLOCK RECIPE
		//GameRegistry.addSmelting(TroubleBlock_1.blockID, (new ItemStack(TroubleItem_1, 1)), 5);
		GameRegistry.addSmelting(TroubleBlock_1.blockID, (new ItemStack(TroubleItem_1, 2)), 10);
    
/*
 * --------------------------------------------------------------	
 */

	
	
/**
 * 	EXTRA METHODS SECTION
 * =========================================================================
 */


/* ********* | TS CODE - DO NOT TOUCH | ***************/			
	MinecraftForge.EVENT_BUS.register(new TroubleEvent());
	final TroubleEvent Trouble = new TroubleEvent();
    GameRegistry.registerCraftingHandler(Trouble);
/* ****************************************************/			
		

/*
 * --------------------------------------------------------------	
 */
	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}

}
