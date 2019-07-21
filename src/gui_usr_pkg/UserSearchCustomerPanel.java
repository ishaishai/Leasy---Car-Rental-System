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

public class UserSearchCustomerPanel extends BasePanel {
	private BaseLabel bslblSearch;
	private JButton btnSearch;
	private BaseTextField txtSearchInput;


	public UserSearchCustomerPanel()
	{
		bslblSearch = new BaseLabel("Search customer:");
		bslblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		bslblSearch.setBounds(85, 40, 250, 34);
			
		add(bslblSearch);
		
		txtSearchInput = new BaseTextField();
		txtSearchInput.setBounds(135, 139,111, 20);
		add(txtSearchInput);
		
		BaseLabel bslblSearchByIdphone = new BaseLabel();
		bslblSearchByIdphone.setText("Search by: ID/Phone number");
		bslblSearchByIdphone.setBounds(135, 108, 240, 20);
		add(bslblSearchByIdphone);
		
	
		btnSearch = new JButton("Search customer");
		btnSearch.setFocusPainted(false);
		btnSearch.setFocusable(false);
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(true);
		btnSearch.setBackground(new Color(17, 41, 64));
		btnSearch.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSearch.setBounds(137, 201, 190, 36);
		btnSearch.addMouseListener(new MyMouseListener());
		add(btnSearch);
	}
	
	public BaseLabel getBslblSearch() {
		return bslblSearch;
	}



	public BaseTextField getTxtSearchInput() {
		return txtSearchInput;
	}



	public JButton getBtnSearch() {
		return btnSearch;
	}



	public final BaseLabel getbslblInvoices() {
		return bslblSearch;
	}

	public final BaseLabel getBslblInvoices() {
		return bslblSearch;
	}
}
