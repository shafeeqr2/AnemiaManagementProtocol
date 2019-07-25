package application;
import javax.swing.JPanel;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class hgb_tsat_ferritin_dates extends JPanel {


	private JDateChooser dateChooser = new JDateChooser();
	
	private JDateChooser dateChooser_1 = new JDateChooser();
	
	
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	private DateTime dt1;
	
	private DateTime dt2;
	
	private JButton btnConfirm = new JButton("Next >");

	private JButton button = new JButton("< Back");
	
	
	//private DateFormat f = DateFormat.getDateInstance(DateFormat.LONG);
	
	
	public hgb_tsat_ferritin_dates() {
		
		setLayout(null);
		
		JLabel lblDateOfMost = new JLabel("Date of previous Hgb:");
		lblDateOfMost.setBounds(50, 46, 206, 14);
		add(lblDateOfMost);
		
		JLabel lblDateOfMost_1 = new JLabel("Date of previous TSAT and ferritin:");
		lblDateOfMost_1.setBounds(50, 125, 206, 14);
		add(lblDateOfMost_1);

		dateChooser.setBounds(282, 40, 101, 20);
		add(dateChooser);
		
		dateChooser_1.setBounds(282, 119, 101, 20);
		add(dateChooser_1);
		
		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		button.setBounds(263, 296, 89, 23);
		
		add(button);

	}

/*	
	public JDateChooser date_hgb() {
		return dateChooser;
	}
		
	public JDateChooser date_tsat_ferritin() {
		return dateChooser_1;
	}
*/	
	public DateTime dateTime_hgb() {
		
		dt1 = new DateTime(dateChooser.getDate());
		return dt1;
	}
	

	
	public DateTime dateTime_tsat_ferritin() {

		dt2 = new DateTime(dateChooser_1.getDate());
		return dt2;
	}
	
	public JButton confirmDates() {
		return btnConfirm;
	}
	
	public SimpleDateFormat dateFormat() {
		return format;
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


