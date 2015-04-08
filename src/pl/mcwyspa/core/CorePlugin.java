package pl.mcwyspa.core;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pl.mcwyspa.core.ConfigManager.RConfig;
import pl.mcwyspa.core.commands.GamemodeCommand;
import pl.mcwyspa.core.commands.HelpCommand;
import pl.mcwyspa.core.commands.SetSpawnCommand;
import pl.mcwyspa.core.commands.SpawnCommand;
import pl.mcwyspa.core.commands.WhoCommand;
import pl.mcwyspa.core.listeners.PlayerJoinListener;
import pl.mcwyspa.core.listeners.PlayerQuitListener;
import pl.themolka.cmds.Settings;
import pl.themolka.cmds.command.Commands;

public class CorePlugin extends JavaPlugin {

	public void onEnable(){
		//Config
		ConfigManager.registerConfig("spawn", "spawn.yml", this);
		
		//Listeners
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerQuitListener(), this);
		
		//Commands
		Settings.setup(this);
		Commands.register(this, HelpCommand.class);
		Commands.register(this, SpawnCommand.class);
		Commands.register(this, SetSpawnCommand.class);
		Commands.register(this, WhoCommand.class);
		Commands.register(this, GamemodeCommand.class);
	}
	
	public void onDisable(){
		Settings.destroy();
	}
	
	public static String getTag(){
		return ChatColor.GREEN + "[McWyspa.pl] ";
	}
	
	public static String getUncolouredTag(){
		return "[McWyspa.pl] ";
	}
	
	public static Location getSpawnLocation(){
		RConfig spawnCfg = ConfigManager.getConfig("spawn");
		Location spawn = new Location(null, 0, 0, 0);
		spawn.setX(spawnCfg.getDouble("x"));
		spawn.setY(spawnCfg.getDouble("y"));
		spawn.setZ(spawnCfg.getDouble("z"));
		spawn.setWorld(Bukkit.getWorld(spawnCfg.getString("world")));
		spawn.setYaw(spawnCfg.getInt("yaw"));
		spawn.setPitch(spawnCfg.getInt("pitch"));
		return spawn;
	}
	
	public static void setSpawnLocation(String world, double x, double y, double z, float yaw, float pitch){
		RConfig spawnCfg = ConfigManager.getConfig("spawn");
		spawnCfg.set("world", world);
		spawnCfg.set("x", x);
		spawnCfg.set("y", y);
		spawnCfg.set("z", z);
		spawnCfg.set("yaw", yaw);
		spawnCfg.set("pitch", pitch);
		try {
			spawnCfg.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
