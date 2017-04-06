package People;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import entities.Entity;
import graphics.Tiles;
import main.Handler;

public class WoodCutter extends Entity {

	private boolean die=false;
	private static int health=5000;
	
	public WoodCutter(Handler handler,int x, int y,int width,int height){
		super(handler,x,y,64,64);
	}
	
	public static void vermeerderHealth(){
		health=health+1000;
	}

	
	public void tick() {
		health--;
		//System.out.println(health);
		if(health<=0){
			die=true;
			health=0;
		}
	}

	public void render(Graphics g) {
		if(!die)
			g.drawImage(Tiles.soldaat, (int) (x- handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
	}
	
	
}
