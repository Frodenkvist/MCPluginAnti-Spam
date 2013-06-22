package me.frodenkvist.antispam;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiSpam extends JavaPlugin
{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static AntiSpam plugin;
	public final ChatListener cl = new ChatListener(this);
	public final HashMap<String,SpamPlayer> players = new HashMap<String,SpamPlayer>();
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.cl, this);
	}
	
}
