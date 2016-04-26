package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LobbyState extends BasicGameState{
	
	private Button inventory;
	private Button combat;
	private Button dungeon;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		inventory = new Button("Inventory", w - gc.getGraphics().getFont().getWidth("Inventory") / 2, h - gc.getGraphics().getFont().getHeight("Ok") / 2 - 50, gc);
		combat = new Button("Combat", w - gc.getGraphics().getFont().getWidth("Inventory") / 2, h - gc.getGraphics().getFont().getHeight("Ok") / 2 + 50, gc);
		dungeon = new Button("Dungeon", w - gc.getGraphics().getFont().getWidth("Inventory") / 2, h - gc.getGraphics().getFont().getHeight("Ok") / 2 - 100, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		inventory.render(g);
		combat.render(g);
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
			if(combat.isClicked(input.getMouseX(), input.getMouseY()))
			{
				sbg.enterState(8);
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
