package Animals;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Tiles;
import main.Handler;

public class Sheep extends Animals {

	public Sheep(Handler handler,float x, float y){
		super(handler,x,y,30,30);
	
	bounds.x = 0;
	bounds.y = 0;
	bounds.width = 30;
	bounds.height = 30;
	}

	
	int teller=0;
	int richting = (int)(Math.random()*4);
	int tijd = (int) (Math.random()*15 + 5);

	public void tick() {
		if(teller==tijd){
			tijd = (int)(Math.random()*15+5);
			richting = (int)(Math.random()*4);
			teller=0;
		}	
	getInput();
	move();
	teller++;
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		speed=3.0f;
			
		switch(richting){
			case 0: yMove = -speed;break;
			case 1: yMove = speed;break;
			case 2: xMove = -speed;break;
			case 3: xMove = speed;break;
		}				
	}

	public void render(Graphics g) {
		g.drawImage(Tiles.tiles[4], (int) (x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()),width,height,null	);
//		g.setColor(Color.red);
//		g.fillRect((int) (x- handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height);
//		g.setColor(Color.black);
//		g.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()),
//				(int)(y+bounds.y - handler.getGameCamera().getxOffset()), bounds.width,bounds.height);
	}

	public void die() {
		
	}
}
