package design_patterns_pkg;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import enums_pkg.Credit;
import enums_pkg.Rank;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextArea;
import gui_customized_comp.BaseTextField;
import gui_customized_comp.BaseTextPane;
import gui_pkg.FullCustomerDetailsPanel;
import gui_pkg.InvoicePanel;
import gui_pkg.Main;
import gui_pkg.MainPanel;
import gui_pkg.PaymentPanel;
import gui_pkg.ReviewOrderPanel;
import gui_usr_pkg.MainUserPanel;
import gui_usr_pkg.UserCustomersPanel;
import gui_usr_pkg.UserInvoicesPanel;
import gui_usr_pkg.UserStockPanel;
import listeners_pkg.MyDocumentListener;
import person_pkg.Customer;
import person_pkg.Employee;
import regex_pkg.RegexChecker;
import reserv_pkg.CreditCard;
import reserv_pkg.Insurance;
import reserv_pkg.Invoice;
import reserv_pkg.Reservation;
import vehicle_pkg.Vehicle;

public class ViewDesign {
	public Reservation getFirstDetails()
	{
		Date m_Start = Main.getM_FirstScreen().getDatePickUp().getDate();
		Date m_End = Main.getM_FirstScreen().getDateReturn().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dpickup = sdf.format(m_Start);
		String dreturn = sdf.format(m_End);
		
		int m_Age=0;
		int m_DriveXP=0;
		
		
		if(RegexChecker.checkOnlyNumbers(Main.getM_FirstScreen().getTxtAge().getText()) && 
				RegexChecker.checkOnlyNumbers(Main.getM_FirstScreen().getTxtDriveXP().getText()))
		{
			m_Age = Integer.parseInt(Main.getM_FirstScreen().getTxtAge().getText());
			m_DriveXP = Integer.parseInt(Main.getM_FirstScreen().getTxtDriveXP().getText());
			Main.getM_FirstScreen().getTxtpnAgeNXP().setVisible(false);
		}
		else
		{
			Main.getM_FirstScreen().getTxtpnAgeNXP().setVisible(true);
			return null;
		}
		
		if(m_End.before(m_Start) || dpickup.contentEquals(dreturn))
		{
			Main.getM_FirstScreen().getTxtpnMinimumHours().setVisible(true);
			return null;
		}
		else if(m_Age<18)
		{
			MessageBox("Too young");
		}
		else if(m_Age > 80)
		{
			MessageBox("Too old");
		}
		else if(m_DriveXP<1)
		{
			MessageBox("No expirience no rent");
		}
		else if (m_Age - m_DriveXP < 17)
		{
			MessageBox("Please check the age and driving years fields again.");
		}
		else
		{
			return new Reservation(dpickup,dreturn,m_Age,m_DriveXP);
		}
		
		Main.getM_FirstScreen().getTxtpnMinimumHours().setVisible(false);
		return null;
	}
	
	public void setRelevantVehicles(HashMap<String, Vehicle> vehicles)
	{
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getCarComboBox().getModel();
		
		for(Entry<String, Vehicle> vehicle : DataManager.getInstance().getM_Vehicles().entrySet())
		{
			((DefaultComboBoxModel<String>) model).addElement(vehicle.getValue().getM_Model());
		}
	}
	
	public void setSelectedCarDetails(Vehicle vehicle)
	{
		if(vehicle!=null)
			Main.getM_selectCarPanel().getTxtAreaDetails().setText(vehicle.toString());
	}

