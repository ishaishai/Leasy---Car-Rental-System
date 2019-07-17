package gui_customized_comp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class BaseLabel extends JLabel {
	public BaseLabel(String text)
	{
		super(text);
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setForeground(Color.LIGHT_GRAY);
	}
	public BaseLabel()
	{
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setForeground(Color.LIGHT_GRAY);
	}
}
