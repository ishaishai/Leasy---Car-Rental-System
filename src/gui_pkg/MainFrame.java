package gui_pkg;

import java.awt.Color;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(83,92,104));
		getContentPane().setLayout(null);
		pack();
	}
}
