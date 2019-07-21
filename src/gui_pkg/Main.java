package gui_pkg;

import java.awt.EventQueue;

import java.awt.Font;
import gui_usr_pkg.MainUserPanel;

import java.awt.Color;
import javax.swing.JTextPane;

public class Main {

	private static MainFrame m_Mainframe;
	private TitlePanel m_TitlePanel;
	private static MainPanel m_Mainpanel;
	private static FirstDetailsPanel m_FirstScreen;
	private static SelectCarPanel m_selectCarPanel;
	private static InsurancePanel m_InsurancePanel;
	private static FullCustomerDetailsPanel m_FullCustomerDetailsPanel;
	private static ReviewOrderPanel m_ReviewOrder;
	private static PaymentPanel m_PaymentPanel;
	private static InvoicePanel m_InvoicePanel;
	private static JTextPane txtpnHello;
	private static WelcomePanel m_WelcomePanel;
	private static MainUserPanel m_MainUser;
	private static DirPanel m_DirPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					m_Mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		m_Mainframe = new MainFrame();
		m_Mainframe.setTitle("Car Rental System - by AGiN Tec.");
		m_Mainframe.setBounds(500,50, 1205, 780);
		m_Mainframe.setResizable(false);
		m_TitlePanel = new TitlePanel();
		m_TitlePanel.setOpaque(false);
		m_TitlePanel.setSize(683, 81);
		m_TitlePanel.setLocation(253, 6);
		m_Mainpanel = new MainPanel();
		m_Mainpanel.setBorder(null);
		m_Mainpanel.setBounds(6, 99, 1187, 547);
		m_DirPanel = new DirPanel();
		
		
		m_Mainframe.getContentPane().setBackground(new Color(17, 41, 64));
		m_Mainframe.getContentPane().add(m_TitlePanel);
		m_TitlePanel.setLayout(null);
		
		
		
		m_Mainframe.getContentPane().add(m_Mainpanel);
		m_Mainpanel.setLayout(null);
		m_FirstScreen = new FirstDetailsPanel();
		
	
		m_selectCarPanel = new SelectCarPanel();
		m_InsurancePanel = new InsurancePanel();		
		m_FullCustomerDetailsPanel = new FullCustomerDetailsPanel();
		m_ReviewOrder = new ReviewOrderPanel();
		m_PaymentPanel = new PaymentPanel();
		m_WelcomePanel = new WelcomePanel();
		m_MainUser = new MainUserPanel();
		m_InvoicePanel = new InvoicePanel();
		
		m_Mainpanel.add(m_WelcomePanel);
		
		m_Mainframe.getContentPane().add(m_DirPanel);
		m_DirPanel.setLayout(null);
		
		
		txtpnHello = new JTextPane();
		txtpnHello.setVisible(false);
		txtpnHello.setText("");
		txtpnHello.setBounds(16, 36, 99, 61);
		txtpnHello.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtpnHello.setForeground(Color.WHITE);
		txtpnHello.setEditable(false);
		txtpnHello.setOpaque(false);
		m_Mainframe.getContentPane().add(txtpnHello);
	}	
	

	public static final WelcomePanel getM_WelcomePanel() {
		return m_WelcomePanel;
	}

	public static final void setM_WelcomePanel(WelcomePanel m_WelcomePanel) {
		Main.m_WelcomePanel = m_WelcomePanel;
	}
	
	public static final DirPanel getM_DirPanel() {
		return m_DirPanel;
	}

	public static final InvoicePanel getM_InvoicePanel() {
		return m_InvoicePanel;
	}

	public static final PaymentPanel getM_PaymentPanel() {
		return m_PaymentPanel;
	}

	public static ReviewOrderPanel getM_ReviewOrder() {
		return m_ReviewOrder;
	}

	public static final MainFrame getM_Mainframe() {
		return m_Mainframe;
	}

	public static final JTextPane getTxtpnHello() {
		return txtpnHello;
	}

	public static final MainPanel getM_Mainpanel() {
		return m_Mainpanel;
	}

	public static final void setM_Mainpanel(MainPanel m_Mainpanel) {
		Main.m_Mainpanel = m_Mainpanel;
	}

	public static final FirstDetailsPanel getM_FirstScreen() {
		return m_FirstScreen;
	}

	public static final SelectCarPanel getM_selectCarPanel() {
		return m_selectCarPanel;
	}


	public static final InsurancePanel getM_InsurancePanel() {
		return m_InsurancePanel;
	}

	public static final FullCustomerDetailsPanel getM_FullCustomerDetailsPanel() {
		return m_FullCustomerDetailsPanel;
	}

	public final TitlePanel getM_TitlePanel() {
		return m_TitlePanel;
	}

	public static final MainUserPanel getM_MainUser() {
		return m_MainUser;
	}
	
}







