package com.github.pommesfee;

//import java.io.File;

//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pommesfee.commands.Command_SENDEXP;

public class Main extends JavaPlugin{

	public void onDisable() 
	{
		PluginDescriptionFile descFile = this.getDescription();
		
		//Informationen beim deaktivieren des Plugins
		System.out.println("[" + descFile.getName() + "] The Plugin has been disabled!");
	}
	public void onEnable() 
	{
		PluginDescriptionFile descFile = this.getDescription();
		
		//Informationen beim laden des Plugins
		System.out.println("[" + descFile.getName() + "] The Plugin has been enabled!");
		System.out.println("[" + descFile.getName() + "] Version: " + descFile.getVersion());
		System.out.println("[" + descFile.getName() + "] Created by: " + descFile.getAuthors());
		
/*
		//Config laden
		loadConfig();
 */		
		//Commands laden
		this.getCommand("sendxp").setExecutor(new Command_SENDEXP(this));
	}
	
/*	//config erstellen/laden...
	public FileConfiguration config;
	public void loadConfig() 
	{
			if(new File("plugins/SendXP/config.yml").exists())
			{			
				config = getConfig();
				config.options().copyDefaults(true);
				System.out.println("[" + descFile.getName() +"] Config.yml geladen.");	
			}
			else
			{
				saveDefaultConfig();
				config = getConfig();
				config.options().copyDefaults(true);
				System.out.println("[" + descFile.getName() + "] Config.yml erstellt und geladen.");
			}
	}
 */
}

