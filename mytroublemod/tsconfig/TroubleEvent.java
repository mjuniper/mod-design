/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import mytroublemod.entity.troublecow.EntityTroubleCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.common.ICraftingHandler;


public class TroubleEvent implements ICraftingHandler
{

	private static boolean troubleComplete = false;
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
	}

	@ForgeSubscribe
	public void onHitTroubleCow (EnderTeleportEvent event) {
		if (!event.entity.worldObj.isRemote
			&& event.entity instanceof EntityTroubleCow
			&& troubleComplete == false)
			{
				TSConfig.cNtW(TSConfig.nC, event.entity.worldObj);
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);	
				troubleComplete = true;
			}
		}		
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	
	}


}
