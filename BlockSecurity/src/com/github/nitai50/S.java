package com.github.nitai50;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class S {
	public static void save(Object object, JavaPlugin plugin, String name) throws FileNotFoundException, IOException {
		File dataFolder = plugin.getDataFolder();
		if(!dataFolder.isDirectory()) dataFolder.mkdir();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFolder + "/" + name));
		oos.writeObject(object);
		oos.flush();
		oos.close();
	}
	public static Object load (JavaPlugin plugin, String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dataFolder = plugin.getDataFolder();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFolder+ "/" + name));
		Object object = ois.readObject();
		ois.close();
		return object;
	}
	public static void writeDB(HashMap<Player, LinkedList<DBC>> db, Player player) {
		Iterator<Entry<Player, LinkedList<DBC>>> iterator = db.entrySet().iterator();
		String string;
		while(iterator.hasNext()) {
			String trueorfalse;
			Map.Entry<Player, LinkedList<DBC>> entry = (Map.Entry<Player, LinkedList<DBC>>)iterator.next();
			player.sendMessage(ChatColor.RED + "" + entry.getValue().size());
			for (int i = 0; i < entry.getValue().size(); i++) {
				LinkedList<DBC> list = entry.getValue();
				if(list.get(i).change) trueorfalse = "placed";
				else trueorfalse = "broke";
				Block b = list.get(i).block;
				string = String.format("%s %s the %s block at %s at %s",
						entry.getKey().getName(),
						trueorfalse,
						b.getType().toString(),
						b.getLocation().toString(),
						list.get(i).date.toString());
				player.sendMessage(string);
			}
		}
	}
	
	public static int distance (Location l1, Location l2) {
		return (int) Math.sqrt((l1.getX() - l2.getX()) * (l1.getX() - l2.getX()) + (l2.getY() - l1.getY()) * (l2.getY() - l1.getY()));
	}
	
	@SuppressWarnings("deprecation")
	public static String getNormalTime(Date date) {
		return String.format("%d:%d:%d %d.%d.%d", date.getHours(), date.getMinutes(), date.getSeconds(), date.getDate(), date.getMonth(), date.getYear());
	}
}
