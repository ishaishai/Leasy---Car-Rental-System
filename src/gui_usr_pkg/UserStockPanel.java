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

public class UserStockPanel extends BasePanel {

	private BaseLabel bslblStock;
	private static JTable tableStock;

	public UserStockPanel()
	{
		bslblStock = new BaseLabel("Stock:");
		bslblStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		bslblStock.setBounds(85, 40, 110, 34);
		JScrollPane scrollInvoices;
		tableStock = new JTable(new DefaultTableModel());
		tableStock.setBounds(0, 225, 743, 142);
		scrollInvoices = new JScrollPane(tableStock, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollInvoices.setBounds(85, 85, 743, 276);
		add(scrollInvoices);
		
		
		
		
		add(bslblStock);
	}

	public final BaseLabel getBslblStock() {
		return bslblStock;
	}

	public static final JTable getTableStock() {
		return tableStock;
	}
	
	
}
