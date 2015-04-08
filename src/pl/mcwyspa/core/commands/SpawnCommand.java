package pl.mcwyspa.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class SpawnCommand extends Command {
	public SpawnCommand() {
		super(new String[] {"spawn", "sapwn"});
		super.setDescription("Teleportacja na spawn");
		super.setUsage("spawn");
	}
	
	@Override
	public void handle(Player player, String label, String[] args) {
		player.teleport(CorePlugin.getSpawnLocation());
		player.sendMessage(CorePlugin.getTag() + ChatColor.GRAY + "Witamy na spawnie.");
	}
}
