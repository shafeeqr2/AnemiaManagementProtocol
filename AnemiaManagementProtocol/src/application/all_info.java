package application;


import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import org.joda.time.DateTime;

import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Font;

public class all_info extends JScrollPane {
	
	
	private JLabel lblName = new JLabel("pateintName");
	private JLabel lblNname = new JLabel("nurseName");
	private JLabel lblCurrenthgb = new JLabel("currentHgb");
	private JLabel lblLasthgb = new JLabel("lastHgb");
	private JLabel lblRecenttsat = new JLabel("recentTsat");
	private JLabel lblRecentferritin = new JLabel("recentFerritin");
	private JLabel lblOnesa = new JLabel("onESA");
	private JLabel lblWhichESAMed = new JLabel("whichESAMed");
	private JLabel lblESAMedDosage = new JLabel("ESAMedDosage");
	private JLabel lblOnironmed = new JLabel("onIronMed");
	private JLabel lblWhichIronMed = new JLabel("whichIronMed");
	private JLabel lblIronMedDosage = new JLabel("ironMedDosage");
	private JLabel lblLastThreeHgbs_1 = new JLabel("hgb");
	private JLabel lblLastThreeHgbs_2 = new JLabel("hgb");
	private JLabel lblLastThreeHgbs_3 = new JLabel("hgb");
	private JLabel lblLastTwoTSATs_1 = new JLabel("tsat");
	private JLabel lblLastTwoTSATs_2 = new JLabel("tsat");
	private JLabel lblDateESAOnHold = new JLabel("date");
	private JLabel lblDateOfMostRecentHgb = new JLabel("date");
	private JLabel lblDateMostRecentTsatFerritin = new JLabel("date");


	/*
	private String pname;
	private String nname;
	private int current_hgb;
	private int last_hgb;
	private int recent_tsat;
	private int recent_ferritin;
	private String on_esa_med;
	private String which_esa_med;
	private boolean on_iron_med;
	private String which_iron_med;
	private String iron_med_dosage;
	//private String date_previous_hgb;
	//private String date_previous_tsat_ferritin;
	private int last_3_hgbs_1;
	private int last_3_hgbs_2;
	private int last_3_hgbs_3;
	private int last_2_tsats_1;
	private int last_2_tsats_2;
	private DateTime date_ESA_on_hold;
	private DateTime date_previous_hgb;
	private DateTime date_previous_tsat_ferritin;
	*/
	


    Font font = new Font("Helvetica", Font.BOLD, 11);
	
