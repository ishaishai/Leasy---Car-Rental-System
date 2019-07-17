package gui_customized_comp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class BaseTextPane extends JTextPane {
	public BaseTextPane(String text)
	{
		setText(text);
		StyledDocument doc = getStyledDocument();
		SimpleAttributeSet set = new SimpleAttributeSet();
		JTextPane textPane = new JTextPane(doc);
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Tahoma", Font.BOLD, 14));
	    
	    setEditable(false);
	    setOpaque(false);
	    setVisible(false);
	    javax.swing.text.Style style2 = addStyle("Red", null);
	    StyleConstants.setForeground(style2, Color.red);
        doc.setCharacterAttributes(0, 1, this.getStyle("Red"), true);
	}

}
