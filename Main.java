import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
public class Main
{
	public static Player player;
	public static boolean debug;
	public static void main(String[] args)
	{	
		//Initialize variables
		int[] stats = new int[3];
		stats = genStats();
		Scanner Input = new Scanner(System.in);
		int in =0;
		debug = false; //defaults
		try
		{
		if(args[0].equals("--debug"))//enter debugmode
			debug=true;
			System.out.println("Running game in debugger mode");
		}catch(ArrayIndexOutOfBoundsException oob)
		{
			System.out.println("Starting game normally...");
		}
		
		player = mainMenu.Menu(); //New or Load screen
		
		if(debug==true)
		{
			while(in==0)
			{
				System.out.println("1) RoomHandling");
				System.out.println("2) Combat Testing");
				in = Input.nextInt();
				if(in == 1)
					RoomHandling.startGame();
				if(in == 2)
				{
					//Monster(String mName, int HP, int mStr, int mDef, int mHit, int mCon, int mDex, int att, int dchance, int speC)
					Monster kobold = new Monster("Kobold",1000,10,10,10,10,10,50,50,10);
					System.out.println(kobold.toString());
					//Monster is created properly
					String about = "You are in appears to be an oubliette but emerge through the hole in a large cavern."
						+"\nThere are exits all around.";
					Room start = new Room(about,2,kobold);
					//Monster doesn't seem to be assigned to room properly.
					Combat.comMenu(start);
				}
			}
		}
		else
		{
        RoomHandling.startGame();
		}
		System.out.println("END OF THE GAME SO FAR");
		
		
	}
	public static void Test()
	{
		int option=0;
		Scanner Input = new Scanner (System.in);
		while(option != 3)
		{
		System.out.println("Fight the Kobold?");
		System.out.println("1) Yes");
		System.out.println("2) Save Game");
		System.out.println("3) exit");
		option = Input.nextInt();
		if (option == 1)
			{
			//fight code
			}
		if (option == 2)
			{
				FileOperations.Save(player);
			}
		if (option == 3)
			{
				System.out.println("END GAME");
				System.exit(1);
			}
		}
		
	}
	public static void combat()
	{
		
	}
	
	//Generates a character
	//TODO: Add randomization for character names
	public static Player createChar()
	{
		//Initializes variables
		String name;
		int[] stats = genStats();
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("\n");
	    System.out.println("Enter your character name:");
	    name = in.nextLine();

		Player player = new Player(name, stats);
		
		return player;
	}
	
	//TODO Save as a binary file
	 public static void Save()
	 {
	        int i;
	        String x;
	        
	        //Saves File in plaintext
	        Scanner Input = new Scanner(System.in);
	        String strFile = player.getName().toLowerCase() + ".stats";
	        String newLine = System.getProperty("line.separator");
	        int[] stats = player.getStatLine();
	         try{
	                FileWriter fstream = new FileWriter(strFile);
	                fstream.write(player.getName()+newLine);
	                for(i=1; i < (stats).length; i++)
	                {
	                    fstream.write(stats[i]+newLine);
	                }
	                fstream.close();
	                System.out.println("File Saved.");
	         }
	            catch(Exception e){
	            System.err.println("Error: " + e.getMessage());
	        }
	   }

	 //TODO Has to load binary files too then
	 public static void Load()
	 { //loads the character's file (plaintext)
	        Scanner Input = new Scanner(System.in);
	        String strFile;
	        String charName;
	        int[] stats = new int[6];
	        
	        System.out.println("Enter your old character's name:");
	        strFile = (Input.nextLine());
	        strFile = strFile.toLowerCase() + ".stats";
	        
	         //Reads File
	        File file = new File(strFile);
	        if (file.exists() == true)
	        {

	            System.out.println("Loading...");

	         try{
	        	 Scanner Read = new Scanner(file);
	             	int i;
	             	charName = Read.nextLine();
	             	for(i=1; i < 6; i++)
	             	{
	             		stats[i]= Read.nextInt();
	             		System.out.println(stats[i]); //debug
	             	}
	             	player = new Player(charName, stats, "Load");
	             	System.out.println(player.toString()); //test
	                System.out.println("File loaded Successfully.");
	                System.out.println("\n");
	         	}
	         catch (FileNotFoundException e) 
	         	{
	               e.printStackTrace();
	         	}
	         

	        }
	        else
	        {
	           System.out.println("That character does not exist");
	           Load();
	        }
//	        Story.Start();
	   }



//Generates stats, duh
public static int[] genStats()
{
	int[] stats = new int[3];
	for(int i=0; i < stats.length; i++)
         stats[i] = (int)(Math.random() * (18 - 1 + 1)) + 1;
	
	return stats;
}

}//Main