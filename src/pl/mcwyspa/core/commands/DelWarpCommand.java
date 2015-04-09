package pl.mcwyspa.core.commands;

import org.bukkit.command.CommandSender;
import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class DelWarpCommand extends Command {
	
	public DelWarpCommand() {
		super(new String[] {"delwarp"});
		super.setDescription("Usun warp");
		super.setUsage("delwarp <warp>");
		super.setPermission("mcwyspa.core.delwarp");
		
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) throws CommandException {
		if(args.length != 0){
			CorePlugin.delWarp(args[0], sender);
		} else {
			throw new UsageException("Podaj nazwe warpu!");
		}
	}

}
