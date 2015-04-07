package pl.skygold.core.commands;

import org.bukkit.command.CommandSender;
import pl.themolka.cmds.command.Command;

public class SpawnCommand extends Command {
    public SpawnCommand() {
        super(new String[] {"spawn"});
        super.setDescription("Teleportacja na spawn");
        super.setUsage("spawn");
    }
    
    @Override
    public void handle(CommandSender sender, String label, String[] args) {
        sender.sendMessage("test");
    }
}
