package application;


import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class whichIronMed extends JPanel {

	/**
	 * Create the panel.
	 */
	private ButtonGroup group;
	
	private JRadioButton rdbtnVenofer = new JRadioButton("Venofer (Iron Sucrose)");
	
	private JRadioButton rdbtnFerrlecit = new JRadioButton("Ferrlecit (Sodium Ferric Gluconate)");

	private JButton btnConfirm = new JButton("Next >");
	private JButton btnNewButton = new JButton("< Back");

	public whichIronMed() {
		setLayout(null);
		
		
		rdbtnVenofer.setBounds(104, 101, 198, 23);
		add(rdbtnVenofer);
		
		rdbtnFerrlecit.setBounds(104, 127, 237, 23);
		add(rdbtnFerrlecit);
		
		JLabel lblWhichIronMedication = new JLabel("Which Iron Medication is the Patient On?");
		lblWhichIronMedication.setBounds(88, 11, 253, 14);
		add(lblWhichIronMedication);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		btnNewButton.setBounds(263, 296, 89, 23);
		add(btnNewButton);
		
		group = new ButtonGroup();
		
		group.add(rdbtnVenofer);
		group.add(rdbtnFerrlecit);

		
		

	}
	
	public JButton confirmWhicnIronMed() {
		return btnConfirm;
	}
	
	public JRadioButton radio_venofer() {
		return rdbtnVenofer;
	}
	
	public JRadioButton radio_ferrlecit() {
		return rdbtnFerrlecit;
	}
	
	public JButton back() {
		return btnNewButton;
	}
	
}
