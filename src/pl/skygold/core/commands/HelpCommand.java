package pl.skygold.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import pl.themolka.cmds.command.Command;
import pl.themolka.cmds.command.Commands;

public class HelpCommand extends Command {
    public HelpCommand() {
        super(new String[] {"help"});
        super.setDescription("Pomoc");
        super.setUsage("help");
        super.setVisible(false);
    }
    
    @Override
    public void handle(CommandSender sender, String label, String[] args) {
        this.printCommands(sender);
    }
    
    private void printCommands(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW + "======" + ChatColor.DARK_PURPLE + "=== Command List ===" + ChatColor.YELLOW + "======");
        sender.sendMessage(ChatColor.GREEN + "You have access to the following commands:");
        
        for (Command command : Commands.getCommands()) {
            if (!command.hasPermission() || sender.hasPermission(command.getPermission())) {
            	if(command.isVisible() == true){
            		sender.sendMessage(ChatColor.GREEN + "/" + command.getName() + ChatColor.GOLD + " - " + command.getDescription());
            	}
            }
        }
    }
}
