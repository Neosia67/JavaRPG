package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	private boolean mouseClicked = false;
	private Button options;
	private Button character;
	private Button quit;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		options = new Button("Options", w - gc.getGraphics().getFont().getWidth("Options") / 2, h - gc.getGraphics().getFont().getHeight("Options") / 2 + 50, gc);
		character = new Button("Create", w - gc.getGraphics().getFont().getWidth("Create") / 2, h - gc.getGraphics().getFont().getHeight("Create") / 2 + 100, gc);
		quit = new Button("Quit", w - gc.getGraphics().getFont().getWidth("Quit") / 2, h - gc.getGraphics().getFont().getHeight("Quit") / 2 + 200, gc);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		String text = "Main menu";
		g.drawString(text, w - g.getFont().getWidth(text) / 2, h - g.getFont().getHeight(text) / 2);
		options.render(g);
		character.render(g);
		quit.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(options.isClicked(input.getMouseX(), input.getMouseY()))
				sbg.enterState(2);
			if(character.isClicked(input.getMouseX(), input.getMouseY()))
				sbg.enterState(4);
			if(quit.isClicked(input.getMouseX(), input.getMouseY()))
				gc.exit();
		}
		else
			mouseClicked = false;
	}

	@Override
	public int getID() {
		return 1;
	}
	
}
