public class ability{

	public int turnsRunning = 0;
	public int maxTurns;
	public int minTurns;
	public int chanceToCast;
	public String name;

	//TODO evertything involving this stuff
	public ability(int minTurns, int chanceToCast){
		this.minTurns = minTurns;
		maxTurns = (int) 2.5 * minTurns;
		this.chanceToCast = chanceToCast;
	}
}