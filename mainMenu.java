import java.util.Scanner;

//This starts the game and deals with character creation.
public class mainMenu
	{
	
	public static Player Menu()
	{
		int[] stats = new int[3];
        String name;
		int input;
		Player decoy = new Player();
		Player player;
		boolean keep=false;
		Scanner inMenu = new Scanner(System.in);
		
		//Initial Output
        System.out.println("===============================================");
        System.out.println("Welcome to the Never-Ever Engine: example game");
        System.out.println("===============================================");
        System.out.println("                    by dark_james Feb 2011    ");
        System.out.println("MAIN MENU");
        System.out.println("1) New Character");
        System.out.println("2) Load Character");
        input = inMenu.nextInt();

            if(input == 1)
            {
                
            	while(!keep) //Loops until they say yes
            	{
            	player = createChar();
                System.out.println("Here is your character: "); 
                System.out.println(player.toString()); //Displays the character sheet
                System.out.println("Keep this character?");
                System.out.println("1) Yes");
                System.out.println("2) No");
            	input=0;
                input = inMenu.nextInt();
                	if(input == 1)
                	{
                		keep = true;//Save
                		FileOperations.Save(player);
                        return player;
                	}

            	}//while
            }
            if(input == 2){
              player = FileOperations.Load();
              return player;
            }
            else
            {
            System.out.println("ERROR in selection");
            }
            
            return decoy;

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
	
	
	//Generates stats, duh
	public static int[] genStats()
	{
		int[] stats = new int[3];
		for(int i=0; i < stats.length; i++)
	         stats[i] = (int)(Math.random() * (18 - 1 + 1)) + 1;
		
		return stats;
	}

}