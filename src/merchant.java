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
				armor t = new armor(randInt(minDefence, maxDefence + 1),
						randInt(minHealth, maxHealth), "");
				itemSupply[i] = t;
			}

			//weapon
			else if(temp == 2){
				weapon t = new weapon(randInt(minAttack, maxAttack + 1), "");
				itemSupply[i] = t;
			}

			//potion
			else{
				potion t = new potion(randInt(minHealth, maxHealth + 1),
						randInt(minMana, maxMana), "");
				itemSupply[i] = t;
			}
		}
	}

	private void initializeSpells(int lvl){
		int minAttack = 2 * lvl;
		int maxAttack = 5 * lvl;

		for(int i = 0; i < spellSupply.length; i++){
			int temp = rand.nextInt(2);

			//offensive spell
			if(temp == 1){
				spell s = new spell(randInt(minAttack, maxAttack + 1), true, "");
				spellSupply[i] = s;
			}

			//defensive spell
			else{
				spell s = new spell(randInt(minAttack, maxAttack + 1), false, "");
				spellSupply[i] = s;
			}
		}
	}

	private int randInt(int x, int y){
		return rand.nextInt(y - x) + x;
	}
}