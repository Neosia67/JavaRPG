package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class OptionMenuState extends BasicGameState{
	private Button back;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		back = new Button("Back", w - gc.getGraphics().getFont().getWidth("Back") / 2, h - gc.getGraphics().getFont().getHeight("Back") / 2 + 50, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		float w = gc.getWidth() / 2;
		float h = gc.getHeight() / 2;
		String text = "Options";
		g.drawString(text, w - g.getFont().getWidth(text) / 2, h - g.getFont().getHeight(text) / 2);
		back.render(g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(back.isClicked(input.getMouseX(), input.getMouseY()))
				sbg.enterState(1);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
