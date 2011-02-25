import java.io.*;
import java.util.Scanner;
public class RoomHandling
{

	public static void startGame()
	{
		String about = "You are in appears to be an oubliette but emerge through the hole in a large cavern."
							+"\nThere are exits all around.";
		Room start = new Room(about,2);
		mainMenu.help();
		Movement.enterRoom(start);
	}
	
	public static Room generateRoom(int from, Room fromR)
	{
		Room.count++;
		Room theRoom = new Room(randomizeDescription(),randomNum(50),0,from,fromR);
		return theRoom;
	}
	
	public static String randomizeDescription()
	{
		return "Some Room";
	}
	public static void randomizeItems()
	{
		
	}
	
	//Monster(String mName, int HP, int mStr, int mDef, int mHit, int mCon, int mDex, int att, int dchance, int speC)
	public static Monster randomizeMonsters()
	{
		int which = (int)(Math.random()*12+1);
			Monster mon;
		if(which >= 10)
			mon = new Monster("Orc",randomNum(20),randomNum(20),randomNum(20),randomNum(20),randomNum(11),randomNum(8),randomNum(50),randomNum(50),randomNum(0));
		if(which == 9)
		{
		mon = new Monster("Dragon",120,randomNum(50),randomNum(50),randomNum(50),randomNum(20),randomNum(20),randomNum(50),randomNum(50),randomNum(0));
		}
		else
		{
			mon = new Monster("Kobold",randomNum(10),randomNum(10),randomNum(10),randomNum(10),randomNum(5),randomNum(11),randomNum(50),randomNum(50),randomNum(0));
		}
		
		return mon;
		
	}
	
	public static int randomNum(int max)
	{
		int num = (int)(Math.random()*max);
		return num;
	}
	
	public static String[] read(String filetype)
	{
		String strFile = filetype;
		String[] Blah = null;
		int filelength=0;
     	try {
			filelength = count(strFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File file = new File(strFile);
        if (file.exists() == true)
        {

            //System.out.println("Loading...");

         try{
        	 Scanner Read = new Scanner(file);
				for(int i=0; i < filelength;i++)
        	 	{
        	 		Blah[i] = Read.nextLine();
        	 	}
         	}
         catch (FileNotFoundException e) 
         	{
               e.printStackTrace();
         	}
         

        }
        else
        {
           System.out.println("ERROR! CONFIG FILE MISSING");
        }
		return Blah;
	}
	
	public  static int count(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    byte[] c = new byte[1024];
	    int count = 0;
	    int readChars = 0;
	    while ((readChars = is.read(c)) != -1) {
	        for (int i = 0; i < readChars; ++i) {
	            if (c[i] == '\n')
	                ++count;
	        }
	    }
	    return count;
	}
}