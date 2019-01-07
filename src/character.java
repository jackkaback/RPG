import java.util.Scanner;
import java.lang.Math;

public class character {

	private Scanner input = new Scanner(System.in);

	public String name;
	public int defence;
	public int attack;
	public int luck;

	public int level = 1;
	public int Exp;

	//ammont of points to distribute on level up
	public int lvlPoints;

	//threshold to level up
	private int expThreshold;


	public int maxHealth;
	public int currHealth;
	public int maxMana;
	public int currMana;

	public int gold;

	//initializer
	public character(int defence, int attack, int Health, int luck, int mana, int Exp, String name) {
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

	//adds experience points
	public void addExp(int newExp) {
		Exp += newExp;
		levelUp();
	}


	//allows the distrobution of level up points
	private void addLvlPoints() {

		if (level % 10 == 0) {
			lvlPoints = 5;
		} else if (level % 5 == 0) {
			lvlPoints = 3;
		} else {
			lvlPoints = 2;
		}

	}


	//Levels up the character based on XP and level
	private void levelUp() {

		while (true) {
			expThreshold = Math.pow(1.5, level) * 100;
			if (Exp >= expThreshold) {
				Exp -= expThreshold;
				level++;
				System.out.println("You leveled up.");
				addLvlPoints();
			} else {
				break;
			}

		}
	}
}