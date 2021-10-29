package com.github.ukraine1449.claimplugin.Events;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlockInteractEvent implements Listener {
ClaimPlugin plugin;

    public BlockInteractEvent(ClaimPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void blockBreakEvent(BlockBreakEvent event) throws Exception {
        int xpos = event.getBlock().getX();
        int zpos = event.getBlock().getZ();
        Player player = event.getPlayer();
        ArrayList<Integer> coordsOrg = plugin.selectCD(player.getWorld().getName(), player.getLocation().getChunk().toString());
        if(!plugin.cache.contains(event.getBlock().getLocation())){
            if(xpos <= Math.max(coordsOrg.get(0), coordsOrg.get(1)) && xpos >= Math.min(coordsOrg.get(0), coordsOrg.get(1))){
                if(zpos <= Math.max(coordsOrg.get(2), coordsOrg.get(3)) && zpos >= Math.min(coordsOrg.get(2), coordsOrg.get(3))){
                    plugin.cache.add(event.getBlock().getLocation());
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "This block is claimed.");
                }
            }
        }else{
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "This block is claimed.");
        }
    }

}
