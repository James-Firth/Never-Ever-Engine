class Room
{
	private String Description;
	private int monChance;
	private Monster roomMon;
	private int itemChance;
	private Room[] connections= new Room[4]; //[0]N,[1]S,[2]E,[3]W connections
	
	public Room(String about,int item)
	{
		Description = about;
		monChance = 0;
		roomMon = null;
		itemChance = item;
		connections = null;
		
	}
	
	public Room(String about, int mons, int itemchance, int direction, Room from)
	{
		Description = about;
		monChance = mons;
		this.itemChance = itemchance;
		connections[direction] = from;
	}
	
	
	
	/****************************************************/

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
	
	public String toString()
	{
		return "I am a room";
	}
	
}