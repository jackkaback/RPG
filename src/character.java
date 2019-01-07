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

	//amount of points to distribute on level up
	private int lvlPoints;

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


	//allows the distribution of level up points
	private void addLvlPoints() {

		//certain levels let players get more lives
		if (level % 10 == 0) {
			lvlPoints = 5;
		} else if (level % 5 == 0) {
			lvlPoints = 3;
		} else {
			lvlPoints = 2;
		}

		//distribute the points
		for(int ii = 0; ii < lvlPoints;){
			System.out.println("You have " + (lvlPoints - ii) + " points remaining");
			System.out.println("(A)ttack, (D)efense, (L)uck, (H)ealth, or (M)ana");

			String temp = input.nextLine().toLowerCase();
			if(temp.contains("a")){
				attack += 3;
				ii++;
			}
			else if(temp.contains("d")){
				defence += 3;
				ii++;
			}
			else if(temp.contains("l")){
				luck += 1;
				ii++;
			}
			else if(temp.contains("h")){
				maxHealth += 10;
				ii++;
			}
			else if(temp.contains("m")){
				maxMana += 10;
				ii++;
			}
			else{
				System.out.println("Invalid input");
			}
		}

	}


	//Levels up the character based on XP and level
	private void levelUp() {

		while (true) {
			expThreshold = (int) Math.pow(1.5, level) * 100;
			if (Exp >= expThreshold) {

				//removed over flowed EXP
				Exp -= expThreshold;
				level++;

				//level up
				System.out.println("You leveled up.");
				addLvlPoints();

				//set current HP and mana to max
				currMana = maxMana;
				currHealth = maxHealth;
			} else {
				break;
			}

		}
	}
}