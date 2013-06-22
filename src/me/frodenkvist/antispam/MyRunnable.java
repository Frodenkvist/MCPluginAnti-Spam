package me.frodenkvist.antispam;

public class MyRunnable implements Runnable
{
	 //public static int taskID;
	 public AntiSpam plugin;
	 public SpamPlayer sp;
	 
	 public MyRunnable(AntiSpam instance, SpamPlayer sp)
	 {
		plugin = instance;
		this.sp = sp;
	 }
	 
	 @Override
	 public void run()
	 {
		 sp.setLastMessage(null);
	 }
}
