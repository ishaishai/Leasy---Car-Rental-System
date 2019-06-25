package design_patterns_pkg;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import enums_pkg.Credit;
import enums_pkg.Rank;
import gui_pkg.BasePanel;
import gui_pkg.BaseTextArea;
import gui_pkg.BaseTextField;
import gui_pkg.FirstDetailsPanel;
import gui_pkg.FullCustomerDetailsPanel;
import gui_pkg.Main;
import gui_pkg.MainFrame;
import gui_pkg.MainPanel;
import gui_pkg.MainUserPanel;
import gui_pkg.PaymentPanel;
import gui_pkg.ReviewOrderPanel;
import gui_pkg.UserInvoicesPanel;
import person_pkg.Customer;
import person_pkg.Employee;
import reserv_pkg.CreditCard;
import reserv_pkg.Insurance;
import reserv_pkg.Invoice;
import reserv_pkg.Reservation;
import vehicle_pkg.Vehicle;

public class ViewDesign {
	private Date m_Start,m_End;
	private int m_Age,m_DriveXP;
	
	public ViewDesign()
	{
		m_Age = 0;
		m_DriveXP = 0;
	}
	
	
	
	public final Date getM_Start() {
		return m_Start;
	}



	public final Date getM_End() {
		return m_End;
	}



	public final int getM_Age() {
		return m_Age;
	}



	public final int getM_DriveXP() {
		return m_DriveXP;
	}



	public boolean getFirstDetails()
	{
		m_Start = Main.getM_FirstScreen().getDatePickUp().getDate();
		m_End = Main.getM_FirstScreen().getDateReturn().getDate();
		try
		{
			m_Age = Integer.parseInt(Main.getM_FirstScreen().getTxtAge().getText());
			m_DriveXP = Integer.parseInt(Main.getM_FirstScreen().getTxtDriveXP().getText());
		}
		catch(NumberFormatException e)
		{
			MessageBox("Please fill the fields with digits only");
			return false;
		}
		
		if(m_End.before(m_Start))
		{
			MessageBox("Error on dates");
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
		else if (m_Age - m_DriveXP < 16)
		{
			MessageBox("Please check the age and driving years fields again.");
		}
		else
		{
			return true;
		}
		
		return false;
	}
	
	public void setRelevantVehicles()
	{
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getCarComboBox().getModel();
		
		for(Vehicle v : DataManager.getInstance().getM_Vehicles())
		{
			model.addElement(v.getM_Model());
		}
	}
	
	public void setSelectedCarDetails()
	{
		//Main.getM_selectCarPanel().getLbCarDetails().setText("Details: "+DataManager.getInstance().getM_SelectedVehicle().toString());
		Main.getM_selectCarPanel().getTxtAreaDetails().setText(DataManager.getInstance().getM_SelectedVehicle().toString());
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
			Main.getTxtpnHello().setText("Hello,\n"+DataManager.getInstance().getM_Employee().getM_Username());
			Main.getTxtpnHello().setVisible(true);
		}
	}
	
	public void SetInsurances()
	{
		Main.getM_InsurancePanel().setSelected(' ');
		Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new LineBorder(Color.BLACK,2,true));
		Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new LineBorder(Color.BLACK,2,true));
		Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new LineBorder(Color.BLACK,2,true));
		
		Main.getM_InsurancePanel().getTxtInsuranceA().setText(DataManager.getInstance().getM_Insurances().get(0).toString());
		Main.getM_InsurancePanel().getTxtInsuranceB().setText(DataManager.getInstance().getM_Insurances().get(1).toString());
		Main.getM_InsurancePanel().getTxtInsuranceC().setText(DataManager.getInstance().getM_Insurances().get(2).toString());
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
		String message = "";
		FullCustomerDetailsPanel tmp = Main.getM_FullCustomerDetailsPanel();
		if (!(tmp.getTxtFirstName().getText().matches("[a-zA-Z]+")) || tmp.getTxtFirstName().getText().length() < 2) {
			message += "Make sure the first name field is filled with English characters only and the length is greater than 2\n";
		}
		if (!(tmp.getTxtLastName().getText().matches("[a-zA-Z]+")) || tmp.getTxtLastName().getText().length() < 2) {
			message += "Make sure the last name field is filled with English characters only and the length is greater than 2\n";
		}
		if (!(tmp.getTxtID().getText().matches("[0-9]+")) || tmp.getTxtID().getText().length() < 9) {
			message += "Invalid ID\n";
		}
		if (!(tmp.getTxtPhone().getText().matches("[0-9]+")) || tmp.getTxtPhone().getText().length() < 10) {
			message += "Invalid phone number";
		}
		
		else
			return new Customer(tmp.getTxtID().getText(),tmp.getTxtFirstName().getText()+" "+tmp.getTxtLastName().getText(),tmp.getTxtPhone().getText());
		MessageBox(message);
		return null;	
	}
	

	public void MessageBox(String txt)
	{
		JOptionPane.showMessageDialog(new JFrame(), txt);
	}




	public void SetFinalReviewDetails(Vehicle vehicle, Insurance insurance, Reservation reserv, Customer customer,String price) {
		ReviewOrderPanel tmp = Main.getM_ReviewOrder();
		tmp.getTxtVehicle().setText(vehicle.toString());
		tmp.getTxtFullDetails().setText(customer.toString());
		tmp.getTxtInsurance().setText(insurance.toString());
		tmp.getTxtPrice().setText(price);
		
	}


	public boolean CardCheck()
	{
		PaymentPanel panel = Main.getM_PaymentPanel();
		
		return true;
		/*if (!(panel.getTxtNumber().getText().matches("[0-9]+"))|| panel.getTxtNumber().getText().length() != 19) {
			return false;
		}
		return true;*/
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
		    if(txtUsername.equals("") || txtPassword.equals(""))
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



	public void SetManageInvoices(DefaultTableModel dtm) {
		
		
		UserInvoicesPanel.getTableInvoices().setModel(dtm);
		
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
		
		Main.getM_Mainpanel().removeAll();
		Main.getM_Mainpanel().repaint();
		Main.getM_Mainpanel().revalidate();
		MainPanel.m_Status=0;
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
		        //ctrl.setSelectedIndex(0);
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
		}
		
	}



	public CreditCard GetCreditCard() {
		PaymentPanel panel = Main.getM_PaymentPanel();
		
		return (panel.getChckbxSaveCardFor().isSelected()) ? 
				new CreditCard((panel.getBoxMonth().getSelectedItem()+"/"+panel.getBoxYear().getSelectedItem()),"************"+panel.getTxtNumber().getText(),
						(panel.getLblAmerican().isVisible()) ? Credit.AMEX :
							(panel.getLblMaster().isVisible()) ? Credit.MASTERCARD : Credit.VISA) : null;
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
			Main.getM_ReviewOrder().getBtnLogin().setVisible(false);
			Main.getM_ReviewOrder().getBtnDiscount().setVisible(true);
		}
		else
		{
			Main.getM_WelcomePanel().getbtnLogin().setVisible(true);
			Main.getM_WelcomePanel().getBtnLogout().setVisible(false);
			Main.getM_WelcomePanel().getEmployeelbl().setVisible(true);
			Main.getM_ReviewOrder().getBtnLogin().setVisible(true);
			Main.getM_ReviewOrder().getBtnDiscount().setVisible(false);
		}
		
	}
}	

