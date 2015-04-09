package pl.mcwyspa.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pl.mcwyspa.core.ConfigManager.RConfig;
import pl.mcwyspa.core.commands.DelWarpCommand;
import pl.mcwyspa.core.commands.GamemodeCommand;
import pl.mcwyspa.core.commands.HelpCommand;
import pl.mcwyspa.core.commands.SetSpawnCommand;
import pl.mcwyspa.core.commands.SetWarpCommand;
import pl.mcwyspa.core.commands.SpawnCommand;
import pl.mcwyspa.core.commands.WarpCommand;
import pl.mcwyspa.core.commands.WhoCommand;
import pl.mcwyspa.core.listeners.DropListener;
import pl.mcwyspa.core.listeners.PlayerJoinListener;
import pl.mcwyspa.core.listeners.PlayerQuitListener;
import pl.mcwyspa.core.listeners.SignListener;
import pl.themolka.cmds.Settings;
import pl.themolka.cmds.command.Commands;

public class CorePlugin extends JavaPlugin {
	
	protected static CorePlugin plugin;
	public Random random;
	public List<Material> durabilityFixAppliedItems = new ArrayList<Material>();
	public List<Material> durabilityFixSwords = new ArrayList<Material>();

	public void onEnable(){
		//Plugin
		plugin = this;
		
		//Config
		ConfigManager.registerConfig("spawn", "spawn.yml", this);
		ConfigManager.registerConfig("drop", "drop.yml", this);
		ConfigManager.registerConfig("warps", "warps.yml", this);
		
		//Listeners
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new PlayerQuitListener(), this);
		pm.registerEvents(new DropListener(), this);
		pm.registerEvents(new SignListener(), this);
		
		//Commands
		Settings.setup(this);
		Commands.register(this, HelpCommand.class);
		Commands.register(this, SpawnCommand.class);
		Commands.register(this, SetSpawnCommand.class);
		Commands.register(this, WhoCommand.class);
		Commands.register(this, GamemodeCommand.class);
		Commands.register(this, WarpCommand.class);
		Commands.register(this, SetWarpCommand.class);
		Commands.register(this, DelWarpCommand.class);
		
		//Random
		this.random = new Random();
		
		//Drop
	    this.durabilityFixAppliedItems.add(Material.WOOD_SWORD);
	    this.durabilityFixAppliedItems.add(Material.WOOD_PICKAXE);
	    this.durabilityFixAppliedItems.add(Material.WOOD_AXE);
	    this.durabilityFixAppliedItems.add(Material.WOOD_SPADE);
	    
	    this.durabilityFixAppliedItems.add(Material.STONE_SWORD);
	    this.durabilityFixAppliedItems.add(Material.STONE_PICKAXE);
	    this.durabilityFixAppliedItems.add(Material.STONE_AXE);
	    this.durabilityFixAppliedItems.add(Material.STONE_SPADE);
	    
	    this.durabilityFixAppliedItems.add(Material.IRON_SWORD);
	    this.durabilityFixAppliedItems.add(Material.IRON_PICKAXE);
	    this.durabilityFixAppliedItems.add(Material.IRON_AXE);
	    this.durabilityFixAppliedItems.add(Material.IRON_SPADE);
	    
	    this.durabilityFixAppliedItems.add(Material.GOLD_SWORD);
	    this.durabilityFixAppliedItems.add(Material.GOLD_PICKAXE);
	    this.durabilityFixAppliedItems.add(Material.GOLD_AXE);
	    this.durabilityFixAppliedItems.add(Material.GOLD_SPADE);
	    
	    this.durabilityFixAppliedItems.add(Material.DIAMOND_SWORD);
	    this.durabilityFixAppliedItems.add(Material.DIAMOND_PICKAXE);
	    this.durabilityFixAppliedItems.add(Material.DIAMOND_AXE);
	    this.durabilityFixAppliedItems.add(Material.DIAMOND_SPADE);

	    this.durabilityFixSwords.add(Material.WOOD_SWORD);
	    this.durabilityFixSwords.add(Material.STONE_SWORD);
	    this.durabilityFixSwords.add(Material.IRON_SWORD);
	    this.durabilityFixSwords.add(Material.GOLD_SWORD);
	    this.durabilityFixSwords.add(Material.DIAMOND_SWORD);
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
	
	public static int randomAmount(int minAmount, int maxAmount){
		return (int)Math.round(Math.random() * (maxAmount - minAmount) + minAmount);
	}
	
