package mytroublemod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;


public class TroubleSword extends ItemSword {
    
	private String texturePath = "troublemod:";
	
    public TroubleSword(int ItemID, EnumToolMaterial material, String textureName)
    {
        super(ItemID, material);
		this.setUnlocalizedName(textureName);
		texturePath += textureName;
    }

@Override   
@SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }   


}