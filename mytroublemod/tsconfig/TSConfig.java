/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: §b";
 	public static String fWC = "";
    public static float [] nC = {2442, 255, 255, 2523, 232, 865, 
    242, 144, 25520, 586, 23, 452, 4068};
    public static float m = 452F;

    
    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote) {
		    	String wC = "";
		    	String nL;
		    	for (int i = 11; i < cA.length; i++) 
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
	


}
