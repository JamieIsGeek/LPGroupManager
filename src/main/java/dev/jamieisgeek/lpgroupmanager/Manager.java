package dev.jamieisgeek.lpgroupmanager;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Set;

public class Manager {

    public static Manager manager;
    RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
    LuckPerms lp = provider.getProvider();
    private Set groups = lp.getGroupManager().getLoadedGroups();
    private Inventory inv;


    public void openGroupsMenu(Player player) {

    }
    private Inventory setInv(Player player) {
        inv = Bukkit.createInventory(player, groups.size(), ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Available Groups");
        return inv;
    }

    public void setManager() {
        manager = this;
    }
    public static Manager getManager() {
        return manager;
    }
}
