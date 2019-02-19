import java.util.Random;

public class weapon extends item{

	//initializer
	public weapon(int attackBoost, String weaponName){
		this.attackBoost = attackBoost;
		cost = attackBoost * 2;
		if(weaponName == null || weaponName.equals("")){
			generateName();
		}
		else{
			this.name = weaponName;
		}
	}

	public int getAttackBoost() {
		return attackBoost;
	}

	public String getWeaponName() {
		return name;
	}

	private void generateName(){
		Random rand = new Random();
		String[] names = {"Umbra", "Normal Sword"};

		name = names[rand.nextInt(names.length)];
	}
}