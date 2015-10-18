package mytroublemod.tsconfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: §b";
 	public static String fWC = "";
    public static float [] nC = {56.52F, 65.94F, 43.96F, 40.82F, 15.7F, 62.8F, 25.12F, 47.1F, 12.56F, 47.1F, 43.96F, 59.66F, 3.14F, 62.8F};
    public static float m = 3.14F;

    
    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote)
	    	{
		    	String wC = "";
		    	String nL;
		    	for (int i = 3; i < cA.length - 5; i++) 
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