	public void setSelectCarRanks(Rank r)
	{
		((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).removeAllElements();
		((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getCarComboBox().getModel()).removeAllElements();
		
		
		switch(r)
		{
		case A:
		{
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("A", 0);
			break;
		}
		case B:
		{
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("A", 0);
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("B", 1);	
			break;
		}
		case C:
		{
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("A", 0);
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("B", 1);
			((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt("C", 2);
			break;
		}
		case D:
		{
			for(Rank rank : Rank.values())
			{
				((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).insertElementAt(rank.name(), Main.getM_selectCarPanel().getRankComboBox().getItemCount());
			}
			break;
		}
		}
		
		Main.getM_selectCarPanel().getTxtAreaDetails().setText(null);
	}
	
	public String GetSelectedVehicle()
	{
		return (String) Main.getM_selectCarPanel().getCarComboBox().getModel().getSelectedItem();
	}
	
	public void SetLoginInfo(String username)
	{
		if(username == null)
		{
			Main.getTxtpnHello().setText(null);
			Main.getTxtpnHello().setVisible(false);
			ChangeUserStatus(false);
		}
		else
		{
			Main.getTxtpnHello().setText("Hello,\n"+username);
			Main.getTxtpnHello().setVisible(true);
		}
	}
	
	public void SetInsurances(List<Insurance> list)
	{
		
		Main.getM_InsurancePanel().setSelected(Character.MIN_VALUE);
		Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				list.get(0).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
		
		Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				list.get(1).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
		
		Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				list.get(2).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
		
		
		Main.getM_InsurancePanel().getTxtInsuranceA().setText(list.get(0).getM_Desc());
		Main.getM_InsurancePanel().getTxtInsuranceB().setText(list.get(1).getM_Desc());
		Main.getM_InsurancePanel().getTxtInsuranceC().setText(list.get(2).getM_Desc());
	}



	public char GetSelectedInsurance() {
		if(Main.getM_InsurancePanel().getSelected() == Character.MIN_VALUE)
		{
			MessageBox("Please choose insurance first");
			return Character.MIN_VALUE;
		}
		
		return Main.getM_InsurancePanel().getSelected();
		
	}
	
	public Customer GetFullDetails() 
	{
		String message = null;
		boolean error = false;
		FullCustomerDetailsPanel tmp = Main.getM_FullCustomerDetailsPanel();
	
		if (!(RegexChecker.checkOnlyLetters(tmp.getTxtFirstName().getText())) || tmp.getTxtFirstName().getText().length() < 3) {
			Main.getM_FullCustomerDetailsPanel().getTxtpnName().setVisible(true);
			error = true;
		}
		else
		{
			Main.getM_FullCustomerDetailsPanel().getTxtpnName().setVisible(false);
			error = false;
		}
		if (!(RegexChecker.checkOnlyLetters(tmp.getTxtLastName().getText())) || tmp.getTxtLastName().getText().length() < 2) {
			Main.getM_FullCustomerDetailsPanel().getTxtpnLname().setVisible(true);
			error = true;
		}
		else
		{
			Main.getM_FullCustomerDetailsPanel().getTxtpnLname().setVisible(false);
			error = false;
		}
		if (!(RegexChecker.checkOnlyNumbers(tmp.getTxtID().getText())) || tmp.getTxtID().getText().length() < 9) {
			Main.getM_FullCustomerDetailsPanel().getTxtpnID().setVisible(true);
			error = true;
		}
		else
		{
			Main.getM_FullCustomerDetailsPanel().getTxtpnID().setVisible(false);
			error = false;
		}
		if (!(RegexChecker.checkPhoneNumber(tmp.getTxtPhone().getText())) || tmp.getTxtPhone().getText().length() < 10) {
			Main.getM_FullCustomerDetailsPanel().getTxtpnPhone().setVisible(true);
			error = true;
		}
		else
		{
			Main.getM_FullCustomerDetailsPanel().getTxtpnPhone().setVisible(false);
			error = false;
		}
		return (error) ? null : new Customer(tmp.getTxtID().getText(),
				((tmp.getTxtFirstName().getText().substring(0,1).toUpperCase()+tmp.getTxtFirstName().getText().substring(1))+" "+
						(tmp.getTxtLastName().getText().substring(0,1).toUpperCase()+tmp.getTxtLastName().getText().substring(1))),
							tmp.getTxtPhone().getText());
	}

	public void MessageBox(String txt)
	{
		JOptionPane.showMessageDialog(new JFrame(), txt);
	}




	public void SetFinalReviewDetails(Vehicle vehicle, Insurance insurance, Reservation reserv, Customer customer,String price) {
		ReviewOrderPanel tmp = Main.getM_ReviewOrder();
		tmp.getTxtVehicle().setText(vehicle.toString());
		tmp.getTxtFullDetails().setText(customer.toString() + "\n\n"+reserv.toString());
		tmp.getTxtInsurance().setText(insurance.getM_Title()+"\n"+insurance.getM_Desc());
		tmp.getTxtPrice().setText(price);
		tmp.getBtnDiscount().setEnabled(true);
	}

	
	public void creditSwitch()
	{
		PaymentPanel panel = Main.getM_PaymentPanel();
		Runnable editCard = new Runnable()
		{
			@Override
			public void run() {
				System.out.println(panel.getTxtNumber().getText());
				panel.getTxtNumber().getDocument().removeDocumentListener(panel.getMydoclistener());
				panel.getTxtNumber().setText(String.format("%s-",panel.getTxtNumber().getText()));
				panel.getTxtNumber().getDocument().addDocumentListener(panel.getMydoclistener());
			}
		};
		
		if(panel.getTxtNumber().getText().length()>0)
		{
			if(panel.getTxtNumber().getText().length()==14)
			{
				SwingUtilities.invokeLater(editCard);
			}
			else if(panel.getTxtNumber().getText().length()==9)
			{
				SwingUtilities.invokeLater(editCard);					
			}
			else if(panel.getTxtNumber().getText().length()==4)
			{
				SwingUtilities.invokeLater(editCard);					
			}
			else if(panel.getTxtNumber().getText().length()==19)
			{
				Credit credit = RegexChecker.checkCreditType(panel.getTxtNumber().getText());
				if(credit!=null)
				{
					panel.setValidCard(true);
					switch(credit)
					{
					case MASTERCARD:
					{
						panel.getLblMaster().setVisible(true);
						panel.getLblAmerican().setVisible(false);
						panel.getLblVisa().setVisible(false);
						return;
					}
					case VISA:
					{
						panel.getLblMaster().setVisible(false);
						panel.getLblAmerican().setVisible(false);
						panel.getLblVisa().setVisible(true);
						return;
					}
					case AMEX:
					{
						panel.getLblMaster().setVisible(false);
						panel.getLblAmerican().setVisible(true);
						panel.getLblVisa().setVisible(false);
						return;
					}
					default:
					{
						panel.setValidCard(false);
						panel.getLblMaster().setVisible(true);
						panel.getLblAmerican().setVisible(true);
						panel.getLblVisa().setVisible(true);
					}
					}
				}
			}			
		}
		panel.getLblMaster().setVisible(true);
		panel.getLblAmerican().setVisible(true);
		panel.getLblVisa().setVisible(true);
	}

	public boolean CardCheck()
	{
		PaymentPanel panel = Main.getM_PaymentPanel();
		
		if(panel.isValidCard())
		{
			if(!(panel.getTxtNumber().getText().matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$")))
			{
				MessageBox("Only 16 digits are allowed seperated by '-'");
				return false;
			}
			else if(!(panel.getTxtCVV().getText().matches("^[0-9]{3}$")))
			{
				MessageBox("CVT can be only 3 digits");
				return false;
			}
		}
		else
		{
			MessageBox("Card is invalid");
			return false;
		}
		
		
		
		return true;
	}

	public boolean PaymentSimulate() 
	{
		Main.getM_PaymentPanel().getProgressBar().setValue(Main.getM_PaymentPanel().getProgressBar().getValue() +1);
	    switch(Main.getM_PaymentPanel().getProgressBar().getValue())
	           {
	            case 1:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Connecting to credit card company...");
	            	break;
	            }
	            case 20:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Validating personal information...");
	            	break;
	            }
	            case 38:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Requesting payment from card...");
	            	break;
	            }
	            case 70:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Payment has been done.");
	            	break;
	            }
	            case 80:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Setting up invoice...");
	            	break;
	            }
	            case 100:
	            {
	            	Main.getM_PaymentPanel().getLblProgress().setText("Invoice ready, go to next screen");
	            	return true;
	            }  	
	        }
		return false;	
	}



	public Employee GetUserInfo() {
		BaseTextField username = new BaseTextField();
		JPasswordField password = new JPasswordField();
		String txtUsername = null;
		String txtPassword = null;
		
		Object[] message = {
		    "Username: ", username,
		    "Password: ", password
		};
		int option = JOptionPane.showConfirmDialog(new JFrame(), message, "Enter login info:", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
		    txtUsername = username.getText();
		    txtPassword = String.valueOf(password.getPassword());
		    if(!RegexChecker.checkOnlyLetters(txtUsername) || !RegexChecker.checkOnlyNumbers(txtPassword))
		    {
		    	return null;
		    }
		    else
		    {
		    	return new Employee(txtUsername,txtPassword);	
		    }
		}
		return null;
	}



	public void SetManageStock(DefaultTableModel dtm) {
		UserStockPanel.getTableStock().setModel(dtm);
		FixTableCols(UserStockPanel.getTableStock());
	}

	public void SetManageInvoices(DefaultTableModel dtm) {
		UserInvoicesPanel.getTableInvoices().setModel(dtm);
		FixTableCols(UserInvoicesPanel.getTableInvoices());
	}

	public void SetManageCustomers(DefaultTableModel dtm) {
		UserCustomersPanel.getTableCustomers().setModel(dtm);
		FixTableCols(UserCustomersPanel.getTableCustomers());
		
	}


	private void FixTableCols(JTable mainTable) {
		adjustJTableRowSizes(mainTable);
        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            adjustColumnSizes(mainTable, i, 2);
        }
		
	}
	
	private void adjustJTableRowSizes(JTable jTable) {
        for (int row = 0; row < jTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
                Object valueAt = jTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            jTable.setRowHeight(row, maxHeight);
        }

    }

    public void adjustColumnSizes(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        
        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }

        width += 2 * margin;

        col.setPreferredWidth(width);
        col.setWidth(width);
    }



