import java.util.Random;

public class armor extends item{
	
	//initializer
	public armor(int defenseBoost, int healthBoost, String armorName){
		this.defenseBoost = defenseBoost;
		this.healthBoost = healthBoost;
		cost = healthBoost/2 + defenseBoost;

		//no name causes it to generate a random name from a list
		if(armorName == null || armorName.equals("")){
			generateName();
		}
		else{
			this.name = armorName;
		}
	}

	public int getDefenseBoost() {
		return defenseBoost;
	}

	public int getHealthBoost() {
		return healthBoost;
	}

	public String getArmorName() {
		return name;
	}

	private void generateName(){
		Random rand = new Random();
		String[] names = {"Some bent peice of metal", "Moss clothes", "black mesa"};

		name = names[rand.nextInt(names.length)];
	}
}
