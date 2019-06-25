package gui_pkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class MyMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource() == Main.getM_WelcomePanel().getbtnLogin())
		{
			DirPanel.getM_Controller().mainLogin(true);
		}
		else if(event.getSource() == Main.getM_WelcomePanel().getBtnLogout())
		{
			DirPanel.getM_Controller().mainLogin(false);
		}
		else if(event.getSource() == Main.getM_ReviewOrder().getBtnLogin())
		{
			DirPanel.getM_Controller().ReviewLogin();
		}
		else if(event.getSource() == Main.getM_WelcomePanel().getBtnCustomer())
		{
			Main.getM_DirPanel().getNextButton().setVisible(true);
			DirPanel.getM_Controller().MoveForward();
		}
		else if(event.getSource() == UserSideMenu.getBtnViewInvoices())
		{
			DirPanel.getM_Controller().LoadInvoices();
		}
		else if((event.getSource() instanceof JTable))
		{
			if((event.getSource()==UserInvoicesPanel.getTableInvoices()))
			{
				//((JTable)event.getSource())
				//DirPanel.getM_Controller().SetSelectedInvoicePanel();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if(event.getSource() instanceof JButton)
		{
			((JButton)event.getSource()).setContentAreaFilled(true);
			((JButton)event.getSource()).setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));		
		}
		else if((event.getSource() == UserInvoicesPanel.getTableInvoices()))
		{
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if((event.getSource() instanceof JButton))
		{
			((JButton)event.getSource()).setContentAreaFilled(false);
			((JButton)event.getSource()).setBorder(new LineBorder(Color.WHITE, 2, true));
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if((event.getSource() instanceof JButton))
		{
			((JButton)event.getSource()).setContentAreaFilled(false);
			((JButton)event.getSource()).setBorder(new LineBorder(Color.WHITE, 2, true));
		}
	}
	

}
