package application;


import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class VenoferDosage extends JPanel {

	
	private ButtonGroup group;
	/**
	 * Create the panel.
	 */
	private JRadioButton rdbtnmgQ = new JRadioButton("100mg q 2 weeks");
	
	private JRadioButton rdbtnNewRadioButton = new JRadioButton("100mg q 4 weeks");

	private JRadioButton rdbtnMgQ = new JRadioButton("100 mg q treatmet for 9 consecutive sessions");

	private JButton btnConfirm = new JButton("Next >");
	private JButton button = new JButton("< Back");
		
	public VenoferDosage() {
		setLayout(null);
		
		JLabel lblDosageOfVenofer = new JLabel("Dosage of Venofer (Iron Sucrose)");
		lblDosageOfVenofer.setBounds(144, 5, 200, 14);
		add(lblDosageOfVenofer);
		
		rdbtnmgQ.setBounds(129, 62, 200, 23);
		add(rdbtnmgQ);
		
		rdbtnNewRadioButton.setBounds(129, 108, 200, 23);
		add(rdbtnNewRadioButton);
		
		rdbtnMgQ.setBounds(129, 156, 300, 23);
		add(rdbtnMgQ);
		
		group = new ButtonGroup();
		
		group.add(rdbtnMgQ);
		group.add(rdbtnmgQ);
		group.add(rdbtnNewRadioButton);
		

		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		button.setBounds(263, 296, 89, 23);
		
		add(button);

	}
	
	public JButton confirmVenoferDosage() {
		return btnConfirm;
	}
	
	public JRadioButton radio_two_weeks() {
		return rdbtnmgQ;
	}
	
	public JRadioButton radio_four_weeks() {
		return rdbtnNewRadioButton;
	}
	
	public JRadioButton radio_nine_weeks() {
		return rdbtnMgQ;
	}
	
	public JButton back() {
		return button;
	}
}
