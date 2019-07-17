package gui_pkg;

import java.awt.Font;
import javax.swing.ImageIcon;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextField;
import gui_customized_comp.BaseTextPane;

public class FullCustomerDetailsPanel extends BasePanel
{

	private BaseTextField txtFirstName;
	private BaseTextField txtID;
	private BaseTextField txtLastName;
	private BaseTextField txtPhone;
	private BaseTextPane txtpnName;
	private BaseTextPane txtpnLname;
	private BaseTextPane txtpnID;
	private BaseTextPane txtpnPhone;
	public FullCustomerDetailsPanel()
	{		
		BaseLabel lblPleaseFillIn = new BaseLabel("Please fill in your details:");
		lblPleaseFillIn.setBounds(280, 86, 230, 39);
		add(lblPleaseFillIn);
		
		BaseLabel lblFirstName = new BaseLabel("First Name:");
		lblFirstName.setBounds(280, 123, 155, 39);
		add(lblFirstName);
		
		txtFirstName = new BaseTextField();
		txtFirstName.setSize(111, 20);
		txtFirstName.setLocation(399, 132);
		txtFirstName.setColumns(10);
		add(txtFirstName);
		
		BaseLabel lblLastName = new BaseLabel("Last Name:");
		lblLastName.setBounds(280, 191, 90, 20);
		add(lblLastName);
		
		txtLastName = new BaseTextField();
		txtLastName.setSize(111, 20);
		txtLastName.setLocation(399, 189);
		txtLastName.setColumns(10);
		add(txtLastName);

		BaseLabel lblId = new BaseLabel("ID:");
		lblId.setBounds(280, 244, 56, 16);
		add(lblId);
		
		txtID = new BaseTextField();
		txtID.setSize(111, 20);
		txtID.setLocation(399, 244);
		txtID.setColumns(10);
		add(txtID);
		
		BaseLabel lblPhoneNumber = new BaseLabel("Phone Number:");
		lblPhoneNumber.setBounds(280, 305, 120, 16);
		add(lblPhoneNumber);
		
		txtPhone = new BaseTextField();
		txtPhone.setSize(111, 20);
		txtPhone.setLocation(399, 304);
		txtPhone.setColumns(10);
		add(txtPhone);
		
		BaseLabel lblNewLabel = new BaseLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resources\\Imgs\\customer.png"));
		lblNewLabel.setBounds(942, 123, 128, 112);
		add(lblNewLabel);
		
		txtpnName = new BaseTextPane("* Can hold only letters with no special chars");
		txtpnName.setBounds(523, 132, 301, 20);
		add(txtpnName);
		
		txtpnLname = new BaseTextPane("* Can hold only letters with no special chars");
		txtpnLname.setBounds(523, 191, 301, 20);
		add(txtpnLname);
		
		txtpnID = new BaseTextPane("* Can hold only digits, length>8");
		txtpnID.setBounds(523, 244, 301, 20);
		add(txtpnID);
		
		txtpnPhone = new BaseTextPane("* Can be in format of XXX-XXXXXXX or XX-XXXXXXX");
		txtpnPhone.setBounds(523, 304, 390, 20);
		add(txtpnPhone);
	}
	
	

	public final BaseTextPane getTxtpnLname() {
		return txtpnLname;
	}



	public final BaseTextPane getTxtpnID() {
		return txtpnID;
	}



	public final BaseTextPane getTxtpnPhone() {
		return txtpnPhone;
	}



	public final BaseTextPane getTxtpnName() {
		return txtpnName;
	}



	public BaseTextField getTxtFirstName() {
		return txtFirstName;
	}



	public BaseTextField getTxtID() {
		return txtID;
	}



	public BaseTextField getTxtLastName() {
		return txtLastName;
	}



	public BaseTextField getTxtPhone() {
		return txtPhone;
	}
}
