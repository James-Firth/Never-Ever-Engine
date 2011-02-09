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
			try
			{
				System.out.println("To the north you see "+ room.getConnects()[0].getDesc()); //Then it tells you what is seen
			}catch(NullPointerException npe){
				Room nRoom = new Room("described",0,0,1,room);
				room.setConnect(0, nRoom); //It connects this new room to the north of the current one
				System.out.println("To the north you see "+nRoom.getDesc()); //Then it tells you what is seen
			}
		}
		if(input.equals("go north") || input.equals("go n"))
		{
			move(0,room);
		}
		
		/**************SOUTH***************/
		if(input.equals("south") || input.equals("s"))
		{
			//go south code
			try
			{
				System.out.println("To the South is: "+room.getConnects()[1].getDesc());
			}catch(NullPointerException npe){
			Room sRoom = new Room ("Oh look a new room",0,0,0,room);
			room.setConnect(1,sRoom);
			System.out.println("To the South is " + sRoom.getDesc());
			}
		}
		if(input.equals("go south") || input.equals("go s"))
		{
			move(1,room);
		}
		
		/***********EAST*****************/
		if(input.equals("east") || input.equals("e"))
		{
			//go east code
			try
			{
			System.out.println("To the East is"+room.getConnects()[2].getDesc());
			}catch(NullPointerException npe){
			Room eRoom = new Room("SHINY",0,0,3,room);
			System.out.println("To the East is " + eRoom.getDesc());
			room.setConnect(2,eRoom);
			}
		}
		if(input.equals("go east") || input.equals("go e"))
		{
			move(2,room);
		}
		
		
		/***********WEST********/
		if(input.equals("west") || input.equals("w"))
		{
			//go west code
			try
			{
				System.out.println("To the West is " + room.getConnects()[3].getDesc());
			}catch(NullPointerException npe){
			Room wRoom = new Room("DOOOM",0,0,2,room);
			System.out.println("To the West is " + wRoom.getDesc());
			room.setConnect(3,wRoom);
			}
		}
		if(input.equals("go west") || input.equals("go w"))
		{
			move(3,room);
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
			
			try //checks if a room to the north exists. If not..
			{
				nRoom[0].equals(null);
			}catch(NullPointerException npe)
			{ ///... It'll make a new room for you and auto-connect them.
				nRoom[0] = RoomHandling.generateRoom(2,curRoom);
			}
			enterRoom(nRoom[0]); //Then you enter this new room!
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