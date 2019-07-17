package listeners_pkg;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui_pkg.DirPanel;
import gui_pkg.Main;
import regex_pkg.RegexChecker;

public class MyDocumentListener implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent e) {
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(e.getDocument()==Main.getM_PaymentPanel().getTxtNumber().getDocument())
		{
			DirPanel.getM_Controller().EditCreditCard();
		}		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument() == Main.getM_PaymentPanel().getTxtNumber().getDocument())
		{
			if(Main.getM_PaymentPanel().getTxtNumber().getText().contentEquals(""))
			{
				DirPanel.getM_Controller().EditCreditCard();
			}
		}
		
	}

}
