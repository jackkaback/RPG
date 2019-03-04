public class confusion extends ability{
	
	public confusion(int minTurns, int chanceToCast){
		this.minTurns = minTurns;
		maxTurns = (int) 2.5 * minTurns;
		this.chanceToCast = chanceToCast;
		name = "Confusion";
	}
}