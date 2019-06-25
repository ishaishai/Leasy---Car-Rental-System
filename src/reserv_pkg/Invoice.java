package reserv_pkg;

import person_pkg.Customer;
import vehicle_pkg.Vehicle;

public class Invoice {
	private int m_InvoiceNum;
	private Reservation m_Reserv;
	private Insurance m_Ioffer; //insurance offer
	private int m_TotalPrice;
	private Customer m_Customer;
	private Vehicle m_Vehicle;
	private CreditCard m_CreditCard;
	
	public Invoice(int m_InvoiceNum,Reservation m_Reserv, Insurance m_Ioffer, int m_TotalPrice,Customer m_Customer,Vehicle m_Vehicle,CreditCard m_CreditCard) {
		this.m_InvoiceNum = m_InvoiceNum;
		this.m_Reserv = m_Reserv;
		this.m_Ioffer = m_Ioffer;
		this.m_TotalPrice = m_TotalPrice;
		this.m_Customer = m_Customer;
		this.m_Vehicle = m_Vehicle;
		this.m_CreditCard = m_CreditCard;
	}
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public final CreditCard getM_CreditCard() {
		return m_CreditCard;
	}

	public final void setM_CreditCard(CreditCard m_CreditCard) {
		this.m_CreditCard = m_CreditCard;
	}

	public final Reservation getM_Reserv() {
		return m_Reserv;
	}

	public final void setM_Reserv(Reservation m_Reserv) {
		this.m_Reserv = m_Reserv;
	}

	public final Insurance getM_Ioffer() {
		return m_Ioffer;
	}

	public final void setM_Ioffer(Insurance m_Ioffer) {
		this.m_Ioffer = m_Ioffer;
	}

	public final int getM_TotalPrice() {
		return m_TotalPrice;
	}

	public final void setM_TotalPrice(int m_TotalPrice) {
		this.m_TotalPrice = m_TotalPrice;
	}

	public Customer getM_Customer() {
		return m_Customer;
	}

	public void setM_Customer(Customer m_Customer) {
		this.m_Customer = m_Customer;
	}

	public int getM_InvoiceNum() {
		return m_InvoiceNum;
	}

	public void setM_InvoiceNum(int m_InvoiceNum) {
		this.m_InvoiceNum = m_InvoiceNum;
	}

	public Vehicle getM_Vehicle() {
		return m_Vehicle;
	}

	public void setM_Vehicle(Vehicle m_Vehicle) {
		this.m_Vehicle = m_Vehicle;
	}
}

