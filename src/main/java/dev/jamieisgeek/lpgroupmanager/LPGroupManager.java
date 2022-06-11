package dev.jamieisgeek.lpgroupmanager;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class LPGroupManager extends JavaPlugin {

    Logger log = Bukkit.getLogger();
    LuckPerms luckPerms;
    @Override
    public void onEnable() {

        if (!setupLuckPerms()) {
            log.severe("Could not hook into LuckPerms");
            log.severe("Make sure you have LuckPerms installed and that it is up to date!");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            new Manager();
            getCommand("grant").setExecutor(new CommandHandler());
            getCommand("gmreload").setExecutor(new ReloadCommand());

            log.info("");
            log.info("=+=+=+=+=+=+=+=+=+=+=");
            log.info("LuckPerms Group Manager has Enabled!");
            log.info("Made by: JamieIsGeek");
            log.info("=+=+=+=+=+=+=+=+=+=+=");
            log.info("");
        }
    }


    @Override
    public void onDisable() {
        log.info("");
        log.info("=+=+=+=+=+=+=+=+=+=+=");
        log.info("LuckPerms Group Manager has Disabled!");
        log.info("Made by: JamieIsGeek");
        log.info("=+=+=+=+=+=+=+=+=+=+=");
        log.info("");
    }

    private boolean setupLuckPerms() {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            luckPerms = provider.getProvider();
            log.info("Successfully hooked into LuckPerms");
            return true;
        } else {
            return false;
        }
    }
}
