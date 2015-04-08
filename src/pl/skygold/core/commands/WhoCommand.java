package pl.skygold.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.skygold.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class WhoCommand extends Command {
	
	public WhoCommand() {
		super(new String[] {"who"});
		super.setDescription("Lista graczy online");
		super.setUsage("who");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		sender.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Na serwerze znajduje sie obecnie " + Bukkit.getOnlinePlayers().size() + " graczy online.");
		List<String> players = new ArrayList<>();
		for(Player p : Bukkit.getOnlinePlayers()){
			players.add(p.getName());
		}
		sender.sendMessage(StringUtils.join(players, ", "));
	}

}
