package legrand.project;

public abstract class Potion extends Item{
	protected int size;
	
	public Potion(int v, int s){
		super(v, Rarity.COMMON);
		this.size = s;
	}
	
	public abstract void use(Player p);
}
