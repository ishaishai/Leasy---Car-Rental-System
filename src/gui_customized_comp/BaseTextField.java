package gui_customized_comp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class BaseTextField extends JTextField{
	public BaseTextField()
	{
		this(86,20);
	}
	
	public BaseTextField(int width,int height)
	{
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setSize(width,height);
	}
}
