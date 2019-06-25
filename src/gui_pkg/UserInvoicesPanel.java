package gui_pkg;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class UserInvoicesPanel extends BasePanel implements TableModelListener {
	private BaseLabel bslblInvoices;
	private static JTable tableInvoices;

	public UserInvoicesPanel()
	{
		bslblInvoices = new BaseLabel("Invoices:");
		bslblInvoices.setBounds(85, 40, 110, 34);
		JScrollPane scrollInvoices;
		tableInvoices = new JTable(new DefaultTableModel());
		tableInvoices.setBounds(0, 225, 743, 142);
		tableInvoices.addMouseListener(new MyMouseListener());
		tableInvoices.getModel().addTableModelListener(this);
		scrollInvoices = new JScrollPane(tableInvoices, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(85, 85, 743, 142);
		add(scrollInvoices);
		
		BaseLabel bslblDidCustomerDelivered = new BaseLabel();
		bslblDidCustomerDelivered.setFont(new Font("Tahoma", Font.BOLD, 20));
		bslblDidCustomerDelivered.setText("Did customer delivered vehicle?");
		bslblDidCustomerDelivered.setBounds(162, 331, 375, 52);
		add(bslblDidCustomerDelivered);
		
		
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
