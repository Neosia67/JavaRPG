package legrand.project;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button {
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected String text;
	
	public Button(String s, int x, int y, GameContainer gc){
		this.text = s;
		this.x = x;
		this.y = y;
		this.height = gc.getGraphics().getFont().getHeight(s);
		this.width = gc.getGraphics().getFont().getWidth(s);
	}
	
	public Button(int x, int y, GameContainer gc){
		this.x = x;
		this.y = y;
		this.height = 215;
		this.width = 215;		
	}
	
	public boolean isClicked(int posx, int posy){
		return (posx > x && posx < (x + width) && posy > y && posy < (y + height));
	}
	
	public void render(Graphics g){
		g.drawString(text, x, y);
	}
	
	
}
