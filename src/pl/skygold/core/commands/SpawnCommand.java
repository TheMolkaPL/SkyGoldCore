package pl.skygold.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.skygold.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class SpawnCommand extends Command {
	public SpawnCommand() {
		super(new String[] {"spawn"});
		super.setDescription("Teleportacja na spawn");
		super.setUsage("spawn");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player)sender;
			player.teleport(CorePlugin.getSpawnLocation());
			player.sendMessage(CorePlugin.getTag() + ChatColor.GRAY + "Witamy na spawnie.");
		}
	}
}
