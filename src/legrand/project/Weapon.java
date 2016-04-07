package legrand.project;

import java.util.Random;

public class Weapon extends Item{
	private int damage;
	private int speed;
	
	public Weapon(int v, Rarity r, int d, int s){
		super(v, r);
		this.damage = d;
		this.speed = s;
		this.name = "Sword";
		this.level = 1;
	}
	
	public Weapon(Rarity r, int l){
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
		double dam = (1 + rnd.nextInt(3) + (l / 2)) * mult;
		this.damage = (int)dam;
		this.speed = 1;	
		this.name = "Sword";
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public int getSpeed(){
		return this.speed;
	}

}
