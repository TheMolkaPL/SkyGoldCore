package pl.mcwyspa.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.skionz.pingapi.PingEvent;
import com.skionz.pingapi.PingListener;
import com.skionz.pingapi.PingReply;

public class ServerListPingListener implements PingListener {
	public void onPing(PingEvent event){
		PingReply reply = event.getReply();
		event.getReply().setMOTD(Bukkit.getMotd().replaceAll("&", ChatColor.COLOR_CHAR + ""));
        reply.setProtocolVersion(-1);
        reply.setProtocolName(ChatColor.GREEN + "McWyspa.pl" + ChatColor.RED + " * " + ChatColor.GRAY + "Graczy: " + ChatColor.GOLD + Bukkit.getOnlinePlayers().size());
	}
}
