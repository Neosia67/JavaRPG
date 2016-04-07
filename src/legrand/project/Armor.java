package legrand.project;

import java.util.Random;

public class Armor extends Item{
	private int defense;
	private int life_add;
	
	public Armor(int v, Rarity r, int d, int l){
		super(v, r);
		this.defense = d;
		this.life_add = l;
	}
	
	public Armor(Rarity r, int l){
		int val = l * 10;
		double mult = 1;
		switch(r)
		{
			case RARE: val *= 2;
					   mult = 1.4;
					   break;
			case EPIC: val *= 4;
					   mult = 1.9;
					   break;
			case LEGENDARY: val *= 8;
					   mult = 2.5;
					   break;
		}
		this.value = val;
		this.rarity = r;
		this.level = l;
		Random rnd = new Random();
		double def = (1 + rnd.nextInt(3) + (l / 2)) * mult;
		this.defense = (int)def;
		this.life_add = 0;	
		this.name = "Chestplate";
	}
	
	public int getDefense(){
		return this.defense;
	}
	
	public int getLife(){
		return this.life_add;
	}
}
