public class weapon extends item{

	private int attackBoost;
	private String weaponName;


	//initializer
	public weapon(int attackBoost, String weaponName){
		this.attackBoost = attackBoost;
		cost = attackBoost * 2;
		this.weaponName = weaponName;
	}

	public int getAttackBoost() {
		return attackBoost;
	}

	public String getWeaponName() {
		return weaponName;
	}
}