package me.frodenkvist.antispam;

import org.bukkit.entity.Player;

public class SpamPlayer
{
	private Player player;
	private String lastMessage;
	private int runnableID;
	private int counter;
	private float fork;

	public SpamPlayer(Player player)
	{
		this.player = player;
		lastMessage = null;
		counter = 0;
	}

	public Player getPlayer()
	{
		return player;
	}

	public String getLastMessage()
	{
		return lastMessage;
	}

	public void setLastMessage(String msg)
	{
		lastMessage = msg;
	}

	public int getRunnableID()
	{
		return runnableID;
	}

	public void setRunnableID(int id)
	{
		runnableID = id;
	}

	public int getCounter()
	{
		return counter;
	}

	public void setCounter(int counter)
	{
		this.counter = counter;
	}
}
