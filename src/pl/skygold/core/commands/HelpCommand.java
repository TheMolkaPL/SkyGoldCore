package pl.skygold.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import pl.skygold.core.CorePlugin;
import pl.themolka.cmds.command.Command;
import pl.themolka.cmds.command.Commands;

public class HelpCommand extends Command {
	
	CorePlugin plugin;
	
	public HelpCommand() {
		super(new String[] {"help"});
		super.setDescription("Pomoc");
		super.setUsage("help");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		this.printCommands(sender);
	}
	
	private void printCommands(CommandSender sender) {
		sender.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Pomoc:");
		
		for (Command command : Commands.getCommands()) {
			if (!command.hasPermission() || sender.hasPermission(command.getPermission())) {
				sender.sendMessage(ChatColor.GRAY + "/" + command.getName() + ChatColor.DARK_AQUA + " - " + ChatColor.GOLD + command.getDescription());
			}
		}
	}
}
