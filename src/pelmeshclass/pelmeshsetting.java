package pelmeshclass;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class pelmeshsetting extends JavaPlugin {
	

	public void onEnable() {
    	
    	Bukkit.getPluginManager().registerEvents(new MessageJoin(this), this);
    	Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
    	getConfig();
    	getCommand("pinfo").setExecutor(new Commands(this));
    	getCommand("help").setExecutor(new CommandHelp(this));
    	getCommand("psreload").setExecutor(new CommandReload(this));
    	
        
        
    	
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
        	getConfig().options().copyDefaults(true);
        	saveDefaultConfig();
        }
        getLogger() .info("enabled!");
    	
 }	
    
    public void onDisable() {  	
    	getLogger().info("disabled!");
    }
    
}