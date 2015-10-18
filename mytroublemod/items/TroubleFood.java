package mytroublemod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class TroubleFood extends ItemFood 
{

	private String texturePath = "troublemod:";
	public static int tshealAmount;
	public static Float tssaturationModifier;
	
    public TroubleFood(int par1, int par2, Float par3, boolean par4, String textureName) 
    {
        super(par1, par2, par3, par4);
		this.setUnlocalizedName(textureName);
        texturePath += textureName;
		this.tshealAmount = par2;
		this.tssaturationModifier = par3;
		if(par4 == true) setAlwaysEdible();
    }

@Override
@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }
 

}