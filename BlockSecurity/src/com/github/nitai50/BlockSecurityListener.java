package com.github.nitai50;

<<<<<<< HEAD
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockSecurityListener implements Listener {
	BlockSecurity plugin;
	public BlockSecurityListener(BlockSecurity plugin)
	{
		this.plugin = plugin;
		//plugin.getLogger().info("1");
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockPlace(BlockPlaceEvent event){
		//plugin.getLogger().info("2");
// optional	//plugin.getLogger().info(event.getPlayer().getName() + " placed " + event.getBlock().getType().toString());
		Date date = new GregorianCalendar().getTime();
		Block block = event.getBlock();
		Player player = event.getPlayer();
		if(!BlockSecurity.data.containsKey(player)) {
			LinkedList<DBC> s = new LinkedList<DBC>();
			s.add(new DBC(date, block, true));
			BlockSecurity.data.put(player, s);
		} else {
			LinkedList<DBC> s = BlockSecurity.data.get(player);
			s.add(new DBC(date, block, true));
			BlockSecurity.data.remove(player);
			BlockSecurity.data.put(player, s);
		}
		if (!BlockSecurity.blockData.containsKey(block)) {
			LinkedList<PDC> v = new LinkedList<PDC>();
			v.add(new PDC(player, date, true, block.getTypeId()));
			BlockSecurity.blockData.put(block, v);
		} else {
			LinkedList<PDC> v = BlockSecurity.blockData.get(block);
			v.add(new PDC(player, date, true, block.getTypeId()));
			BlockSecurity.blockData.remove(block);
			BlockSecurity.blockData.put(block, v);
		}
//		if(!BlockSecurity.dateData.containsKey(date)) {
//			LinkedList<PBC> u = new LinkedList<PBC>();
//			u.add(new PBC(player, block, true));
//			BlockSecurity.dateData.put(date, u);
//		} else {
//			LinkedList<PBC> u = BlockSecurity.dateData.get(date);
//			u.add(new PBC(player, block, true));
//			BlockSecurity.dateData.remove(date);
//			BlockSecurity.dateData.put(date, u);
//		}
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void onBlockBreak(BlockBreakEvent event) {
// optianal	//plugin.getLogger().info(event.getPlayer().getName() + " broke " + event.getBlock().getType().toString());
		Date date = new GregorianCalendar().getTime();
		Block block = event.getBlock();
		Player player = event.getPlayer();
		if(!BlockSecurity.data.containsKey(player)) {
			LinkedList<DBC> s = new LinkedList<DBC>();
			s.add(new DBC(date, block, false));
			BlockSecurity.data.put(player, s);
		} else {
			LinkedList<DBC> s = BlockSecurity.data.get(player);
			s.add(new DBC(date, block, false));
			BlockSecurity.data.remove(player);
			BlockSecurity.data.put(player, s);
		}
		if (!BlockSecurity.blockData.containsKey(block)) {
			LinkedList<PDC> v = new LinkedList<PDC>();
			BlockSecurity.blockData.put(block, v);
		} else {
			LinkedList<PDC> v = BlockSecurity.blockData.get(block);
			v.add(new PDC(player, date, false, block.getTypeId()));
			BlockSecurity.blockData.remove(block);
			BlockSecurity.blockData.put(block, v);
		}
//		if(!BlockSecurity.dateData.containsKey(date)) {
//			LinkedList<PBC> u = new LinkedList<PBC>();
//			u.add(new PBC(player, block, false));
//			BlockSecurity.dateData.put(date, u);
//		} else {
//			LinkedList<PBC> u = BlockSecurity.dateData.get(date);
//			u.add(new PBC(player, block, false));
//			BlockSecurity.dateData.remove(date);
//			BlockSecurity.dateData.put(date, u);
//		}
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerInteract(PlayerInteractEvent event) {
		//plugin.log.info("1");
		Player player = event.getPlayer();
		if(!player.isOp()) return;
		if(event.getItem().getTypeId() != 347)
			return;
		//plugin.log.info("2");
		LinkedList<PDC> list = BlockSecurity.blockData.get(event.getClickedBlock());
		if(list == null) {
			// plugin.log.info("no-good");
			player.sendMessage("No history for this block!");
			return;
		}
		for (PDC pdc : list) {
			//plugin.log.info("4");
			String trueorfalse;
			if(pdc.change) trueorfalse = "placed";
			else trueorfalse = "broke";
			String str = String.format("%s has %s this block at %s",
					player.getName(),
					trueorfalse,
					S.getNormalTime(pdc.date));
			player.sendMessage(str);
		}
	}
	
}
=======
import org.bukkit.event.Listener;

public class BlockSecurityListener implements Listener {
	
}
>>>>>>> 0f973839df23a5966d9c0028d2379393d765b231
