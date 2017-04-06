package People;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.Entity;
import graphics.Tiles;
import main.Handler;
import worlds.World1;


public class Player extends Entity {
	
	private final static int DEFAULT_PLAYER_HEIGHT = 64;
	private final static int DEFAULT_PLAYER_WIDTH = 64;
	private final static int TILEHEIGHT=64;
	private final static int TILEWIDTH=64;
	protected float xMove;
	protected float yMove;
	protected float speed;
	
	public Player(Handler handler, float x, float y,int health) {
		super(handler, x, y,DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 63;
		bounds.height = 63;
	}
	
	public void tick() {
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}
	
	
		
	private void getInput(){
		xMove = 0;
		yMove = 0;
		speed=3.0f;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
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
	
	private int tx=(int) getX(),ty=(int)getY();
	
	protected boolean collisionWithTile(int x, int y){
		if(World1.world[x][y]==3){
			return true;}else return false;
	}
		
	public void render(Graphics g) {
		g.drawImage(Tiles.player, (int) (x- handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		tx=(int) getX();ty=(int)getY();
		for(int y = 0;y < 40;y++){
			for(int x = 0;x < 40;x++){
				if(World1.world[y][x]==14 && ((int)(tx))>(y*64) && ((int)(tx))<(y*64+64) && ((int)(ty)) > (x*64) && ((int)(ty))<(64+x*64)){
					World1.world[y][x]=15;
				}
			}
		}
	}
}
