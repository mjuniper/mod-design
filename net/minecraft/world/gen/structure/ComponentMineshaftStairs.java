package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ComponentMineshaftStairs extends StructureComponent
{
    public ComponentMineshaftStairs() {}

    public ComponentMineshaftStairs(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4)
    {
        super(par1);
        this.coordBaseMode = par4;
        this.boundingBox = par3StructureBoundingBox;
    }

    protected void func_143012_a(NBTTagCompound par1NBTTagCompound) {}

    protected void func_143011_b(NBTTagCompound par1NBTTagCompound) {}

    /**
     * Trys to find a valid place to put this component.
     */
    public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, int par2, int par3, int par4, int par5)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3 - 5, par4, par2, par3 + 2, par4);

        switch (par5)
        {
            case 0:
                structureboundingbox.maxX = par2 + 2;
                structureboundingbox.maxZ = par4 + 8;
                break;
            case 1:
                structureboundingbox.minX = par2 - 8;
                structureboundingbox.maxZ = par4 + 2;
                break;
            case 2:
                structureboundingbox.maxX = par2 + 2;
                structureboundingbox.minZ = par4 - 8;
                break;
            case 3:
                structureboundingbox.maxX = par2 + 8;
                structureboundingbox.maxZ = par4 + 2;
        }

        return StructureComponent.findIntersecting(par0List, structureboundingbox) != null ? null : structureboundingbox;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
        int i = this.getComponentType();

        switch (this.coordBaseMode)
        {
            case 0:
                StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, 0, i);
                break;
            case 1:
                StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, 1, i);
                break;
            case 2:
                StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, 2, i);
                break;
            case 3:
                StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, 3, i);
        }
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.isLiquidInStructureBoundingBox(par1World, par3StructureBoundingBox))
        {
            return false;
        }
        else
        {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5, 0, 2, 7, 1, 0, 0, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 7, 2, 2, 8, 0, 0, false);

            for (int i = 0; i < 5; ++i)
            {
                this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, 0, 0, false);
            }

            return true;
        }
    }
}
