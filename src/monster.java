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
		setAttack();
		setDefense();
		setHP();
		setName();
		setRewardExp();
		setRewardGold();
	}

	public int getAttack(){
		return attack;
	}

	private void setAttack(){
		attack = rand.nextInt(Lvl * 3) + 1;
	}

	private void setDefense(){
		defense = rand.nextInt(Lvl * 3);
	}

	private void setHP(){
		HP = rand.nextInt(Lvl * 10) + 20;
	}

	//getter and setter for the name
	public String getName() {
		return name;
	}

	public boolean isAlive(){
		return HP > 0;
	}

	private void setName(){
		String[] arr = new String[]  {"loch ness monster", "guard", "mob of bunnies", "Gryffin", "goblin",
				"rotting fish", "thief", "cannibal", "wolf", "MISSINGNO", "lost soul", "giant spider", "dragon", "giant",
				"dwarf on a unicycle", "moss person", "BEARSHARK", "Hobo weilding an eggroll", "mailbox"};

		name = arr[rand.nextInt((arr.length))];
	}


	//getter and setter for reward xp
	public int getRewardExp(){
		return rewardExp;
	}
	private void setRewardExp(){
		rewardExp = attack + defense + HP;
	}


	//getter and setter for gold
	public int getRewardGold(){
		return rewardGold;
	}
	private void setRewardGold(){
		rewardGold = rand.nextInt(rewardExp) + 10;
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