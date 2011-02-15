import java.util.ArrayList;

class Room
{
	public static int count=0;
	public static ArrayList<Room> roomList = new ArrayList<Room>();
	private String Description;
	private int monChance;
	private Monster roomMon;
	private int itemChance;
	private int vert;
	private int hor;
	private Room[] connections= new Room[4]; //[0]N,[1]S,[2]E,[3]W connections
	
	public Room(String about,int item)
	{
		Description = about;
		monChance = 0;
		roomMon = null;
		itemChance = item;
		vert = 0;
		hor = 0;
		roomMon = null;
		for(int i=0; i < connections.length; i++)
		{
		connections[i] = null;
		}
		roomList.add(this);
	}
	
	public Room(String about, int mons, int itemchance, int fromDir, Room from)
	{
		Description = about;
		monChance = mons;
		roomMon = null;
		this.itemChance = itemchance;
		//Sets coordinates <- CRUDELY
		if(fromDir == 0)
		{
		vert = (from.getVert()-1);
		hor = from.getHor();
		}
		if(fromDir == 1)
		{
		vert = (from.getVert()+1);
		hor = from.getHor();
		}
		
		if(fromDir == 2)
		{
			hor = (from.getHor()-1);
			vert = from.getVert();
		}
		if(fromDir == 3)
		{
			hor = (from.getHor()+1);
			vert = from.getVert();
		}
		connections[fromDir] = from;
		
		//Checks for neighbouring rooms
		for(int i=0; i < roomList.size(); i++)
		{
			Room temp = roomList.get(i); //temp room to be compared
		
			//check above
			if(temp.getHor() == hor && temp.getVert() == vert+1)
			{
				connections[0] = temp;
			}
			//Checks below
			if(temp.getHor() == hor && temp.getVert() == vert-1)
			{
				connections[1] = temp;
			}
			//checks east
			if(temp.getVert() == vert && temp.getHor() == hor+1)
			{
				connections[2] = temp;
			}
			//checks west
			if(temp.getVert() == vert && temp.getVert() == hor-1)
			{
				connections[3] = temp;
			}
		}
		//roomList.indexOf(get)
		roomList.add(this);
		
		//Prints out a list of all the rooms if in debug mode
		if(Main.debug==true)
		{
		System.out.println("ROOMLISTINGS");
		for(int i=0; i < roomList.size(); i++)
		{
			System.out.println(roomList.get(i).getHor()+","+roomList.get(i).getVert());
		}
		System.out.println("~~~~~~~~~~~");
		}
	}
	
	
	
	/****************************************************/

	public Room[] getConnects()
	{
		return connections;
	}
	public String getDesc()
	{
		return Description;
	}
	
	//Will calculate if a monster is there and sets it?
	public int getMonChance()
	{
		return monChance;
	}
	
	//grabs the monster in case the player comes back.
	public Monster getMonster()
	{
		Monster mon=new Monster();
		return mon;
	}
	
	
	//Randomizes if an item is there or not
	public int getItemChance()
	{
		return 0;
	}
	
	//returns Vertical Coordinate of the room
	public int getVert()
	{
		return vert;
	}
	//returns Horizontal Coordinate of the room
	public int getHor()
	{
		return hor;
	}
	/***********SETTERS**********/
	public void setConnect(int to,Room roomTo)
	{
		connections[to] = roomTo;
	}
	public String toString()
	{
		return "I am a room";
	}
	public void addMonster(Monster mon)
	{
		
		roomMon = mon;
	}
	public void killMon()
	{
		roomMon = null;
		System.out.println("Killed monster");
	}
	
}