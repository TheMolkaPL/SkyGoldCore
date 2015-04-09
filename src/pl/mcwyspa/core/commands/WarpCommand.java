package pl.mcwyspa.core.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class WarpCommand extends Command {
	
	public WarpCommand() {
		super(new String[] {"warp"});
		super.setDescription("Lista warpow, teleportacja na warpa");
		super.setUsage("warp");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		if(args.length != 0){
			Player p = (Player)sender;
			CorePlugin.teleportToWarp(p, args[0]);
		}else{
			CorePlugin.listWarps(sender);
		}
	}

}
