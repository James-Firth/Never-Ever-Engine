//Generic class for all Monsters
class Monster extends Character
	{
		private int attChance;
		private int defChance;
		private int specChance;
		
		Monster(String mName, int HP, int mStr, int mDef, int mHit, int mCon, int mDex, int att, int dchance, int speC)
		{
			name = mName;
			level = 0; 
			exp = 0;
			con=mCon;
			maxHP = setHP(HP);
			curHP = maxHP;
			str = mStr;
			hit=mHit;
			dex=mDex;
			def = mDef;
		attChance = att;
		defChance = dchance;
		specChance = speC;
		}
		
		Monster()
		{
		name = "GLITCH";
		level = 0; 
		exp = 10;
		curHP = 1;
		maxHP = 1;
		str = 0;
		hit= 0;
		con= 0;
		dex= 0;
		def = 0;
		attChance = 0;
		defChance = 0;
		specChance = 0; 
		}
		/******GETTERS***********/
		public String getName()
		{
			return name;
		}
		public String toString()
		{
			return name;
		}
		public int hit()
		{
			return hit;
		}
		public int getStr()
		{
			return str;
		}
		/******SETTERS**********/
		
		//Adds bonus HP based on con.
		public int setHP(int HP)
		{
			int total=0;
			total = HP + (int)(con/4);
			return total;
		}
		/******OTHER STUFF**********/
		public boolean willAttack(int check)
		{
			return (attChance >= check);
		}
		
		public boolean dying()
		{
			return (curHP <= (maxHP/4));
		}
		
		public void defend()
		{
			if(defending)
			{
				def -= (con/3)+2;
				defending = false;
			}
			else
			{
				def += (con/3)+2;
				defending = true;
			}
		}
		public boolean isDefending()
		{
			return defending;
		}
		
		public int isHit(int pdmg)
		{
			System.out.println("DMG:"+pdmg);
			System.out.println("DEF:"+def);
			int toDo = (pdmg-def);
			if (toDo <= 0)
			{
				//stays the same
			}
			else if(toDo > 0)
			{
			curHP = curHP-toDo;
				if(curHP < (-2*maxHP))
				{
					System.out.println("OVERKILL");
					curHP = 0;
				}
				else if (curHP < 0)
				{
					curHP = 0;
				}
			}
			
			
			if(curHP <= 0)
			{
				isAlive = false;
			}
			return (toDo);
		}
		
	}