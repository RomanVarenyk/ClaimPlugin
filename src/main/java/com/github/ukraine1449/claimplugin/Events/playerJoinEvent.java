package com.github.ukraine1449.claimplugin.Events;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {
ClaimPlugin plugin;

    public playerJoinEvent(ClaimPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) throws Exception {
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){
        }
    }

}
