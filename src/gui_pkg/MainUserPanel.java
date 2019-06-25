package gui_pkg;

import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;

public class MainUserPanel extends BasePanel
{
	private static UserSideMenu m_SideMenu;
	private static MenuMainPanel m_MenuMain;
	private static UserInvoicesPanel m_UserInvoices;
	private static JLayeredPane m_layeredPaneTop;
	
	public MainUserPanel()
	{
		m_SideMenu = new UserSideMenu();
		m_MenuMain = new MenuMainPanel();
		m_UserInvoices = new UserInvoicesPanel();
		
		m_UserInvoices.setLayout(null);

		m_layeredPaneTop = new JLayeredPane();
		m_layeredPaneTop.setBounds(241,21,936,517);
		m_layeredPaneTop.setLayout(new CardLayout(0, 0));
		add(m_layeredPaneTop);
		m_SideMenu.setBounds(6, 6, 225, 537);
		add(m_SideMenu);


		
		
	}


	public static final UserSideMenu getM_SideMenu() {
		return m_SideMenu;
	}


	public static final void setM_SideMenu(UserSideMenu m_SideMenu) {
		MainUserPanel.m_SideMenu = m_SideMenu;
	}


	public static final MenuMainPanel getM_MenuMain() {
		return m_MenuMain;
	}


	public static final void setM_MenuMain(MenuMainPanel m_MenuMain) {
		MainUserPanel.m_MenuMain = m_MenuMain;
	}


	public static final UserInvoicesPanel getM_UserInvoices() {
		return m_UserInvoices;
	}


	public static final void setM_UserInvoices(UserInvoicesPanel m_UserInvoices) {
		MainUserPanel.m_UserInvoices = m_UserInvoices;
	}


	public static final JLayeredPane getM_layeredPaneTop() {
		return m_layeredPaneTop;
	}


	public static final void setM_layeredPaneTop(JLayeredPane m_layeredPaneTop) {
		MainUserPanel.m_layeredPaneTop = m_layeredPaneTop;
	}



	
	
}