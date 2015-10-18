package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
class ThreadStatSyncherReceive extends Thread
{
    final StatsSyncher syncher;

    ThreadStatSyncherReceive(StatsSyncher par1StatsSyncher)
    {
        this.syncher = par1StatsSyncher;
    }

    public void run()
    {
        try
        {
            if (StatsSyncher.func_77419_a(this.syncher) != null)
            {
                StatsSyncher.func_77414_a(this.syncher, StatsSyncher.func_77419_a(this.syncher), StatsSyncher.func_77408_b(this.syncher), StatsSyncher.func_77407_c(this.syncher), StatsSyncher.func_77411_d(this.syncher));
            }
            else if (StatsSyncher.func_77408_b(this.syncher).exists())
            {
                StatsSyncher.func_77416_a(this.syncher, StatsSyncher.func_77410_a(this.syncher, StatsSyncher.func_77408_b(this.syncher), StatsSyncher.func_77407_c(this.syncher), StatsSyncher.func_77411_d(this.syncher)));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            StatsSyncher.setBusy(this.syncher, false);
        }
    }
}
