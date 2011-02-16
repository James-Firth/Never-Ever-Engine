
/**
 *This file deals with the loading and saving of characters
 * @author James
 */
import java.io.*;
import java.util.Scanner;

public class FileOperations 
{


	//TODO Save as a binary file
 public static void Save(Player player)
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
                for(i=1; i < (stats).length; i++){
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
 public static Player Load()
 { //loads the character's file (plaintext)
        Scanner Input = new Scanner(System.in);
        Player player;
        Player decoy = new Player();
        String strFile;
        String charName;
        int[] stats = new int[9];
        String cmd="";
        System.out.println("Enter your old character's name:");
        strFile = (Input.nextLine());
        cmd = strFile.toLowerCase();
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
             	for(i=1; i < 9; i++)
             	{
             		stats[i]= Read.nextInt();
             		//System.out.println(stats[i]); //debug
             	}
             	player = new Player(charName, stats, "Load");
             	System.out.println(player.toString()); //test
                System.out.println("File loaded Successfully.");
                System.out.println("\n");
                return player;
         	}
         catch (FileNotFoundException e) 
         	{
               e.printStackTrace();
         	}
         

        }
        else if(cmd.equals(".."))
        {
        	System.out.println("Returning to menu.");
        	mainMenu.Menu();
        }
        else
        {
           System.out.println("That character does not exist");
           Load();
        }
//        Story.Start();
        return decoy;
   }
 
}
