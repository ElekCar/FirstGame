package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlantWortelMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		MainFrameMouseListener.setPlantgraan(false);
		MainFrameMouseListener.setPlantwortel(true);		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


