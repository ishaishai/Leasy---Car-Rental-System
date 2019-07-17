package gui_pkg;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import design_patterns_pkg.ControllerDesign;
import design_patterns_pkg.ModelDesign;
import design_patterns_pkg.ViewDesign;
import listeners_pkg.MyIconBtnListener;

public class DirPanel extends JPanel {
	private JButton NextButton;
	private JButton BackButton;
	private static ControllerDesign m_Controller;
	private ViewDesign m_View;
	private ModelDesign m_Model;
	private JButton btnHome;
	
	public DirPanel()
	{
		setOpaque(false);
		setBounds(253, 658, 702, 87);
		setBackground(new Color(223, 228, 234));
		setVisible(true);
		m_View = new ViewDesign();
		m_Model = new ModelDesign();
		m_Controller = new ControllerDesign(m_Model,m_View);
		
		NextButton = new JButton();
		NextButton.setFont(new Font("Tahoma", Font.BOLD, 32));
		NextButton.setBounds(512, 11, 140, 50);
		NextButton.addMouseListener(new MyIconBtnListener());
		NextButton.setFocusPainted(false);
		NextButton.setFocusable(false);
		NextButton.setRequestFocusEnabled(false);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setText("");
		NextButton.setBounds(539, 11, 90, 68);
		NextButton.setVisible(false);
		NextButton.setIcon(new ImageIcon("Resources\\Imgs\\forward.png"));
		add(NextButton);
		
		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("Resources\\Imgs\\home.png"));
		btnHome.setBounds(305, 6, 90, 70);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setFocusable(false);
		btnHome.setRequestFocusEnabled(false);
		btnHome.setBorderPainted(false);
		btnHome.addMouseListener(new MyIconBtnListener());
		add(btnHome);
		
		BackButton = new JButton("Back");
		BackButton.setVisible(false);
		BackButton.setFocusPainted(false);
		BackButton.setFocusable(false);
		BackButton.setRequestFocusEnabled(false);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setText("");
		BackButton.setBounds(546, 11, 90, 68);
		BackButton.setIcon(new ImageIcon("Resources\\Imgs\\back.png"));
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 32));
		BackButton.setBounds(73, 11, 90, 68);
		BackButton.addMouseListener(new MyIconBtnListener());
		add(BackButton);
	}
	

	public final JButton getBtnHome() {
		return btnHome;
	}

	public final void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

	public final JButton getNextButton() {
		return NextButton;
	}

	public final JButton getBackButton() {
		return BackButton;
	}

	public static final ControllerDesign getM_Controller() {
		return m_Controller;
	}
}
