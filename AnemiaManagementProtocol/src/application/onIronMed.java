package application;


import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class onIronMed extends JPanel {

	/**
	 * Create the panel.
	 */
	private ButtonGroup group;

	private JButton btnConfirm = new JButton("Next >");
	private JButton button = new JButton("< Back");

	private JRadioButton rdbtnTest_1 = new JRadioButton("Yes");

	private JRadioButton rdbtnTest_2 = new JRadioButton("No");

	private JRadioButton rdbtnTest = new JRadioButton("No, it is currently on hold");


	
	public onIronMed() {
		
		//this.window = window;
		
		setBorder(null);
		setLayout(null);
		
		
		rdbtnTest_1.setBounds(53, 82, 350, 23);
		add(rdbtnTest_1);
		
		rdbtnTest_2.setBounds(53, 105, 300, 23);
		add(rdbtnTest_2);
		
		rdbtnTest.setBounds(53, 128, 300, 23);
		add(rdbtnTest);
		
		group = new ButtonGroup();
		
		group.add(rdbtnTest_1);
		group.add(rdbtnTest_2);
		group.add(rdbtnTest);

		JLabel lblIsThePatient = new JLabel("Is the Patient on Iron Replacement?");
		lblIsThePatient.setBounds(65, 12, 250, 14);
		add(lblIsThePatient);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		button.setBounds(263, 296, 89, 23);
		add(button);
		
		
	}
	
	public JButton confirmOnIronMed() {
		return btnConfirm;
	}
	
	public JRadioButton radio_yes() {
		return rdbtnTest_1;
	}
	
	
	public JRadioButton radio_no() {
		return rdbtnTest_2;
	}
	public JRadioButton radio_no_on_hold() {
		return rdbtnTest;
	}
	
	public JButton back() {
		return button;
	}
	
}
