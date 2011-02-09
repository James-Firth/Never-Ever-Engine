import java.util.Scanner;
public class Movement
{
	public static void enterRoom(Room room)
	{
		Scanner key = new Scanner(System.in);
		String input;
		String mon = room.getMonster().getName();
		//Prints out the players options
		System.out.println(room.getDesc());
		if(mon.equals("GLITCH"))
		{
			System.out.println("Luckily there are no monsters here\n");
		}
		else
		{
			System.out.println("There's a "+mon+" in the room!\n");
		}
		
		input = key.next();
		input = input.toLowerCase();
		//Takes input and checks if it matches any of the options
		if(input.equals("north") || input.equals("n"))
		{
			//go north code
			System.out.println("N: "+"What's north");
		}
		if(input.equals("go north"))
			move(0,room);
		if(input.equals("south") || input.equals("s"))
		{
			//go south code
			System.out.println("S: "+"whatever is south");
			move(1,room);
		}
		
		if(input.equals("east") || input.equals("e"))
		{
			//go east code
			System.out.println("E: "+"Whatever's East");
			move(2,room);
		}
		
		if(input.equals("west") || input.equals("w"))
		{
			//go west code
			move(3,room);
			System.out.println("W: "+"Whatever's West");
		}
		
	}
	
	public static void move(int to, Room curRoom)
	{
		if(to==0)
		{
			System.out.println("You went North");
			Room nRoom = new Room("described",0,0,1,curRoom);
			enterRoom(nRoom);
		}
		if(to==1)
		{
			System.out.println("You went South");
			Room sRoom = new Room("described",0,0,0,curRoom);
			enterRoom(sRoom);
		}
		if(to==2)
		{
			System.out.println("You went East");
			Room eRoom = new Room("described",0,0,3,curRoom);
			enterRoom(eRoom);
		}
		if(to==3)
		{
			System.out.println("You went West");
			Room wRoom = new Room("described",0,0,2,curRoom);
			enterRoom(wRoom);
		}
		
	}
}