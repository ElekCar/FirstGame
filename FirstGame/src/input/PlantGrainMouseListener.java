package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlantGrainMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		MainFrameMouseListener.setPlantgraan(true);
		MainFrameMouseListener.setPlantwortel(false);		
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

