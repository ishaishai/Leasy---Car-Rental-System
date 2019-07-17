package gui_usr_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import listeners_pkg.MyMouseListener;

public class UserCustomersPanel extends BasePanel {

	private BaseLabel bslblCustomers;
	private static JTable tableCustomers;
	private JButton btnRemoveCustomer;
	public UserCustomersPanel()
	{
		bslblCustomers = new BaseLabel("Customers:");
		bslblCustomers.setFont(new Font("Tahoma", Font.BOLD, 18));
		bslblCustomers.setBounds(85, 40, 110, 34);
		
		tableCustomers = new JTable(new DefaultTableModel());
		tableCustomers.setBounds(0, 225, 743, 142);
		tableCustomers.addMouseListener(new MyMouseListener());
		JScrollPane scrollInvoices;
		scrollInvoices = new JScrollPane(tableCustomers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(85, 85, 743, 276);
		add(scrollInvoices);

		btnRemoveCustomer = new JButton("Remove");
		btnRemoveCustomer.setFocusPainted(false);
		btnRemoveCustomer.setFocusable(false);
		btnRemoveCustomer.setRequestFocusEnabled(false);
		btnRemoveCustomer.setContentAreaFilled(false);
		btnRemoveCustomer.setBorderPainted(true);
		btnRemoveCustomer.setBackground(new Color(17, 41, 64));
		btnRemoveCustomer.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnRemoveCustomer.setForeground(Color.WHITE);
		btnRemoveCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnRemoveCustomer.setBounds(663, 389, 165, 50);
		btnRemoveCustomer.addMouseListener(new MyMouseListener());
		add(btnRemoveCustomer);
		
		add(bslblCustomers);
	}
	
	public final BaseLabel getBslblCustomers() {
		return bslblCustomers;
	}
	public static final JTable getTableCustomers() {
		return tableCustomers;
	}
	public final JButton getBtnRemoveCustomer() {
		return btnRemoveCustomer;
	}
	
	

}
