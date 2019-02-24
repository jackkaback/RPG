import java.util.Random;

public class spell{

	public int damage;
	public int manaCost;
	public boolean offensive;
	public String name;

	public spell(int damage, boolean offensive, String name){
		this.damage = damage;
		this.offensive = offensive;
		
		//no name causes it to generate a random name from a list
		if(name == null || name.equals("")){
			
			//offensive and defensive moves need different names
			if(offensive){
				generateNameDamging();
			}
			else{
				generateNameDefensive();
			}
		}
		
		else{
			this.name = name;
		}

		manaCost = (int)Math.pow(damage, 1.5);
	}

	private void generateNameDamging(){
		Random rand = new Random();
		String[] names = {"Fireball", "pew pew", "PEW", "death ray"};

		name = names[rand.nextInt(names.length)];
	}

	private void generateNameDefensive(){
		Random rand = new Random();
		String[] names = {"Watershell", "Taco sandwich", "health burst"};

		name = names[rand.nextInt(names.length)];
	}
}