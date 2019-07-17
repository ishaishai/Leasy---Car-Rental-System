package listeners_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import design_patterns_pkg.DataManager;
import gui_pkg.Main;

public class InsuranceListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceA())
		{
			Main.getM_InsurancePanel().setSelected('A');
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(0).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 18), Color.WHITE));
			
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(1).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(2).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
		}
		else if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceB())
		{
			Main.getM_InsurancePanel().setSelected('B');
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(0).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(1).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 18), Color.WHITE));
			
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(2).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
		}
		else if(event.getSource()==Main.getM_InsurancePanel().getTxtInsuranceC())
		{
			Main.getM_InsurancePanel().setSelected('C');
			Main.getM_InsurancePanel().getTxtInsuranceA().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(0).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
			Main.getM_InsurancePanel().getTxtInsuranceB().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(1).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
			
			Main.getM_InsurancePanel().getTxtInsuranceC().setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					DataManager.getInstance().getM_Insurances().get(2).getM_Title(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 18), Color.WHITE));
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
