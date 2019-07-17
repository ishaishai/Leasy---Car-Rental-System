package gui_pkg;

import java.awt.Color;
import enums_pkg.Credit;
import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextField;
import listeners_pkg.MyDocumentListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import regex_pkg.RegexChecker;

import javax.swing.ImageIcon;

public class PaymentPanel extends BasePanel
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
	private MyDocumentListener mydoclistener;
	private boolean validCard;
	public PaymentPanel()
	{		
		validCard = false;
		mydoclistener = new MyDocumentListener();
		BaseLabel lblCardNumber = new BaseLabel("Card Number:");
		lblCardNumber.setBounds(262, 143, 108, 38);
		add(lblCardNumber);
		
		txtNumber = new BaseTextField();
		txtNumber.setBounds(389, 152, 193, 22);
		txtNumber.getDocument().addDocumentListener(mydoclistener);

		add(txtNumber);
		txtNumber.setColumns(10);
		
		lblCardType = new BaseLabel("Card Type:");
		lblCardType.setBounds(262, 96, 100, 28);
		add(lblCardType);
		
		lblExpirationDate = new BaseLabel("Expiration Date");
		lblExpirationDate.setBounds(262, 206, 122, 28);
		add(lblExpirationDate);
		
		lblVisa = new BaseLabel("");
		lblVisa.setIcon(new ImageIcon("Resources\\Imgs\\visa.png"));
		lblVisa.setBounds(367, 101, 46, 22);
		add(lblVisa);
		
		lblMaster = new BaseLabel("");
		lblMaster.setIcon(new ImageIcon("Resources\\Imgs\\master.png"));
		lblMaster.setBounds(423, 102, 46, 22);
		add(lblMaster);
		
		lblAmerican = new BaseLabel("");
		lblAmerican.setIcon(new ImageIcon("Resources\\Imgs\\american.png"));
		lblAmerican.setBounds(477, 102, 46, 22);
		add(lblAmerican);
		
		boxMonth = new JComboBox<>(new DefaultComboBoxModel<String>());
		boxMonth.setBounds(262, 255, 100, 22);
		add(boxMonth);
		
		boxYear = new JComboBox<>(new DefaultComboBoxModel<String>());
		boxYear.setBounds(372, 255, 76, 22);
		add(boxYear);
		
		lblCvv = new BaseLabel("CVV");
		lblCvv.setBounds(460, 206, 63, 28);
		add(lblCvv);
		
		txtCVV = new BaseTextField();
		txtCVV.getDocument().addDocumentListener(mydoclistener);
		txtCVV.setBounds(460, 255, 82, 22);
		txtCVV.setColumns(3);
		add(txtCVV);
		
		
		
		lblAsterisk1 = new BaseLabel("*");
		lblAsterisk1.setForeground(Color.RED);
		lblAsterisk1.setBounds(367, 151, 17, 22);
		add(lblAsterisk1);

		lblAsterisk2 = new BaseLabel("*");
		lblAsterisk2.setForeground(Color.RED);
		lblAsterisk2.setBounds(353, 99, 17, 22);
		add(lblAsterisk2);
		
		lblAsterisk3 = new BaseLabel("*");
		lblAsterisk3.setForeground(Color.RED);
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


	public final MyDocumentListener getMydoclistener() {
		return mydoclistener;
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


	public BaseLabel getLblCardType() {
		return lblCardType;
	}


	public void setLblCardType(BaseLabel lblCardType) {
		this.lblCardType = lblCardType;
	}

	public boolean isValidCard() {
		return validCard;
	}


	public void setValidCard(boolean validCard) {
		this.validCard = validCard;
	}
	
	





}
