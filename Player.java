import java.util.ArrayList;

class Player extends Character
{
	private ArrayList<String> items;
	private ArrayList<Integer> itemQuantity;
	
	//STATS: LEVEL, XP, CURHP, MAXHP, STR, CON, DEX, HIT, DEF, 
	//          -    -   -     -       0    1   2     3    4
	//CONSTRUCTOR for new player
	Player(String pName, int[] stat)
	{
		name = pName;
		level = 0; 
		exp = 0;
		con=stat[1];
		maxHP = setHP(con);
		curHP = maxHP;
		str = stat[0];
		hit = stat[3];
		dex = stat[2];
		def = stat[4];
		items = new ArrayList<String>();
		itemQuantity = new ArrayList<Integer>();
	}
	
	//only happens if something messes up
	Player()
	{
		name = "ERROR";
	}
	
	//CONSTRUCTOR for loading a player
	//STATS: LEVEL, XP, CURHP, MAXHP, STR, CON, DEX, HIT, DEF,
	//          0   1     2      3     4     5   6     7   8 
	Player(String pName, int[] stats, String load)
	{
		name = pName;
		level = stats[0]; 
		exp = stats[1];
		curHP = stats[2];
		maxHP = stats[3];
		str = stats[4];
		con = stats[5];
		dex = stats[6];
		hit = stats[7];
		def = stats[8];
		items = new ArrayList<String>();
		itemQuantity = new ArrayList<Integer>();
	}
	/*********OTHER STUFF**********/
	public void defend()
	{
		if(defending)
		{
			def -= (con/3)+2;
			defending = false;
		}
		else
		{
			def += (con/3)+2;
			defending = true;
		}
	}
	
	//TODO fix this
	public int isHit(int mdmg)
	{
		int toDo = (mdmg-def);
		if (toDo <= 0)
		{
			toDo = 0;
			//stays the same
		}
		else if(toDo > 0) //if it actually does damage
		{
		curHP = curHP-toDo; //take away the damage from hp
			if(curHP < (-2*maxHP))
			{ //if it does more than twice your maxhp it's an overkill
				System.out.println("OVERKILL");
				curHP = 0;
			}
			else if (curHP < 0) //otherwise if you just die it sets hp to 0
			{
				curHP = 0;
			}
		}
		
		
		if(curHP <= 0)
		{
			isAlive = false;
		}
		return (toDo);
	}
	
	public int hit()
	{
		return (int)(Math.random()*100)+(2*hit);
	}
	
	public int getDmg()
	{
		return str;
	}
	/********SETTER************/
	private int setHP(int con)
	{
		int HP=0;
		HP = (int)((Math.random() * (20 - 1 + 1)) + 1) + (con/3);
		return con;
	}
	/*********GETTER**********/
	public String getName()
	{
		return name;
	}
	
	public int[] getStatLine()
	{
		int[] statline = new int[9];
		statline[0] = level;
		statline[1] = exp;
		statline[2] = curHP;
		statline[3] = maxHP;
		statline[4] = str;
		statline[5] = dex;
		statline[6] = con;
		statline[7] = hit;
		statline[8] = def;
		
		return statline;
	}
	
	public int getDef()
	{
		return def;
	}
	public String toString()
	{
		return "Name: " + name + "\n Level: " + level + "\n HP: " + curHP +"/" + maxHP + "\n STR: " + str + 
		"\n CON: " + con+"\n DEX: "+dex+"\n HIT: "+hit+ "\n DEF: "+def+"\n Experience: " + exp ;
	}
	
	
}