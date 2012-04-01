package com.github.nitai50;

import java.util.Date;

import org.bukkit.block.Block;

public class DBC {
	public Date date;
	public Block block;
	public Boolean change; // true for placed, false for destroyed.
	public DBC(Date date, Block block, Boolean change) {
		this.date = date;
		this.block = block;
		this.change = change;
	}
}
