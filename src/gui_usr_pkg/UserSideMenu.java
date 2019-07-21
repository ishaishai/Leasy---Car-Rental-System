package gui_usr_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import listeners_pkg.MyMouseListener;

public class UserSideMenu extends BasePanel  {
	private BaseLabel bslblMenu;
	
	private static JButton btnViewInvoices;
	private static JButton btnViewVehicles;
	private static JButton btnViewCustomers;
	private static JButton btnSearchCustomer;
	
	public UserSideMenu()
	{		
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 24), Color.WHITE));
		
		btnViewInvoices = new JButton("View all invoices");
		btnViewInvoices.setFocusPainted(false);
		btnViewInvoices.setFocusable(false);
		btnViewInvoices.setRequestFocusEnabled(false);
		btnViewInvoices.setContentAreaFilled(false);
		btnViewInvoices.setBorderPainted(true);
		btnViewInvoices.setBackground(new Color(17, 41, 64));
		btnViewInvoices.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnViewInvoices.setForeground(Color.WHITE);
		btnViewInvoices.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnViewInvoices.setBounds(17, 71, 190, 36);
		btnViewInvoices.addMouseListener(new MyMouseListener());
		add(btnViewInvoices);
		
		btnViewVehicles = new JButton("View all vehicles");
		btnViewVehicles.setFocusPainted(false);
		btnViewVehicles.setFocusable(false);
		btnViewVehicles.setRequestFocusEnabled(false);
		btnViewVehicles.setContentAreaFilled(false);
		btnViewVehicles.setBorderPainted(true);
		btnViewVehicles.setBackground(new Color(17, 41, 64));
		btnViewVehicles.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnViewVehicles.setForeground(Color.WHITE);
		btnViewVehicles.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnViewVehicles.setBounds(17, 131, 190, 36);
		btnViewVehicles.addMouseListener(new MyMouseListener());
		add(btnViewVehicles);
		
		btnViewCustomers = new JButton("View all customers");
		btnViewCustomers.setFocusPainted(false);
		btnViewCustomers.setFocusable(false);
		btnViewCustomers.setRequestFocusEnabled(false);
		btnViewCustomers.setContentAreaFilled(false);
		btnViewCustomers.setBorderPainted(true);
		btnViewCustomers.setBackground(new Color(17, 41, 64));
		btnViewCustomers.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnViewCustomers.setForeground(Color.WHITE);
		btnViewCustomers.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnViewCustomers.setBounds(17, 191, 190, 36);
		btnViewCustomers.addMouseListener(new MyMouseListener());
		add(btnViewCustomers);
		
		btnSearchCustomer = new JButton("Search customer");
		btnSearchCustomer.setFocusPainted(false);
		btnSearchCustomer.setFocusable(false);
		btnSearchCustomer.setRequestFocusEnabled(false);
		btnSearchCustomer.setContentAreaFilled(false);
		btnSearchCustomer.setBorderPainted(true);
		btnSearchCustomer.setBackground(new Color(17, 41, 64));
		btnSearchCustomer.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnSearchCustomer.setForeground(Color.WHITE);
		btnSearchCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSearchCustomer.setBounds(17, 251, 190, 36);
		btnSearchCustomer.addMouseListener(new MyMouseListener());
		add(btnSearchCustomer);
		
		/*JButton button = new JButton("Search customer");
		button.setRequestFocusEnabled(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		button.setFocusable(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(true);
		button.setBorder(new LineBorder(Color.WHITE, 2, true));
		button.setBackground(new Color(17, 41, 64));
		button.setBounds(17, 251, 190, 36);
		add(button);
		*/
	}

	
	
	public BaseLabel getBslblMenu() {
		return bslblMenu;
	}



	public static JButton getBtnViewCustomers() {
		return btnViewCustomers;
	}



	public static JButton getBtnSearchCustomer() {
		return btnSearchCustomer;
	}



	public static final JButton getBtnViewInvoices() {
		return btnViewInvoices;
	}

	public static final JButton getBtnViewVehicles() {
		return btnViewVehicles;
	}

	public static final JButton getbtnViewCustomers() {
		return btnViewCustomers;
	}
}
