package dev.jamieisgeek.lpgroupmanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(!player.hasPermission("lpgroupmanager.grant")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }

            if(args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please specify a player!");
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    player.sendMessage(ChatColor.RED + "Player not found!");
                } else {
                    Manager manager = Manager.getManager();
                    manager.openGroupsMenu(player);
                }
            }
        }

        return true;
    }
}
