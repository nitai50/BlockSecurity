package com.github.nitai50;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BlockSecurityCommandExecutor implements CommandExecutor {
	private BlockSecurity plugin;
	public BlockSecurityCommandExecutor(BlockSecurity plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("writeDB")) {
			S.writeDB(BlockSecurity.data, (Player)sender);
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("rollback")) {
				Iterator<Entry<Block, LinkedList<PDC>>> iterator = BlockSecurity.blockData.entrySet().iterator();
				while(iterator.hasNext()) {
					plugin.log.info("3");
					Map.Entry<Block, LinkedList<PDC>> entry = iterator.next();
					if(S.distance(((Player)sender).getLocation(), entry.getKey().getLocation()) < Integer.parseInt(args[0])) {
						entry.getKey().setTypeId(entry.getValue().get(0).prvBlock);
					}
				}
			}
		return false;
	}

}