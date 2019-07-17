package gui_customized_comp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;

public class BaseTable extends JTable{
	public BaseTable()
	{
		setBounds(0, 225, 743, 142);
		this.setGridColor(Color.WHITE);
		this.setForeground(Color.WHITE);
	}
}
