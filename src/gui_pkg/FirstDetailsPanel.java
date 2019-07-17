package gui_pkg;

import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextField;

import javax.swing.ImageIcon;
import gui_customized_comp.BaseTextPane;

public class FirstDetailsPanel extends BasePanel {
	private BaseTextField txtAge;
	private BaseTextField txtDriveXP;
	private JDateChooser datePickUp;
	private JDateChooser dateReturn;
	private BaseTextPane txtpnMinimumHours;
	private BaseTextPane txtpnAgeNXP;
	public FirstDetailsPanel()
	{		
		BaseLabel lblNewLabel = new BaseLabel("Pick up date:");
		lblNewLabel.setBounds(313, 113, 127, 29);
		add(lblNewLabel);
		
		BaseLabel lblReturnDate = new BaseLabel("Return date:");
		lblReturnDate.setBounds(313, 157, 127, 29);
		add(lblReturnDate);
		
		BaseLabel lblAge = new BaseLabel("Age:");
		lblAge.setBounds(313, 216, 63, 29);
		add(lblAge);
		
		BaseLabel lblDrivingYears = new BaseLabel("Driving years:");
		lblDrivingYears.setBounds(313, 265, 127, 29);
		add(lblDrivingYears);
		
		datePickUp = new JDateChooser();
		datePickUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		datePickUp.setMinSelectableDate(new Date()); 
		datePickUp.setBounds(444, 122, 132, 20);
		add(datePickUp);
		
		dateReturn = new JDateChooser();
		dateReturn.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateReturn.setMinSelectableDate(new Date()); 
		dateReturn.setBounds(444, 166, 132, 20);
		add(dateReturn);
		
		txtAge = new BaseTextField();
		txtAge.setSize(41, 20);
		txtAge.setLocation(444, 220);
		add(txtAge);
		txtAge.setColumns(10);
		
		txtDriveXP = new BaseTextField();
		txtDriveXP.setSize(41, 20);
		txtDriveXP.setLocation(444, 271);
		add(txtDriveXP);
		txtDriveXP.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Resources\\Imgs\\timeline.png"));
		label.setBounds(940, 122, 110, 113);
		add(label);
		
		txtpnMinimumHours = new BaseTextPane("* Minimum 24 hours rent & pickup before return date");
		txtpnAgeNXP = new BaseTextPane("* Please fill the fields with digits only");
		txtpnAgeNXP.setBounds(622,238,261,29);
		txtpnMinimumHours.setBounds(622, 138, 261, 40);
		add(txtpnAgeNXP);
		add(txtpnMinimumHours);
	}
	
	
	public final BaseTextPane getTxtpnMinimumHours() {
		return txtpnMinimumHours;
	}


	public final BaseTextPane getTxtpnAgeNXP() {
		return txtpnAgeNXP;
	}


	public final BaseTextField getTxtAge() {
		return txtAge;
	}

	public  final void setTxtAge(BaseTextField txtAge) {
		this.txtAge = txtAge;
	}

	public final BaseTextField getTxtDriveXP() {
		return txtDriveXP;
	}

	public final void setTxtDriveXP(BaseTextField txtDriveXP) {
		this.txtDriveXP = txtDriveXP;
	}

	public final JDateChooser getDatePickUp() {
		return this.datePickUp;
	}

	public final void setDatePickUp(JDateChooser datePickUp) {
		this.datePickUp = datePickUp;
	}

	public final JDateChooser getDateReturn() {
		return this.dateReturn;
	}

	public final void setDateReturn(JDateChooser dateReturn) {
		this.dateReturn = dateReturn;
	}
}