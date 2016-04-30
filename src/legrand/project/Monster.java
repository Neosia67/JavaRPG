package legrand.project;

import java.util.Random;

public class Monster extends Entity{
	private Rarity rarity;
	private Item loot;
	
	public Monster(Rarity r, int l){
		super("Gobelin", l, 100, 100, 5, 1, 2, 1);
		this.rarity = r;
		Random rnd = new Random();
		int rar = rnd.nextInt(2);
		if(rar == 0)
			this.loot = new Weapon(rarity, level);
		else
			this.loot = new Armor(rarity, level);
	}
	
	public Item getLoot(){
		return this.loot;
	}
	
	
}
