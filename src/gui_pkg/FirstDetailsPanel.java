package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class FirstDetailsPanel extends BasePanel {
	private BaseTextField txtAge;
	private BaseTextField txtDriveXP;
	private JDateChooser datePickUp;
	private JDateChooser dateReturn;
	
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
		datePickUp.setMinSelectableDate(new Date()); 
		datePickUp.setBounds(444, 122, 91, 20);
		add(datePickUp);
		
		dateReturn = new JDateChooser();
		dateReturn.setMinSelectableDate(new Date()); 
		dateReturn.setBounds(444, 166, 91, 20);
		add(dateReturn);
		
		txtAge = new BaseTextField();
		txtAge.setLocation(444, 220);
		add(txtAge);
		txtAge.setColumns(10);
		
		txtDriveXP = new BaseTextField();
		txtDriveXP.setLocation(444, 271);
		add(txtDriveXP);
		txtDriveXP.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Resources\\Imgs\\timeline.png"));
		label.setBounds(634, 148, 110, 113);
		add(label);
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