	public all_info() {
		
		
		//all_info_panel all_info = new all_info_panel();
		JPanel panel_1 = new JPanel();
		this.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Name:");
		//lblNewLabel.setFont(font);
		lblNewLabel.setBounds(10, 10, 200, 14);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("Nurse Name:");
		label.setBounds(10, 25, 200, 14);
		//label.setFont(font);
		panel_1.add(label);
		
		JLabel lblNurseName_1 = new JLabel("Current Hgb:");
		lblNurseName_1.setBounds(10, 40, 200, 14);
		//lblNurseName_1.setFont(font);
		panel_1.add(lblNurseName_1);
		
		JLabel label_1 = new JLabel("Last Protocol Hgb:");
		label_1.setBounds(10, 55, 200, 14);
		//label_1.setFont(font);
		panel_1.add(label_1);		
		
		JLabel lbl_MostRecentTsat_1 = new JLabel("Previous TSAT:");
		lbl_MostRecentTsat_1.setBounds(10, 70, 200, 14);
		//lbl_MostRecentTsat_1.setFont(font);
		panel_1.add(lbl_MostRecentTsat_1);
		
		JLabel lbl_MostRecentFerritin_1 = new JLabel("Previous Ferritin:");
		lbl_MostRecentFerritin_1.setBounds(10, 85, 200, 14);
		//lbl_MostRecentFerritin_1.setFont(font);
		panel_1.add(lbl_MostRecentFerritin_1);
		
		JLabel lbl_PatientOnEsa = new JLabel("Is the patient on ESA medication?");
		lbl_PatientOnEsa.setBounds(10, 100, 200, 14);
		//lbl_PatientOnEsa.setFont(font);
		panel_1.add(lbl_PatientOnEsa);
		
		JLabel lbl_PatientOn = new JLabel("Which ESA medication is the patient on?");
		lbl_PatientOn.setBounds(10, 115, 300, 14);
		//lbl_PatientOn.setFont(font);
		panel_1.add(lbl_PatientOn);
		
		JLabel lbl_ESAMedDosage = new JLabel("ESA Medication Dosage:");
		lbl_ESAMedDosage.setBounds(10, 130, 300, 14);
		//lbl_IronMedDosage.setFont(font);
		panel_1.add(lbl_ESAMedDosage);
		
		JLabel lbl_PatientOnIronMed = new JLabel("Is the patient on iron med?");
		lbl_PatientOnIronMed.setBounds(10, 145, 300, 14);
		//lbl_PatientOnIronMed.setFont(font);
		panel_1.add(lbl_PatientOnIronMed);
		
		JLabel lbl_WhichIronMed = new JLabel("Which Iron Medication is the patient on?");
		lbl_WhichIronMed.setBounds(10, 160, 300, 14);
		//lbl_WhichIronMed.setFont(font);
		panel_1.add(lbl_WhichIronMed);
		
		JLabel lbl_IronMedDosage = new JLabel("Iron Medication Dosage:");
		lbl_IronMedDosage.setBounds(10, 175, 300, 14);
		//lbl_IronMedDosage.setFont(font);
		panel_1.add(lbl_IronMedDosage);
		
		JLabel lbl_LastThreeHgbs_1 = new JLabel("Last three Hgbs:");
		lbl_LastThreeHgbs_1.setBounds(10, 190, 300, 14);
		//lbl_LastThreeHgbs_1.setFont(font);
		panel_1.add(lbl_LastThreeHgbs_1);
		
		JLabel lbl_LastThreeHgbs_2 = new JLabel("                ");
		lbl_LastThreeHgbs_2.setBounds(10, 205, 300, 14);
		//lbl_LastThreeHgbs_2.setFont(font);
		panel_1.add(lbl_LastThreeHgbs_2);
		
		JLabel lbl_LastThreeHgbs_3 = new JLabel("                ");
		lbl_LastThreeHgbs_3.setBounds(10, 220, 300, 14);
		//lbl_LastThreeHgbs_3.setFont(font);
		panel_1.add(lbl_LastThreeHgbs_3);
		
		JLabel lbl_LastTwoTSATs_1 = new JLabel("Last two TSATs:");
		lbl_LastTwoTSATs_1.setBounds(10, 235, 300, 14);
		//lbl_LastTwoTSATs_1.setFont(font);
		panel_1.add(lbl_LastTwoTSATs_1);
		
		JLabel lbl_LastTwoTSATs_2 = new JLabel("               ");
		lbl_LastTwoTSATs_2.setBounds(10, 250, 300, 14);
		//lbl_LastTwoTSATs_2.setFont(font);
		panel_1.add(lbl_LastTwoTSATs_2);
				
		JLabel lbl_DateESAOnHold = new JLabel("Date ESA was put on hold: ");
		lbl_DateESAOnHold.setBounds(10, 265, 300, 14);
		//lbl_DateESAOnHold.setFont(font);
		panel_1.add(lbl_DateESAOnHold);
		
		JLabel lbl_DateOfMostRecentHgb = new JLabel("Date of previous Hgb: ");
		lbl_DateOfMostRecentHgb.setBounds(10, 280, 300, 14);
		//lbl_DateOfMostRecentHgb.setFont(font);
		panel_1.add(lbl_DateOfMostRecentHgb);
		
		JLabel lbl_DateMostRecentTsatFerritin = new JLabel("Date of previous TSAT and Ferritin: ");
		lbl_DateMostRecentTsatFerritin.setBounds(10, 295, 300, 14);
		//lbl_DateMostRecentTsatFerritin.setFont(font);
		panel_1.add(lbl_DateMostRecentTsatFerritin);
		
		//-------------------------------------------------------------------
				
		lblName.setBounds(250, 10, 230, 14);
		panel_1.add(lblName);
		lblName.setVisible(false);
		
		lblNname.setBounds(250, 25, 230, 14);
		panel_1.add(lblNname);
		lblNname.setVisible(false);
		
		lblCurrenthgb.setBounds(250, 40, 230, 14);
		panel_1.add(lblCurrenthgb);
		lblCurrenthgb.setVisible(false);
		
		lblLasthgb.setBounds(250, 55, 230, 14);
		panel_1.add(lblLasthgb);
		lblLasthgb.setVisible(false);
		
		lblRecenttsat.setBounds(250, 70, 230, 14);
		panel_1.add(lblRecenttsat);
		lblRecenttsat.setVisible(false);
		
		lblRecentferritin.setBounds(250, 85, 230, 14);
		panel_1.add(lblRecentferritin);
		lblRecentferritin.setVisible(false);
		
		lblOnesa.setBounds(250, 100, 230, 14);
		panel_1.add(lblOnesa);
		lblOnesa.setVisible(false);
		
		lblWhichESAMed.setBounds(250, 115, 300, 14);
		panel_1.add(lblWhichESAMed);
		lblWhichESAMed.setVisible(false);
		
		lblESAMedDosage.setBounds(250, 130, 300, 14);
		panel_1.add(lblESAMedDosage);
		lblESAMedDosage.setVisible(false);
		
		lblOnironmed.setBounds(250, 145, 230, 14);
		panel_1.add(lblOnironmed);
		lblOnironmed.setVisible(false);
		
		lblWhichIronMed.setBounds(250, 160, 300, 14);
		panel_1.add(lblWhichIronMed);
		lblWhichIronMed.setVisible(false);
		
		lblIronMedDosage.setBounds(250, 175, 300, 14);
		panel_1.add(lblIronMedDosage);
		lblIronMedDosage.setVisible(false);

		lblLastThreeHgbs_1.setBounds(250, 190, 300, 14);
		panel_1.add(lblLastThreeHgbs_1);
		lblLastThreeHgbs_1.setVisible(false);

		
		lblLastThreeHgbs_2.setBounds(250, 205, 300, 14);
		panel_1.add(lblLastThreeHgbs_2);
		lblLastThreeHgbs_2.setVisible(false);
		
		
		lblLastThreeHgbs_3.setBounds(250, 220, 300, 14);
		panel_1.add(lblLastThreeHgbs_3);
		lblLastThreeHgbs_3.setVisible(false);

		
		lblLastTwoTSATs_1.setBounds(250, 235, 300, 14);
		panel_1.add(lblLastTwoTSATs_1);
		lblLastTwoTSATs_1.setVisible(false);

		
		lblLastTwoTSATs_2.setBounds(250, 250, 300, 14);
		panel_1.add(lblLastTwoTSATs_2);
		lblLastTwoTSATs_2.setVisible(false);

				
		lblDateESAOnHold.setBounds(250, 265, 300, 14);
		panel_1.add(lblDateESAOnHold);
		lblDateESAOnHold.setVisible(false); 

		
		lblDateOfMostRecentHgb.setBounds(250, 280, 300, 14);
		panel_1.add(lblDateOfMostRecentHgb);
		lblDateOfMostRecentHgb.setVisible(false); 

		
		lblDateMostRecentTsatFerritin.setBounds(250, 295, 300, 14);
		panel_1.add(lblDateMostRecentTsatFerritin);
		lblDateMostRecentTsatFerritin.setVisible(false);
		
	}
	
	
	public void set_patient_name (String patient_name){
		
		lblName.setText(patient_name);
		lblName.setVisible(true);		
		
	}
	
