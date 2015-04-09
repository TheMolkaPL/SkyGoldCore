package pl.mcwyspa.core.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {

	@EventHandler
	public void onSign(SignChangeEvent event){
		if(event.getPlayer().hasPermission("mcwyspa.sign")){
			for (int i = 0; i <= 3; i++){
				event.setLine(i, event.getLine(i).replaceAll("&", "" + ChatColor.COLOR_CHAR));
			}
		}
	}
}
