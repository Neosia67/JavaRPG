package legrand.project;

public abstract class Entity {
	protected String name;
	protected int level;
	protected int health;
	protected int maxhealth;
	protected int damage;
	protected int defense;
	protected int speed;
	protected int critical;
	protected boolean dead;
	
	public Entity(String n, int l, int h, int m, int d, int def, int s, int c){
		this.name = n;
		this.level = l;
		this.health = h;
		this.maxhealth = m;
		this.damage = d;
		this.defense = def;
		this.speed = s;
		this.critical = c;
		this.dead = false;
	}
	
	public Entity(int l, int h, int c){
		this.level = l;
		this.health = h;
		this.maxhealth = h;
		this.critical = c;
		this.dead = false;
	}
	
	public void attack(Entity e){
		if(damage > e.getdefense())
			e.take_damage(damage - e.getdefense());
	}
	
	public void take_damage(int i){
		health -= i;
		if(health < 1)
			death();
	}
	
	public abstract void death();
	
	public int gethealth(){
		return health;
	}
	
	public int getmaxhealth(){
		return maxhealth;
	}
	
	public String getname(){
		return name;
	}
	
	public int getspeed(){
		return speed;
	}
	
	public boolean getdead(){
		return dead;
	}
	
	public int getdamage(){
		return damage;
	}

	public int getdefense(){
		return defense;
	}
	
	public int getCritical(){
		return critical;
	}
	
	public int getLevel(){
		return level;
	}
}

