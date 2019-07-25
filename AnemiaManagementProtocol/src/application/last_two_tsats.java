package application;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class last_two_tsats extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	

	private JButton button = new JButton("< Back");
	private JButton btnConfirm = new JButton("Next >");

	/**
	 * Create the panel.
	 */
	public last_two_tsats() {
		setLayout(null);
		
		JLabel lblPreviousTwoTsats = new JLabel("Previous two TSATs:");
		lblPreviousTwoTsats.setBounds(50, 49, 182, 8);
		add(lblPreviousTwoTsats);
		
		textField = new JTextField();
		textField.setBounds(283, 43, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 90, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
		button.setBounds(263, 296, 89, 23);
		add(button);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		
	}
	
	public int get_last_two_tsats_1() {
		return Integer.parseInt(textField.getText());
	}
	
	public int get_last_two_tsats_2() {
		return Integer.parseInt(textField_1.getText());
	}
	


	public JButton confirmLastTwoTSATs() {
		return btnConfirm;
	}
	
	public JButton back() {
		return button;
	}
	

}
