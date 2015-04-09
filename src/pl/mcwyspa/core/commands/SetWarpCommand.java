package pl.mcwyspa.core.commands;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class SetWarpCommand extends Command {
	
	public SetWarpCommand() {
		super(new String[] {"setwarp"});
		super.setDescription("Ustawia warp");
		super.setUsage("setwarp <warp>");
		super.setPermission("mcwyspa.core.setwarp");
	}
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		if(args.length != 0){
			Player p = (Player)sender;
			Location l = p.getLocation();
			CorePlugin.createWarp(l.getX(), l.getY(), l.getZ(), l.getYaw(), l.getWorld().getName(), l.getPitch(), args[0], sender);
		}else{
			sender.sendMessage("/setwarp warp");
		}
	}

}
