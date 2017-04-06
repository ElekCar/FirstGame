package Animals;

import java.awt.Graphics;

import entities.Entity;
import main.Handler;
import worlds.World1;

public abstract class Animals extends Entity {

		
	protected float speed;
	protected float xMove, yMove;
	private final int TILEHEIGHT=64;
	private final int TILEWIDTH=64;
	
	public Animals(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		xMove = 0;
		yMove=0;
	}

	public void move(){
			moveX();
			moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * TILEWIDTH + TILEWIDTH - bounds.x;
			}
			
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * TILEHEIGHT + TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		if(World1.world[x][y]!=2){
			return true;}else return false;
	}
	
}
