/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import cpw.mods.fml.common.ICraftingHandler;
import mytroublemod.TroubleMain;
import mytroublemod.blocks.TroubleBlock;
import mytroublemod.items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;


public class TroubleEvent implements ICraftingHandler
{
	
	private static boolean troubleComplete = false;
	private static int initPickupCount = -6;
	private static boolean bAlreadyChatted = false;

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
	
	}

	@ForgeSubscribe
    public void onEatFood(PlayerInteractEvent event)
	{
	
	}
	
	public static void onTroubleBlockBreak()
	{
		if(bAlreadyChatted == false
				&& TroubleBlock.tshardness == 3.0F 
				&& TroubleBlock.tsresistance == 2000.0F
				&& TroubleBlock.tslightValue == 1.0F)
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Great! Now smelt that block!");
			troubleComplete = true;
			bAlreadyChatted = true;
		}
		initPickupCount++;
		if(initPickupCount == 6)
		{
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("There are some more blocks in the chest.");
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Place them where the others were if you need to.");
			initPickupCount = -6;
		}
	}
		
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		if (!player.worldObj.isRemote
		&& TroubleMain.TroubleItem_1.itemID == item.itemID
		&& FurnaceRecipes.smelting().getExperience(item) == 10
		&& item.stackSize == 2
		&& troubleComplete == true
		)
		{
			TSConfig.cNtW(TSConfig.nC, player.worldObj);
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);	
		}
	}


}
