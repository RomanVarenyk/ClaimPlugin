package com.github.ukraine1449.claimplugin.Events;

import com.github.ukraine1449.claimplugin.ClaimPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

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
                event.setCancelled(true);
                if(!plugin.listOfPotClaims.containsKey(player.getUniqueId())){
                    plugin.listOfPotClaims.put(player.getUniqueId(), event.getClickedBlock().getLocation());
                    player.sendMessage(ChatColor.GREEN + "Mark a second point");
                }else{
                    int xTotal = plugin.listOfPotClaims.get(player.getUniqueId()).getBlockX() + event.getClickedBlock().getLocation().getBlockX();
                    int zTotal = plugin.listOfPotClaims.get(player.getUniqueId()).getBlockZ() + event.getClickedBlock().getLocation().getBlockZ();
                    if(xTotal+zTotal <= plugin.selectUD(player.getUniqueId().toString(), 0)){

                    }else{
                        player.sendMessage(ChatColor.DARK_AQUA + "You do not have enough claim blocks to claim this. If you believe this is a mistake please contact the server admins and if issues persist contact Ukraine#1449 on discord or ukraine1449@gmail.com");
                    }
                    //Add check for if there is less then or equal to ammount of blocks set in max. ask rickard maybe he knows? 2 points possibility of negatives.
                    try{
                        plugin.postCD(player.getUniqueId().toString(), 0, event.getClickedBlock().getChunk().toString(), event.getClickedBlock().getWorld().toString(), plugin.listOfPotClaims.get(player.getUniqueId()).getBlockX(), event.getClickedBlock().getX(), plugin.listOfPotClaims.get(player.getUniqueId()).getBlockZ(), event.getClickedBlock().getZ(), null, player.getName()+ "'s claim at " + event.getClickedBlock().getLocation(), "null", 1);
                        plugin.listOfPotClaims.remove(player.getUniqueId());
                    }catch (Exception e){
                        e.printStackTrace();
                        player.sendMessage("Something went wrong with the claiming proccess. Please ask the admins to check the console for the error and contact Ukraine#1449 (discord) for support if issues persist");
                    }
                }
            }
        }
    }

}
