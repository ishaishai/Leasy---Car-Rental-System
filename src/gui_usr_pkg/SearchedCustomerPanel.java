package gui_usr_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import listeners_pkg.MyMouseListener;
import gui_customized_comp.BaseTextField;
import javax.swing.JButton;
import gui_customized_comp.BaseTextArea;

public class SearchedCustomerPanel extends BasePanel {
	private BaseLabel bslblCustomerName;
	private BaseTextArea txtCustomerDetails;
	private JButton btnHistory;
	private JTable tableInvoices;
	private JScrollPane scrollInvoices;
	public SearchedCustomerPanel()
	{
		bslblCustomerName = new BaseLabel();
		bslblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 18));
		bslblCustomerName.setBounds(25, 42, 250, 34);
			
		add(bslblCustomerName);
		
		tableInvoices = new JTable(new DefaultTableModel());
		tableInvoices.setBounds(0, 225, 743, 142);
		tableInvoices.addMouseListener(new MyMouseListener());
		
		scrollInvoices = new JScrollPane(tableInvoices, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(359, 116, 488, 219);
		scrollInvoices.setVisible(false);
		add(scrollInvoices);
		
		
	
		btnHistory = new JButton("Show history");
		btnHistory.setFocusPainted(false);
		btnHistory.setFocusable(false);
		btnHistory.setRequestFocusEnabled(false);
		btnHistory.setContentAreaFilled(false);
		btnHistory.setBorderPainted(true);
		btnHistory.setBackground(new Color(17, 41, 64));
		btnHistory.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnHistory.setForeground(Color.WHITE);
		btnHistory.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnHistory.setBounds(145, 357, 190, 36);
		btnHistory.addMouseListener(new MyMouseListener());
		add(btnHistory);
		
		txtCustomerDetails = new BaseTextArea();
		txtCustomerDetails.setBounds(25, 112, 296, 175);
		add(txtCustomerDetails);
	}
	
	
	
	

	public JScrollPane getScrollInvoices() {
		return scrollInvoices;
	}





	public JTable getTableInvoices() {
		return tableInvoices;
	}





	public BaseLabel getBslblCustomerName() {
		return bslblCustomerName;
	}





	public BaseTextArea getTxtCustomerDetails() {
		return txtCustomerDetails;
	}





	public JButton getBtnHistory() {
		return btnHistory;
	}





	public JButton getbtnHistory() {
		return btnHistory;
	}



	public final BaseLabel getbslblCustomerName() {
		return bslblCustomerName;
	}
}
