package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import entities.Entity;
import graphics.GameCamera;
import input.KeyManager;
import worlds.World1;



public class Handler {
	
	private Game game;
	private World1 world;
	private ArrayList<Entity> entity = new ArrayList<Entity>();
	
	public void render(Graphics g){
		for(Entity en:entity){
			en.render(g);
		}	
	}
	
	public void tick(){
		for(Entity en:entity){
			en.tick();
		}
	}
	
	public void removeEntity(Entity en){
		entity.remove(en);
	}
	
	public void addEntity(Entity en){
		entity.add(en);
	}
	
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
//	public MouseManager getMouseManager(){
//		return game.getMouseManager();
//	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World1 getWorld() {
		return world;
	}

	public void setWorld(World1 world) {
		this.world = world;
	}

	public ArrayList<Entity> getEntities() {
		return entity;
	}

}

