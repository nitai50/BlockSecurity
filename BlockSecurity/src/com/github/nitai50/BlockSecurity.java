package com.github.nitai50;

<<<<<<< HEAD

import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

import org.bukkit.block.Block;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

>>>>>>> 0f973839df23a5966d9c0028d2379393d765b231
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockSecurity extends JavaPlugin{
	Logger log;
<<<<<<< HEAD
	BlockSecurityCommandExecutor ce;
	public static HashMap<Player, LinkedList<DBC>> data = new HashMap<Player, LinkedList<DBC>>();
	public static HashMap<Block, LinkedList<PDC>> blockData = new HashMap<Block, LinkedList<PDC>>();
	// public static HashMap<Date, LinkedList<PBC>> dateData = new HashMap<Date, LinkedList<PBC>>();
	
	public void onEnable() {
		log = this.getLogger();	
		log.info("has been enabled!");
		new BlockSecurityListener(this);
		ce = new BlockSecurityCommandExecutor(this);
		getCommand("writeDB").setExecutor(ce);
		getCommand("rollback").setExecutor(ce);
	}
	public void onDisable() {
		log.info("has been disabled!");
=======
	public static HashMap<Player, ArrayList<Set>> data = new HashMap<Player, ArrayList<Set>>();
	public void onEnable() {
		log = this.getLogger();
		log.info("[BlockSecurity] has been enabled!");
	}
	public void onDisable() {
		log.info("[BlockSecurity] has been disabled!");
>>>>>>> 0f973839df23a5966d9c0028d2379393d765b231
	}
}
