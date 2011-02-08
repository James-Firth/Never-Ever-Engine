//Generic class for all Monsters
class Monster extends Character
	{
		private int attChance;
		private int defChance;
		private int specChance;
		Monster(String mName, int HP, int mDmg, int mDef, int att, int dchance, int speC)
		{
			name = mName;
			level = 0; 
			exp = 0;
			curHP = HP;
			maxHP = HP;
			dmg = mDmg;
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
		dmg = 0;
		def = 0;
		attChance = 0;
		defChance = 0;
		specChance = 0; 
		}
		public String toString()
		{
			return name;
		}
	}