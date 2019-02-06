public class weapon extends item{

	private int attackBoost;


	//initializer
	public weapon(int attackBoost, String weaponName){
		this.attackBoost = attackBoost;
		cost = attackBoost * 2;
		this.name = weaponName;
	}

	public int getAttackBoost() {
		return attackBoost;
	}

	public String getWeaponName() {
		return name;
	}
}