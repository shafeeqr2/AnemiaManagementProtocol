package application;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class ESAHoldDate extends JPanel {

	/**
	 * Create the panel.
	 * 
	 * 
	 */
	
	private JDateChooser dateChooser = new JDateChooser();

	private JButton btnConfirm = new JButton("Next >");
	
	private DateTime dt1;
	private final JButton button = new JButton("< Back");
	
	public ESAHoldDate() {
		setLayout(null);
		
		JLabel lblDateAranespOr = new JLabel("Date aranesp or eprex was put on hold:");
		lblDateAranespOr.setBounds(50, 25, 207, 14);
		add(lblDateAranespOr);
		
		dateChooser.setBounds(317, 19, 101, 20);
		add(dateChooser);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		button.setBounds(263, 296, 89, 23);
		
		add(button);

	}
	
	public JDateChooser date_on_hold() {
		return dateChooser;
	}
	
	public DateTime dateTime_on_hold() {
		return dt1;
	}
	
	public JButton confirm_onHoldDate() {
		return btnConfirm;
	}
	
	public JButton back() {
		return button;
	}
}
