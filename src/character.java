public class character {

	public int defence;
	public int attack;
	public int luck;
	public int level = 1;
	public int Exp;
	public int lvlPoints;


	public int maxHealth;
	public int currHealth;
	public int gold;

	//initializer
	public character(int defence, int attack, int Health, int luck, int Exp){
		this.Exp = Exp;
		this.defence = defence;
		this.attack = attack;
		this.luck = luck;
		this.maxHealth = Health;
		this.currHealth = Health;
		levelUp();
	}

	//Levels up the character baised on XP and level
	public void levelUp(){

	}
}
