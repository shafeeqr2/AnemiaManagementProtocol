package application;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ferricitDosage extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private ButtonGroup group;
	
	private JRadioButton rdbtnmgQ = new JRadioButton("125mg q 2 weeks");

	private JRadioButton rdbtnMgQ = new JRadioButton("125 mg q 4 weeks");
	
	private JRadioButton rdbtnMgQ_1 = new JRadioButton("125 mg q tx for 9 sessions");
	
	private JButton btnConfirm = new JButton("Next >");
	private final JButton button = new JButton("< Back");
	
	public ferricitDosage() {
		setLayout(null);
		
		JLabel lblWhatIsThe = new JLabel("What is the FerrIcit dosage the patient is on?");
		lblWhatIsThe.setBounds(51, 37, 249, 14);
		add(lblWhatIsThe);
		
		rdbtnmgQ.setBounds(83, 74, 109, 23);
		add(rdbtnmgQ);
		
		rdbtnMgQ.setBounds(83, 119, 159, 23);
		add(rdbtnMgQ);
		
		rdbtnMgQ_1.setBounds(83, 160, 179, 23);
		add(rdbtnMgQ_1);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		
		group = new ButtonGroup();		
		group.add(rdbtnmgQ);
		group.add(rdbtnMgQ);
		group.add(rdbtnMgQ_1);
		button.setBounds(263, 296, 89, 23);
		
		add(button);
		
	}
	
	public JButton confirmFerricitDosage() {
		return btnConfirm;
	}
	
	public JRadioButton radio_two_weeks() {
		return rdbtnmgQ;
	}
	
	public JRadioButton radio_four_weeks() {
		return rdbtnMgQ;
	}
	
	public JRadioButton radio_nine_weeks() {
		return rdbtnMgQ_1;
	}
	
	public JButton back() {
		return button;
	}

}
