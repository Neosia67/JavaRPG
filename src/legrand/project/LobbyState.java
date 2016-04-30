package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LobbyState extends BasicGameState{
	
	private Button inventory;
	private Button dungeon;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		inventory = new Button("Inventory", w - gc.getGraphics().getFont().getWidth("Inventory") / 2, 250, gc);
		dungeon = new Button("Dungeon", w - gc.getGraphics().getFont().getWidth("Dungeon") / 2, 300, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		g.drawString("MENU", w - g.getFont().getWidth("MENU") / 2, 100);
		
		inventory.render(g);
		dungeon.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(inventory.isClicked(input.getMouseX(), input.getMouseY()))
			{
				sbg.enterState(6);
			}	
			if(dungeon.isClicked(input.getMouseX(), input.getMouseY()))
			{
				sbg.enterState(7);
			}
		}
	}

	@Override
	public int getID() {
		return 5;
	}

}
