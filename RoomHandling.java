import java.io.*;
import java.util.Scanner;
public class RoomHandling
{

	public static void startGame()
	{
		String about = "You enter what appears to be an oubliette but emerge through the hole in a large cavern."
							+"\nThere are exits all around. Where do you go?";
		Room start = new Room(about,2);
		Movement.enterRoom(start);
	}
	
	public static void randomizeDescription()
	{
		
	}
	public static void randomizeItems()
	{
		
	}
	public static void randomizeMonsters()
	{
		
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