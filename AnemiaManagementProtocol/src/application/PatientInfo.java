package application;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PatientInfo extends JPanel {
	
	
	//private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField();
	private JTextField textField_4 = new JTextField();
	private JTextField textField_5 = new JTextField();
	//private JSplitPane splitPane;
	
	//private PatientInfo window;
	//private AMP_View window;
	
	private JButton btnConfirm = new JButton("Next >");
	
	public PatientInfo() {

		setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(10, 37, 120, 14);
		add(lblPatientName);
		
		JLabel lblPatientInformation = new JLabel("Patient Information");
		lblPatientInformation.setBounds(170, 12, 120, 14);
		add(lblPatientInformation);
		
		JLabel lblNurseName = new JLabel("Nurse Name:");
		lblNurseName.setBounds(10, 62, 120, 14);
		add(lblNurseName);
		
		JLabel lblCurrentHgb = new JLabel("Current Hgb:");
		lblCurrentHgb.setBounds(10, 87, 120, 14);
		add(lblCurrentHgb);
		
		JLabel lblLastProtocolHgb = new JLabel("Last Protocol Hgb:");
		lblLastProtocolHgb.setBounds(10, 112, 120, 14);
		add(lblLastProtocolHgb);
		
		JLabel lblMostRecentTsat = new JLabel("Previous TSAT:");
		lblMostRecentTsat.setBounds(10, 137, 120, 14);
		add(lblMostRecentTsat);
		
		JLabel lblMostRecentFerritin = new JLabel("Previous Ferritin:");
		lblMostRecentFerritin.setBounds(10, 162, 120, 14);
		add(lblMostRecentFerritin);
		

		textField.setBounds(150, 34, 250, 20);
		add(textField);
		textField.setColumns(10);
		

		textField_1.setBounds(150, 59, 250, 20);
		add(textField_1);
		textField_1.setColumns(10);
		

		textField_2.setBounds(150, 84, 250, 20);
		add(textField_2);
		textField_2.setColumns(10);
		

		textField_3.setBounds(150, 109, 250, 20);
		add(textField_3);
		textField_3.setColumns(10);
		

		textField_4.setBounds(150, 134, 250, 20);
		add(textField_4);
		textField_4.setColumns(10);
		

		textField_5.setBounds(150, 159, 250, 20);
		add(textField_5);
		textField_5.setColumns(10);

		btnConfirm.setBounds(351, 296, 89, 23);
		add(btnConfirm);
		
		JLabel lblGl = new JLabel("g/L");
		lblGl.setBounds(402, 87, 26, 14);
		add(lblGl);
		
		JLabel label = new JLabel("g/L");
		label.setBounds(402, 112, 26, 14);
		add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(402, 137, 26, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("mcg/L");
		label_2.setBounds(402, 162, 38, 14);
		add(label_2);
	
	}
	
	public JButton confirmPatientInfo() {
		return btnConfirm;
	}
	
	public String getPatientName() {
		return textField.getText();
	}
	
	public String getNurseName() {
		return textField_1.getText();
	}
	
	public int getCurrentHgb() {
		return Integer.parseInt(textField_2.getText());
	}
	
	public int getLastProtocolHgb() {
		return Integer.parseInt(textField_3.getText());
	}
	
	public int getRecentTSAT() {
		return Integer.parseInt(textField_4.getText());
	}
	
	public int getRecentFerritin() {
		return Integer.parseInt(textField_5.getText());
	}
}
