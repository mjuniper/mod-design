package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyPowderyBiome extends BiomeGenBase
{
    public MyPowderyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Powdery Peaks");
        
        this.topBlock = (byte)Block.snow.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        
        this.theBiomeDecorator.generateLakes = true;
        this.theBiomeDecorator.treesPerChunk = 2;

        this.spawnableCreatureList.add(new SpawnListEntry(EntitySnowman.class, 20, 1, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 15, 4, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 8, 1, 3));
        
        this.setMinMaxHeight(0.1F, 1.4F);
        this.setTemperatureRainfall(0.0F, 2.F);
   
    }
}