	protected void ShowDirPanel() {
		Main.getM_DirPanel().setVisible(true);
		
	}
	
	public void UpdateReservDiscount(String UpdatedPrice) {
		Main.getM_ReviewOrder().getTxtPrice().setText(UpdatedPrice);		
	}



	public void ChangeScreen(BasePanel panel) {
		Main.getM_Mainpanel().removeAll();
		Main.getM_Mainpanel().add(panel);
		Main.getM_Mainpanel().repaint();
		Main.getM_Mainpanel().revalidate();
		
	}



	public void SetDirBackButton(boolean b) {
		Main.getM_DirPanel().getBackButton().setVisible(b);
	}
	
	public void SetDirNextButton(boolean b)
	{
		Main.getM_DirPanel().getNextButton().setVisible(b);
	}



	public void SetHomePage(String username) {
		SetLoginInfo(username);
		MainPanel.m_Status=0;		
		Main.getM_Mainpanel().removeAll();
		Main.getM_Mainpanel().repaint();
		Main.getM_Mainpanel().revalidate();
		Main.getM_Mainpanel().add(Main.getM_WelcomePanel());
		Main.getM_DirPanel().getBackButton().setVisible(false);
		Main.getM_DirPanel().getNextButton().setVisible(false);
		
	}



	public String GetDiscountFromUser() {
		do
		{
			String discount = JOptionPane.showInputDialog("5,10,15 discounts only");
			if(discount.contentEquals("5") || discount.contentEquals("10") || discount.contentEquals("15"))
			{
				return discount;
			}
				
		}while(true);
	}



