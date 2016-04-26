package legrand.project;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{
	
	private static Player player = new Player();
	
	public static Player getPlayer(){
		return player;
	}

	public Main(String name) {
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new MainMenuState());
		this.addState(new OptionMenuState());
		this.addState(new CharacterCreationState());
		this.addState(new CombatState());
		this.addState(new InventoryState());
		this.addState(new LobbyState());
		this.addState(new LoadingState());
		this.addState(new DungeonState());
		this.enterState(1);
	}
	
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main("RPG_Project"));
			appgc.setDisplayMode(1600, 900, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
