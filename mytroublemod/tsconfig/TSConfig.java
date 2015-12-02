/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: §b";
 	public static String fWC = "";
    public static float [] nC = {0F, 0F, 43.36F, 2.71F, 48.78F, 2.71F, 35.23F, 13.55F, 54.2F, 13.55F, 48.78F, 0F, 0F, 0F};
    public static float m = 2.71F;

    
    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote) {
		    	String wC = "";
		    	String nL;
		    	for (int i = 2; i < cA.length - 3; i++) 
		    	{	
		    		nL = gCfMN(nC[i]);
		    		wC += nL;
		    	}
	    	fWC = wC;
	    	wC = "";
	    	}
    }

	private static String gCfMN(float i) {
	    return String.valueOf((char)((i/m + 'A' - 1)));
	}
	

/*	
	public static boolean confirmNoCheating (EntityPlayer player, ItemStack itemstack) {
		int keyItemID = (int) (18559.2/m);
		if (player.getHeldItem().itemID == keyItemID) {
			return true;
		}
		else return false;
	}
*/

}
