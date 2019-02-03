public class spell{
	
	public int damage;
	public int manaCost;
	public String name;

	public spell(int damage, String name){
		this.damage = damage;
		this.name = name;

		manaCost = (int)Math.pow(damage, 1.5);
	}
}