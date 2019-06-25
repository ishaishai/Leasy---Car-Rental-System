package gui_pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyDialog implements ActionListener {
	private JButton btn;
	private JDialog MessageBox;
	public MyDialog(String txt)
	{
		btn = new JButton("Ok");
		MessageBox = new JDialog(new JFrame(), "Error"); 
		
        // create a label 
        JLabel l = new JLabel("Error on "+txt); 
        l.setBounds(0,0,150,30);
        MessageBox.add(l); 

        // setsize of dialog 
        MessageBox.setBounds(150,150,150,150);
        MessageBox.add(btn);
        
        // set visibility of dialog 
		MessageBox.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn)
		{
			MessageBox.dispose();
		}
		
	}
	
	
	
}
