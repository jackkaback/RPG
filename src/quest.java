import java.util.Random;

public class quest{
	
	public int[] destination = {0,0};
	public int[] start = {0,0};
	public boolean finshed = false;
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
	}
}