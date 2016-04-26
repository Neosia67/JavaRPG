package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class DungeonState extends BasicGameState{
	
	private Player player = Main.getPlayer();
	private int fights;
	private int xp;
	Button fight;
	Button done;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		fights = 2;
		
		done = new Button("Done", 300, 350, gc);
		fight = new Button("Fight", 300, 300, gc);
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg){
		xp = fights * player.getLevel() * 10;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(fights > 0)
		{
			fight.render(g);
			g.drawString("You have to clear all " + fights + " fights to clear the dungeon.", 300, 250);
		}
		else
		{
			done.render(g);
			g.drawString("Congratulation, you beat all the monsters and won " + xp + " xp points", 300, 300);
		}
	}
	
	@Override
	public void leave(GameContainer gc, StateBasedGame sbg)

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(fight.isClicked(input.getMouseX(), input.getMouseY()));
			{
				sbg.enterState(8);
				fights--;
			}
		}
	}

	@Override
	public int getID() {
		return 7;
	}

}
