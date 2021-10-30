package com.github.ukraine1449.claimplugin.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class rightClickEvent implements Listener {

    @EventHandler
    public void rightClickEvent(PlayerInteractEvent event) throws Exception {
        Player player = event.getPlayer();
        Action a = event.getAction();
        if ((a == Action.PHYSICAL) || (event.getItem().getType() == Material.GOLDEN_SHOVEL)){
            if(event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Claim tool")){

            }
        }
    }

}
