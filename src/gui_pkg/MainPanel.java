package gui_pkg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;

public class MainPanel extends JLayeredPane {
	public static int m_Status = 0;
	public MainPanel()
	{
		this.setBounds(0, 91, 714, 338);
		this.setLayout(new CardLayout(0, 0));	
		
	}
	
	public static int getPageStatus()
	{
		return m_Status;
	}
}
