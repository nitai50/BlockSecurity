package com.github.nitai50;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bukkit.plugin.java.JavaPlugin;

public class Stream {
	public static void save(Object object, JavaPlugin plugin) throws FileNotFoundException, IOException {
		File dataFolder = plugin.getDataFolder();
		if(!dataFolder.isDirectory()) dataFolder.mkdir();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFolder + "/data.bin"));
		oos.writeObject(object);
		oos.flush();
		oos.close();
	}
	public static Object load (JavaPlugin plugin) throws FileNotFoundException, IOException, ClassNotFoundException {
		File dataFolder = plugin.getDataFolder();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFolder+ "/data.bin"));
		Object object = ois.readObject();
		ois.close();
		return object;
	}
}
