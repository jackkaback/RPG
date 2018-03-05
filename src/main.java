import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int [] statBoost = new int [4];

		System.out.println("You find yourself in a dimly lit room as an old man helps you get off the floor.");
		System.out.print("The old man asks \"What's your name Stranger?\"\t");
		String name = input.next();

		Goat(statBoost, input);
		character user = new character(10+statBoost[0], 10+statBoost[1], 100+statBoost[2], 10+statBoost[3], 0, name);
	}

	public static void Goat(int[] stats, Scanner input) {
		//sets the stats to default values
		for (int ii = 0; ii < stats.length; ii++) {
			stats[ii] = 0;
		}

		System.out.println("\n\nThe answers to the following questions will determine your initial stats\n");

		//Question 1
		while (true) {
			System.out.println("The old man asks how you got knocked out last night");
			System.out.println("(1) Bar fight [increases attack] (2) guard knocked me out [increases defence]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				stats[1] += 5;
				break;
			}
			else if(ch1 == 2){
				stats[0] += 5;
				break;
			}
		}

		//Question 2

	}
}