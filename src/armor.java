import java.util.Random;

public class armor extends item{

	private int defenseBoost;
	private int healthBoost;

	//initializer
	public armor(int defenseBoost, int healthBoost, String armorName){
		this.defenseBoost = defenseBoost;
		this.healthBoost = healthBoost;
		cost = healthBoost/2 + defenseBoost;

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
		String[] names = {"Some bent peice of metal", "Moss clothes"};

		name = names[rand.nextInt(names.length)];
	}
}
