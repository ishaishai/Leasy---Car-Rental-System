package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;

public class PaymentPanel extends BasePanel implements DocumentListener
{
	private BaseTextField txtNumber;
	private BaseTextField txtCVV;
	private JComboBox<String> boxMonth;
	private JComboBox<String> boxYear;
	private BaseLabel lblAsterisk1;
	private BaseLabel lblAsterisk2;
	private BaseLabel lblAsterisk3;
	private JProgressBar progressBar;
	private BaseLabel lblProgress;
	private BaseLabel lblAmerican;
	private BaseLabel lblVisa;
	private BaseLabel lblMaster;
	private BaseLabel lblCardType;
	private BaseLabel lblExpirationDate;
	private BaseLabel lblCvv;
	private JCheckBox chckbxSaveCardFor;
	private BaseLabel lblSave;
	
	public PaymentPanel()
	{		
		BaseLabel lblCardNumber = new BaseLabel("Card Number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardNumber.setBounds(262, 143, 108, 38);
		add(lblCardNumber);
		
		txtNumber = new BaseTextField();
		txtNumber.setBounds(389, 152, 193, 22);
		txtNumber.getDocument().addDocumentListener(this);

		add(txtNumber);
		txtNumber.setColumns(10);
		
		lblCardType = new BaseLabel("Card Type:");
		lblCardType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCardType.setBounds(262, 96, 100, 28);
		add(lblCardType);
		
		lblExpirationDate = new BaseLabel("Expiration Date");
		lblExpirationDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpirationDate.setBounds(262, 206, 122, 28);
		add(lblExpirationDate);
		
		lblVisa = new BaseLabel("");
		lblVisa.setIcon(new ImageIcon(".\\Resources\\Imgs\\visa.png"));
		lblVisa.setBounds(367, 101, 46, 22);
		add(lblVisa);
		
		lblMaster = new BaseLabel("");
		lblMaster.setIcon(new ImageIcon(".\\Resources\\Imgs\\master.png"));
		lblMaster.setBounds(423, 102, 46, 22);
		add(lblMaster);
		
		lblAmerican = new BaseLabel("");
		lblAmerican.setIcon(new ImageIcon(".\\Resources\\Imgs\\american.png"));
		lblAmerican.setBounds(477, 102, 46, 22);
		add(lblAmerican);
		
		boxMonth = new JComboBox<>(new DefaultComboBoxModel<String>());
		boxMonth.setBounds(262, 255, 100, 22);
		add(boxMonth);
		
		boxYear = new JComboBox<>(new DefaultComboBoxModel<String>());
		boxYear.setBounds(372, 255, 76, 22);
		add(boxYear);
		
		lblCvv = new BaseLabel("CVV");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCvv.setBounds(460, 206, 63, 28);
		add(lblCvv);
		
		txtCVV = new BaseTextField();
		txtCVV.setBounds(460, 255, 82, 22);
		txtCVV.setColumns(3);
		add(txtCVV);
		
		lblSave = new BaseLabel("Save");
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSave.setBounds(262, 333, 53, 28);
		add(lblSave);
		
		chckbxSaveCardFor = new JCheckBox("Save card for later reuse");
		chckbxSaveCardFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxSaveCardFor.setBounds(307, 336, 214, 25);
		add(chckbxSaveCardFor);
		
		
		
		lblAsterisk1 = new BaseLabel("*");
		lblAsterisk1.setForeground(Color.RED);
		lblAsterisk1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAsterisk1.setBounds(367, 151, 17, 22);
		add(lblAsterisk1);

		lblAsterisk2 = new BaseLabel("*");
		lblAsterisk2.setForeground(Color.RED);
		lblAsterisk2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAsterisk2.setBounds(353, 99, 17, 22);
		add(lblAsterisk2);
		
		lblAsterisk3 = new BaseLabel("*");
		lblAsterisk3.setForeground(Color.RED);
		lblAsterisk3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAsterisk3.setBounds(383, 209, 17, 22);
		add(lblAsterisk3);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(651, 397, 270, 28);
		progressBar.setStringPainted(true);
		progressBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblProgress = new BaseLabel("");
		lblProgress.setBounds(654, 364, 300, 23);
		add(lblProgress);
		
		add(progressBar);
	}

	
	public final JComboBox<String> getBoxMonth() {
		return boxMonth;
	}


	public final void setBoxMonth(JComboBox<String> boxMonth) {
		this.boxMonth = boxMonth;
	}


	public final JComboBox<String> getBoxYear() {
		return boxYear;
	}


	public final void setBoxYear(JComboBox<String> boxYear) {
		this.boxYear = boxYear;
	}


	public final BaseLabel getLblAmerican() {
		return lblAmerican;
	}


	public final void setLblAmerican(BaseLabel lblAmerican) {
		this.lblAmerican = lblAmerican;
	}


	public final BaseLabel getLblVisa() {
		return lblVisa;
	}


	public final void setLblVisa(BaseLabel lblVisa) {
		this.lblVisa = lblVisa;
	}


	public final BaseLabel getLblMaster() {
		return lblMaster;
	}


	public final void setLblMaster(BaseLabel lblMaster) {
		this.lblMaster = lblMaster;
	}


	public final JCheckBox getChckbxSaveCardFor() {
		return chckbxSaveCardFor;
	}


	public final void setChckbxSaveCardFor(JCheckBox chckbxSaveCardFor) {
		this.chckbxSaveCardFor = chckbxSaveCardFor;
	}


	public final void setTxtNumber(BaseTextField txtNumber) {
		this.txtNumber = txtNumber;
	}


	public final void setTxtCVV(BaseTextField txtCVV) {
		this.txtCVV = txtCVV;
	}


	public final BaseLabel getLblProgress() {
		return lblProgress;
	}


	public final JProgressBar getProgressBar() {
		return progressBar;
	}


	public BaseTextField getTxtNumber() {
		return txtNumber;
	}

	public BaseTextField getTxtCVV() {
		return txtCVV;
	}



	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument() == this.txtNumber.getDocument())
		{
			if(txtNumber.getText().length()==1)
				changeCredit();
			if(txtNumber.getText().length()>0)
			{
				if(txtNumber.getText().length()==14)
				{
					SwingUtilities.invokeLater(new Runnable()
					{
					    public void run()
					    {
					    	System.out.println(txtNumber.getText());
					    	txtNumber.getDocument().removeDocumentListener(Main.getM_PaymentPanel());
					    	txtNumber.setText(String.format("%s-",txtNumber.getText()));
					    	txtNumber.getDocument().addDocumentListener(Main.getM_PaymentPanel());
					    }
					});
				}
				else if(txtNumber.getText().length()==9)
				{
					SwingUtilities.invokeLater(new Runnable()
					{
					    public void run()
					    {
					    	System.out.println(txtNumber.getText());
					    	txtNumber.getDocument().removeDocumentListener(Main.getM_PaymentPanel());
					    	txtNumber.setText(String.format("%s-",txtNumber.getText()));
					    	txtNumber.getDocument().addDocumentListener(Main.getM_PaymentPanel());
					    }
					});
					
				}
				else if(txtNumber.getText().length()==4)
				{
					SwingUtilities.invokeLater(new Runnable()
					{
					    public void run()
					    {
					    	System.out.println(txtNumber.getText());
					    	txtNumber.getDocument().removeDocumentListener(Main.getM_PaymentPanel());
					    	txtNumber.setText(String.format("%s-",txtNumber.getText()));
					    	txtNumber.getDocument().addDocumentListener(Main.getM_PaymentPanel());
					    }
					});
					
				}
				
			}
		}
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument() == this.txtNumber.getDocument())
		{
			changeCredit();
		}
		
	}
	
	

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}




	
	public void changeCredit()
	{
		if(this.txtNumber.getText().contentEquals("4"))
		{
			this.lblAmerican.setVisible(false);
			this.lblMaster.setVisible(false);
		}
		else if(this.txtNumber.getText().contentEquals("5"))
		{
			this.lblAmerican.setVisible(false);
			this.lblVisa.setVisible(false);
		}
		else if(this.txtNumber.getText().contentEquals("3"))
		{
			this.lblVisa.setVisible(false);
			this.lblMaster.setVisible(false);
		}
		else if(this.txtNumber.getText().contentEquals(""))
		{
			this.lblAmerican.setVisible(true);
			this.lblMaster.setVisible(true);
			this.lblVisa.setVisible(true);
		}
	}




}
