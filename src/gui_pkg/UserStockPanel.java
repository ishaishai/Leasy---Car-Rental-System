package gui_pkg;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class UserStockPanel extends BasePanel implements TableModelListener  {

	private BaseLabel bslblStock;
	private static JTable tableStock;

	public UserStockPanel()
	{
		bslblStock = new BaseLabel("Stock:");
		bslblStock.setBounds(85, 40, 110, 34);
		JScrollPane scrollInvoices;
		tableStock = new JTable(new DefaultTableModel());
		tableStock.setBounds(0, 225, 743, 142);
		tableStock.addMouseListener(new MyMouseListener());
		tableStock.getModel().addTableModelListener(this);
		scrollInvoices = new JScrollPane(tableStock, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(85, 85, 743, 142);
		add(scrollInvoices);
		
		
		
		
		add(bslblStock);
	}
	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public final BaseLabel getBslblStock() {
		return bslblStock;
	}
	public static final JTable getTableStock() {
		return tableStock;
	}
	
	

}
