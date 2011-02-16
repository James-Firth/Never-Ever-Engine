import java.util.Scanner;

// 0 1 2 3
// N S E W
public class Movement
{
	public static void enterRoom(Room room)
	{
		Scanner key = new Scanner(System.in);
		String input;
		if(room.monInRoom())
		{
		String mon = room.getMonster().getName();
		}
		
		//Prints out the players options
		System.out.println("Description: " + room.getDesc());
		if(Main.debug == true)
		{
			System.out.println("Your current Coordinates are ("+room.getHor()+","+room.getVert()+")");
			System.out.println("======null means the room isn't generated yet.====");
			
			System.out.println("To the North: " + room.getConnects()[0]);
			System.out.println("To the South: " + room.getConnects()[1]);
			System.out.println("To the East: " + room.getConnects()[2]);
			System.out.println("To the West: " + room.getConnects()[3]);
		}
		//Check if a monster appears each time they enter the room
		/*
		System.out.println((int)(Math.random()*100));
		System.out.println(room.getMonChance());
		System.out.println(room.getMonster());
		if((int)(Math.random()*100) > room.getMonChance());
		{
			System.out.println("HI");
			Monster tempMon =new Monster("kobold",10,3,4,50,50,0,0,0,0); //PLACEHOLDER REDO!
			room.killMon();
			room.addMonster(tempMon);
		}
		*/
		//Displays info if there's a monster or not
		if(!room.monInRoom())
		{
			System.out.println("Luckily there are no monsters here\n");
		}
		else
		{
			System.out.println("There's a "+room.getMonster()+" in the room!\n");
		}
		
		System.out.println("What will you do?");
		
		input = key.nextLine();
		input = input.toLowerCase();
		//Takes input and checks if it matches any of the options
		if(input.equals("help"))
				{
					mainMenu.help();
				}
		/***************NORTH*************/
		if(input.equals("north") || input.equals("n"))
		{
			//Since you look it creates a new room (Boring)
			try
			{
				if(Main.debug==true)
				System.out.println("To the north you see "+ room.getConnects()[0].getDesc()+" at:("+room.getConnects()[0].getHor()+","+room.getConnects()[0].getVert()+")"); //Then it tells you what is seen
				System.out.println("To the north you see " + room.getConnects()[0].getDesc());
			}catch(NullPointerException npe){
				Room nRoom = new Room("described",50,0,1,room);
				room.setConnect(0, nRoom); //It connects this new room to the north of the current one
				if(Main.debug==true)
				System.out.println("To the north you see "+nRoom.getDesc()+" at:("+room.getConnects()[0].getHor()+","+room.getConnects()[0].getVert()+")"); //Then it tells you what is seen
				System.out.println("To the north you see " + nRoom.getDesc()); //normal mode
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
				if(Main.debug==true)
				System.out.println("To the South is: "+room.getConnects()[1].getDesc()+" at:("+room.getConnects()[1].getHor()+","+room.getConnects()[1].getVert()+")");
				System.out.println("To the South you see " + room.getConnects()[1].getDesc());
			}catch(NullPointerException npe){
			Room sRoom = new Room ("Oh look a new room",0,0,0,room);
			room.setConnect(1,sRoom);
			if(Main.debug==true)
			System.out.println("To the South is " + sRoom.getDesc()+" at:("+room.getConnects()[1].getHor()+","+room.getConnects()[1].getVert()+")");
			System.out.println("To the South you see " + sRoom.getDesc()); //normal mode
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
				if(Main.debug==true)
			System.out.println("To the East is"+room.getConnects()[2].getDesc()+" at:("+room.getConnects()[2].getHor()+","+room.getConnects()[2].getVert()+")");
				System.out.println("To the East you see " + room.getConnects()[2].getDesc());
			}catch(NullPointerException npe){
			Room eRoom = new Room("SHINY",0,0,3,room);
			room.setConnect(2,eRoom);
			if(Main.debug==true)
			System.out.println("To the East is " + eRoom.getDesc()+" at:("+room.getConnects()[2].getHor()+","+room.getConnects()[2].getVert()+")");
			System.out.println("To the East you see " + eRoom.getDesc());//normal mode
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
				if(Main.debug==true)
				System.out.println("To the West is " + room.getConnects()[3].getDesc()+" at:("+room.getConnects()[3].getHor()+","+room.getConnects()[3].getVert()+")");
				System.out.println("To the West you see " + room.getConnects()[3].getDesc());
			}catch(NullPointerException npe){
			Room wRoom = new Room("DOOOM",0,0,2,room);
			room.setConnect(3,wRoom);
			if(Main.debug==true)
			System.out.println("To the West is " + wRoom.getDesc()+" at:("+room.getConnects()[3].getHor()+","+room.getConnects()[3].getVert()+")");
			System.out.println("To the West you see " + wRoom.getDesc());//normal mode
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
			
			try //checks if a room to the north exists. If not..
			{
				nRoom[0].equals(null);
			}catch(NullPointerException npe)
			{ ///... It'll make a new room for you and auto-connect them.
				nRoom[0] = RoomHandling.generateRoom(1,curRoom);
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
			Room[] eRoom = curRoom.getConnects();
			System.out.println("You went East");
			try //checks if a room to the north exists. If not..
			{ 
				eRoom[2].equals(null);
			}catch(NullPointerException npe)
			{ ///... It'll make a new room for you and auto-connect them.
				//eRoom[2] = RoomHandling.generateRoom(2,curRoom);
				eRoom[2] = new Room("An East Room",0,0,3,curRoom);
			}
			enterRoom(eRoom[2]); //Then you enter this new room!
		}
		if(to==3)
		{
			System.out.println("You went West");
			Room[] wRoom = curRoom.getConnects();
			//System.out.println(wRoom[3].getHor()+","+wRoom[3].getVert()+" OHMYGOOD"); //<-FOR TESTING WEST GLITCH
			try //checks if a room to the north exists. If not..
			{
				wRoom[3].equals(null);
			}catch(NullPointerException npe)
			{ ///... It'll make a new room for you and auto-connect them.
				//eRoom[2] = RoomHandling.generateRoom(2,curRoom);
				wRoom[3] = new Room("A West Room",0,0,2,curRoom);
			}
			enterRoom(wRoom[3]); //Then you enter this new room!
		}
		
	}
}