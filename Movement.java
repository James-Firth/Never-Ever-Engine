import java.util.Scanner;

// 0 1 2 3
// N S E W
public class Movement
{
	public static void enterRoom(Room room)
	{
		Scanner key = new Scanner(System.in);
		String input;
		String mon = room.getMonster().getName();
		//Prints out the players options
	System.out.println("YOU ENTER: " + room.getDesc());
	System.out.println("NORTH CONNECT: " + room.getConnects()[0]);
		if(mon.equals("GLITCH"))
		{
			System.out.println("Luckily there are no monsters here\n");
		}
		else
		{
			System.out.println("There's a "+mon+" in the room!\n");
		}
		
		input = key.nextLine();
		input = input.toLowerCase();
		//Takes input and checks if it matches any of the options
		
		/***************NORTH*************/
		if(input.equals("north") || input.equals("n"))
		{
			//Since you look it creates a new room (Boring)
			Room nRoom = new Room("described",0,0,1,room);
			room.setConnect(0, nRoom); //It connects this new room to the north of the current one
			System.out.println("To the north you see "+nRoom.getDesc()); //Then it tells you what is seen
		}
		if(input.equals("go north") || input.equals("go n"))
		{
			move(0,room);
		}
		
		/**************SOUTH***************/
		if(input.equals("south") || input.equals("s"))
		{
			//go south code
			System.out.println("S: "+ room.getConnects()[1].getDesc());
			move(1,room);
		}
		if(input.equals("go south") || input.equals("go s"))
		{
			move(1,room);
		}
		
		/***********EAST*****************/
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
		enterRoom(room); //loops if nothing is selected
		
	}
	
	public static void move(int to, Room curRoom)
	{
		if(to==0)
		{
			Room[] nRoom = curRoom.getConnects();
			System.out.println("You went North");
			System.out.println("Room to the north" + nRoom[0]);
			
			try
			{
				nRoom[0].equals(null);
			}catch(NullPointerException npe)
			{
				nRoom[0] = RoomHandling.generateRoom(2,curRoom);
			}
			enterRoom(nRoom[0]);
		}
		
		if(to==1)
		{
			Room[] sRoom = curRoom.getConnects();
			System.out.println("You went South");
			try{
				sRoom[1].equals(null);
			}catch(NullPointerException npe)
			{
				sRoom[1] = RoomHandling.generateRoom(0, curRoom);
			}
			enterRoom(sRoom[1]);
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