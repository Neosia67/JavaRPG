package legrand.project;

import java.math.*;

public class Dungeon {
	private Player player = Main.getPlayer();
	private int remain;
	private int xp;
	private Item[] loot;
	
	public Dungeon(){
		remain = -1;
	}
	
	public Dungeon(int i){
		remain = i;
		xp = i * (int)Math.pow(2, 1 + player.getLevel());
		loot = new Item[i];
	}
	
	public void fight(){
		remain--;
	}
	
	public int getXp(){
		return xp;
	}
	
	public int getRemain(){
		return remain;
	}
	
	public void setLoot(Item i, int n){
		loot[n] = i;
	}
	
	public Item[] getLoot(){
		return loot;
	}
}
