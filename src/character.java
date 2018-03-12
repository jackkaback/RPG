public class character {

	public String name;
	public int defence;
	public int attack;
	public int luck;

	public int level = 1;
	public int Exp;
	public int lvlPoints;


	public int maxHealth;
	public int currHealth;
	public int maxMana;
	public int currMana;

	public int gold;

	//initializer
	public character(int defence, int attack, int Health, int luck, int mana, int Exp, String name){
		this.name = name;

		this.Exp = Exp;

		this.defence = defence;

		this.attack = attack;

		this.luck = luck;

		this.maxHealth = Health;

		this.currHealth = Health;

		this.maxMana = mana;

		this.currMana = mana;

		levelUp();
	}

	//Levels up the character based on XP and level
	public void levelUp(){

	}
}