	public static void givePlayerDrop(Collection<ItemStack> items, Player player, Location dropLocation){
		if (items != null) {
			ItemStack[] itemBoard = new ItemStack[items.size()];
			for (int i = 0; i < items.size(); i++) {
				itemBoard[i] = ((ItemStack)((ArrayList<ItemStack>) items).get(i));
			}
			player.getInventory().addItem(itemBoard);
		}
	}
	
	public static void recalculateDurability(Player player) {
		ItemStack item = player.getItemInHand();
		Integer enchantLevel = Integer.valueOf(item.getEnchantmentLevel(Enchantment.DURABILITY));
		Integer random = randomAmount(0, 100);
		if ((plugin.durabilityFixAppliedItems.contains(item.getType())) && ((enchantLevel.intValue() == 0) || (random.intValue() <= 100 / (enchantLevel.intValue() + 1)))) {
			if (plugin.durabilityFixSwords.contains(item.getType())) {
				if (item.getDurability() + 2 >= item.getType().getMaxDurability()) {
					player.getInventory().clear(player.getInventory().getHeldItemSlot());
					player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
				} else {
					item.setDurability((short)(item.getDurability() + 2));
				}
			} else if (item.getDurability() + 1 >= item.getType().getMaxDurability()) {
				player.getInventory().clear(player.getInventory().getHeldItemSlot());
				player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
			} else {
				item.setDurability((short)(item.getDurability() + 1));
			}
			player.updateInventory();
		}
	}
	
	public static double getDropChance(String item){
		return ConfigManager.getConfig("drop").getDouble(item);
	}
	
	public boolean isWarpExits(String warp){
		if(ConfigManager.getConfig("warps").contains(warp)){
			return true;
		}else{
			return false;
		}
	}
	
	public Location getWarpLoc(String warp){
		if(isWarpExits(warp)){
			Location loc = new Location(null, 0, 0, 0);
			loc.setX(ConfigManager.getConfig("warps").getDouble(warp + ".x"));
			loc.setY(ConfigManager.getConfig("warps").getDouble(warp + ".y"));
			loc.setZ(ConfigManager.getConfig("warps").getDouble(warp + ".z"));
			loc.setYaw(ConfigManager.getConfig("warps").getInt(warp + ".yaw"));
			loc.setWorld(Bukkit.getWorld(ConfigManager.getConfig("warps").getString(warp + ".world")));
			loc.setPitch(ConfigManager.getConfig("warps").getInt(warp + ".pitch"));
			return loc;
		}
		return null;
		
	}
	
	public static void teleportToWarp(Player player, String warp){
		if(plugin.isWarpExits(warp)){
			if(player.isOnline()){
				player.teleport(plugin.getWarpLoc(warp));
				player.sendMessage(getTag() + "§cZostales przeteleportowany do §6" + warp + "§7.");
			}
		}else{
			player.sendMessage(getTag() + "§cTaki warp nie istnieje.");
		}
	}
	
	public static void createWarp(Double x, Double y, Double z, float yaw, String world, float pitch, String warp, CommandSender sender){
		if(plugin.isWarpExits(warp)){
			sender.sendMessage("Taki warp juz istnieje.");
			return;
		}
		ConfigManager.getConfig("warps").set(warp + ".x", x);
		ConfigManager.getConfig("warps").set(warp + ".y", y);
		ConfigManager.getConfig("warps").set(warp + ".z", z);
		ConfigManager.getConfig("warps").set(warp + ".yaw", yaw);
		ConfigManager.getConfig("warps").set(warp + ".world", world);
		ConfigManager.getConfig("warps").set(warp + ".pitch", pitch);
		sender.sendMessage("§7Warp zostal stworzony.");
		ConfigManager.saveAll();
		return;
	}
	
	public static void delWarp(String warp, CommandSender sender){
		if(!plugin.isWarpExits(warp)){
			sender.sendMessage("Taki warp nie istnieje.");
			return;
		}
		ConfigManager.getConfig("warps").set(warp, null);
		sender.sendMessage("§7Warp zostal usuniety.");
		ConfigManager.saveAll();
		return;
	}
	
	public static void listWarps(CommandSender sender){
		Set<String> warpy = ConfigManager.getConfig("warps").getKeys(false);
		String list = "";
		for(String warp : warpy){
			list += "§7" + warp + "§6,";
		}
		sender.sendMessage("§a[SkyGold.pl] §cLista warpow:");
		sender.sendMessage(list);
	}
	  
}
