package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CombatState extends BasicGameState{
	private Player player = Main.getPlayer();
	private Monster monster;
	private int time;
	private boolean fight;
	private Button begin;
	private Button use;
	

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		monster = new Monster(Rarity.COMMON);
		fight = false;
		begin = new Button("Begin", 100, 100, gc);
		use = new Button("Use", 100, 150, gc);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		begin.render(g);
		g.drawString(player.getname(), w / 2 - 20, h - 50);
		g.drawString("\\o/", w / 2, h - 20);
		g.drawString(" | ", w / 2, h - 5);
		g.drawString("/ \\", w / 2, h + 10);
		g.drawString(monster.getname(), w / 2 + w - 15, h - 50);
		g.drawString(player.gethealth() + "/" + player.getmaxhealth(), w / 2 - 15, h + 25);
		g.drawString("\\o/", w / 2 + w, h - 20);
		g.drawString(" | ", w / 2 + w, h - 5);
		g.drawString("/ \\", w / 2 + w, h + 10);
		
		if(!monster.getdead())
			g.drawString(monster.gethealth() + "/" + monster.getmaxhealth(), w / 2 + w - 15, h + 25);
		else
		{
			g.drawString("Dead", w / 2 + w - 40, h + 25);
			use.render(g);
			g.drawString(monster.getLoot().getName(), 150, 150);
		}
		g.drawString("Time : " + time/1000, w, 100);
		
		g.drawString(player.getname(), 100, 200);
		g.drawString("" + player.getdamage(), 200, 200);
		g.drawString("" + player.getdefense(), 250, 200);
		g.drawString("" + player.getspeed(), 300, 200);
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
				player.equip(monster.getLoot());
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
		return 3;
	}
	
	public void setFight(boolean b){
		this.fight = b;
	}
	
	public void setPlayer(Player p){
		this.player = p;
	}
	
}
