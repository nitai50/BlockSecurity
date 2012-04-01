package com.github.nitai50;

import java.util.Date;

import org.bukkit.entity.Player;

public class PDC {
	public Player player;
	public Date date;
	public Boolean change;
	public int prvBlock; // Only ID.
	public PDC(Player player, Date date, Boolean change, int prvBlock) {
		this.player = player;
		this.date = date;
		this.change = change;
		this.prvBlock = prvBlock;
	}
}
