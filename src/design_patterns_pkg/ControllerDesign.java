package design_patterns_pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;

import gui_pkg.Main;
import gui_pkg.MainPanel;
import gui_pkg.MainUserPanel;
import person_pkg.Customer;
import reserv_pkg.Insurance;
import reserv_pkg.Reservation;
import vehicle_pkg.Vehicle;

public class ControllerDesign 
{
	private ModelDesign m_Model;
	private ViewDesign m_View;
	private Timer t;
	
	public ControllerDesign(ModelDesign model,ViewDesign view)
	{
		t = null;
		m_Model = model;
		m_View = view;
	}
	
	
	public boolean FirstDetailsCheck()
	{
		if(m_View.getFirstDetails()==false)
			return false;
		m_Model.SetFirstDetails(new Reservation(m_View.getM_Start(),m_View.getM_End(),m_View.getM_Age(),m_View.getM_DriveXP()));
		
		System.out.println(DataManager.getInstance().getM_Reserv().toString());
		
		m_View.setSelectCarRanks(m_Model.RankFilter());		
		return true;
	}
	
	public void LoadVehicles()
	{
		m_Model.getRelevantVehicles(((DefaultComboBoxModel<String>) Main.getM_selectCarPanel().getRankComboBox().getModel()).getSelectedItem().toString());
		m_View.setRelevantVehicles();
	}
	



	public void SetVehicleDetails()
	{
		m_Model.FindSelectedCarDetails(m_View.GetSelectedVehicle());
		m_View.setSelectedCarDetails();
	}
	
	public boolean ReviewLogin()
	{
		if(this.checkUserLogin())
		{
			m_View.ChangeUserStatus(true);
		}
		else
		{
			m_View.ChangeUserStatus(false);
		}
		
		
		return false;
	}
	
	public boolean CheckIfChooseCar()
	{
		if(DataManager.getInstance().getM_SelectedVehicle() == null)
		{
			m_View.MessageBox("Need to pick vehicle first");
			return false;
		}
		return true;
	}
	


	public boolean CheckChosenInsurance() 
	{
		char Selected = m_View.GetSelectedInsurance();
		if(Selected == Character.MIN_VALUE)
		{
			return false;
		}
		m_Model.SetSelectedInsurance(Selected);
		return true;
	}

	public boolean CheckFullDetails() 
	{
		Customer c = m_View.GetFullDetails();
		if(c==null)
			return false;
		m_Model.SetFullDetails(c);
		m_Model.setFinalPrice();
		return true;
	}


	private void HandleFinalReview() {
		Vehicle vehicle = m_Model.getSelectedVehicle();
		Insurance insurance = m_Model.getSelectedInsurance();
		Reservation reserv = m_Model.getReserv();
		Customer customer = m_Model.getCustomer();
		String price = String.format("%d", m_Model.getFinalPrice());
		//String username = m_Model.getLoggedEmployee();
		
		m_View.SetFinalReviewDetails(vehicle,insurance,reserv,customer,price);		
	}


	


	public boolean ReviewForward() {
		
		return true;
	}


	public boolean PaymentHandle() {
		return m_View.PaymentSimulate();
		
	}


	private boolean checkUserLogin() {
		if(m_Model.SetLoggedEmployee(m_View.GetUserInfo()))
		{
			m_View.SetLoginInfo(m_Model.getLoggedEmployee());
			return true;
		}
		else
		{
			m_View.MessageBox("Wrong user\\password");
		}
		
		return false;
	}
	
	public void mainLogin(boolean b)
	{
		if(b)
		{
			if(checkUserLogin())
			{
				m_View.ChangeUserStatus(true);
				setUserHome();
			}
		}
		else
		{
			m_Model.SetLoggedEmployee(null);
			m_View.SetLoginInfo(null);			
		}
	}
	
	public void setUserHome()
	{
		m_View.ChangeScreen(Main.getM_MainUser());
	}
	


	public void SetDiscount() {
		m_View.UpdateReservDiscount(m_Model.SetReservDiscount(m_View.GetDiscountFromUser()));
		
	}


