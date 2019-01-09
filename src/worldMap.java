public class worldMap{
	public city[] cities = new city[];
	public int location = {0,0};

	public worldMap(int size){
		generateCities(size);
	}

	//Randomly spawns the cities and ensures that they don't overlap
	private void generateCities(int range){

		//names of the cities and the array of X/Y cordinates for the cities
		String[] names = new String [] {"John", "New Mombasa", "Seattle", "Seoul", "Yemen", "Vvardenfell", "Los Santos",
				"Shermer", "Mordor", "Rapture","Podgorica", "Ljubljana", "Elvenwood", "Megaton", "Hanover"};

		city[] cities = new city[names.length];
		int[] X = new int[c.length];
		int[] Y = new int[c.length];

		Random rand = new Random();

		//genrates the cities
		while(true){
			for(int ii = 1; ii < X.length; ii++){

				X[ii] = rand.nextInt(range) - 10;
				Y[ii] = rand.nextInt(range) - 10;
			}

			for(int jj = 0; jj < X.length; jj++){
				for(int ii = 0; ii < X.length; ii++){
					if (ii == jj) {
						continue;
					}
					if (X[ii] == X [jj] && Y [ii] == Y [jj]){
						X[ii] = rand.nextInt(range) - 10;
						Y[ii] = rand.nextInt(range) - 10;
						jj = 0;
						ii = 0;
					}
				}
			}
			break;
		}

		//initializes the cities
		for(int ii = 0; ii < X.length; ii++){
			cities[ii] = new city(X[ii], Y[ii], names[ii]);
		}
	}
}