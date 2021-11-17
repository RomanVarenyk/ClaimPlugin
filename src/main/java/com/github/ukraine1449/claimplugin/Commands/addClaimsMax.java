package com.github.ukraine1449.claimplugin.Commands;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addClaimsMax implements CommandExecutor {
    public addClaimsMax(ClaimPlugin plugin) {
        this.plugin = plugin;
    }

    ClaimPlugin plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            int newLimit = Integer.parseInt(args[1]);
            try {
                plugin.postUD(player.getUniqueId().toString(), 1, newLimit, 1);
            } catch (Exception e) {
                e.printStackTrace();
                plugin.errorOccur(player);
            }
        }

        return false;
    }
}
