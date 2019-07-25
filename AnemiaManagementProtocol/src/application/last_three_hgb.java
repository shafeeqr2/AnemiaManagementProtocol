package application;
 import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class last_three_hgb extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JDateChooser dateChooser = new JDateChooser();

	private JDateChooser dateChooser_1 = new JDateChooser();
	
	private JButton btnGeneratePDF = new JButton("Generate PDF");
	
	private JButton btnConfirm = new JButton("Next >");
	
	private JButton button = new JButton("< Back");
		
	private DateTime dt1;
	
	private DateTime dt2;

	
	/**
	 * Create the panel.
	 */
	public last_three_hgb() {
		setLayout(null);
		
		JLabel lblEnterLastThree = new JLabel("Enter last three protocol Hgbs:");
		lblEnterLastThree.setBounds(50, 25, 192, 14);
		add(lblEnterLastThree);
		
		textField = new JTextField();
		textField.setBounds(324, 22, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 53, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 84, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateOfCurrent = new JLabel("Date of current Hgb:");
		lblDateOfCurrent.setBounds(50, 153, 149, 14);
		add(lblDateOfCurrent);
		
		JLabel lblDateOfMost = new JLabel("Date of most recent TSAT and Ferritin:");
		lblDateOfMost.setBounds(50, 220, 192, 14);
		add(lblDateOfMost);
		
		dateChooser.setBounds(321, 147, 101, 20);
		add(dateChooser);
		
		dateChooser_1.setBounds(321, 214, 101, 20);
		add(dateChooser_1);
		
		btnGeneratePDF.setBounds(165, 296, 99, 23);
		add(btnGeneratePDF);
		btnGeneratePDF.setVisible(false);
		
		button.setBounds(263, 296, 89, 23);
		add(button);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);

	}
	
	public int get_last_three_hgbs_1() {
		return Integer.parseInt(textField.getText());
	}
	
	public int get_last_three_hgbs_2() {
		return Integer.parseInt(textField_1.getText());
	}
	
	public int get_last_three_hgbs_3() {
		return Integer.parseInt(textField_2.getText());
	}
	
	public String get_last_three_hgbs_1_raw() {
		return textField.getText();
	}
	
	public String get_last_three_hgbs_2_raw() {
		return textField_1.getText();
	}
	
	public String get_last_three_hgbs_3_raw() {
		return textField_2.getText();
	}
	
	
	public JButton confirmLastThreeHGBs() {
		return btnConfirm;
	}
	
	public JDateChooser date_hgb() {
		return dateChooser;
	}
		
	public JDateChooser date_tsat_ferritin() {
		return dateChooser_1;
	}
	
	public DateTime dateTime_hgb() {
		return dt1;
	}
	
	public DateTime dateTime_tsat_ferritin() {
		return dt2;
	}
	
	public JButton confirmDates() {
		return btnConfirm;
	}
	
	public JButton generate_pdf(){
		return btnGeneratePDF;
	}
	
	public void date_difference() {
		
		dt1 = new DateTime(dateChooser.getDate());
		dt2 = new DateTime(dateChooser_1.getDate());
		
		System.out.println(Days.daysBetween(dt1, dt2).getDays());
		//return Days.daysBetween(dt1, dt2).getDays();
		
	}
	public JButton back() {
		return button;
	}
}
