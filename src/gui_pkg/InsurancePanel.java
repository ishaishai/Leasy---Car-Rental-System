package gui_pkg;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextArea;
import listeners_pkg.InsuranceListener;

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
		txtInsuranceA.setSize(255, 250);
		txtInsuranceA.addMouseListener(new InsuranceListener());
		add(txtInsuranceA);
		
		txtInsuranceB = new BaseTextArea();
		txtInsuranceB.setLocation(451,99);
		txtInsuranceB.setSize(255, 250);
		txtInsuranceB.addMouseListener(new InsuranceListener());
		add(txtInsuranceB);
		
		txtInsuranceC = new BaseTextArea();
		txtInsuranceC.setLocation(746,99);
		txtInsuranceC.setSize(255, 250);
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
