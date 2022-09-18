package me.damiannylon.damiannyloninventoryrecover;

import org.bukkit.plugin.java.JavaPlugin;

public final class DamianNylonInventoryRecover extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        this.getCommand("invrestore").setExecutor(new CommandInvrestore(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