	public void ClearDetails(Component[] c) {
		for(Component control : c)
		{
		    if((JComponent)control instanceof BaseTextField)
		    {
		    	BaseTextField ctrl = (BaseTextField) control;
		        ctrl.setText("");
		    }
		    else if((JComponent)control instanceof BaseTextArea)
		    {
		    	BaseTextArea ctrl = (BaseTextArea) control;
		        ctrl.setText("");
		    }
		    
		    else if ((JComponent)control instanceof JComboBox)
		    {
		        @SuppressWarnings("unchecked")
				JComboBox<String> ctrl =  (JComboBox<String>) control;
		        ctrl.removeAllItems();
		    }
		    else if((JComponent)control instanceof JDateChooser)
		    {
		    	JDateChooser ctrl =  (JDateChooser) control;
		    	ctrl.setDate(new Date());
		    }
		    else if((JComponent)control instanceof JProgressBar)
		    {
		    	JProgressBar ctrl = (JProgressBar) control;
		    	ctrl.setValue(0);
		    	Main.getM_PaymentPanel().getLblProgress().setText("");
		    }
		    else if((JComponent)control instanceof BaseTextPane)
		    {
		    	BaseTextPane ctrl = (BaseTextPane) control;
		    	ctrl.setVisible(false);
		    }
		    
		}
		
	}



