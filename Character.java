//Generic class for players and monsters.
public class Character
{
	protected String name;
	protected int level;
	protected int curHP;
	protected int maxHP;
	protected int str; //Adds bonus to damage
	protected int hit; //Adds bonus to hit
	protected int con; //Increases maxHP
	protected int dex; //Dodging and Running
	protected int def; //Base armour
	protected int exp;
	protected boolean defending=false;
	protected boolean isAlive=true;
	
	public int dodge()
	{
		return (int)(Math.random()*100)+(int)(1.5*dex);
	}
	public String printHP()
	{
		return (curHP+"/"+maxHP);
	}
	public boolean isAlive()
	{
		return isAlive;
	}
}