package design_patterns_pkg;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import person_pkg.*;
import reserv_pkg.*;
import vehicle_pkg.*;

/*
 * The DataManager class implemented as our singleton design pattern
 */

public class DataManager 
{
	private static DataManager m_DataManager;
	
	private Invoice m_Invoice;
	private Reservation m_Reserv;
	private List<Insurance> m_Insurances;
	private Insurance m_SelectedInsurance;
	private Employee m_Employee;
	private Customer m_Customer;
	private HashMap<String,Vehicle> m_Vehicles;
	private Vehicle m_SelectedVehicle;
	private SqlLink m_SqlLink;
	
	private DataManager() throws ClassNotFoundException
	{
		m_Invoice = new Invoice();
		m_Reserv = new Reservation();
		m_Insurances = new ArrayList<>();
		m_SelectedInsurance = new Insurance();
		m_Employee = null;
		m_Customer = new Customer();
		m_Vehicles = new HashMap<String,Vehicle>();
		m_SqlLink = new SqlLink();
		m_SelectedVehicle = null;
	}
	
	public static DataManager getInstance()
	{
		if(m_DataManager == null)
		{
			try
			{
			m_DataManager = new DataManager();
			}
			catch(ClassNotFoundException exception)
			{
				System.out.println(exception.getMessage());
			}
		}
		return m_DataManager;
	}

	
	public final Vehicle getM_SelectedVehicle() {
		return m_SelectedVehicle;
	}

	public final void setM_SelectedVehicle(Vehicle m_SelectedVehicle) {
		this.m_SelectedVehicle = m_SelectedVehicle;
	}

	public static final DataManager getM_DataManager() {
		return m_DataManager;
	}

	public static final void setM_DataManager(DataManager m_DataManager) {
		DataManager.m_DataManager = m_DataManager;
	}

	public final Invoice getM_Invoice() {
		return m_Invoice;
	}

	public final void setM_Invoice(Invoice m_Invoice) {
		this.m_Invoice = m_Invoice;
	}

	public final Reservation getM_Reserv() {
		return m_Reserv;
	}

	public final void setM_Reserv(Reservation m_Reserv) {
		this.m_Reserv = m_Reserv;
	}

	public final List<Insurance> getM_Insurances() {
		return m_Insurances;
	}

	public final void setM_Insurances(List<Insurance> m_Insurances) {
		this.m_Insurances = m_Insurances;
	}

	public final Employee getM_Employee() {
		return m_Employee;
	}

	public final void setM_Employee(Employee m_Employee) {
		this.m_Employee = m_Employee;
	}

	public final Customer getM_Customer() {
		return m_Customer;
	}

	public final void setM_Customer(Customer m_Customer) {
		this.m_Customer = m_Customer;
	}

	public final HashMap<String,Vehicle> getM_Vehicles() {
		return m_Vehicles;
	}

	public final void setM_Vehicles(HashMap<String,Vehicle>  m_Vehicles) {
		this.m_Vehicles = m_Vehicles;
	}

	public final SqlLink getM_SqlLink() {
		return m_SqlLink;
	}

	public final void setM_SqlLink(SqlLink m_SqlLink) {
		this.m_SqlLink = m_SqlLink;
	}

	public Insurance getM_SelectedInsurance() {
		return m_SelectedInsurance;
	}

	public void setM_SelectedInsurance(Insurance m_SelectedInsurance) {
		this.m_SelectedInsurance = m_SelectedInsurance;
	}

	
	
	
}

