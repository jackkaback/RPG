import java.util.Random;

public class potion extends item{

	public potion(int healthBoost, int manaBoost, String potionName){
		this.healthBoost = healthBoost;
		this.manaBoost = manaBoost;
		
		//no name causes it to generate a random name from a list
		if(potionName == null || potionName.equals("")){
			generateName();
		}
		else{
			this.name = potionName;
		}

		cost = (int) ((healthBoost / 2) + (manaBoost /4));
	}

	private void generateName(){
		Random rand = new Random();
		String[] names = {"Elivor del vigor", "Vulgar"};

		name = names[rand.nextInt(names.length)];
	}
}