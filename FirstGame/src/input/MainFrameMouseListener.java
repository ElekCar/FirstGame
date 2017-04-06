package input;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import inventory.Inventory;
import main.Game;
import main.Handler;
import worlds.World1;

public class MainFrameMouseListener implements MouseListener,MouseMotionListener {

	private Handler handler;
	private static int x;
	public static int grainUpdate;
	public static int wortelUpdate;
	public static boolean grainIsReady=false;
	private static boolean plantgraan,plantwortel;
	
	public MainFrameMouseListener(int x,Handler handler){
		this.handler=handler;
		this.x=x;
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
			
	}
	public void mouseMoved(MouseEvent e) {
	}
	
	private static boolean start[]=new boolean[100];
	private static int index2;
	private static int tempX[] = new int [100];
	private static int tempY[] = new int [100];
	private static int k=0;
	private static int tijd[] = new int[100];
	private static boolean start2[]=new boolean[100];
	private static int index22;
	private static int tempX2[] = new int [100];
	private static int tempY2[] = new int [100];
	private static int k2=0;
	private static int tijd2[] = new int[100];

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<20;i++){
			for(int j=0;j<20;j++){
				if(World1.world[i][j]==1 && ((int)(e.getX()+handler.getGameCamera().getxOffset()))>(i*64) && ((int)(e.getX()+handler.getGameCamera().getxOffset()))<(i*64+64) && ((int)(e.getY()+handler.getGameCamera().getyOffset())) > (j*64) && ((int)(e.getY()+handler.getGameCamera().getyOffset()))<(64+j*64)){
					if(plantgraan){
							World1.world[i][j]=0;
							tempX[k]=i;
							tempY[k]=j;
							tijd[k]=Game.getSeconden();
							start[k]=true;
							k++;
					}	
					if(plantwortel){
						World1.world[i][j]=12;
						tempX2[k2]=i;
						tempY2[k2]=j;
						tijd2[k2]=Game.getSeconden();
						start2[k2]=true;
						k2++;
					}
				}
			}
		}
	}
	
	public static void test2(){
		for(int index=0; index<100;index++){
			if(Game.getSeconden()>=tijd2[index]+10 && start2[index]){
				World1.world[tempX2[index]][tempY2[index]]=13;
				wortelUpdate++;
				Inventory.updateWortelAantal(wortelUpdate);
				start2[index22]=false;
				index22++;
			}
		}
	}

	
	public static void test(){
		for(int index=0; index<100;index++){
			if(Game.getSeconden()>=tijd[index]+10 && start[index]){
				World1.world[tempX[index]][tempY[index]]=11;
				grainUpdate++;
				Inventory.updateGrainAantal(grainUpdate);
				start[index2]=false;
				index2++;
			}
		}
	}
	
	public static boolean isPlantgraan() {
		return plantgraan;
	}

	public static void setPlantgraan(boolean plantgraan) {
		MainFrameMouseListener.plantgraan = plantgraan;
	}

	public static boolean isPlantwortel() {
		return plantwortel;
	}

	public static void setPlantwortel(boolean plantwortel) {
		MainFrameMouseListener.plantwortel = plantwortel;
	}
}

