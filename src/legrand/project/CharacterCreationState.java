package legrand.project;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CharacterCreationState extends BasicGameState{
	
	private String name;
	private int damage;
	private int speed;
	private int defense;
	private int points;
	private Button speedp;
	private Button speedm;
	private Button damagep;
	private Button damagem;
	private Button defensep;
	private Button defensem;
	private Button ok;
	private TextField gname;
	public Player player = Main.getPlayer();

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		damage = 1;
		speed = 1;
		defense = 1;
		points = 5;
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		speedp = new Button("+", w - gc.getGraphics().getFont().getWidth("+") / 2 + 50, 290, gc);
		speedm = new Button("-", w - gc.getGraphics().getFont().getWidth("-") / 2 + 40, 290, gc);
		damagep = new Button("+", w - gc.getGraphics().getFont().getWidth("+") / 2 + 50, 250, gc);
		damagem = new Button("-", w - gc.getGraphics().getFont().getWidth("-") / 2 + 40, 250, gc);
		defensep = new Button("+", w - gc.getGraphics().getFont().getWidth("+") / 2 + 50, 270, gc);
		defensem = new Button("-", w - gc.getGraphics().getFont().getWidth("-") / 2 + 40, 270, gc);
		ok = new Button("Ok", w - gc.getGraphics().getFont().getWidth("Ok") / 2, h - gc.getGraphics().getFont().getHeight("Ok") / 2 + 100, gc);
		gname = new TextField(gc, gc.getGraphics().getFont(), w - 60, 400, 120, 30);
		gname.setBackgroundColor(Color.darkGray);
		gname.setBorderColor(Color.white);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int w = gc.getWidth() / 2;
		int h = gc.getHeight() / 2;
		g.drawString("Character Creation", w - g.getFont().getWidth("Character creation") / 2, 100);
		g.drawString("Select Stats", w - g.getFont().getWidth("Select Stats") / 2, 150);
		g.drawString("Points : " + points, w - g.getFont().getWidth("Points :  ") / 2, 200);
		g.drawString("Damage", w - g.getFont().getWidth("Damage") / 2 - 60, 250);
		g.drawString("Defense", w - g.getFont().getWidth("Defense") / 2 - 60, 270);
		g.drawString("Speed", w - g.getFont().getWidth("Speed") / 2 - 65, 290);
		g.drawString("" + damage, w - g.getFont().getWidth("00") / 2, 250);
		g.drawString("" + defense, w - g.getFont().getWidth("00") / 2, 270);
		g.drawString("" + speed, w - g.getFont().getWidth("00") / 2, 290);
		damagep.render(g);
		damagem.render(g);
		speedp.render(g);
		speedm.render(g);
		defensep.render(g);
		defensem.render(g);
		ok.render(g);
		gname.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		boolean remain = (points > 0);
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(ok.isClicked(input.getMouseX(), input.getMouseY())){
				player.setDamage(damage);
				player.setName(gname.getText());
				player.setDefense(defense);
				player.setSpeed(speed);
				player.setLife(100);
				sbg.enterState(6);
			}
			if(damagep.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(remain)
				{
					damage++;
					points--;
				}
			}
			if(damagem.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(damage != 1)
				{
					damage--;
					points++;
				}
			}
			if(speedp.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(remain)
				{
					speed++;
					points--;
				}
			}
			if(speedm.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(speed != 1)
				{
					speed--;
					points++;
				}
			}
			if(defensep.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(remain)
				{
					defense++;
					points--;
				}
			}
			if(defensem.isClicked(input.getMouseX(), input.getMouseY()))
			{
				if(defense != 1)
				{
					defense--;
					points++;
				}
			}
		}
	}

	@Override
	public int getID() {
		return 4;
	}
}
