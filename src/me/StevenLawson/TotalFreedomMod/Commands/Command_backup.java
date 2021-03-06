package me.StevenLawson.TotalFreedomMod.Commands;

import java.io.File;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Runns Custom Backup System.", usage = "/<command>")
public class Command_backup extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.adminAction(sender.getName(), "Backing up the server - Warning: Lag may occur", true);

        if (senderIsConsole)
        {
            server.dispatchCommand(sender, "ziptool zip E:\\UserFiles\\CHARLESG\\GameServers\\TC13664486412628155325358\\Minecraft\\plugins");
            server.dispatchCommand(sender, "ziptool zip E:\\UserFiles\\CHARLESG\\GameServers\\TC13664486412628155325358\\Minecraft\\plugins\\BukkitHttpd");
            server.dispatchCommand(sender, "ziptool zip E:\\UserFiles\\CHARLESG\\GameServers\\TC13664486412628155325358\\Minecraft\\plugins\\BukkitTelnet");
            server.dispatchCommand(sender, "ziptool zip E:\\UserFiles\\CHARLESG\\GameServers\\TC13664486412628155325358\\Minecraft\\plugins\\CJFreedomMod");
            server.dispatchCommand(sender, "ziptool zip E:\\UserFiles\\CHARLESG\\GameServers\\TC13664486412628155325358\\Minecraft\\plugins\\WorldEdit");
        }
    try
      {
            TFM_Util.downloadFile("http://www.thecjgcjg.com/cjfreedom/scripts/autobackup.php", new File(TotalFreedomMod.plugin.getDataFolder(), TotalFreedomMod.BACKUP_FILE));
            TFM_Util.adminAction(sender.getName(), "Backup Completed Succesfully", false);
      }
     catch (Exception ex)
        {
            TFM_Log.severe(ex);
        }
        return true;
    }
}
