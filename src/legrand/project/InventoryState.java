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
	private ButtonInv[] slots;
	private ButtonInv equ1;
	private ButtonInv equ2;
	
	private Button back;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		grid = new Image("Assets/Background/Image_Inventaire_State.png");
		// uFont = new UnicodeFont("Assets/Fonts/angrybirds-regular.ttf", 50,
		// false, false);
		slots = new ButtonInv[16];
		Weapon w = new Weapon(Rarity.EPIC, 3);
		Armor a = new Armor(Rarity.RARE, 3);
		player.getloot(a);
		player.getloot(w);
		slots[0] = new ButtonInv(player.getStuff().getInv(1), 20, 20, gc);
		slots[1] = new ButtonInv(player.getStuff().getInv(2), 235, 20, gc);
		slots[2] = new ButtonInv(player.getStuff().getInv(3), 450, 20, gc);
		slots[3] = new ButtonInv(player.getStuff().getInv(4), 665, 20, gc);
		slots[4] = new ButtonInv(player.getStuff().getInv(5), 20, 235, gc);
		slots[5] = new ButtonInv(player.getStuff().getInv(6), 235, 235, gc);
		slots[6] = new ButtonInv(player.getStuff().getInv(7), 450, 235, gc);
		slots[7] = new ButtonInv(player.getStuff().getInv(8), 665, 235, gc);
		slots[8] = new ButtonInv(player.getStuff().getInv(9), 20, 450, gc);
		slots[9] = new ButtonInv(player.getStuff().getInv(10), 235, 450, gc);
		slots[10] = new ButtonInv(player.getStuff().getInv(11), 450, 450, gc);
		slots[11] = new ButtonInv(player.getStuff().getInv(12), 665, 450, gc);
		slots[12] = new ButtonInv(player.getStuff().getInv(13), 20, 665, gc);
		slots[13] = new ButtonInv(player.getStuff().getInv(14), 235, 665, gc);
		slots[14] = new ButtonInv(player.getStuff().getInv(15), 450, 665, gc);
		slots[15] = new ButtonInv(player.getStuff().getInv(16), 665, 665, gc);
		
		equ1 = new ButtonInv(player.getStuff().getEqu(1), 1365, 235, gc);
		equ2 = new ButtonInv(player.getStuff().getEqu(2), 1365, 450, gc);
		
		back = new Button("Back", 1050, 700, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.setFont(uFont);
		//g.setColor(Color.white);

		grid.draw();
		
		for(int i = 0; i < slots.length; i++)
			slots[i].renderinv(g);
		for (int i = 0; i < slots.length; i++)
			slots[i].setItem(player.getStuff().getInv(i + 1));
		equ1.renderinv(g);
		equ2.renderinv(g);
		
		g.drawString(player.getname(), 1050, 230);
		g.drawString("Level : " + player.getLevel(), 1050, 295);
		g.drawString("Damage : " + player.getdamage(), 1050, 360);
		g.drawString("Defense : " + player.getdefense(), 1050, 425);
		g.drawString("Health : " + player.getmaxhealth(), 1050, 490);
		g.drawString("Speed : " + player.getspeed(), 1050, 555);
		g.drawString("Critical : " + player.getCritical(), 1050, 620);
		
		g.drawString("Weapon", 1450, 200);
		g.drawString("Armor", 1450, 680);
		
		back.render(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int g) throws SlickException {
		Input input = gc.getInput();
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			for (int i = 0; i < slots.length; i++) 
				slots[i].clicked(input, equ1, equ2, player);
			if(back.isClicked(input.getMouseX(), input.getMouseY()))
			{
				leave(gc, sbg);
				sbg.enterState(5);
			}
		}
	}

	public void setPlayer(Player p) {
		player = p;
	}

	@Override
	public int getID() {
		return 6;
	}

}
