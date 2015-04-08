package pl.mcwyspa.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class SetSpawnCommand extends Command {
	public SetSpawnCommand() {
		super(new String[] {"setspawn"});
		super.setDescription("Ustaw spawn");
		super.setUsage("setspawn");
		super.setPermission("skygold.core.setspawn");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		Player player = (Player)sender; //nie usuwac, wali bledami O.o
		CorePlugin.setSpawnLocation(player.getWorld().getName(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
		player.sendMessage(CorePlugin.getTag() + ChatColor.GOLD + "Spawn ustawiony.");
	}
}
