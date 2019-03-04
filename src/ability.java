public class ability{

	public int turnsRunning = 0;
	public int maxTurns;
	public int minTurns;
	public int chanceToCast;
	public int uses = 5;
	public String name;

	//TODO evertything involving this stuff
	public ability(){
	}

	public void setup(int minTurns, int chanceToCast, String name){
		this.minTurns = minTurns;
		maxTurns = (int) 2.5 * minTurns;
		this.chanceToCast = chanceToCast;
		this.name = name;
	}
}