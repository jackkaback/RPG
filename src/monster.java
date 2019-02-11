import java.util.Random;

public class monster {

	private String name;

	private Random rand = new Random();

	private int Lvl;
	private int HP;
	private int defense;
	private int attack;
	private int rewardExp;
	private int rewardGold;


	//initializer
	public monster(int LvL){
		this.Lvl = LvL;
		attack = rand.nextInt(Lvl * 3) + 1;
		defense = rand.nextInt(Lvl * 3);
		HP = rand.nextInt(Lvl * 10) + 20;
		ewardExp = attack + defense + HP;
		rewardGold = rand.nextInt(rewardExp) + 10;
		setName();
	}

	public int getAttack(){
		return attack;
	}

	//getter for the name
	public String getName() {
		return name;
	}

	public boolean isAlive(){
		return HP > 0;
	}

	//setter for the name
	private void setName(){
		String[] arr = new String[]  {"loch ness monster", "guard", "mob of bunnies", "Gryffin", "goblin",
				"rotting fish", "thief", "cannibal", "wolf", "MISSINGNO", "lost soul", "giant spider", "dragon", "giant",
				"dwarf on a unicycle", "moss person", "BEARSHARK", "Hobo weilding an eggroll", "mailbox"};

		name = arr[rand.nextInt((arr.length))];
	}


	//getter for reward xp
	public int getRewardExp(){
		return rewardExp;
	}

	//getter and setter for gold
	public int getRewardGold(){
		return rewardGold;
	}

	//takes a physical hit
	public void takePhysical(int playerAttack){
		int temp = playerAttack - defense;
		
		if (temp < 0){
			temp = 1;
		}

		HP -= temp;
		System.out.println("You swung for " + temp + " damage");
	}

	//takes spell damage
	public void takeSpell(int spellDamage){
		HP -= spellDamage;
		System.out.println("You dealt " + spellDamage + " damage to the " + name);
	}
}