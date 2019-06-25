package gui_pkg;

import java.awt.Color;

import javax.swing.JTextField;

public class BaseTextField extends JTextField{
	public BaseTextField()
	{
		this(86,20);
	}
	
	public BaseTextField(int width,int height)
	{
		setSize(width,height);
	}
}
