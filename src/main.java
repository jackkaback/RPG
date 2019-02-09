import java.util.Scanner;
import java.util.Random;


public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		character user = new character();

		//TODO build item list
		while (true) {
			System.out.println("So what do you do?");
			System.out.println("(1) Blacksmith [better starting sword]\n(2) Banker [extra starting money]\n(3) Knight [better armor]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1) {
				weapon zeWeapon = new weapon(60, "Umbra");
				user.addInventory(zeWeapon);
				user.addWeapon(zeWeapon);
				break;
			} else if (ch1 == 2) {
				user.gold += 1000;
				break;
			} else if (ch1 == 3) {
				armor zeArmor = new armor(10, 100, "black mesa");
				user.addInventory(zeArmor);
				user.addArmor(zeArmor);
				break;
			}
		}

		user.mainLoop();
		playCredits(user.currHealth > 0);

		System.out.print("Continue? ");
		String temp = input.next().toLowerCase();

		if(temp.contains("y")){
			user.mainLoop();
		}
	}

	//write the credits. add timer between parts of credits add people's specific contributions to the credits
	public static void playCredits(Boolean victory){
		
		if(victory){
			System.out.println("You won!");
		}

		else{
			System.out.println("You died");
		}

		System.out.println("Programming: Jack and Talons");
		
		System.out.println("Translation:\n" +
				"French: Micheal and Matt C.\n" +
				"Spanish: Jack\n" +
				"German: Rachel");
		
		System.out.println("Ideas:\n" +
				"Evil shoebox: He who shall not be named\n" + //add
				"Random axe salesman: Dennis ''The Paw'' Salo (he wanted to be known as 'the paw' then complained about the names stuipdity)\n" +//add
				"Quoting the politically correct beggar: Brandon\n" + //add
				"Antique road show, punny axe salesman, make moss people speak multiple languages: Michael");//add
	}
}