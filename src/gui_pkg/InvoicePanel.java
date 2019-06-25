package gui_pkg;

import java.awt.Color;

import javax.swing.ImageIcon;

public class InvoicePanel extends BasePanel
{
	
	private BaseTextField txtReserv;
	private BaseTextField txtCreditCard;
	private BaseTextArea txtVehicle;
	private BaseTextArea txtInsurance;
	private BaseTextArea txtPrice;
	private BaseLabel Tick;
	private BaseLabel CreditCard;
	private BaseLabel ReservNum;
	private BaseTextArea CustomerDetails;
	private BaseLabel lblTitleReserv;
	
	public InvoicePanel()
	{
		lblTitleReserv = new BaseLabel("Reservation Completed!");
		//lblTitleReserv.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitleReserv.setBounds(393, 33, 368, 47);
		lblTitleReserv.setForeground(new Color(60, 179, 113));
		add(lblTitleReserv);
		
		ReservNum = new BaseLabel("Reservation Number:");
		ReservNum.setBounds(205, 91, 181, 47);
		add(ReservNum);
		
		txtReserv = new BaseTextField();
		txtReserv.setBounds(383, 105, 116, 22);
		add(txtReserv);
		txtReserv.setColumns(10);
		
		CreditCard = new BaseLabel("Credit Card Number:");
		CreditCard.setBounds(205, 137, 181, 47);
		add(CreditCard);
		
		txtCreditCard = new BaseTextField();
		txtCreditCard.setColumns(10);
		txtCreditCard.setBounds(383, 151, 116, 22);
		add(txtCreditCard);
		
		CustomerDetails = new BaseTextArea("Customer details:");
		CustomerDetails.setBounds(215, 197, 243, 196);
		add(CustomerDetails);
		
		txtVehicle = new BaseTextArea("Vehicle details:");
		txtVehicle.setBounds(497, 197, 243, 196);
		add(txtVehicle);
		
		txtInsurance = new BaseTextArea("Insurance details:");
		txtInsurance.setBounds(771, 197, 243, 196);
		add(txtInsurance);
		
		txtPrice = new BaseTextArea("Price:");
		txtPrice.setBounds(795, 105, 181, 55);
		add(txtPrice);
		
		Tick = new BaseLabel("");
		Tick.setIcon(new ImageIcon("Resources\\Imgs\\checkmark.png"));
		Tick.setBounds(773, 33, 66, 47);
		add(Tick);
	}

	
	public final BaseLabel getLblTitleReserv() {
		return lblTitleReserv;
	}


	public BaseTextField getTxtReserv() {
		return txtReserv;
	}

	public BaseTextField getTxtCreditCard() {
		return txtCreditCard;
	}

	public BaseTextArea getTxtVehicle() {
		return txtVehicle;
	}

	public BaseTextArea getTxtInsurance() {
		return txtInsurance;
	}

	public BaseTextArea getTxtPrice() {
		return txtPrice;
	}

	public BaseLabel getTick() {
		return this.Tick;
	}

	public BaseLabel getCreditCard() {
		return CreditCard;
	}

	public BaseLabel getReservNum() {
		return ReservNum;
	}

	public BaseTextArea getCustomerDetails() {
		return CustomerDetails;
	}


}
