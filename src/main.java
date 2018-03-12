import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int [] statBoost = new int [4];

		System.out.println("You find yourself in a dimly lit room as an old man helps you get off the floor.");
		System.out.print("The old man asks \"What's your name Stranger?\"\t");
		String name = input.next();

		Goat(statBoost, input);

		//TODO build item list
		while(true) {
			System.out.println("So what do you do?");
			System.out.println("(1) Blacksmith [better starting sword]\n(2) Banker [extra starting money\n(3) Knight [better armor]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1){

				break;
			}
			else if(ch1 == 2){

				break;
			}
			else if(ch1 == 3){

				break;
			}


		}
		character user = new character(10+statBoost[0], 10+statBoost[1], 100+statBoost[2], 10+statBoost[3], 200, 0, name);
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
			System.out.println("(1) Bar fight [increases attack]\n(2) guard knocked me out [increases defence]");
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

		System.out.println("The old man acknowledges your explanation\n");

		//Question 2
		while(true){
			System.out.println("\nThe old man now points to your scar and inquires about it");
			System.out.println("(1) blood letting [increases health]\n(2) stab wound [defence boost]\n(3) tripped on a stump [luck boost, ironically]");

			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				stats[2] += 20;
				break;
			}
			else if(ch1 == 2){
				stats[0] += 5;
				break;
			}
			else if(ch1 == 3){
				stats[3] += 1;
				break;
			}
		}

		//Question 3
		while (true) {
			System.out.println("\nHow long have you been in this land?");
			System.out.println("(1) not very long [increases health a lot]\n(2) quite awhile [increases defence and attack]");

			char ch1 = (char) input.nextByte();

			if (ch1 == 1){
				stats[2] += 40;
				break;
			}
			else if(ch1 == 2){
				stats[1] += 5;
				stats[0] += 5;
				break;
			}
		}
	}
}