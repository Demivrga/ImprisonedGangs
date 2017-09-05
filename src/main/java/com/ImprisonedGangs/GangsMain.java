package com.ImprisonedGangs;

import org.bukkit.plugin.java.JavaPlugin;

import com.ImprisonedGangs.Commands.CreateGang;

public class GangsMain extends JavaPlugin {

	public void onEnable() {

		this.getCommand("creategang").setExecutor(new CreateGang(this));

		
	}

	public void onDisable() {

	}
}
