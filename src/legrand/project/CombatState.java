package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CombatState extends BasicGameState{
	private Player player = Main.getPlayer();
	private Monster monster = Main.getMonster();
	private int time;
	private boolean fight;
	private Button begin;
	private Button use;
	private Button done;
	private Button potion;
	

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		fight = false;
		begin = new Button("Begin", gc.getWidth() / 2 - gc.getGraphics().getFont().getWidth("Begin") / 2, 150, gc);
		use = new Button("Use", 100, 150, gc);
		done = new Button("Done", gc.getWidth() / 2 - gc.getGraphics().getFont().getWidth("Done") / 2, 200, gc);
		potion = new Button("Use Potion", 350, 500, gc);
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg){
		fight = false;
		monster = new Monster(Rarity.COMMON, player.getLevel());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		g.drawString("COMBAT", w - g.getFont().getWidth("COMBAT") / 2, 100);
		begin.render(g);
		potion.render(g);
		g.drawString(player.getname(), w / 2 - 20, 400);
		g.drawString("\\o/", w / 2, 420);
		g.drawString(" | ", w / 2, 435);
		g.drawString("/ \\", w / 2, 450);
		g.drawString(player.gethealth() + "/" + player.getmaxhealth(), w / 2 - 15, 470);
		
		g.drawString(monster.getname(), w / 2 + w - 15, 400);
		g.drawString("\\o/", w / 2 + w, 420);
		g.drawString(" | ", w / 2 + w, 435);
		g.drawString("/ \\", w / 2 + w, 450);
		
		if(!monster.getdead())
			g.drawString(monster.gethealth() + "/" + monster.getmaxhealth(), w / 2 + w - 15, 470);
		else
		{
			g.drawString("Dead", w / 2 + w - 40, h + 25);
			use.render(g);
			g.drawString(monster.getLoot().getName(), 150, 150);
			done.render(g);
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		time += delta;
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(begin.isClicked(input.getMouseX(), input.getMouseY()))
				fight = true;
			if(use.isClicked(input.getMouseX(), input.getMouseY()))
				player.getloot(monster.getLoot());
			if(done.isClicked(input.getMouseX(), input.getMouseY()))
				sbg.enterState(7);
			if(potion.isClicked(input.getMouseX(), input.getMouseY()))
				player.heal();
		}
		if(fight)
		{
			if(!player.getdead() && !monster.getdead())
			{
				if((time % (1000 / player.getspeed())) == 0)
					player.attack(monster);
				if(time % 1000 / monster.getspeed() == 0)
					monster.attack(player);
			}
		}
		
	}

	@Override
	public int getID() {
		return 8;
	}
	
	public void setFight(boolean b){
		this.fight = b;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}
	
}
