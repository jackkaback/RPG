public class city {
	public int x;
	public int y;
	public String cityName;

	private merchant merch;

	public city(int x, int y, String name) {
		this.x = x;
		this.y = y;
		cityName = name;
	}

	public quest generateQuest(int level){
		quest retQuest = new quest(x, y, level);
		return retQuest;
	}
}