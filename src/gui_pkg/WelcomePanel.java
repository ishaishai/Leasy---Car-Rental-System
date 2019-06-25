package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class WelcomePanel extends BasePanel// implements MouseListener 
{
	private JButton btnLogin;
	private JButton btnCustomer;
	private JButton btnLogout;
	private BaseLabel Employeelbl;
	private BaseTextArea txtWelcome;
	private BaseTextArea txtMiniTitle;
	public WelcomePanel()
	{
		
		txtWelcome = new BaseTextArea();
		txtWelcome.setText("Get exclusive\r\nmember benefits on\r\nyour next rental.");
		txtWelcome.setForeground(Color.WHITE);
		txtWelcome.setBorder(null);
		txtWelcome.setFont(new Font("Segoe UI", Font.BOLD, 29));
		txtWelcome.setBounds(27, 40, 342, 123);
		txtWelcome.setOpaque(false);
		add(txtWelcome);
		txtMiniTitle = new BaseTextArea();
		txtMiniTitle.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtMiniTitle.setText("Rent your next vehicle \nall in few steps.");
		txtMiniTitle.setOpaque(false);
		txtMiniTitle.setBorder(null);
		txtMiniTitle.setForeground(new Color(161, 172, 181));
		txtMiniTitle.setBounds(27, 164, 342, 59);
		add(txtMiniTitle);
		
	
		
		btnLogin = new JButton("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setRequestFocusEnabled(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(true);
		btnLogin.setBackground(new Color(17, 41, 64));
		btnLogin.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLogin.setBounds(999, 475, 165, 50);
		btnLogin.addMouseListener(new MyMouseListener());
		add(btnLogin);
		
		btnLogout = new JButton("Logout");
		btnLogout.setVisible(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setFocusable(false);
		btnLogout.setRequestFocusEnabled(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(true);
		btnLogout.setBackground(new Color(17, 41, 64));
		btnLogout.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLogout.setBounds(999, 475, 165, 50);
		btnLogout.addMouseListener(new MyMouseListener());
		add(btnLogout);
		
		
		
	
		btnCustomer = new JButton("GET STARTED");
		btnCustomer.setFocusPainted(false);
		btnCustomer.setFocusable(false);
		btnCustomer.setRequestFocusEnabled(false);
		btnCustomer.setContentAreaFilled(false);
		btnCustomer.setBorderPainted(true);
		btnCustomer.setBackground(new Color(17, 41, 64));
		btnCustomer.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnCustomer.setForeground(Color.WHITE);
		btnCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnCustomer.setBounds(260, 304, 165, 50);
		btnCustomer.addMouseListener(new MyMouseListener());
		add(btnCustomer);
		
		Employeelbl = new BaseLabel("Employee?");

		Employeelbl.setBounds(999, 414, 110, 50);
		add(Employeelbl);
		
	}

	
	public final BaseTextArea gettxtWelcome() {
		return txtWelcome;
	}


	public final void settxtWelcome(BaseTextArea txtWelcome) {
		this.txtWelcome = txtWelcome;
	}


	public final JButton getbtnLogin() {
		return btnLogin;
	}


	public final void setbtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}


	public final JButton getBtnCustomer() {
		return btnCustomer;
	}


	public final void setBtnCustomer(JButton btnCustomer) {
		this.btnCustomer = btnCustomer;
	}


	public final BaseTextArea getTxtWelcome() {
		return txtWelcome;
	}


	public final void setTxtWelcome(BaseTextArea txtWelcome) {
		this.txtWelcome = txtWelcome;
	}


	public final BaseTextArea getTxtMiniTitle() {
		return txtMiniTitle;
	}


	public final void setTxtMiniTitle(BaseTextArea txtMiniTitle) {
		this.txtMiniTitle = txtMiniTitle;
	}


	public final JButton getBtnLogin() {
		return btnLogin;
	}


	public final JButton getBtnLogout() {
		return btnLogout;
	}


	public final BaseLabel getEmployeelbl() {
		return Employeelbl;
	}	
	
}
