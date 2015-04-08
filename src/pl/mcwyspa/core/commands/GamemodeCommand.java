package pl.mcwyspa.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.mcwyspa.core.CorePlugin;
import pl.themolka.cmds.command.Command;

public class GamemodeCommand extends Command {
	
	public GamemodeCommand() {
		super(new String[] {"gamemode", "gm"});
		super.setDescription("Zmiana trybu gry.");
		super.setUsage("gamemode");
		super.setPermission("mcwyspa.core.gamemode");
	}
	
	//TODO: odbugowac?
	
	@Override
	public void handle(CommandSender sender, String label, String[] args) {
		if(args.length == 1){
			Player player = (Player)sender;
			if(args[0] == "0"){
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry zmieniony na survival.");
			}else if(args[0] == "1"){
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry zmieniony na kreatywny.");
			}else if(args[0] == "2"){
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry zmieniony na przygode.");
			}else if(args[0] == "3"){
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry zmieniony na widza.");
			}else{
				player.sendMessage(CorePlugin.getTag() + ChatColor.RED + "Poprawne uzycie: /gamemode (0/1/2/3) (nick)");
			}
		}else if(args.length == 2){
			Player player = Bukkit.getPlayer(args[1]);
			if(player != null){
				if(args[0] == "0"){
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry gracza " + player.getName() + " zmieniony na survival.");
				}else if(args[0] == "1"){
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry gracza " + player.getName() + " zmieniony na kreatywny.");
				}else if(args[0] == "2"){
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry gracza " + player.getName() + " zmieniony na przygode.");
				}else if(args[0] == "3"){
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(CorePlugin.getTag() + ChatColor.WHITE + "Tryb gry gracza " + player.getName() + " zmieniony na widza.");
				}else{
					player.sendMessage(CorePlugin.getTag() + ChatColor.RED + "Poprawne uzycie: /gamemode (0/1/2/3) (nick)");
				}
			}else{
				sender.sendMessage(CorePlugin.getTag() + ChatColor.RED + "Podany gracz jest offline.");
			}
			
		}else{
			sender.sendMessage(CorePlugin.getTag() + ChatColor.RED + "Poprawne uzycie: /gamemode (0/1/2/3) (nick)");
		}
	}

}
