package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextArea;
import listeners_pkg.MyMouseListener;
import gui_customized_comp.BaseLabel;

public class ReviewOrderPanel extends BasePanel implements ActionListener {
	private BaseTextArea TxtVehicle;
	private BaseTextArea TxtFullDetails;
	private BaseTextArea TxtPrice;
	private BaseTextArea TxtInsurance;
	private JButton btnLogin;

	private JButton btnDiscount;
	
	public ReviewOrderPanel()
	{
		TxtVehicle = new BaseTextArea("Vehicle details:");
		TxtVehicle.setLocation(194, 87);
		
		add(TxtVehicle);
		
		TxtFullDetails = new BaseTextArea("Customer details:");
		TxtFullDetails.setBounds(464, 87, 250, 264);
		
		add(TxtFullDetails);
		
		TxtInsurance = new BaseTextArea("Insurance details:");
		TxtInsurance.setBounds(734, 87, 250, 150);
		add(TxtInsurance);
		
		TxtPrice = new BaseTextArea("Total price:");
		TxtPrice.setBounds(516, 436, 140, 60);
		add(TxtPrice);
		
		
		
		btnLogin = new JButton("Login");
		btnLogin.setFocusPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setRequestFocusEnabled(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(true);
		btnLogin.setBackground(new Color(17, 41, 64));
		btnLogin.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLogin.setBounds(999, 475, 165, 50);
		btnLogin.addMouseListener(new MyMouseListener());
		add(btnLogin);
		
		btnDiscount = new JButton();
		btnDiscount.setBounds(714, 327, 140, 88);
		add(btnDiscount);
		btnDiscount.setFocusPainted(false);
		btnDiscount.setFocusable(false);
		btnDiscount.setRequestFocusEnabled(false);
		btnDiscount.setBorderPainted(false);
		btnDiscount.setContentAreaFilled(false);
		btnDiscount.setIcon(new ImageIcon("Resources\\Imgs\\discount.png"));
		btnDiscount.addActionListener(this);
		
		BaseLabel bslblFinalReview = new BaseLabel();
		bslblFinalReview.setText("Final review:");
		bslblFinalReview.setBounds(194, 27, 132, 30);
		add(bslblFinalReview);
		btnDiscount.setVisible(false);
		
		
	}
	
	
	
	public final JButton getBtnDiscount() {
		return btnDiscount;
	}



	public final JButton getBtnLogin() {
		return btnLogin;
	}

	public BaseTextArea getTxtVehicle() {
		return TxtVehicle;
	}
	public void setTxtVehicle(BaseTextArea TxtVehicle) {
		this.TxtVehicle = TxtVehicle;
	}
	public BaseTextArea getTxtFullDetails() {
		return TxtFullDetails;
	}
	public void setTxtFullDetails(BaseTextArea TxtFullDetails) {
		this.TxtFullDetails = TxtFullDetails;
	}
	public BaseTextArea getTxtPrice() {
		return TxtPrice;
	}
	public void setTxtPrice(BaseTextArea TxtPrice) {
		this.TxtPrice = TxtPrice;
	}
	public BaseTextArea getTxtInsurance() {
		return TxtInsurance;
	}
	public void setTxtInsurance(BaseTextArea TxtInsurance) {
		this.TxtInsurance = TxtInsurance;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == btnDiscount)
		{
			btnDiscount.setEnabled(false);
			DirPanel.getM_Controller().SetDiscount();
		}
		
	}
}
