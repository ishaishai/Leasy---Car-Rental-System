package listeners_pkg;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import gui_pkg.DirPanel;
import gui_pkg.Main;
import gui_usr_pkg.MainUserPanel;
import gui_usr_pkg.UserInvoicesPanel;
import gui_usr_pkg.UserSideMenu;

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
		else if(event.getSource() == Main.getM_WelcomePanel().getBtnManage())
		{
			DirPanel.getM_Controller().setUserHome();
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
			DirPanel.getM_Controller().LoadUserInvoicesPanel();
		}
		else if(event.getSource() == UserSideMenu.getBtnViewVehicles())
		{
			DirPanel.getM_Controller().LoadUserStockPanel();
		}
		else if(event.getSource() == UserSideMenu.getbtnViewCustomers())
		{
			DirPanel.getM_Controller().LoadUserCustomersPanel();
		}
		else if(event.getSource() == UserSideMenu.getBtnSearchCustomer())
		{
			DirPanel.getM_Controller().LoadUserSearchCustomerPanel();
		}
		else if(event.getSource() == MainUserPanel.getM_UserSearchCustomerPanel().getBtnSearch())
		{
			DirPanel.getM_Controller().SearchCustomer();
		}
		else if(event.getSource() == MainUserPanel.getM_SearchedCustomerPanel().getbtnHistory())
		{
			DirPanel.getM_Controller().ShowCustomerHistory();
		}
		else if(event.getSource() == MainUserPanel.getM_UserCustomersPanel().getBtnRemoveCustomer())
		{
			DirPanel.getM_Controller().RemoveCustomer();
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
