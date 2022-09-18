package me.damiannylon.damiannyloninventoryrecover;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class InventorySaver {
    DamianNylonInventoryRecover plugin;

    public InventorySaver(DamianNylonInventoryRecover plugin){
        this.plugin = plugin;
    }

    public void saveInventory(Player p) {
        File f = new File(plugin.getDataFolder().getAbsolutePath(), p.getUniqueId() + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory", p.getInventory().getContents());

        try {
            c.save(f);
        } catch(IOException e){
            Bukkit.getLogger().info("ERROR WHILE SAVING INVENTORY: " + e.getMessage());
        }
    }

    public void recoverInventory(Player p){
        File f = new File(plugin.getDataFolder().getAbsolutePath(), p.getUniqueId() + ".yml");
        if(f.exists()){
            FileConfiguration c = YamlConfiguration.loadConfiguration(f);
            ItemStack[] content = ((List<ItemStack>) c.get("inventory")).toArray(new ItemStack[0]);

            World w = p.getWorld();
            for (ItemStack item: content) {
                if(item != null){
                    w.dropItemNaturally(p.getLocation(), item);
                }
            }

            f.delete();
        } else {
            p.sendMessage(ChatColor.RED + "No inventory saved");
        }
    }
}
