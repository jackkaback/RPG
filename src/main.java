import java.util.Scanner;
import java.util.Random;


public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		worldMap map = new worldMap(35);

		character user = new character();

		//TODO build item list
		while (true) {
			System.out.println("So what do you do?");
			System.out.println("(1) Blacksmith [better starting sword]\n(2) Banker [extra starting money]\n(3) Knight [better armor]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1) {
				weapon steve = new weapon(60, "Umbra");
				user.addInventory(steve);
				user.addWeapon(steve);
				break;
			} else if (ch1 == 2) {
				user.gold += 1000;
				break;
			} else if (ch1 == 3) {
				armor steve = new armor(10, 100, "black mesa");
				user.addInventory(steve);
				user.addArmor(steve);
				break;
			}
		}
	}

	//TODO this
	public static void generateFight(character user){
		monster Steve = new monster(user.level);

	}
}