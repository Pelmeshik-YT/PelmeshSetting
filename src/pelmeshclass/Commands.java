package pelmeshclass;

import javax.annotation.CheckReturnValue;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.w3c.dom.events.EventTarget;
import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class Commands implements CommandExecutor {

	private pelmeshsetting plugin;

    public Commands(pelmeshsetting plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("pelmeshsetting.pinfo")){
 sender.sendMessage(ChatColor.RED + "У вас нет прав на выполнение данной команды!");
 sender.sendMessage(ChatColor.RED + "Право, которое отсутствует: pelmeshsetting.info");
            return true;
        }
        if(args.length == 0){
        sender.sendMessage("Команда пишется так: /pinfo <player>");
            return true;
        }
        String name = args[0];
        Player p = Bukkit.getPlayer(name);
        if(p == null){
 sender.sendMessage(name + ChatColor.RED + " не в онлайне");
            return true;
        }

 sender.sendMessage(ChatColor.RED + name + ": ");
 sender.sendMessage(ChatColor.DARK_GREEN + "IP: " + p.getAddress().getAddress());
 sender.sendMessage(ChatColor.DARK_BLUE + "World: " + ChatColor.YELLOW + p.getWorld().getWorldFolder());
 sender.sendMessage("§cUUID: §e"+p.getUniqueId());
 sender.sendMessage("§cРежим: §e"+p.getGameMode());
 sender.sendMessage("§cИмеет ОП: §e"+p.isOp());
        return true;
    }
}