	public void MoveForward() {
		switch(MainPanel.m_Status)
		{
		case 0:
		{
			m_View.ClearDetails(Main.getM_FirstScreen().getComponents());
			m_View.ChangeScreen(Main.getM_FirstScreen());
			m_View.ShowDirPanel();
			break;
		}
		case 1:
		{
			if(FirstDetailsCheck()==false)
			{
				return;
			}
			m_View.ChangeScreen(Main.getM_selectCarPanel());
			m_View.SetDirBackButton(true);
			break;
		}
		case 2:
		{
			if(!(CheckIfChooseCar()))
			{
				return;
			}
			
			m_View.ChangeScreen(Main.getM_InsurancePanel());
			m_View.ClearDetails(Main.getM_InsurancePanel().getComponents());
			m_Model.PullInsurances();
			m_View.SetInsurances();
			break;
		}
		case 3:
		{
			if(!(CheckChosenInsurance()))
			{
				return;
			}
			m_View.ChangeScreen(Main.getM_FullCustomerDetailsPanel());
			m_View.ClearDetails(Main.getM_FullCustomerDetailsPanel().getComponents());
			
			break;
		}
		case 4:
		{
			if(!(CheckFullDetails()))
			{
					return;
			}
			m_View.ChangeScreen(Main.getM_ReviewOrder());
			m_View.ClearDetails(Main.getM_ReviewOrder().getComponents());
			HandleFinalReview();
			break;
		}
		case 5:
		{
			if(!(ReviewForward()))
			{
				return;
			}
			
			m_View.ChangeScreen(Main.getM_PaymentPanel());
			m_View.ClearDetails(Main.getM_PaymentPanel().getComponents());
			m_View.SetPaymentBoxes();
			break;
			
		}
		case 6:
		{
			if(getCardInfo()) {
				t = new Timer(50, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						if(PaymentHandle())
						{
								
							// need to save 4 last digits of credit card and some other details
							m_View.MessageBox((m_Model.SetFinalInvoice(m_View.GetCreditCard())));
							m_View.ChangeScreen(Main.getM_InvoicePanel());
							m_View.SetDirBackButton(false);
							m_View.SetDirNextButton(false);
							stopTimer(t);
								}
						else {
							return;
						}
					}
					
					
				});	
				t.start();
		
				break;
			}
			else {
				m_View.MessageBox("Please check your card info");
				return;
			}
		}
	}
		MainPanel.m_Status++;
		System.out.println(MainPanel.m_Status);
		
	}


	public void MoveBackward() {
		MainPanel.m_Status--;
		System.out.println(MainPanel.m_Status);
		switch(MainPanel.m_Status)
		{
		case 1:
		{
			m_View.SetDirBackButton(false);
			m_View.ChangeScreen(Main.getM_FirstScreen());
					
			break;
		}
		case 2:
		{
			m_View.ChangeScreen(Main.getM_selectCarPanel());
			break;
		}
		case 3:
		{
			m_View.ChangeScreen(Main.getM_InsurancePanel());
			break;
		}
		case 4:
		{
			m_View.ChangeScreen(Main.getM_FullCustomerDetailsPanel());
			break;
		}
		case 5:
		{
			m_View.ChangeScreen(Main.getM_ReviewOrder());
			break;
		}
		}
		
	}
	
	private boolean getCardInfo() {
		return m_View.CardCheck();
	}
	
	public void stopTimer(Timer timer)
	{
		timer.stop();
	}


	public void SetHomePage() {
		m_View.SetHomePage(m_Model.getLoggedEmployee());
		
	}


	public void LoadInvoices() {
		m_View.SetManageInvoices(m_Model.GetInvoices());
		m_View.ChangeUserScreen(MainUserPanel.getM_UserInvoices());
	}


	public void LoadStock() {
		m_View.SetManageStock(m_Model.GetCompanyStock());
		m_View.ChangeUserScreen(MainUserPanel.getM_UserStockPanel());
	}

}
