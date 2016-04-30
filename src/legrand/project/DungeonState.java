package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;

public class DungeonState extends BasicGameState{
	
	private Player player = Main.getPlayer();
	private Monster monster = Main.getMonster();
	private Dungeon dungeon;
	Button fight;
	Button done;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		done = new Button("Done", 300, 350, gc);
		fight = new Button("Fight", 200, 350, gc);
		
		dungeon = new Dungeon();
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg){
		Random rnd = new Random();
		if(dungeon.getRemain() <= -1)
			dungeon = new Dungeon(1 + rnd.nextInt(4));
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		g.drawString("DUNGEON LV. " + player.getLevel(), w - g.getFont().getWidth("DUNGEON LV.   ") / 2, 100);
		if(dungeon.getRemain() != 0)
		{
			fight.render(g);
			g.drawString("You have to clear all fights to clear the dungeon.", 200, 250);
			g.drawString("Fights remaining : " + dungeon.getRemain(), 200, 300);
		}
		else
		{
			done.render(g);
			g.drawString("Congratulation, you beat all the monsters and won " + dungeon.getXp() + " xp points", 300, 300);
		}
	}
	
	@Override
	public void leave(GameContainer gc, StateBasedGame sbg){
		dungeon.fight();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(fight.isClicked(input.getMouseX(), input.getMouseY()));
			{
				sbg.enterState(8);
			}
			if(done.isClicked(input.getMouseX(), input.getMouseY()))
			{
				player.setXp(dungeon.getXp());
				Item[] loot = dungeon.getLoot();
				for (int i = 0; i < loot.length; i++)
					player.getloot(loot[i]);
				player.setLife(player.getmaxhealth());
				//ajouter l'item a la liste a l'entrée de la state.
				sbg.enterState(5);
			}
		}
	}

	@Override
	public int getID() {
		return 7;
	}

}
