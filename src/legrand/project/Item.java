package legrand.project;

public class Item {
	
	protected String name;
	protected int value;
	protected Rarity rarity;
	protected int level;
	
	public Item(){
		this.name = "0";
		this.value = 0;
		this.rarity = Rarity.COMMON;
	}
	
	public Item(int v, Rarity r){
		this.value = v;
		this.rarity = r;
	}

	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Rarity getRarity() {
		return rarity;
	}
	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}
	public String getName(){
		return this.name;
	}
	public int getLevel(){
		return this.level;
	}
}
