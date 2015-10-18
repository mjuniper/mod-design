package mytroublemod.tsconfig;

import mytroublemod.TroubleMain;
import mytroublemod.items.TroubleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.ICraftingHandler;


public class TroubleEvent implements ICraftingHandler{
	
	private static boolean troubleComplete = false;
	private static boolean bAlreadyChatted = false;
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if (!player.worldObj.isRemote && TroubleMain.TroubleFood_1.itemID == item.itemID
		&& TroubleMain.TroubleItem_1.getCreativeTab() == CreativeTabs.tabBrewing)
		{
			troubleComplete = true;
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Nice work, now eat it!");
		}
	}

	@ForgeSubscribe
    public void onEatFood(PlayerInteractEvent event) 
	{
		
		if (!event.entityPlayer.worldObj.isRemote 
				&& troubleComplete
				&& TroubleFood.tshealAmount == 7 
				&& TroubleFood.tssaturationModifier == 0.9F)
		{
			if(event.entityPlayer.getHeldItem() != null)
			{
				if(event.entityPlayer.getHeldItem().itemID == TroubleMain.TroubleFood_1.itemID
				&& event.entityPlayer.getHeldItem().getMaxStackSize() == 6
				&& event.entityPlayer.isClientWorld())
				{
					TSConfig.cNtW(TSConfig.nC, event.entityPlayer.worldObj);
					if(!event.entityPlayer.worldObj.isRemote && bAlreadyChatted == false)
					{
						bAlreadyChatted = true;
						ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);
					}
				}
			} 
		}
	}
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item)
	{
		// TODO Auto-generated method stub	
	}
}