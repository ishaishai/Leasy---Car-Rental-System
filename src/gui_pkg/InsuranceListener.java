package gui_pkg;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;

public class InsuranceListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceA())
		{
			Main.getM_InsurancePanel().setSelected('A');
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new LineBorder(Color.WHITE, 4, true));
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new LineBorder(Color.BLACK, 2, true));
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new LineBorder(Color.BLACK, 2, true));
		}
		else if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceB())
		{
			Main.getM_InsurancePanel().setSelected('B');
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new LineBorder(Color.WHITE, 4, true));
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new LineBorder(Color.BLACK, 2, true));
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new LineBorder(Color.BLACK, 2, true));
		}
		else if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceC())
		{
			Main.getM_InsurancePanel().setSelected('C');
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new LineBorder(Color.WHITE, 4, true));
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new LineBorder(Color.BLACK, 2, true));
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new LineBorder(Color.BLACK, 2, true));
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
