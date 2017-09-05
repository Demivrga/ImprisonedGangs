package com.ImprisonedGangs.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ImprisonedCore.Database.DatabaseManager;
import com.ImprisonedGangs.GangsMain;
import com.ImprisonedGangs.Gangs.GangManager;

public class CreateGang implements CommandExecutor {

	public GangsMain pl;
	List<String> GangMods = new ArrayList<String>();
	List<String> GangMembers = new ArrayList<String>();

	public CreateGang(GangsMain instance) {
		pl = instance;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String lbl, String[] args) {

		Player p = (Player) cs;
		UUID u = p.getUniqueId();

		if (lbl.equalsIgnoreCase("creategang")) {

			if (DatabaseManager.PlayerGang(u) == null) {

				GangManager.storeGang(p.getUniqueId(), "TestGang", p.getName(), GangMods, "X", GangMembers, 0);
				DatabaseManager.updatePlayerGang(u, "TestGang");

			} else {
				
				p.sendMessage("You are already in a gang! stapppph");
				
			}

		}
		return false;

	}

}
