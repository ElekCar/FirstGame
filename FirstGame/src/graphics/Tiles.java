package graphics;


import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tiles {
	
	private static final int width = 64, height = 64;
	public static BufferedImage player,soldaat;
	public static BufferedImage sheep;
	public static BufferedImage money;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] tiles;

	public static BufferedImage wood;
	public static BufferedImage rock;
	public static Image tree;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		player = sheet.crop(0, 0, width, height);
		money = sheet.crop(width*2, height, width, height);
		soldaat = sheet.crop(3*width, height, width, height);
		
		tiles = new BufferedImage[16];
		
		tiles[0]= sheet.crop(width, 0, width, height);//grain
		tiles[1]= sheet.crop(width * 2, 0, width, height);//dirt
		tiles[2]= sheet.crop(width * 3, 0, width, height);//grass
		tiles[3]= sheet.crop(width *4, 0, width, height);//footpath
		tiles[4]= sheet.crop(width*9, 0, width, height);//sheep
		tiles[5]= sheet.crop(width *5, 0, width, height);//water_vertical
		tiles[6]= sheet.crop(width *6, 0, width, height);//water_linksBoven
		tiles[7]= sheet.crop(width *7, 0, width, height);//water_horizontal
		tiles[8]= sheet.crop(width *8, 0, width, height);//water_rechtsBoven
		tiles[9]= sheet.crop(width *6, height, width, height);//water_linksOnder
		tiles[10]= sheet.crop(width *8, height, width, height);//water_rechtsOnder
		tiles[11] = sheet.crop(width, height, width, height);//takegrain
		tiles[12] = sheet.crop(0, height, width, height);//wortel
		tiles[13] = sheet.crop(0, height*2, width, height);//takewortel
		tiles[14] = sheet.crop(3*width, 2*height, width, height);//boom
		tiles[15] = sheet.crop(4*width, 1*height, width, height);//boomstronk
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(0,  0, width , height);
		btn_start[1] = sheet.crop(width, 0 * 5, width , height);
		
		}
	
}
