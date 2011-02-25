import java.util.Scanner;

public class Combat
{
	public static void comMenu(Room comRoom)
	{
		Scanner key = new Scanner(System.in);
		int input=0;
		Monster mon = comRoom.getMonster();
		
		//while(mon.isAlive() && Main.player.isAlive())
		//{
			System.out.println("There's a " + mon.getName()+ "(HP:"+mon.printHP()+") in the room! What do you do?");
			System.out.println("1) Attack the monster!");
			System.out.println("2) Defend against the monter");
			System.out.println("3) RUN AWAY!");
			input = key.nextInt();
			
			if(input ==1)
			{
				attack(mon);
				if(mon.isAlive())
				{
					monTurn(mon);
				}
			}
			if(input==2)
			{

				System.out.println("Current DEF:"+Main.player.getDef());
				Main.player.defend(); //Increase Def
				System.out.println("DEF after defending:"+Main.player.getDef());
				System.out.println("MONSTERS DO STUFF"); //Get attacked
				monTurn(mon);
				Main.player.defend(); //Lower Def again.
				System.out.println("DEF is lowered after monster's turn: "+Main.player.getDef());

			}
			if(input==3)
			{
				System.out.println("You run away!!!!");
				Movement.enterRoom(comRoom);
				
			}
		//}
			if(!mon.isAlive())
			{
				System.out.println("You killed the monster!");
				comRoom.killMon();
			}
			if(mon.isAlive())
			{
			comMenu(comRoom);
			}
	}
	
	public static void monTurn(Monster mon)
	{
		int whatDo = (int)(Math.random()*100);
		if(mon.isAlive())
		{
			if(mon.isDefending()) //if it's defending. Stop.
			{
				mon.defend();
			}
			//	Now will it attack or defend?
			if(mon.willAttack(whatDo) && !mon.dying())
			{
				monAttack(mon);
			}
			else
			{
				mon.defend();
				System.out.println("~~~DEFENSE MODE~~~");
			}
		}
	}
	
	public static void monAttack(Monster mon)
	{
		System.out.println("The "+mon.getName()+" attacks you!");
		int mhit = mon.hit();
		int pDodge = Main.player.dodge();
		if(mhit >= pDodge)
		{
			int dmg = Main.player.isHit(mon.getStr());
			System.out.println("It hits for "+dmg+" damage!");
			System.out.println(Main.player.getName()+" HP: "+Main.player.printHP());
		}
		else
		{
			System.out.println("... but it misses!");
		}
	}
	public static void attack(Monster mon)
	{
		System.out.println("You attack the "+mon.getName()+"!");
		int pHit = Main.player.hit();
		int mDodge = mon.dodge();
		if(Main.debug)
		{
			System.out.println("Player hit "+pHit+" vs Dodge:"+mDodge);
		}
		if(pHit >= mDodge)
		{
			int dmg;
			if(pHit >= 2*mDodge)
			{
				dmg = mon.isHit(2*Main.player.getDmg());
				System.out.println("~CRICITCAL!~");
			}
			else
			{
				dmg = mon.isHit(Main.player.getDmg());
			}
			System.out.println("Yout hit it for "+dmg+" points of damage!");

		}
		else
		{
			System.out.println("You miss! :(");
		}
		
	}
}