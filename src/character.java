import java.util.Scanner;
import java.lang.Math;

public class character {

	private Scanner input = new Scanner(System.in);

	//stats
	public String name;
	public int defence;
	public int attack;
	public int luck;

	//equipment
	private weapon attacker;
	private armor defender;


	private item[] inventory = new item [30];
	private int lastItem = 0;

	//leveling info
	public int level = 1;
	private int Exp = 0;

	//amount of points to distribute on level up
	private int lvlPoints;

	//threshold to level up
	private int expThreshold;


	//healh and mana stats
	private int maxHealth;
	public int currHealth;
	public int maxMana = 200;
	private int currMana = 200;

	public int gold = 10;

	//initializer
	public character(int defence, int attack, int Health, int luck, String name) {
		this.name = name;
		this.defence = defence;
		this.attack = attack;
		this.luck = luck;
		this.maxHealth = Health;
		this.currHealth = Health;
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
				System.out.println("You leveled up!\nYou're lvl: " + level + " now");
				addLvlPoints();

				//set current HP and mana to max
				currMana = maxMana;
				currHealth = maxHealth;
			} else {
				break;
			}

		}
	}

	//add or remove weapon
	public void addWeapon(weapon weap){
		attacker = weap;
		attack += attacker.getAttackBoost();
	}
	public void removeWeapon(){
		attack -= attacker.getAttackBoost();
		attacker = null;
	}
	//add or remove armor
	public void addArmor(armor arm){
		defender = arm;
		defence += defender.getDefenseBoost();
		maxHealth += defender.getHealthBoost();
		currHealth += defender.getHealthBoost();
	}
	public void removeArmor(){
		defence -= defender.getDefenseBoost();
		maxHealth -= defender.getHealthBoost();
		currHealth -= defender.getHealthBoost();
		defender = null;
	}


	//sorts items by cost
	//bubble sort because it's small and I'm lazy
	private void sortInventory(){
		for(int i = 0; i < lastItem; i++) {
			for (int j = 1; j < (lastItem - i); j++) {
				if(inventory[j-1].getCost < inventory[j].getCost) {
					//swap elements
					item temp = inventory[j - 1];
					inventory[j - 1] = inventory[j];
					inventory[j] = temp;
				}
			}
		}
	}

	//Adding subtracting items
	public item[] getInventory() {
		return inventory;
	}
	public void addInventory(item newItem) {
		inventory[lastItem] = newItem;
		lastItem++;
		sortInventory;
	}
	public void removeItem(int i){
		inventory[i] = null;
		sortInventory();
		lastItem--;
	}
}