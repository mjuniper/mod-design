package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Hilly Willy");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.blockClay.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 3;
        this.theBiomeDecorator.treesPerChunk = 4;
        this.theBiomeDecorator.waterlilyPerChunk = 2;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityOcelot.class, 13, 1, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 13, 4, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCaveSpider.class, 8, 1, 1));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        this.setTemperatureRainfall(0.5F, 1.0F);
   
    }
}