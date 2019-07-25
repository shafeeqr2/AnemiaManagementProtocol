package application;


import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class OnESA_greater_than_115 extends JPanel {

	/**
	 * Create the panel.
	 */
	
	//AMP_View window;

	private ButtonGroup group;
	
	private JButton btnConfirm = new JButton("Next >");
	
	private JButton button = new JButton("< Back");

	private JRadioButton rdbtnTest_1 = new JRadioButton("Yes");

	private JRadioButton rdbtnTest = new JRadioButton("No");
	
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("ESA on hold or discontinued");

	public OnESA_greater_than_115() {
		//this.window = window;
		setBorder(null);
		setLayout(null);
		
		JLabel lblIsThePatient = new JLabel("Is the Patient on ESA Medication?");
		lblIsThePatient.setBounds(102, 12, 288, 14);
		add(lblIsThePatient);
		
		rdbtnTest_1.setBounds(53, 77, 250, 23);
		add(rdbtnTest_1);
		
		
		rdbtnTest.setBounds(53, 107, 250, 23);
		add(rdbtnTest);

		rdbtnNewRadioButton.setBounds(53, 133, 250, 23);
		add(rdbtnNewRadioButton);

		group = new ButtonGroup();		
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnTest_1);
		group.add(rdbtnTest);
		

		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		button.setBounds(263, 296, 89, 23);
		add(button);
	
	}
	
	public JButton confirmOnESA() {
		return btnConfirm;
	}
	
	public JRadioButton radio_yes() {
		return rdbtnTest_1;
	}
	
	public JRadioButton radio_no() {
		return rdbtnTest;
	}
	
	public JRadioButton radio_on_hold_or_discontinued() {
		return rdbtnNewRadioButton;
	}
	
	public JButton back() {
		return button;
	}
	
}
