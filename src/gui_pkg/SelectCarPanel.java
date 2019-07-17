package gui_pkg;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import gui_customized_comp.BaseLabel;
import gui_customized_comp.BasePanel;
import gui_customized_comp.BaseTextArea;

public class SelectCarPanel extends BasePanel implements ItemListener {
	private BaseLabel lblNewLabel;
	private BaseLabel lblChooseCar;
	private BaseTextArea txtAreaDetails;
	private JComboBox<String> CarComboBox;
	private JComboBox<String> RankComboBox;
	public SelectCarPanel()
	{
		lblNewLabel = new BaseLabel("Choose rank:");
		lblNewLabel.setBounds(281, 73, 127, 29);
		add(lblNewLabel);
		
		lblChooseCar = new BaseLabel("Choose car:");
		lblChooseCar.setBounds(281, 117, 133, 29);
		add(lblChooseCar);
		
		RankComboBox = new JComboBox<>(new DefaultComboBoxModel<String>());
		RankComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		RankComboBox.setBounds(390, 73, 56, 25);
		RankComboBox.addItemListener(this);
		
		add(RankComboBox);
		
		CarComboBox = new JComboBox<>(new DefaultComboBoxModel<String>());
		CarComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
		CarComboBox.setBounds(390, 117, 161, 25);
		CarComboBox.addItemListener(this);
		add(CarComboBox);
		
		txtAreaDetails = new BaseTextArea("Details:");
		txtAreaDetails.setLocation(595, 73);
		add(txtAreaDetails);
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == RankComboBox && e.getStateChange() == ItemEvent.SELECTED)
		{
			if(RankComboBox.getItemCount()>0)
			{
				CarComboBox.removeAllItems();
				DirPanel.getM_Controller().LoadVehicles();
			}
		}
		else if(e.getSource() == CarComboBox && e.getStateChange() == ItemEvent.SELECTED)
		{
			if(CarComboBox.getItemCount()>0)
			{
				DirPanel.getM_Controller().SetVehicleDetails();
			}
		}
		
		
	}

	public final JTextArea getTxtAreaDetails() {
		return txtAreaDetails;
	}


	public final void setTxtAreaDetails(BaseTextArea txtAreaDetails) {
		this.txtAreaDetails = txtAreaDetails;
	}


	public final JComboBox<String> getCarComboBox() {
		return CarComboBox;
	}

	public final void setCarComboBox(JComboBox<String> carComboBox) {
		CarComboBox = carComboBox;
	}

	public final JComboBox<String> getRankComboBox() {
		return RankComboBox;
	}

	public final void setRankComboBox(JComboBox<String> rankComboBox) {
		RankComboBox = rankComboBox;
	}

}
