package design_patterns_pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;

import gui_pkg.Main;
import gui_pkg.MainPanel;
import gui_usr_pkg.MainUserPanel;
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
	

	///////////////////////////////////////////////////////////////////////////////////////
	///																				    ///
	///			Navigating methods between screens using Next and Back buttons		    ///	
	///																					///
	///////////////////////////////////////////////////////////////////////////////////////
	
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
			if(!FirstDetailsCheck())
			{
				return;
			}
			m_View.ChangeScreen(Main.getM_selectCarPanel());
			m_View.SetDirBackButton(true);
			break;
		}
		case 2:
		{
			if(!(CheckIfChoseCar(m_Model.getSelectedVehicle())))
			{
				m_View.MessageBox("Need to pick vehicle first");
				return;
			}
			
			m_View.ChangeScreen(Main.getM_InsurancePanel());
			m_View.ClearDetails(Main.getM_InsurancePanel().getComponents());
			m_View.SetInsurances(m_Model.PullInsurances());
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
							m_Model.SetFinalInvoice(m_View.GetCreditCard());
							m_View.MessageBox((m_Model.SaveInvoice()));
							m_View.ChangeScreen(Main.getM_InvoicePanel());
							m_View.SetFinalInvoice(m_Model.GetFinalInvoice());
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
	
	///////////////////////////////////////////////////////////////////////////////////////
	///																				    ///
	///						End of navigating methods								    ///	
	///																					///
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	/*
	 * FirstDetailsCheck method for test errors in first reservation details 
	 * and set those details in the model.
	 * if everything goes well the next screen will get the customer available vehicle ranks
	 */
	
	public boolean FirstDetailsCheck()
	{
		Reservation reserv;
		if((reserv=m_View.getFirstDetails())==null)
			return false;
		m_Model.SetFirstDetails(reserv);
		m_View.setSelectCarRanks(m_Model.RankFilter());		
		return true;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////
	///																				    ///
	///			Following methods are vehicle choose screen managing events 		    ///	
	///																					///
	///////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * LoadVehicles method used for setting the relevant vehicles related to the customer chosen vehicle rank
	 * and set 
	 */
	public void LoadVehicles()
	{
		m_View.setRelevantVehicles(m_Model.getRelevantVehicles(m_View.getSelectedRank()));
	}
	////////////////////////////////////////////////////////////////////////////////////////////

	
	/*
	 * SetVehicleDetails method is used for setting the TextArea after selecting a vehicle from list
	 */
	public void SetVehicleDetails()
	{
		m_View.setSelectedCarDetails(m_Model.FindSelectedCarDetails(m_View.GetSelectedVehicle()));
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * CheckIfChoseCar method used when trying to go to next screen (if not chosen gets msg)
	 */
	public boolean CheckIfChoseCar(Vehicle vehicle)
	{
		return (vehicle!=null) ? true : false;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////
	///																				    ///
	///						End of managing vehicle choose event methods			    ///	
	///																					///
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	/*
	 * CheckChosenInsurance method is used to check and set the chosen insurance deal
	 */
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
	///////////////////////////////////////////////////////////////////////////////////
	

	/*
	 * CheckFullDetails method is used to check whether all customer details are valid
	 * in fullcustomerdetails panel and process customer details - if customer is new or 
	 * already exists it will pop up a message about it
	 */
	public boolean CheckFullDetails() 
	{
		Customer c = m_View.GetFullDetails();
		String msg;
		if(c==null)
			return false;
		m_Model.setFinalPrice();
		msg = m_Model.SetFullDetails(c);
		m_View.MessageBox(msg);
		if(!(msg.contentEquals("Returned customer")) && !(msg.contentEquals("New customer")))
		{
			return false;
		}
		return true;		
	}
	////////////////////////////////////////////////////////////////////////////////////////


	
	public boolean ReviewLogin()
	{
		if(checkUserLogin())
		{
			m_View.ChangeUserStatus(true);
		}
		else
		{
			m_View.ChangeUserStatus(false);
		}
		
		
		return false;
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
			}
		}
		else
		{
			m_Model.SetLoggedEmployee(null);
			m_View.SetLoginInfo(null);			
		}
	}
	
	private void HandleFinalReview() {
		Vehicle vehicle = m_Model.getSelectedVehicle();
		Insurance insurance = m_Model.getSelectedInsurance();
		Reservation reserv = m_Model.getReserv();
		Customer customer = m_Model.getCustomer();
		String price = String.format("%d", m_Model.getFinalPrice());		
		m_View.SetFinalReviewDetails(vehicle,insurance,reserv,customer,price);		
	}

	public boolean PaymentHandle() {
		return m_View.PaymentSimulate();
		
	}


	
	public void setUserHome()
	{
		m_View.ChangeScreen(Main.getM_MainUser());
		m_View.ChangeUserScreen(MainUserPanel.getM_MenuMain());
	}
	


	public void SetDiscount() {
		m_View.UpdateReservDiscount(m_Model.SetReservDiscount(m_View.GetDiscountFromUser()));
		
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
	
	public void LoadCustomers() {
		m_View.SetManageCustomers(m_Model.GetCompanyCustomers());
		m_View.ChangeUserScreen(MainUserPanel.getM_UserCustomersPanel());
		
	}



	public final ModelDesign getM_Model() {
		return m_Model;
	}


	public final ViewDesign getM_View() {
		return m_View;
	}


	public void RemoveCustomer() {
		m_Model.DeleteCustomer(m_View.getSelectedCustomer());
	}


	public void EditCreditCard() {
		m_View.creditSwitch();		
	}
	
}
