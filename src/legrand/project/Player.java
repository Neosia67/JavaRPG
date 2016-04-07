package legrand.project;

public class Player extends Entity{
	private Stuff stuff;
	private int baseDam;
	private int baseDef;
	private int baseSpeed;
	private int baseMaxhp;
	
	public Player(String n, int d, int def, int s){
		super(1, 100, 1);
		this.name = n;
		this.damage = d;
		this.defense = def;
		this.speed = s;
		this.baseSpeed = s;
		this.baseDam = d;
		this.baseDef = def;
		this.baseMaxhp = 100;
		this.stuff = new Stuff();
	}
	
	public Player(){
		super("player", 1, 0, 0, 0, 0, 0, 0);
		this.stuff = new Stuff();
		this.baseDam = 0;
		this.baseDef = 0;
		this.baseMaxhp = 0;
		this.baseSpeed = 0;
	}
	
	public void equip(Item i){
		if(i instanceof Weapon)
			equipw((Weapon)i);
		else
			equipa((Armor)i);
	}

	public void equipw(Weapon w){
		stuff.addWeapon(w);
		this.damage = baseDam + w.getDamage();
		this.speed = baseSpeed + w.getSpeed();
	}
	
	public void equipa(Armor a){
		stuff.addArmor(a);
		this.defense = baseDef + a.getDefense();
		this.maxhealth = baseMaxhp + a.getLife();
	}
	
	public void getloot(Item i){
		stuff.addInv(i);
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void setDamage(int d){
		baseDam = d;
		damage = d;
	}
	
	public void setDefense(int d){
		baseDef = d;
		defense = d;
	}
	
	public void setSpeed(int s){
		baseSpeed = s;
		speed = s;
	}
	
	public void setLife(int i){
		baseMaxhp = i;
		health = i;
		maxhealth = i;
	}
	
	public Stuff getStuff(){
		return stuff;
	}
	
	@Override
	public void death() {
		dead = true;
		
	}

}
