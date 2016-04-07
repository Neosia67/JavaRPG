package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ButtonInv extends Button {
	private Item item;
	private Rarity rarity;
	private int stat1;
	private int stat2;
	private int value;
	private int level;

	public ButtonInv(Item i, int x, int y, GameContainer gc) {
		super(x, y, gc);
		this.item = i;
		if (i.getValue() != 0) {
			this.text = i.getName();
			this.value = i.getValue();
			this.rarity = i.getRarity();
			this.level = i.getLevel();
			if (i instanceof Weapon) {
				Weapon w = (Weapon) i;
				this.stat1 = w.getDamage();
				this.stat2 = w.getSpeed();
			} else {
				if (i instanceof Armor) {
					Armor a = (Armor) i;
					this.stat1 = a.getDefense();
					this.stat2 = a.getLife();
				}
				// else
				// potion
			}
		} else {
			this.text = "Empty";
			this.value = 0;
			this.rarity = Rarity.EMPTY;
			this.level = 0;
			this.stat1 = 0;
			this.stat2 = 0;
		}
	}

	public void renderinv(Graphics g) {
		if (!isEmpty()) {
			g.drawString(text, x + width / 2 - (g.getFont().getWidth(text) / 2), y + height / 4);
			g.drawString("" + stat1, x + 50, y + 3 * height / 4);
			g.drawString("" + stat2, x + 100, y + 3 * height / 4);
			g.drawString("" + value, x + 150, y + 3 * height / 4);
			g.drawString("" + rarity, x + width / 2 - g.getFont().getWidth("" + rarity) / 2, y + height / 2);
		}
	}

	public void changeItem(ButtonInv b) {
		Item i = b.getItem();
		b.setItem(this.item);
		setItem(i);
	}

	public boolean isEmpty() {
		return (value == 0);
	}

	public void setItem(Item i) {
		this.item = i;
		this.text = i.getName();
		this.value = i.getValue();
		this.rarity = i.getRarity();
		if (i instanceof Weapon) {
			Weapon w = (Weapon) i;
			this.stat1 = w.getDamage();
			this.stat2 = w.getSpeed();
		} else {
			if (i instanceof Armor) {
				Armor a = (Armor) i;
				this.stat1 = a.getDefense();
				this.stat2 = a.getLife();
			}
			// else
			// potion
		}
	}

	public Item getItem() {
		return item;
	}

}
