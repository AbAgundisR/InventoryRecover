package me.damiannylon.damiannyloninventoryrecover;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class CommandInvrestore implements CommandExecutor {
    DamianNylonInventoryRecover plugin;

    public CommandInvrestore(DamianNylonInventoryRecover plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            InventorySaver inv = new InventorySaver(plugin);

            inv.recoverInventory(p);
        }

        return true;
    }
}
