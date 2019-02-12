public class spell{

	public int damage;
	public int manaCost;
	public boolean offensive;
	public String name;

	public spell(int damage, boolean offensive, String name){
		this.damage = damage;
		this.offensive = offensive;
		this.name = name;

		manaCost = (int)Math.pow(damage, 1.5);
	}
}