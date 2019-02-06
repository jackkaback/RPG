import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class character {

	private Scanner input = new Scanner(System.in);

	private worldMap map;

	//stats
	public String name;
	public int defence = 10;
	public int attack = 10;
	public int luck = 10;

	//equipment
	private weapon attacker;
	private armor defender;


	private item[] inventory = new item [30];
	private int lastItem = 0;

	//list of spells
	private ArrayList<spell> spellbook = new ArrayList<spell>();
	
	//leveling info
	public int level = 1;
	private int Exp = 0;

	//amount of points to distribute on level up
	private int lvlPoints;

	//threshold to level up
	private int expThreshold;


	//healh and mana stats
	private int maxHealth = 100;
	public int currHealth = 100;
	private int maxMana = 200;
	public int currMana = 200;

	public int gold = 10;

	private int[] location = {0,0};

	//initializer
	public character() {

		System.out.println("You find yourself in a dimly lit room as an old man helps you get off the floor.");
		System.out.print("The old man asks \"What's your name Stranger?\"\t");
		name = input.next();

		Goat();
		currHealth = maxHealth;

		worldMap map = new worldMap(35);
		spell temp = new spell(25, true, "Fireball");
		addSpell(temp);
	}



	public void Goat() {

		System.out.println("\n\nThe answers to the following questions will determine your initial stats\n");

		//Question 1
		while (true) {
			System.out.println("The old man asks how you got knocked out last night");
			System.out.println("(1) Bar fight [increases attack]\n(2) guard knocked me out [increases defence]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				attack += 5;
				break;
			}
			else if(ch1 == 2){
				defence += 5;
				break;
			}
		}

		System.out.println("The old man acknowledges your explanation\n");

		//Question 2
		while(true){
			System.out.println("\nThe old man now points to your scar and inquires about it");
			System.out.println("(1) blood letting [increases health]\n(2) stab wound [defence boost]\n(3) tripped on a stump [luck boost, ironically]");

			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				maxHealth += 20;
				break;
			}
			else if(ch1 == 2){
				defence += 5;
				break;
			}
			else if(ch1 == 3){
				luck += 1;
				break;
			}
		}

		//Question 3
		while (true) {
			System.out.println("\nHow long have you been in this land?");
			System.out.println("(1) not very long [increases health a lot]\n(2) quite awhile [increases defence and attack]");

			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				maxHealth += 40;
				break;
			}
			else if(ch1 == 2){
				defence += 5;
				attack += 5;
				break;
			}
		}
	}


	//TODO this
	public void mainLoop(){

		Random rand = new Random();

		//play the game while play has health
		while(currHealth > 0) {
			move();
			int temp = inCity();

			if(temp != -1){
				//CITY STUFF
				System.out.println("You're in " + map.cities[temp].cityName);
			}

			//MOSS PEOPLE STUFF
			else if(inMoss()){
				System.out.println("You've entered a moss colony");

			}

			else{
				//CHANCE FOR FIGHT
				if (rand.nextInt(10) == 1) {
					generateFight();
				}
			}

		}
	}

	private void move(){
		while(true){
			System.out.println("(N)orth, (S)outh, (E)ast, or (W)est");
			String temp = input.next().toLowerCase();

			if(temp.contains("n")){
				System.out.println("You move north");
				location[0]++;
				break;
			}
			else if(temp.contains("s")){
				System.out.println("You move south");
				location[0]--;
				break;
			}
			else if(temp.contains("e")){
				System.out.println("You move East");
				location[1]++;
				break;
			}
			else if(temp.contains("w")){
				System.out.println("You move West");
				location[1]--;
				break;
			}
		}
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
		if(attacker != null){
			removeWeapon();
		}

		attacker = weap;
		attack += attacker.getAttackBoost();
	}
	public void removeWeapon(){
		attack -= attacker.getAttackBoost();
		attacker = null;
	}

	//add or remove armor
	public void addArmor(armor arm){
		if(defender != null){
			removeArmor();
		}

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
				if(inventory[j-1].cost < inventory[j].cost) {
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
		sortInventory();
	}
	public void removeItem(int i){
		inventory[i] = null;
		sortInventory();
		lastItem--;
	}

	//prints the inventory
	public void printInventory(){
		for(int i = 0; i < lastItem; i++){

			//Prints the type of item
			if(inventory[i] instanceof armor){
				System.out.print("Armor:\t");
			}
			else if(inventory[i] instanceof weapon){
				System.out.print("Weapon:\t");
			}
			else if(inventory[i] instanceof potion){
				System.out.print("Potion:\t");
			}

			System.out.println(inventory[i].name);
		}
	}


	//Adds spell to spell book
	public void addSpell(spell newSpell){
		spellbook.add(newSpell);
	}

	//casts
	private int castSpell(int n){
		//takes the mana
		currMana -= spellbook.get(n).manaCost;
		
		//if damaging, returns the damage value
		if(spellbook.get(n).offensive){
			return spellbook.get(n).damage;
		}

		//if healing, just heal the character and return 0
		else{

			currHealth += spellbook.get(n).damage;
			if(currHealth > maxHealth){
				currHealth = maxHealth;
			}

			return 0;
		}
	}


	//TODO this
	private void generateFight(){
		monster Steve = new monster(level);

		while (currHealth > 0 && Steve.isAlive()){

		}
	}


	//checks if the user is in the moss colony
	private boolean inMoss(){
		return location == map.mossColony;
	}

	//checks if the user is in a city and returns which on they're in
	private int inCity(){

		//runs through every city in the map
		for(int i = 0; i < map.cities.length; i++) {
			if (location[0] == map.cities[i].x && location[1] == map.cities[i].y) {
				return i;
			}
		}

		//if not in a city then return -1
		return -1;
	}
}