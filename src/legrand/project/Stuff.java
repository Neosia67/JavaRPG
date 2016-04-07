package legrand.project;

public class Stuff {
	private Item[] inventory;
	private Item[] equipment;
	private int max;
	private boolean full;
	
	public Stuff(){
		this.full = false;
		this.max = 16;
		this.inventory = new Item[max];
		this.equipment = new Item[2];

		for(int i = 0; i < 16; i++)
			inventory[i] = new Item();
		for(int i = 0; i < 2; i++)
			equipment[i] = new Item();
	}
	
	public void addWeapon(Weapon w){
		addInv(equipment[0]);
		equipment[0] = w;
	}
	
	public void addArmor(Armor a){
		addInv(equipment[1]);
		equipment[1] = a;
	}
	
	public void addInv(Item i){
		if(!full)
		{
			int j;
			for (j = 0; j < inventory.length; j++) 
			{
				if(inventory[j].value == 0)
				{
					inventory[j] = i;
					break;
				}
			}
			full = (j == max - 1);
		}
	}
	
	public Item getInv(int i){
		return inventory[i - 1];
	}
	
	public Item getEqu(int i){
		return equipment[i - 1];
	}
}
