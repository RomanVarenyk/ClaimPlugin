package com.github.ukraine1449.claimplugin.Events;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class rightClickEvent implements Listener {
ClaimPlugin plugin;

    public rightClickEvent(ClaimPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void rightClickEvent(PlayerInteractEvent event) throws Exception {
        Player player = event.getPlayer();
        Action a = event.getAction();
        if ((a == Action.PHYSICAL) || (event.getItem().getType() == Material.GOLDEN_SHOVEL)){
            if(event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Claim tool")){

                if(!plugin.listOfPotClaims.containsKey(player.getUniqueId())){
                    plugin.listOfPotClaims.put(player.getUniqueId(), event.getClickedBlock().getLocation());
                }else{
                    plugin.postCD(player.getUniqueId().toString(), 0, event.getClickedBlock().getChunk().toString(), event.getClickedBlock().getWorld().toString(), plugin.listOfPotClaims.get(player.getUniqueId()).getBlockX(), event.getClickedBlock().getX(), plugin.listOfPotClaims.get(player.getUniqueId()).getBlockZ(), event.getClickedBlock().getZ(), null, player.getName()+ "'s claim at " + event.getClickedBlock().getLocation(), "null", 1);
                }
            }
        }
    }

}
