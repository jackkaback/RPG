public class weapon extends item{

	private int attackBoost;
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

	public String getWeaponName() {
		return weaponName;
	}
}