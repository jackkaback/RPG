import java.util.Random;

public class quest{
	
	public int[] destination = {0,0};
	public int[] start = {0,0};
	public boolean finished = false;
	public int rewardGold;
	public int rewardXp;

	//initalizer
	//TODO set destination
	public quest(int x, int y, int lvl){
		Random rand = new Random();
		rewardXp = rand.nextInt(10 * lvl);
		rewardGold = rand.nextInt(10 * lvl);
		this.start[0] = x;
		this.start[1] = y;

		//sets the random destination outside the spawing city area
		destination[0] = rand.nextInt(70) + 35;
		destination[1] = rand.nextInt(70) + 35;

		if(rand.nextBoolean()){
			destination[0] = -destination[0];
		}
		if(rand.nextBoolean()){
			destination[1] = -destination[1];
		}
	}
}