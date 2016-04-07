package legrand.project;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InventoryState extends BasicGameState {
	private Image grid;
	private Player player = Main.getPlayer();
	// private UnicodeFont uFont;

	private ButtonInv slot1;
	private ButtonInv slot2;
	private ButtonInv slot3;
	private ButtonInv slot4;
	private ButtonInv slot5;
	private ButtonInv slot6;
	private ButtonInv slot7;
	private ButtonInv slot8;
	private ButtonInv slot9;
	private ButtonInv slot10;
	private ButtonInv slot11;
	private ButtonInv slot12;
	private ButtonInv slot13;
	private ButtonInv slot14;
	private ButtonInv slot15;
	private ButtonInv slot16;
	private ButtonInv equ1;
	private ButtonInv equ2;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		grid = new Image("Assets/Background/Image_Inventaire_State.png");
		// uFont = new UnicodeFont("Assets/Fonts/angrybirds-regular.ttf", 50,
		// false, false);
		
		Weapon w = new Weapon(Rarity.EPIC, 3);
		Armor a = new Armor(Rarity.RARE, 3);
		player.getloot(a);
		player.getloot(w);
		slot1 = new ButtonInv(player.getStuff().getInv(1), 20, 20, gc);
		slot2 = new ButtonInv(player.getStuff().getInv(2), 235, 20, gc);
		slot3 = new ButtonInv(player.getStuff().getInv(3), 450, 20, gc);
		slot4 = new ButtonInv(player.getStuff().getInv(4), 665, 20, gc);
		slot5 = new ButtonInv(player.getStuff().getInv(5), 20, 235, gc);
		slot6 = new ButtonInv(player.getStuff().getInv(6), 235, 235, gc);
		slot7 = new ButtonInv(player.getStuff().getInv(7), 450, 235, gc);
		slot8 = new ButtonInv(player.getStuff().getInv(8), 665, 235, gc);
		slot9 = new ButtonInv(player.getStuff().getInv(9), 20, 450, gc);
		slot10 = new ButtonInv(player.getStuff().getInv(10), 235, 450, gc);
		slot11 = new ButtonInv(player.getStuff().getInv(11), 450, 450, gc);
		slot12 = new ButtonInv(player.getStuff().getInv(12), 665, 450, gc);
		slot13 = new ButtonInv(player.getStuff().getInv(13), 20, 665, gc);
		slot14 = new ButtonInv(player.getStuff().getInv(14), 235, 665, gc);
		slot15 = new ButtonInv(player.getStuff().getInv(15), 450, 665, gc);
		slot16 = new ButtonInv(player.getStuff().getInv(16), 665, 665, gc);
		equ1 = new ButtonInv(player.getStuff().getEqu(1), 1365, 235, gc);
		equ2 = new ButtonInv(player.getStuff().getEqu(2), 1365, 450, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.setFont(uFont);
		//g.setColor(Color.white);

		grid.draw();

		slot1.renderinv(g);
		slot2.renderinv(g);
		slot3.renderinv(g);
		slot4.renderinv(g);
		slot5.renderinv(g);
		slot6.renderinv(g);
		slot7.renderinv(g);
		slot8.renderinv(g);
		slot9.renderinv(g);
		slot10.renderinv(g);
		slot11.renderinv(g);
		slot12.renderinv(g);
		slot13.renderinv(g);
		slot14.renderinv(g);
		slot15.renderinv(g);
		slot16.renderinv(g);
		equ1.renderinv(g);
		equ2.renderinv(g);
		
		g.drawString(player.getname(), 1100, 230);
		g.drawString("Level : " + player.getLevel(), 1100, 260);
		g.drawString("Damage : " + player.getdamage(), 1100, 290);
		g.drawString("Defense : " + player.getdefense(), 1100, 320);
		g.drawString("Health : " + player.getmaxhealth(), 1100, 350);
		g.drawString("Speed : " + player.getspeed(), 1100, 380);
		g.drawString("Critical : " + player.getCritical(), 1100, 410);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		Input input = gc.getInput();
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if (slot1.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot1.isEmpty()) {
					if (slot1.getItem() instanceof Weapon)
						slot1.changeItem(equ1);
					else
						slot1.changeItem(equ2);
				}
			}
			if (slot2.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot2.isEmpty()) {
					if (slot2.getItem() instanceof Weapon)
						slot2.changeItem(equ1);
					else
						slot2.changeItem(equ2);
				}
			}
			if (slot3.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot3.isEmpty()) {
					if (slot3.getItem() instanceof Weapon)
						slot3.changeItem(equ1);
					else
						slot3.changeItem(equ2);
				}
			}
			if (slot4.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot4.isEmpty()) {
					if (slot4.getItem() instanceof Weapon)
						slot4.changeItem(equ1);
					else
						slot4.changeItem(equ2);
				}
			}
			if (slot5.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot5.isEmpty()) {
					if (slot5.getItem() instanceof Weapon)
						slot5.changeItem(equ1);
					else
						slot5.changeItem(equ2);
				}
			}
			if (slot6.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot6.isEmpty()) {
					if (slot6.getItem() instanceof Weapon)
						slot6.changeItem(equ1);
					else
						slot6.changeItem(equ2);
				}
			}
			if (slot7.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot7.isEmpty()) {
					if (slot7.getItem() instanceof Weapon)
						slot7.changeItem(equ1);
					else
						slot7.changeItem(equ2);
				}
			}
			if (slot8.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot8.isEmpty()) {
					if (slot8.getItem() instanceof Weapon)
						slot8.changeItem(equ1);
					else
						slot8.changeItem(equ2);
				}
			}
			if (slot9.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot9.isEmpty()) {
					if (slot9.getItem() instanceof Weapon)
						slot9.changeItem(equ1);
					else
						slot9.changeItem(equ2);
				}
			}
			if (slot10.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot10.isEmpty()) {
					if (slot10.getItem() instanceof Weapon)
						slot10.changeItem(equ1);
					else
						slot10.changeItem(equ2);
				}
			}
			if (slot11.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot11.isEmpty()) {
					if (slot11.getItem() instanceof Weapon)
						slot11.changeItem(equ1);
					else
						slot11.changeItem(equ2);
				}
			}
			if (slot12.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot12.isEmpty()) {
					if (slot12.getItem() instanceof Weapon)
						slot12.changeItem(equ1);
					else
						slot12.changeItem(equ2);
				}
			}
			if (slot13.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot13.isEmpty()) {
					if (slot13.getItem() instanceof Weapon)
						slot13.changeItem(equ1);
					else
						slot13.changeItem(equ2);
				}
			}
			if (slot14.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot14.isEmpty()) {
					if (slot14.getItem() instanceof Weapon)
						slot14.changeItem(equ1);
					else
						slot14.changeItem(equ2);
				}
			}
			if (slot15.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot15.isEmpty()) {
					if (slot15.getItem() instanceof Weapon)
						slot15.changeItem(equ1);
					else
						slot15.changeItem(equ2);
				}
			}
			if (slot16.isClicked(input.getMouseX(), input.getMouseY())) {
				if (!slot16.isEmpty()) {
					if (slot16.getItem() instanceof Weapon)
						slot16.changeItem(equ1);
					else
						slot16.changeItem(equ2);
				}
			}
		}
	}

	public void setPlayer(Player p) {
		player = p;
	}

	@Override
	public int getID() {
		return 5;
	}

}
