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
public class CommandHelp implements CommandExecutor {

	private pelmeshsetting plugin;

    public CommandHelp(pelmeshsetting plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("pelmeshsetting.help")){
 sender.sendMessage(ChatColor.RED + "У вас нет прав на выполнение данной команды!");
 sender.sendMessage(ChatColor.RED + "Право, которое отсутствует: pelmeshsetting.help");
 
        }
        
            if(args.length == 0)
            sender.sendMessage(ChatColor.RED + "Информация о сервере...");
            String s =	plugin.getConfig().getString("help.servername");
            s = s.replace("&", "\u00a7");
            sender.sendMessage(s);
            String q =	plugin.getConfig().getString("help.vk");
            q = q.replace("&", "\u00a7");
            sender.sendMessage(q);
            String w =	plugin.getConfig().getString("help.dc");
            w = w.replace("&", "\u00a7");
            sender.sendMessage(w);
            String e =	plugin.getConfig().getString("help.cmdreg");
            e = e.replace("&", "\u00a7");
            sender.sendMessage(e);
            String r =	plugin.getConfig().getString("help.cmdlog");
            r = r.replace("&", "\u00a7");
            sender.sendMessage(r);
            String spawn =	plugin.getConfig().getString("help.cmdspawn");
           spawn = spawn.replace("&", "\u00a7");
            sender.sendMessage(spawn);
            String menu =	plugin.getConfig().getString("help.menu");
           menu = menu.replace("&", "\u00a7");
            sender.sendMessage(menu);
            String t =	plugin.getConfig().getString("help.info");
            t = t.replace("&", "\u00a7");
            sender.sendMessage(t);
		return true;
            }
    }
   	

