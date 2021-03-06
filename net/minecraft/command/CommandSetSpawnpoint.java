package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetSpawnpoint extends CommandBase
{
    public String getCommandName()
    {
        return "spawnpoint";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "commands.spawnpoint.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        EntityPlayerMP entityplayermp = par2ArrayOfStr.length == 0 ? getCommandSenderAsPlayer(par1ICommandSender) : getPlayer(par1ICommandSender, par2ArrayOfStr[0]);

        if (par2ArrayOfStr.length == 4)
        {
            if (entityplayermp.worldObj != null)
            {
                byte b0 = 1;
                int i = 30000000;
                int j = b0 + 1;
                int k = parseIntBounded(par1ICommandSender, par2ArrayOfStr[b0], -i, i);
                int l = parseIntBounded(par1ICommandSender, par2ArrayOfStr[j++], 0, 256);
                int i1 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[j++], -i, i);
                entityplayermp.setSpawnChunk(new ChunkCoordinates(k, l, i1), true);
                notifyAdmins(par1ICommandSender, "commands.spawnpoint.success", new Object[] {entityplayermp.getEntityName(), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1)});
            }
        }
        else
        {
            if (par2ArrayOfStr.length > 1)
            {
                throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
            }

            ChunkCoordinates chunkcoordinates = entityplayermp.getPlayerCoordinates();
            entityplayermp.setSpawnChunk(chunkcoordinates, true);
            notifyAdmins(par1ICommandSender, "commands.spawnpoint.success", new Object[] {entityplayermp.getEntityName(), Integer.valueOf(chunkcoordinates.posX), Integer.valueOf(chunkcoordinates.posY), Integer.valueOf(chunkcoordinates.posZ)});
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length != 1 && par2ArrayOfStr.length != 2 ? null : getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames());
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 0;
    }
}
