package pelmeshclass;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@SuppressWarnings("unused")
public class MessageJoin implements Listener {
	
	private pelmeshsetting plugin;
	
	public MessageJoin(pelmeshsetting plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
	    if(this.plugin.getConfig().getBoolean("messages.enable")== true){
    String s =	plugin.getConfig().getString("messages.join");
    s = s.replace("&", "\u00a7");
    p.sendMessage(s);
    
	}
	} 
}