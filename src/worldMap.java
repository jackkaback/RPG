import java.util.Random;

public class worldMap{
	public city[] cities;
	public int[] mossColony = {0,0};

	public worldMap(int size){
		generateCities(size);
		generateMossColony(size);
	}

	//Randomly spawns the cities and ensures that they don't overlap
	private void generateCities(int range){

		//names of the cities and the array of X/Y cordinates for the cities
		String[] names = new String [] {"John", "New Mombasa", "Seattle", "Seoul", "Yemen", "Vvardenfell", "Los Santos",
				"Shermer", "Mordor", "Rapture","Podgorica", "Ljubljana", "Elvenwood", "Megaton", "Hanover"};

		city[] cities = new city[names.length];
		int[] X = new int[cities.length];
		int[] Y = new int[cities.length];


		X[0] = 0;
		Y[0] = 0;

		Random rand = new Random();

		//genrates the cities
		for(int ii = 1; ii < X.length; ii++){

			X[ii] = rand.nextInt(2 * range + 1) - range;
			Y[ii] = rand.nextInt(2 * range + 1) - range;
		}

		//validating there's no overlap
		for(int jj = 0; jj < X.length; jj++){
			for(int ii = 0; ii < X.length; ii++){
				if (ii == jj) {
					continue;
				}
				if (X[ii] == X [jj] && Y [ii] == Y [jj]){
					X[ii] = rand.nextInt(2 * range + 1) - range;
					Y[ii] = rand.nextInt(2 * range + 1) - range;
					jj = 0;
					ii = 0;
				}
			}
		}


		//initializes the cities
		for(int ii = 0; ii < X.length; ii++){
			cities[ii] = new city(X[ii], Y[ii], names[ii]);
		}
	}

	//genarates the mossColony location
	private void generateMossColony(int range){

		//randomly places the moss colony
		Random rand = new Random();
		mossColony[0] = rand.nextInt(2 * range + 1) - range;
		mossColony[1] = rand.nextInt(2 * range + 1) - range;


		//makes sure it doesn't overlap with a city
		for(int jj = 0; jj < cities.length; jj++){

			if (cities[jj].x == mossColony[0] && cities[jj].y == mossColony[1]){
				mossColony[0] = rand.nextInt(2 * range + 1) - range;
				mossColony[1] = rand.nextInt(2 * range + 1) - range;
				jj = 0;
			}
		}
	}
}