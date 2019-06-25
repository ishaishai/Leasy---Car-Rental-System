package gui_pkg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyIconBtnListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == Main.getM_DirPanel().getBtnHome())
		{
			DirPanel.getM_Controller().SetHomePage();
		}
		
		else if(event.getSource() == Main.getM_DirPanel().getNextButton())
		{
			DirPanel.getM_Controller().MoveForward();
		}
		else if(event.getSource() == Main.getM_DirPanel().getBackButton())
		{
			DirPanel.getM_Controller().MoveBackward();			
		}
		
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
