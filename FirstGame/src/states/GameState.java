package states;

import java.awt.Graphics;

import main.Handler;
import worlds.World1;

public class GameState extends State {
	
	private World1 world;
	
	public GameState(Handler handler){
		super(handler);
		
		world = new World1(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		//handler.getGameCamera().move(100,100);
		
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}

