package gui_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class BaseLabel extends JLabel {
	BaseLabel(String text)
	{
		super(text);
		setFont(new Font("Tahoma", Font.BOLD, 16));
		setForeground(Color.WHITE);
	}
	BaseLabel()
	{
		setFont(new Font("Tahoma", Font.BOLD, 16));
		setForeground(Color.WHITE);
	}
}
