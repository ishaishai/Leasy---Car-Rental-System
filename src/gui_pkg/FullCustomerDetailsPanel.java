package gui_pkg;

import java.awt.Font;
import javax.swing.ImageIcon;

public class FullCustomerDetailsPanel extends BasePanel
{

	private BaseTextField txtFirstName;
	private BaseTextField txtID;
	private BaseTextField txtLastName;
	private BaseTextField txtPhone;
	
	public FullCustomerDetailsPanel()
	{		
		BaseLabel lblPleaseFillIn = new BaseLabel("Please fill in your details:");
		lblPleaseFillIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseFillIn.setBounds(280, 86, 230, 39);
		add(lblPleaseFillIn);
		
		BaseLabel lblFirstName = new BaseLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(280, 123, 155, 39);
		add(lblFirstName);
		
		txtFirstName = new BaseTextField();
		txtFirstName.setLocation(399, 132);
		txtFirstName.setColumns(10);
		add(txtFirstName);
		
		BaseLabel lblLastName = new BaseLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(280, 191, 90, 20);
		add(lblLastName);
		
		txtLastName = new BaseTextField();
		txtLastName.setLocation(399, 189);
		txtLastName.setColumns(10);
		add(txtLastName);

		BaseLabel lblId = new BaseLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(280, 244, 56, 16);
		add(lblId);
		
		txtID = new BaseTextField();
		txtID.setLocation(399, 244);
		txtID.setColumns(10);
		add(txtID);
		
		BaseLabel lblPhoneNumber = new BaseLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(280, 306, 120, 16);
		add(lblPhoneNumber);
		
		txtPhone = new BaseTextField();
		txtPhone.setLocation(399, 306);
		txtPhone.setColumns(10);
		add(txtPhone);
		
		BaseLabel lblNewLabel = new BaseLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resources\\Imgs\\customer.png"));
		lblNewLabel.setBounds(772, 170, 128, 112);
		add(lblNewLabel);
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
