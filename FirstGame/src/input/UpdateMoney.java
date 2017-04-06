package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import inventory.Inventory;

public class UpdateMoney implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {		
		Inventory.geefEten();
		Inventory.updateMoney();
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

