package gui_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitlePanel extends JPanel {
	public TitlePanel()
	{
		setBounds(116, 16, 683, 81);
		setBackground(new Color(120, 224, 143));
		
		JLabel label = new JLabel("");
		label.setBounds(99, 0, 110, 81);
		add(label);
		label.setIcon(new ImageIcon("Resources\\Imgs\\Leasy.png"));
		
		JLabel lblNewLabel = new JLabel("Leasing is easy!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 36));
		lblNewLabel.setBounds(221, 0, 358, 81);
		add(lblNewLabel);
		
	}

	
	

}
