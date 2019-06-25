package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class InsurancePanel extends BasePanel
{
	private char Selected;
	private BaseTextArea txtInsuranceA;
	private BaseTextArea txtInsuranceB;
	private BaseTextArea txtInsuranceC;

	public InsurancePanel()
	{
		
		Selected = Character.MIN_VALUE;
		BaseLabel lblInsurance = new BaseLabel("Select from the following insurances:");
		lblInsurance.setBounds(118, 61, 452, 27);
		add(lblInsurance);
		
		txtInsuranceA = new BaseTextArea();
		txtInsuranceA.setLocation(158, 99);
		txtInsuranceA.addMouseListener(new InsuranceListener());
		add(txtInsuranceA);
		
		txtInsuranceB = new BaseTextArea();
		txtInsuranceB.setLocation(451,99);
		txtInsuranceB.addMouseListener(new InsuranceListener());
		add(txtInsuranceB);
		
		txtInsuranceC = new BaseTextArea();
		txtInsuranceC.setLocation(746,99);
		txtInsuranceC.addMouseListener(new InsuranceListener());
		add(txtInsuranceC);
	}

	public final BaseTextArea getTxtInsuranceA() {
		return txtInsuranceA;
	}

	public final BaseTextArea getTxtInsuranceB() {
		return txtInsuranceB;
	}

	public final BaseTextArea getTxtInsuranceC() {
		return txtInsuranceC;
	}

	public void setSelected(char selected)
	{
		this.Selected = selected;
	}

	public char getSelected() {
		return Selected;
	}

	
	
	
}
