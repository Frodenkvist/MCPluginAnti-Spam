package me.frodenkvist.antispam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ChatListener implements Listener
{
	public static AntiSpam plugin;
	
	public ChatListener(AntiSpam instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerChatEvent(PlayerChatEvent event)
	{
		SpamPlayer sp = plugin.players.get(event.getPlayer().getName());
		if(sp.getLastMessage() == null)
		{
			sp.setLastMessage(event.getMessage());
			int id = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new MyRunnable(plugin,sp), 20L*4);
			sp.setRunnableID(id);
			plugin.players.put(sp.getPlayer().getName(), sp);
		}
		else if(sp.getLastMessage().equalsIgnoreCase(event.getMessage()))
		{
			int count = sp.getCounter();
			++count;
			if(count >= 3)
			{
				sp.getPlayer().kickPlayer("Make Love, Not Spam!");
				return;
			}
			else
			{
				sp.setCounter(count);
			}
		}
		else
		{
			plugin.getServer().getScheduler().cancelTask(sp.getRunnableID());
			sp.setLastMessage(event.getMessage());
			int id = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new MyRunnable(plugin,sp), 20L*4);
			sp.setRunnableID(id);
			plugin.players.put(sp.getPlayer().getName(), sp);
		}
	}
	
	@EventHandler
	public void onPlayerLoginEvent(PlayerLoginEvent event)
	{
		SpamPlayer sp = new SpamPlayer(event.getPlayer());
		plugin.players.put(event.getPlayer().getName(), sp);
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event)
	{
		SpamPlayer sp = new SpamPlayer(event.getPlayer());
		plugin.players.remove(sp);
	}
}
