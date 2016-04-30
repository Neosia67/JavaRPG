package legrand.project;

public class Player extends Entity{
	private Stuff stuff;
	private int baseDam;
	private int baseDef;
	private int baseSpeed;
	private int baseMaxhp;
	private int xp;
	private int healPotion;
	
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
		this.xp = 0;
		this.healPotion = 5;
	}

	public void equip(Item i){
		if(i instanceof Weapon)
			equip((Weapon)i);
		else
		{
			if(i instanceof Armor)
				equip((Armor)i);
		}
	}
	
	public void equip(Weapon w){
		stuff.addWeapon(w);
		this.damage = baseDam + w.getDamage();
		this.speed = baseSpeed + w.getSpeed();
	}
	
	public void equip(Armor a){
		stuff.addArmor(a);
		this.defense = baseDef + a.getDefense();
		this.maxhealth = baseMaxhp + a.getLife();
	}
	
	public void delInv(Item i){
		stuff.delInv(i);
	}
	
	public void heal(){
		if(healPotion < 0)
		{
			if(health <= maxhealth * 0.8)
				health *= 1.2;
			healPotion--;
		}
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
	
	public void setXp(int i){
		xp += i;
		levelup();
	}
	
	public void levelup(){
		int lvl = level + 1;
		if(xp >= 3 * ((lvl*lvl*lvl) - 6 * (lvl*lvl) + 17 * lvl - 12))
		{
			xp -= 3 * ((lvl*lvl*lvl) - 6 * (lvl*lvl) + 17 * lvl - 12);
			level ++;
		}
	}
	
	
	public Stuff getStuff(){
		return stuff;
	}
	

}
