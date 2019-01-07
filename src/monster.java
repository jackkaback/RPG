import java.util.Random;

public class monster {

	public String name;

	private Random rand = new Random();

	private int Lvl;
	private int HP;
	private int defense;
	private int attack;

	//initializer
	public monster(int LvL){
		this.Lvl = LvL;
		setAttack();
		setDefense();
		setHP();
		setName();
	}


	//TODO: This stuff
	private void setAttack(){

	}

	private void setDefense(){

	}

	private void setHP(){

	}

	//sets the name
	private void setName(){
		String[] arr = new String[]  {"loch ness monster", "guard", "mob of bunnies", "Gryffin", "goblin",
				"rotting fish", "thief", "canibal", "wolf", "MISSINGNO", "lost soul", "giant spider", "dragon", "giant",
				"dwarf on a unicycle", "moss person", "BEARSHARK", "Hobo weilding an eggroll", "mailbox"};

		name = arr[rand.nextInt((arr.length))];
	}
}