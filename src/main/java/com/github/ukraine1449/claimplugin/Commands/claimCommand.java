package com.github.ukraine1449.claimplugin.Commands;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class claimCommand implements CommandExecutor {
ClaimPlugin plugin;

    public claimCommand(ClaimPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            ItemStack claimTool = new ItemStack(Material.GOLDEN_SHOVEL);
            ItemMeta cTM = claimTool.getItemMeta();
            cTM.setDisplayName(ChatColor.GOLD + "Claim tool");
            claimTool.setItemMeta(cTM);
            player.getInventory().addItem(claimTool);
        }

        return true;
    }
}
