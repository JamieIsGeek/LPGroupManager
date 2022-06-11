package dev.jamieisgeek.lpgroupmanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadCommand implements CommandExecutor {
    Plugin plugin = LPGroupManager.getProvidingPlugin(LPGroupManager.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;
            if(p.hasPermission("lpgroupmanager.reload")) {
                p.sendMessage(ChatColor.GREEN + "Reloading...");
                Bukkit.getPluginManager().disablePlugin(plugin);
                Bukkit.getPluginManager().enablePlugin(plugin);
                p.sendMessage(ChatColor.GREEN + "Reloaded!");
            } else {
                p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }
        }

        return true;
    }
}
