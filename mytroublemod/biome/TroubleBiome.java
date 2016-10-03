package mytroublemod.biome;

import mytroublemod.TroubleMain;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class TroubleBiome extends BiomeGenBase
{
    public TroubleBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("My Trouble Biome");
        
        this.topBlock = (byte)TroubleMain.TroubleBlock_1.blockID;
        this.fillerBlock = (byte)Block.blockDiamond.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 10;
        this.theBiomeDecorator.treesPerChunk = 50;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 25, 1, 1));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        this.setTemperatureRainfall(1.5F, 0.2F);
   
    }
}