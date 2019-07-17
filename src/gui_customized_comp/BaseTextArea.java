package gui_customized_comp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BaseTextArea extends JTextArea {
	public BaseTextArea(int width,int height)
	{
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setEditable(false);
		setBackground(Color.LIGHT_GRAY);
		setBorder(new LineBorder(Color.BLACK, 2, true));
		setSize(width, height);
		setLineWrap(true);
		setVisible(true);
		setWrapStyleWord(true);
	}
	
	public BaseTextArea(String title,int width,int height)
	{
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setEditable(false);
		setBackground(Color.LIGHT_GRAY);
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
		setSize(width, height);
		setLineWrap(true);
		setVisible(true);
		setWrapStyleWord(true);
	}
	public BaseTextArea(String title)
	{
		this(title,255,323);
	}
	public BaseTextArea()
	{
		this(255,323);
	}
}
