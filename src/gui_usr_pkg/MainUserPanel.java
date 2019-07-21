package gui_usr_pkg;

import javax.swing.JLayeredPane;

import gui_customized_comp.BasePanel;

import java.awt.CardLayout;

public class MainUserPanel extends BasePanel
{
	private static UserSideMenu m_SideMenu;
	private static MenuMainPanel m_MenuMain;
	private static UserInvoicesPanel m_UserInvoices;
	private static UserStockPanel m_UserStockPanel;
	private static UserCustomersPanel m_UserCustomersPanel;
	private static JLayeredPane m_layeredPaneTop;
	private static UserSearchCustomerPanel m_UserSearchCustomerPanel;
	private static SearchedCustomerPanel m_SearchedCustomerPanel;
	public MainUserPanel()
	{
		m_SideMenu = new UserSideMenu();
		m_MenuMain = new MenuMainPanel();
		m_UserInvoices = new UserInvoicesPanel();
		m_UserStockPanel = new UserStockPanel();
		m_UserCustomersPanel = new UserCustomersPanel();
		m_UserSearchCustomerPanel = new UserSearchCustomerPanel();
		m_SearchedCustomerPanel = new SearchedCustomerPanel();
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


	public static SearchedCustomerPanel getM_SearchedCustomerPanel() {
		return m_SearchedCustomerPanel;
	}


	public static final void setM_layeredPaneTop(JLayeredPane m_layeredPaneTop) {
		MainUserPanel.m_layeredPaneTop = m_layeredPaneTop;
	}


	public static final UserStockPanel getM_UserStockPanel() {
		return m_UserStockPanel;
	}


	public static final UserCustomersPanel getM_UserCustomersPanel() {
		return m_UserCustomersPanel;
	}


	public static UserSearchCustomerPanel getM_UserSearchCustomerPanel() {
		return m_UserSearchCustomerPanel;
	}


}