	public void set_nurse_name (String nurse_name){
		
		lblNname.setText(nurse_name);
		lblNname.setVisible(true);
		
	}
	
	public void set_current_hgb(String hgb) {
		
		lblCurrenthgb.setText(hgb + " g/L");
		lblCurrenthgb.setVisible(true);
		
	}
	
	public void set_last_protocol_hgb(String hgb) {
		
		lblLasthgb.setText(hgb  + " g/L");
		lblLasthgb.setVisible(true);
		
	}
	
	public void set_previous_tsat(String tsat) {
		
		lblRecenttsat.setText(tsat  + " %");
		lblRecenttsat.setVisible(true);
		
	}
	
	public void set_previous_ferritin(String recent_ferritin) {
		
		lblRecentferritin.setText(recent_ferritin  + " mcg/L");
		lblRecentferritin.setVisible(true);
		
	}
	
	public void set_on_esa(String on_esa_med) {
		/*
		if (on_esa_med_num == 1) {
			lblOnesa.setText("Yes");
		} else if (on_esa_med_num == 2) {
			lblOnesa.setText("No, it is currently on hold");
		} else if (on_esa_med_num == 3) {
			lblOnesa.setText("No, it has been discontinued");
		}
		*/
		lblOnesa.setText(on_esa_med);
		lblOnesa.setVisible(true);
			
	}
	
