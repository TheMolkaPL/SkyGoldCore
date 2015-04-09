package pl.mcwyspa.core.listeners;

import java.util.Collection;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import pl.mcwyspa.core.CorePlugin;

	//TODO: skopiowane ze starych toolsow, do poprawki 

public class DropListener implements Listener {

	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
	  public void onBlockBreak(BlockBreakEvent event)
	  {
	    if (!event.isCancelled()) {
	      Player player = event.getPlayer();
	      Block block = event.getBlock();
	      if (!player.getGameMode().equals(GameMode.CREATIVE)) {
	        Collection<ItemStack> playerDrops = block.getDrops(player.getInventory().getItemInHand());
	        event.setExpToDrop(0);
	        if(block.getType().equals(Material.WHEAT) || block.getType().equals(Material.SEEDS) || block.getType().equals(Material.NETHER_WARTS) || block.getType().equals(Material.MELON_STEM) || block.getType().equals(Material.PUMPKIN_STEM) || block.getType().equals(Material.CARROT) || block.getType().equals(Material.CROPS) || block.getType().equals(Material.POTATO)){
	        	block.breakNaturally();
	        	return;
	        }
	        if (block.getType().equals(Material.STONE) || block.getType().equals(Material.COBBLESTONE)) {
	          player.giveExp(CorePlugin.randomAmount(1, 3));
	            double ironRandom = Math.random() * 100.0D;
	            if ((ironRandom <= CorePlugin.getDropChance("iron"))) {
	              playerDrops.add(new ItemStack(Material.IRON_ORE, 1));
	              player.sendMessage(ChatColor.GRAY + "Znalazles zelazo !");
	              player.giveExp(10);
	              
	            }

	            double lapisRandom = Math.random() * 100.0D;
	            if ((lapisRandom <= CorePlugin.getDropChance("lapis"))) {
	              int amount = CorePlugin.randomAmount(2, 6);
	              playerDrops.add(new ItemStack(Material.INK_SACK, amount, (short) 4));
	              player.sendMessage(ChatColor.GOLD + "Znalazles "+ amount + " sztuki lapis !");
	              player.giveExp(6);
	            }

	            double wegielRandom = Math.random() * 100.0D;
	            if ((wegielRandom <= CorePlugin.getDropChance("coal"))) {
	              double fortuneRandom1 = Math.random() * 100.0D;
	              double fortuneRandom2 = Math.random() * 100.0D;
	              double fortuneRandom3 = Math.random() * 100.0D;
	              ItemStack wegiel = new ItemStack(Material.COAL, 1);
	              if ((30.0D <= fortuneRandom1) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 1)) {
	                wegiel.setAmount(2);
	              }
	              else if ((20.0D <= fortuneRandom2) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 2)) {
	                wegiel.setAmount(3);
	              }
	              else if ((10.0D <= fortuneRandom3) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 3)) {
	                wegiel.setAmount(4);
	              }
	              player.sendMessage(ChatColor.GRAY + "Znalazles " + wegiel.getAmount()+" sztuk wegla. [+2 exp]");
	              player.giveExp(2);
	              playerDrops.add(wegiel);
	            }


	            double goldRandom = Math.random() * 100.0D;
	            if (goldRandom <= CorePlugin.getDropChance("gold")) {
	              playerDrops.add(new ItemStack(Material.GOLD_ORE));
	              player.sendMessage(ChatColor.GOLD + "Znalazles zloto ! [+12 exp]");
	              player.giveExp(12);
	            }

	            double redstoneRandom = Math.random() * 100.0D;
	            if (redstoneRandom <= CorePlugin.getDropChance("redstone")) {
	              int amount = CorePlugin.randomAmount(1, 5);
	              playerDrops.add(new ItemStack(Material.REDSTONE, amount));
	              player.sendMessage(ChatColor.RED + "Znalazles " + amount + " redstone ! [+9 exp]");
	              player.giveExp(9);
	            }

	            double emeraldRandom = Math.random() * 100.0D;
	            if ((emeraldRandom <= CorePlugin.getDropChance("emerald"))) {
	              double fortuneRandom1 = Math.random() * 100.0D;
	              double fortuneRandom2 = Math.random() * 100.0D;
	              double fortuneRandom3 = Math.random() * 100.0D;
	              ItemStack emerald = new ItemStack(Material.EMERALD, 1);
	              if ((30.0D <= fortuneRandom1) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 1)) {
	                emerald.setAmount(CorePlugin.randomAmount(2, 3));
	              }
	              else if ((20.0D <= fortuneRandom2) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 2)) {
	                emerald.setAmount(CorePlugin.randomAmount(2, 4));
	              }
	              else if ((10.0D <= fortuneRandom3) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 3)) {
	                emerald.setAmount(CorePlugin.randomAmount(2, 5));
	              }
	              player.sendMessage(ChatColor.GREEN + "Znalazles " + emerald.getAmount() +" szmaragd ! [+40 exp]");
	              player.giveExp(40);
	              playerDrops.add(emerald);
	            }
	            double diamondRandom = Math.random() * 100.0D;
	            if (diamondRandom <= CorePlugin.getDropChance("diamond")) {
	              double fortuneRandom1 = Math.random() * 100.0D;
	              double fortuneRandom2 = Math.random() * 100.0D;
	              double fortuneRandom3 = Math.random() * 100.0D;
	              ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
	              if ((30.0D <= fortuneRandom1) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 1)) {
	                diamond.setAmount(CorePlugin.randomAmount(2, 3));
	              }
	              else if ((20.0D <= fortuneRandom2) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 2)) {
	                diamond.setAmount(CorePlugin.randomAmount(2, 5));
	              }
	              else if ((10.0D <= fortuneRandom3) && (player.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 3)) {
	                diamond.setAmount(CorePlugin.randomAmount(2, 6));
	              }
	              player.sendMessage(ChatColor.AQUA + "Znalazles " + diamond.getAmount() +" diament ! [+40 exp]");
	              player.giveExp(40);
	              playerDrops.add(diamond);
	            }
	        }
	        block.setType(Material.AIR);
	        CorePlugin.givePlayerDrop(playerDrops, player, event.getBlock().getLocation());
	        CorePlugin.recalculateDurability(player);
	      }
	    }
	  }
}
