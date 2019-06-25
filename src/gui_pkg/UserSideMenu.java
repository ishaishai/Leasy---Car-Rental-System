package gui_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class UserSideMenu extends BasePanel  {
	private BaseLabel bslblMenu;
	
	private static JButton btnViewInvoices;
	private static JButton btnViewVehicles;
	private static JButton btnSearchCustomer;
	
	public UserSideMenu()
	{		
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
		btnSearchCustomer.setBounds(17, 191, 190, 36);
		btnSearchCustomer.addMouseListener(new MyMouseListener());
		add(btnSearchCustomer);
		
		
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 24), Color.WHITE));
		
	}

	public static final JButton getBtnViewInvoices() {
		return btnViewInvoices;
	}

	public static final JButton getBtnViewVehicles() {
		return btnViewVehicles;
	}

	public static final JButton getBtnSearchCustomer() {
		return btnSearchCustomer;
	}
	
	
}
