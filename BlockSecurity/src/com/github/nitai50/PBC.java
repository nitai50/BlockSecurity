package com.github.nitai50;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PBC {
	public Player player;
	public Block block;
	public Boolean changed;
	
	public PBC(Player player, Block block, Boolean changed) {
		this.player = player;
		this.block = block;
		this.changed = changed;
	}
}
