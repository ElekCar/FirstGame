package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import graphics.GameCamera;
import graphics.Tiles;
import input.KeyManager;
import input.MainFrameMouseListener;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		//mouseManager = new MouseManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		Tiles.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		menuState = new MenuState(handler);
		gameState = new GameState(handler);

		display.getFrame().addMouseListener(new MainFrameMouseListener((int) (handler.getGameCamera().getxOffset()),handler));
		display.getFrame().addMouseMotionListener(new MainFrameMouseListener((int) (handler.getGameCamera().getxOffset()),handler));
		display.getCanvas().addMouseListener(new MainFrameMouseListener((int) (handler.getGameCamera().getxOffset()),handler));
		display.getCanvas().addMouseMotionListener(new MainFrameMouseListener((int) (handler.getGameCamera().getxOffset()),handler));
		
		State.setState(gameState);
		
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() == gameState){
			gameState.tick();
		} else menuState.tick();
		
	}
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() == gameState){
			gameState.render(g);
		} else menuState.render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	private static int seconden=0,minuten=0;

	public void run(){
		
		init();
		
		double timePerTick = 1000000000/60;
		double delta=0;
		long now;
		long lastTime=System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta +=(now-lastTime)/timePerTick;
			timer+= now-lastTime;
			lastTime=now;
			
			if(delta>=1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
				//if(seconden==59){
				//	minuten++;
				//	seconden=0;
				//}else{
					seconden++;
				//}
				System.out.println("00 : " + minuten + " : " + seconden);
				
			}
			
		}
		stop();
	}
	
	public static void waitSecTime(int time){
			int lastTime=getSeconden();
		
			System.out.print("ok");
			if(lastTime+time==getSeconden());
	}
		
	public static int getSeconden() {
		return seconden;
	}

	public static void setSeconden(int seconden) {
		Game.seconden = seconden;
	}

	public static int getMinuten() {
		return minuten;
	}

	public static void setMinuten(int minuten) {
		Game.minuten = minuten;
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
//	public MouseManager getMouseManager(){
//		return mouseManager;
//	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}












