package com.github.pommesfee.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.pommesfee.Main;

public class Command_SENDEXP implements CommandExecutor {

	private Main plugin;
	public Command_SENDEXP(Main bpp) 
	{
		plugin = bpp;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) 
	{
		
		//Command-SendXP
		if(cmd.getName().equalsIgnoreCase("sendxp"))
		{
			//Prüfen ob der Sender des Commands ein Spieler ist
			if(sender instanceof Player)
			{
				
				//Wenn Länge der Argumente falsch
				if(args.length != 2)
				{
					Player player = (Player) sender;
					player.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.AQUA + "Please check your syntax!");
					return false;
				}
				
				//Wenn Länge der Argumente richtig
				if(args.length == 2)
				{
					Player player = (Player) sender;
					Player target = this.plugin.getServer().getPlayer(args[0]);
					
						//Überprüfe ob Zielspieler online ist
						if(target != null)
						{
							int exp;
							//Mache aus EXP Anzahl eine Zahl
							try
							{
								exp = Integer.parseInt(args[1]);
							} 
							catch (NumberFormatException e) 
							{
								player.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.AQUA + "Please enter a valid amount of exp! ");
								return true;
							}
							
							//Soll nur funktioenieren wenn der der Spieler genügend Erharung hat
							if(exp <= player.getTotalExperience())
							{
								player.giveExp(-exp);
								target.giveExp(exp);
								player.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.GREEN + exp + ChatColor.AQUA +" expirience sucessfully sent to" + ChatColor.GREEN + target);
								target.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.AQUA + "You just recieved: " + ChatColor.GREEN + exp + ChatColor.AQUA + " experience from " + ChatColor.GREEN + player + ChatColor.AQUA + " !");
								return true;
							}
							else
							{
							player.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.AQUA + "You don't have that much expirience!");
								return true;
							}
						}
						else
						{
							player.sendMessage(ChatColor.GOLD + "[" + this.plugin.getDescription().getName() + "] " + ChatColor.AQUA + "The player: " + ChatColor.GREEN + args[0] + ChatColor.AQUA + " is not online!");
							return true;
						}
				}
			}
			else
			{
				sender.sendMessage("Only players are able to use this command!");
				return true;
			}
		}
		return false;
	}
}