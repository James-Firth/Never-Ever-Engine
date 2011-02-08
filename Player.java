import java.util.ArrayList;

class Player extends Character
{
	private ArrayList<String> items;
	private ArrayList<Integer> itemQuantity;
	
	
	//CONSTRUCTOR for new player
	Player(String pName, int[] stat)
	{
		name = pName;
		level = 0; 
		exp = 0;
		curHP = stat[0];
		maxHP = stat[0];
		dmg = stat[1];
		def = stat[2];
		items = new ArrayList<String>();
		itemQuantity = new ArrayList<Integer>();
	}
	
	//only happens if something messes up
	Player()
	{
		name = "ERROR";
	}
	
	//CONSTRUCTOR for loading a player
	Player(String pName, int[] stats, String load)
	{
		name = pName;
		level = stats[0]; 
		exp = stats[1];
		curHP = stats[2];
		maxHP = stats[3];
		dmg = stats[4];
		def = stats[5];
		items = new ArrayList<String>();
		itemQuantity = new ArrayList<Integer>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int[] getStatLine()
	{
		int[] statline = new int[6];
		statline[0] = level;
		statline[1] = exp;
		statline[2] = curHP;
		statline[3] = maxHP;
		statline[4] = dmg;
		statline[5] = def;
		
		return statline;
	}
	
	public String toString()
	{
		return "Name: " + name + "\n Level: " + level + "\n HP: " + curHP +"/" + maxHP + "\n Damage: " + dmg + 
		"\n Defense: " + def+"\n Experience: " + 
		exp ;
	}
	
	
}