package eu.nac.command;

import eu.nac.NAC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlertsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender == Bukkit.getConsoleSender())
            sender.sendMessage("[NAC] This command cannot be executed in the console.");
        else if (!sender.hasPermission("nac.alerts"))
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aNAC&8] &7You do not have the permission to execute this command."));
        else
            NAC.INSTANCE.getPlayerDataManager().get((Player) sender).toggleAlerts();
        return true;
    }
}
