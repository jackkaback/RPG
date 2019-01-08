import java.util.Scanner;
import java.util.Random;


public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		//for the stat boost from the goat
		int[] statBoost = new int[4];


		//the assorted cities
		city[] cities = new city[15];
		generateCities(cities);


		System.out.println("You find yourself in a dimly lit room as an old man helps you get off the floor.");
		System.out.print("The old man asks \"What's your name Stranger?\"\t");
		String name = input.next();

		Goat(statBoost, input);

		character user = new character(10+statBoost[0], 10+statBoost[1], 100+statBoost[2], 10+statBoost[3], name);

		//TODO build item list
		while (true) {
			System.out.println("So what do you do?");
			System.out.println("(1) Blacksmith [better starting sword]\n(2) Banker [extra starting money]\n(3) Knight [better armor]");
			char ch1 = (char) input.nextByte();

			if (ch1 == 1) {

				break;
			} else if (ch1 == 2) {
				user.gold += 1000;
				break;
			} else if (ch1 == 3) {

				break;
			}


		}
	}

	public static void generateFight(character user){
		monster Steve = new monster(user.level);

	}

	//Randomly spawns the cities and ensures that they don't overlap
	public static void generateCities(city[] c){

		//names of the cities and the array of X/Y cordinates for the cities
		String[] names = new String [] {"John", "New Mombasa", "Seattle", "Seoul", "Yemen",
				"Vvardenfell", "Los Santos", "Shermer", "Mordor", "Rapture",
				"Podgorica", "Ljubljana", "Elvenwood", "Megaton", "Hanover"};
		int[] X = new int[c.length];
		int[] Y = new int[c.length];

		Random rand = new Random();

		//gnerates the cities
		while(true){
			for(int ii = 1; ii < X.length; ii++){

				X[ii] = rand.nextInt(21) - 10;
				Y[ii] = rand.nextInt(21) - 10;
			}

			for(int jj = 0; jj < X.length; jj++){
				for(int ii = 0; ii < X.length; ii++){
					if (ii == jj) {
						continue;
					}
					if (X[ii] == X [jj] && Y [ii] == Y [jj]){
						X[ii] = rand.nextInt(21) - 10;
						Y[ii] = rand.nextInt(21) - 10;
						jj = 0;
						ii = 0;
					}
				}
			}
			break;
		}

		//initializes the cities
		for(int ii = 0; ii < X.length; ii++){
			c[ii] = new city(X[ii], Y[ii], names[ii])
		}

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