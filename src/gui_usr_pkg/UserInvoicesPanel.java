package gui_usr_pkg;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import listeners_pkg.MyMouseListener;

public class UserInvoicesPanel extends BasePanel implements TableModelListener {
	private BaseLabel bslblInvoices;
	private static JTable tableInvoices;

	public UserInvoicesPanel()
	{
		bslblInvoices = new BaseLabel("Invoices:");
		bslblInvoices.setFont(new Font("Tahoma", Font.BOLD, 18));
		bslblInvoices.setBounds(85, 40, 110, 34);
		JScrollPane scrollInvoices;
		tableInvoices = new JTable(new DefaultTableModel());
		tableInvoices.setBounds(0, 225, 743, 142);
		tableInvoices.addMouseListener(new MyMouseListener());
		tableInvoices.getModel().addTableModelListener(this);
		scrollInvoices = new JScrollPane(tableInvoices, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(85, 85, 743, 276);
		add(scrollInvoices);
			
		add(bslblInvoices);
	}
	
	
	public static final JTable getTableInvoices() {
		return tableInvoices;
	}


	public final BaseLabel getbslblInvoices() {
		return bslblInvoices;
	}


	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}


	public final BaseLabel getBslblInvoices() {
		return bslblInvoices;
	}


	

	
	
}
