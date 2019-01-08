public class armor{

	private int defenseBoost;
	private int healthBoost;
	private int cost;
	private String armorName;

	//initializer
	public armor(int defenseBoost, int healthBoost, int cost, String armorName){
		this.defenseBoost = defenseBoost;
		this.healthBoost = healthBoost;
		this.cost = cost;
		this.armorName = armorName;
	}

	public int getDefenseBoost() {
		return defenseBoost;
	}

	public int getHealthBoost() {
		return healthBoost;
	}

	public int getCost() {
		return cost;
	}

	public String getArmorName() {
		return armorName;
	}
}
