public class weapon{

	private int attackBoost;
	private int cost;
	private String weaponName;


	//initializer
	public weapon(int attackBoost, int cost, String weaponName){
		this.attackBoost = attackBoost;
		this.cost = cost;
		this.weaponName = weaponName;
	}

	public int getAttackBoost() {
		return attackBoost;
	}

	public int getCost() {
		return cost;
	}

	public String getWeaponName() {
		return weaponName;
	}
}