	public CreditCard GetCreditCard() {
		PaymentPanel panel = Main.getM_PaymentPanel();
		return new CreditCard((panel.getBoxMonth().getSelectedItem()+"/"+panel.getBoxYear().getSelectedItem()),"************"+panel.getTxtNumber().getText().substring(panel.getTxtNumber().getText().length()-4),
						(panel.getLblAmerican().isVisible()) ? Credit.AMEX :
							(panel.getLblMaster().isVisible()) ? Credit.MASTERCARD : Credit.VISA);
	}



	public void SetPaymentBoxes() {
		popYears();
		popMonths();
		
	}
	

	private void popYears() {
		
		for (int i= Calendar.getInstance().get(Calendar.YEAR); i<Calendar.getInstance().get(Calendar.YEAR)+5; i++) {
			Main.getM_PaymentPanel().getBoxYear().addItem(String.valueOf(i));
		}
	}
	private void popMonths() {
		for (int i=1; i<13; i++) {
			if (i<10) {
				Main.getM_PaymentPanel().getBoxMonth().addItem("0" +i);
			}
			else {
				Main.getM_PaymentPanel().getBoxMonth().addItem(String.valueOf(i));
			}
		}
	}



	public void ChangeUserScreen(BasePanel panel) {

		MainUserPanel.getM_layeredPaneTop().removeAll();
		MainUserPanel.getM_layeredPaneTop().repaint();
		MainUserPanel.getM_layeredPaneTop().revalidate();
		MainUserPanel.getM_layeredPaneTop().add(panel);
		
	}



	public void ChangeUserStatus(boolean b) {
		if(b)
		{
			Main.getM_WelcomePanel().getbtnLogin().setVisible(false);
			Main.getM_WelcomePanel().getBtnLogout().setVisible(true);
			Main.getM_WelcomePanel().getEmployeelbl().setVisible(false);
			Main.getM_WelcomePanel().getBtnManage().setVisible(true);
			Main.getM_ReviewOrder().getBtnLogin().setVisible(false);
			Main.getM_ReviewOrder().getBtnDiscount().setVisible(true);
			Main.getM_ReviewOrder().getBtnDiscount().setEnabled(true);
		}
		else
		{
			Main.getM_WelcomePanel().getbtnLogin().setVisible(true);
			Main.getM_WelcomePanel().getBtnLogout().setVisible(false);
			Main.getM_WelcomePanel().getEmployeelbl().setVisible(true);
			Main.getM_WelcomePanel().getBtnManage().setVisible(false);
			Main.getM_ReviewOrder().getBtnLogin().setVisible(true);
			Main.getM_ReviewOrder().getBtnDiscount().setVisible(false);
		}
		
	}

	public String getSelectedCustomer() {
		String selectedCustomer = ((DefaultTableModel)UserCustomersPanel.getTableCustomers().getModel()).getValueAt(UserCustomersPanel.getTableCustomers().getSelectedRow(), 0).toString();	
		((DefaultTableModel)UserCustomersPanel.getTableCustomers().getModel()).removeRow(UserCustomersPanel.getTableCustomers().getSelectedRow());
		return selectedCustomer;
	}

	public void SetFinalInvoice(Invoice invoice) {
		InvoicePanel panel = Main.getM_InvoicePanel();
		
		panel.getTxtReserv().setText(Integer.toString(invoice.getM_InvoiceNum()));
		panel.getTxtCreditCard().setText(invoice.getM_CreditCard().getM_Digits());
		panel.getCustomerDetails().setText(invoice.getM_Customer().toString() + invoice.getM_Reserv().toString());
		panel.getTxtVehicle().setText(invoice.getM_Vehicle().toString());
		panel.getTxtInsurance().setText(invoice.getM_Ioffer().toString());
		panel.getTxtPrice().setText(Integer.toString(invoice.getM_TotalPrice()));
	}

	public String getSelectedRank() {
		return ((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).getSelectedItem().toString();
	}

	



}	

