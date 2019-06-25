package gui_pkg;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BaseTextArea extends JTextArea {
	public BaseTextArea(int width,int height)
	{
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setEditable(false);
		setBackground(Color.LIGHT_GRAY);
		//setBackground(new Color(83, 92, 104));
		setBorder(new LineBorder(Color.BLACK, 2, true));
		//setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), title, TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setSize(width, height);
		setBounds(158, 99, 255, 323);
		setLineWrap(true);
		setVisible(true);
		setWrapStyleWord(true);
	}
	
	public BaseTextArea(String title,int width,int height)
	{
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setEditable(false);
		setBackground(Color.LIGHT_GRAY);
		//setBackground(new Color(83, 92, 104));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), title, TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 16), Color.BLACK));
		setSize(width, height);
		setBounds(158, 99, 255, 323);
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