	public void set_which_esa_med(String which_esa_med) {
		
		lblWhichESAMed.setText(which_esa_med);
		lblWhichESAMed.setVisible(true);
		
	}
	
	public void set_esa_med_dosage(String esa_med_dosage) {
		lblESAMedDosage.setText(esa_med_dosage);
		lblESAMedDosage.setVisible(true);
	}
	
	public void set_patient_name(boolean on_iron_med) {
		
		if (on_iron_med) {
			lblOnironmed.setText("Yes");
		} else {
			lblOnironmed.setText("No");
		}
		lblOnironmed.setVisible(true);
		
	}
	
	public void set_on_iron_med(String on_iron_med) {
		lblOnironmed.setText(on_iron_med);
		lblOnironmed.setVisible(true);
	}
	
	public void set_which_iron_med(String which_iron_med) {
		
		lblWhichIronMed.setText(which_iron_med);
		lblWhichIronMed.setVisible(true);
		
	}
	
	public void set_iron_med_dosage(String iron_med_dosage) {
		
		lblIronMedDosage.setText(iron_med_dosage);
		lblIronMedDosage.setVisible(true);

	}
	
	public void clear_last_three_hgbs_1() {
		
		lblLastThreeHgbs_1.setVisible(false);
		
	}
	
	public void clear_last_three_hgbs_2() {
		
		lblLastThreeHgbs_2.setVisible(false);
		
	}
	
	public void clear_last_three_hgbs_3() {

		lblLastThreeHgbs_3.setVisible(false);

	}
	
	
	public void set_last_three_hgbs_1(int last_three_hgbs_1) {
		
		lblLastThreeHgbs_1.setText(Integer.toString(last_three_hgbs_1));
		lblLastThreeHgbs_1.setVisible(true);
		
	}
	
	public void set_last_three_hgbs_2(int last_three_hgbs_2) {
		
		lblLastThreeHgbs_2.setText(Integer.toString(last_three_hgbs_2));
		lblLastThreeHgbs_2.setVisible(true);
		
	}
	
	public void set_last_three_hgbs_3(int last_three_hgbs_3) {

		lblLastThreeHgbs_3.setText(Integer.toString(last_three_hgbs_3));
		lblLastThreeHgbs_3.setVisible(true);

	}
	
	public void set_last_two_tsats_1(int last_two_tsats_1) {
		
		lblLastTwoTSATs_1.setText(Integer.toString(last_two_tsats_1));
		lblLastTwoTSATs_1.setVisible(true);
		
	}
	
	public void set_last_two_tsats_2(int last_two_tsats_2) {

		lblLastTwoTSATs_2.setText(Integer.toString(last_two_tsats_2));
		lblLastTwoTSATs_2.setVisible(true);
		
	}
	
	public void set_date_esa_on_hold(String date) {
		
		lblDateESAOnHold.setText(date);
		lblDateESAOnHold.setVisible(true); 
		
	}	
	
	public void set_date_previous_hgb(String date) {
		
		lblDateOfMostRecentHgb.setText(date);
		lblDateOfMostRecentHgb.setVisible(true); 
		
	}
	
	public void set_date_previous_tsat_ferritin(String date_previous_tsat_ferritin) {
		
		lblDateMostRecentTsatFerritin.setText(date_previous_tsat_ferritin);
		lblDateMostRecentTsatFerritin.setVisible(true);
		
	}
	

	
}
