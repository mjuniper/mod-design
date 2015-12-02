/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.blocks;

import mytroublemod.tsconfig.TroubleEvent;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;


public class TroubleBlock extends Block 
{
    
	private String texturePath = "troublemod:";
	public static float tshardness;
	public static float tsresistance;
	public static float tslightValue;
	
    public TroubleBlock(int par1, String textureName) 
    {
        super(par1, Material.rock);
		this.setUnlocalizedName(textureName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		texturePath += textureName;

    }

@Override
@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }
    
@Override
@SideOnly(Side.CLIENT)
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	{
		//EntityPlayer player = par1World.getClosestPlayer((double)par2, (double)par3, (double)par5, 0.0F);
		TroubleEvent.onTroubleBlockBreak();
	}
@Override
@SideOnly(Side.CLIENT)
    public Block setLightValue(float par1)
    {
        lightValue[this.blockID] = (int)(15.0F * par1);
        tslightValue = par1;
        return this;
    }

@Override
@SideOnly(Side.CLIENT)
    public Block setResistance(float par1)
    {
        this.blockResistance = par1 * 3.0F;
        tsresistance = par1;
        return this;
    }

@Override
@SideOnly(Side.CLIENT)
   public Block setHardness(float par1)
    {
        this.blockHardness = par1;

        if (this.blockResistance < par1 * 5.0F)
        {
            this.blockResistance = par1 * 5.0F;
        }
        tshardness = par1;
        return this;
    }


}