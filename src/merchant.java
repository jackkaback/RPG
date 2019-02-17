import java.util.Random;

public class merchant{
	private Random rand = new Random();
	private item[] itemSupply = new item[30];
	private spell[] spellSupply = new spell[10];

	public merchant(){
	}

	public void runStartUp(int lvl){
		initializeItems(lvl);
		initializeSpells(lvl);
	}

	private void initializeItems(int lvl){
		int minAttack = 2 * lvl;
		int maxAttack = 5 * lvl;

		int minDefence = 2 * lvl;
		int maxDefence = 5 * lvl;

		int minHealth = 40 * lvl;
		int maxHealth = 100 * lvl;

		int minMana = 20 * lvl;
		int maxMana = 40 * lvl;

		for(int i = 0; i < itemSupply.length; i++){
			int temp = rand.nextInt(3);

			//armor
			if(temp == 1){
				armor t = new armor(rand.nextInt(minDefence, maxDefence + 1),
					rand.nextInt(minHealth, maxHealth), "");
				itemSupply[i] = t;
			}
			
			//weapon
			else if(temp == 2){
				weapon t = new weapon(rand.nextInt(minAttack, maxAttack + 1), "");
				itemSupply[i] = t;
			}

			//potion
			else{
				potion t = new potion(rand.nextInt(minHealth, maxHealth + 1),
					rand.nextInt(minMana, maxMana), "");
				itemSupply[i] = t;
			}
		}
	}

	private void initializeSpells(int lvl){

	}
}