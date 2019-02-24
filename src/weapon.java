import java.util.Random;

public class weapon extends item{

	//initializer
	public weapon(int attackBoost, String weaponName){
		this.attackBoost = attackBoost;
		cost = attackBoost * 2;

		//no name causes it to generate a random name from a list
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
		String[] names = {"Umbra", "Normal Sword", "Stick", "rotten fish", "Rusty wooden dagger", "Sharpend spoon"};

		name = names[rand.nextInt(names.length)];
	}
}