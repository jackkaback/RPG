public class potion extends item{
	
	public int healthBoost;
	public int manaBoost;
	public String name;

	public potion(int healthBoost, int manaBoost, String name){
		this.healthBoost = healthBoost;
		this.manaBoost = manaBoost;
		this.name = name;

		cost = (int) ((healthBoost / 2) + (manaBoost /4));
	}
}