package application;


import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class whichESAMed extends JPanel {
	
	

	private ButtonGroup group;
	
	private JRadioButton rdbtnAranesp = new JRadioButton("Darbopoetin (Aranesp)");
	
	private JRadioButton rdbtnEprex = new JRadioButton("Epotin alpha (Eprex)");

	private JButton btnConfirm = new JButton("Next >");
	private final JButton btnNewButton = new JButton("< Back");
	
	

	/**
	 * Create the panel.
	 */
	public whichESAMed() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which ESA Medication is the Patient On?");
		lblNewLabel.setBounds(130, 14, 250, 14);
		add(lblNewLabel);
		
		rdbtnAranesp.setBounds(80, 76, 200, 23);
		add(rdbtnAranesp);
		
		rdbtnEprex.setBounds(80, 102, 200, 23);
		add(rdbtnEprex);
		
		group = new ButtonGroup();
		
		group.add(rdbtnAranesp);
		group.add(rdbtnEprex);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		btnNewButton.setBounds(263, 296, 89, 23);
		
		add(btnNewButton);
		
	}
	
	public JButton confirmESAmed() {
		return btnConfirm;
	}
	
	public JRadioButton radio_aranesp() {
		return rdbtnAranesp;
	}
	
	public JRadioButton radio_eprex() {
		return rdbtnEprex;
	}
	
	public JButton back() {
		return btnNewButton;
	}
}
