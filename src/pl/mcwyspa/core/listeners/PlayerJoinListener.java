package pl.mcwyspa.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.mcwyspa.core.CorePlugin;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		event.setJoinMessage(null);
		CorePlugin.sendHeaderAndFooter(event.getPlayer());
	}

}
