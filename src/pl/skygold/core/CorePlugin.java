package pl.skygold.core;

import org.bukkit.plugin.java.JavaPlugin;

import pl.skygold.core.commands.HelpCommand;
import pl.skygold.core.commands.SpawnCommand;
import pl.themolka.cmds.Settings;
import pl.themolka.cmds.command.Commands;

public class CorePlugin extends JavaPlugin {

	public void onEnable(){
		Settings.setup(this);
		Commands.register(this, HelpCommand.class);
		Commands.register(this, SpawnCommand.class);
	}
	
	public void onDisable(){
		Settings.destroy();
	}
}
