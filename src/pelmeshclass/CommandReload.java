package pelmeshclass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import javax.annotation.CheckReturnValue;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.w3c.dom.events.EventTarget;
import org.bukkit.Bukkit;
import java.io.File;

@SuppressWarnings("unused")
public class CommandReload implements CommandExecutor {

	private pelmeshsetting plugin;

    public CommandReload(pelmeshsetting plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("pelmeshsetting.reload")){
 sender.sendMessage(ChatColor.RED + "У вас нет прав на выполнение данной команды!");
 sender.sendMessage(ChatColor.RED + "Право, которое отсутствует: pelmeshsetting.reload");
 
        }
        if(args.length == 0)
        plugin.reloadConfig();
        sender.sendMessage("Конфиг перезагружен...");
        plugin.getLogger() .info("Config reload...");
            return true;
        }

	private boolean equalsIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return false;
	}
    }	
