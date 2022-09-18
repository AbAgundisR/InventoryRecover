package me.damiannylon.damiannyloninventoryrecover;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDeathListener implements Listener {
    DamianNylonInventoryRecover plugin;
    InventorySaver invSaver;

    public PlayerDeathListener(DamianNylonInventoryRecover plugin){
        this.plugin = plugin;
        invSaver = new InventorySaver(plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        invSaver.saveInventory(p);
    }
}
