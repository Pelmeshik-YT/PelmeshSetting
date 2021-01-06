package pelmeshclass;

import org.bukkit.event.*;
import org.bukkit.event.weather.*;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;

public class EventListener implements Listener {
private pelmeshsetting plugin;

public EventListener(pelmeshsetting plugin) {
	this.plugin = plugin;
}

    @EventHandler
    public void EntityDamageEvent(final LeavesDecayEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noLeavesDecay")) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void EntityDamageEvent(final EntityDamageEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noDamage")) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void FoodLevelChangeEvent(final FoodLevelChangeEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noHunger")) {
            if (event.getFoodLevel() < 20) {
                event.setFoodLevel(20);
            }
            else {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void WeatherChangeEvent(final WeatherChangeEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noWeather") && event.toWeatherState()) {
            event.setCancelled(true);
    
        }
    }
    
    @EventHandler
    public void EntityExplodeEvent(final EntityExplodeEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noExplosion")) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void BlockIgniteEvent(final BlockIgniteEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noFire")) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void PlayerInteractEvent(final PlayerInteractEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noWheat") && event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.SOIL) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void PlayerKickEvent(final PlayerKickEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noMessages")) {
            event.setLeaveMessage("");
        }
    }
    
    @EventHandler
    public void PlayerDeathEvent(final PlayerDeathEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noMessages")) {
            event.setDeathMessage("");
        }
    }
    
    @EventHandler
    public void PlayerJoinEvent(final PlayerJoinEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noMessages")) {
            event.setJoinMessage("");
        }
	    if(this.plugin.getConfig().getBoolean("setting.hidePlayers")) {
            for (final Player pl : Bukkit.getOnlinePlayers()) {
                pl.hidePlayer(event.getPlayer());
                event.getPlayer().hidePlayer(pl);
            }
        }
    }
    
    @EventHandler
    public void PlayerQuitEvent(final PlayerQuitEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noMessages")) {
            event.setQuitMessage("");
        }
    }
    
    @EventHandler
    public void AsyncPlayerChatEvent(final AsyncPlayerChatEvent event) {
	    if(this.plugin.getConfig().getBoolean("setting.noChat")) {
            event.setCancelled(true);
        }
    }
}
