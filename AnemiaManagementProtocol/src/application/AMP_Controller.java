package application;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import org.joda.time.DateTime;
import org.joda.time.Days;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

import java.awt.Desktop;
import java.io.File;



public class AMP_Controller {

	private AMP_View theView;
	private AMP_Model theModel;
	
	private boolean current_hgb_in_range;
	private boolean last_protocol_hgb_in_range;
	private boolean previous_tsat_in_range;
	private boolean previous_ferritin_in_range;
	
	private boolean last_3_hgb_protocol_1_range = true;
	private boolean last_3_hgb_protocol_2_range = true;
	private boolean last_3_hgb_protocol_3_range = true;

	private StringBuffer errorMessage = new StringBuffer("");
	
	private StringBuffer errorMessage_last_3_hgbs = new StringBuffer("");
	
	AMP_Controller(AMP_Model theModel, AMP_View theView) {
		
		
		this.theView = theView;		
		this.theModel = theModel;

		
		theView.PatientInfo.confirmPatientInfo().addActionListener((ActionEvent ae) -> {
			
			//Range checks
			try {
			
				if (theView.PatientInfo.getCurrentHgb() >= ranges.getMin_hgb() 
						&& theView.PatientInfo.getCurrentHgb() <= ranges.getMax_hgb()) {
					
					current_hgb_in_range = true;
					
				} else {
				
					current_hgb_in_range = false;
					
				}
				
				if (theView.PatientInfo.getLastProtocolHgb() >= ranges.getMin_hgb() 
						&& theView.PatientInfo.getLastProtocolHgb() <= ranges.getMax_hgb()) {
					
					last_protocol_hgb_in_range = true;
					
				} else {
				
					last_protocol_hgb_in_range = false;
				
				}
				
				if (theView.PatientInfo.getRecentTSAT() >= ranges.getMin_tsat() 
						&& theView.PatientInfo.getRecentTSAT() <= ranges.getMax_tsat()) {
					
					previous_tsat_in_range = true;
					
				} else {
				
					previous_tsat_in_range = false;
				
				}
				
				if (theView.PatientInfo.getRecentFerritin() >= ranges.getMin_ferritin() 
						&& theView.PatientInfo.getRecentFerritin() <= ranges.getMax_ferritin()) {
					
					previous_ferritin_in_range = true;
					
				} else {
				
					previous_ferritin_in_range = false;
				
				}
				
				//Messages for range checks
				if (!current_hgb_in_range) {
					errorMessage.append("Current hgb is out of range.\n\n");
				}
			
				if (!last_protocol_hgb_in_range) {
					errorMessage.append("Last protocol is out of range.\n\n");
				}
			
				if (!previous_tsat_in_range) {
					errorMessage.append("Most recent TSAT is out of range.\n\n");
				}
			
				if (!previous_ferritin_in_range) {
					errorMessage.append("Most recent ferritin is out of range.\n\n");
				}
				
				if (!current_hgb_in_range ||
					!last_protocol_hgb_in_range || 
					!previous_tsat_in_range ||
					!previous_ferritin_in_range) {               
					
					JOptionPane.showMessageDialog(theView.PatientInfo, errorMessage.toString());
					errorMessage = new StringBuffer("");
					
				} else { 
					
					theModel.set_patient_name(theView.PatientInfo.getPatientName());
					theModel.set_nurse_name(theView.PatientInfo.getNurseName());
					theModel.set_current_hgb(theView.PatientInfo.getCurrentHgb());
					theModel.set_last_protocol_hgb(theView.PatientInfo.getLastProtocolHgb());
					theModel.set_previous_tsat(theView.PatientInfo.getRecentTSAT());
					theModel.set_previous_ferratin(theView.PatientInfo.getRecentFerritin());				
					
					theView.all_info.set_patient_name(theModel.get_patient_name());
					theView.all_info.set_nurse_name(theModel.get_nurse_name());
					theView.all_info.set_current_hgb(Integer.toString(theModel.get_current_hgb()));
					theView.all_info.set_last_protocol_hgb(Integer.toString(theModel.get_last_protocol_hgb()));
					theView.all_info.set_previous_tsat(Integer.toString(theModel.get_previous_tsat()));
					theView.all_info.set_previous_ferritin(Integer.toString(theModel.get_previous_ferritin()));
					
					theView.OnESA_Select(theModel);
					//theView.getSplitPane().setLeftComponent(theView.onESA);
					theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
					
				}
			
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(theView.PatientInfo, "You must enter a valid value.");
			}
			
	
		});
//--------------ESA ACTION LISTENERS---------------------		
		theView.Hgb_lt_85_or_dc_gt_15.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.PatientInfo);
			theView.Hgb_lt_85_or_dc_gt_15.set_text("");
			theView.Hgb_lt_85_or_dc_gt_15.set_text2("");
			theView.Hgb_lt_85_or_dc_gt_15.get_text3().setVisible(false);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
	
		});
		
		theView.Hgb_lt_85_or_dc_gt_15.generate_pdf().addActionListener((ActionEvent ae) -> {
			pdfmaker pdfmaker = new pdfmaker(theModel);
			
			try {
				pdfmaker.open();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		theView.OnESA_85_94.confirmOnESA().addActionListener((ActionEvent ae) -> {
			
			if (theView.OnESA_85_94.radio_yes().isSelected()){
				
				theModel.set_on_esa_med(1);
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				

			}  else if (theView.OnESA_85_94.radio_no().isSelected()) {
				
				theModel.set_on_esa_med(2);
				theView.all_info.set_on_esa("");
				theView.all_info.set_which_esa_med("");
				theView.all_info.set_esa_med_dosage("");
				theView.getSplitPane().setLeftComponent(theView.onIronMed);
			
			}
			
			theView.all_info.set_on_esa(theModel.get_on_esa_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.OnESA_85_94.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.PatientInfo);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		
		theView.OnESA_95_115.confirmOnESA().addActionListener((ActionEvent ae) -> {
			
			if (theView.OnESA_95_115.radio_yes().isSelected()){
				
				theModel.set_on_esa_med(1);
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				
			}  else if (theView.OnESA_95_115.radio_no().isSelected()) {
				
				theModel.set_on_esa_med(2);
				theView.all_info.set_on_esa("");
				theView.all_info.set_which_esa_med("");
				theView.all_info.set_esa_med_dosage("");
				theView.getSplitPane().setLeftComponent(theView.onIronMed);
			
			} else if (theView.OnESA_95_115.radio_on_hold().isSelected()) {
				
				theModel.set_on_esa_med(3);
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				
			}
			
			theView.all_info.set_on_esa(theModel.get_on_esa_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		

		theView.OnESA_95_115.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.PatientInfo);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
	
		theView.OnESA_greater_than_115.confirmOnESA().addActionListener((ActionEvent ae) -> {
			
			if (theView.OnESA_greater_than_115.radio_yes().isSelected()){
				
				theModel.set_on_esa_med(1);
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				

			}  else if (theView.OnESA_greater_than_115.radio_no().isSelected()) {
				
				theModel.set_on_esa_med(2);
				theView.all_info.set_on_esa("");
				theView.all_info.set_which_esa_med("");
				theView.all_info.set_esa_med_dosage("");
				theView.getSplitPane().setLeftComponent(theView.onIronMed);
			
			} else if (theView.OnESA_greater_than_115.radio_on_hold_or_discontinued().isSelected()) {
				
				theModel.set_on_esa_med(5);
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				
			}
			
			theView.all_info.set_on_esa(theModel.get_on_esa_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});

		theView.OnESA_greater_than_115.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.PatientInfo);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		
		theView.whichESAMed.confirmESAmed().addActionListener((ActionEvent ae) -> {
			
			if (theView.whichESAMed.radio_aranesp().isSelected()) {
				
				theModel.set_which_esa_med(1);
				theView.getSplitPane().setLeftComponent(theView.EsaDosageAranesp);
				
			} else if (theView.whichESAMed.radio_eprex().isSelected()) {
				
				theModel.set_which_esa_med(2);
				theView.getSplitPane().setLeftComponent(theView.EsaDosageEprex);
			}
			
			theView.all_info.set_which_esa_med(theModel.get_which_esa_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});
		
		theView.whichESAMed.back().addActionListener((ActionEvent ae) -> {
			
			//85 <= Hgb <= 94
			if (theModel.isBetween(theModel.get_current_hgb(),85,94)) {
				
				theView.getSplitPane().setLeftComponent(theView.OnESA_85_94);
			
			//95 <= Hgb <= 115	
			} else if (theModel.isBetween(theModel.get_current_hgb(),95,115)) {
									
				theView.getSplitPane().setLeftComponent(theView.OnESA_95_115);

				
			//115 < Hgb
			} else if (theModel.get_current_hgb() > 115) {
				
				theView.getSplitPane().setLeftComponent(theView.OnESA_greater_than_115);

			}		

			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});
		
		theView.EsaDosageAranesp.confirm().addActionListener((ActionEvent ae) -> {
			
			if (theView.EsaDosageAranesp.get_option() != null) { 
				theModel.set_esa_med_dosage(theView.EsaDosageAranesp.get_option().toString());
			}
			
			theView.all_info.set_esa_med_dosage(theModel.get_esa_med_dosage());
			theView.getSplitPane().setLeftComponent(theView.onIronMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		theView.EsaDosageAranesp.back().addActionListener((ActionEvent ae) -> {
			theView.getSplitPane().setLeftComponent(theView.whichESAMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});
		
		theView.EsaDosageEprex.confirm().addActionListener((ActionEvent ae) -> {
			
			if (theView.EsaDosageEprex.get_option() != null) {
				theModel.set_esa_med_dosage(theView.EsaDosageEprex.get_option().toString());
			}
			
			theView.all_info.set_esa_med_dosage(theModel.get_esa_med_dosage());
			theView.getSplitPane().setLeftComponent(theView.onIronMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.EsaDosageEprex.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.whichESAMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});		
		
//---------------------------IRON MED ACTION LISTENERS -----------------------		
		theView.onIronMed.confirmOnIronMed().addActionListener((ActionEvent ae) -> {
			
			if (theView.onIronMed.radio_yes().isSelected()) {
				theModel.set_on_iron_med(1);
				theView.getSplitPane().setLeftComponent(theView.whichIronMed);
				
			} else if (theView.onIronMed.radio_no().isSelected()) {
				theModel.set_on_iron_med(2);
				theView.all_info.set_which_iron_med("");
				theView.all_info.set_iron_med_dosage("");
				
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
			} else if (theView.onIronMed.radio_no_on_hold().isSelected()) {
				theModel.set_on_iron_med(3);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
			}
			
			theView.all_info.set_on_iron_med(theModel.get_on_iron_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.onIronMed.back().addActionListener((ActionEvent ae) -> {
			
			if ((theModel.get_on_esa_med_num() == 1) 
				|| (theModel.get_on_esa_med_num() == 3)
				|| (theModel.get_on_esa_med_num() == 4)
				||  (theModel.get_on_esa_med_num() == 5)) {
				
				theView.getSplitPane().setLeftComponent(theView.whichESAMed);
				
			} else if (theModel.get_on_esa_med_num() == 2){
				
				//85 <= Hgb <= 94
				if (theModel.isBetween(theModel.get_current_hgb(),85,94)) {
					
					theView.getSplitPane().setLeftComponent(theView.OnESA_85_94);
				
				//95 <= Hgb <= 115	
				} else if (theModel.isBetween(theModel.get_current_hgb(),95,115)) {
										
					theView.getSplitPane().setLeftComponent(theView.OnESA_95_115);
	
				//115 < Hgb
				} else if (theModel.get_current_hgb() > 115) {
					
					theView.getSplitPane().setLeftComponent(theView.OnESA_greater_than_115);

				}		

			}
			
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		theView.whichIronMed.confirmWhicnIronMed().addActionListener((ActionEvent ae) -> {
			
			if (theView.whichIronMed.radio_venofer().isSelected()) {
				
				theModel.set_which_iron_med(1);
				theView.getSplitPane().setLeftComponent(theView.venoferDosage);
				
			} else if (theView.whichIronMed.radio_ferrlecit().isSelected()) {
				
				theModel.set_which_iron_med(2);
				theView.getSplitPane().setLeftComponent(theView.ferricitDosage);
				
			}
			
			theView.all_info.set_which_iron_med(theModel.get_which_iron_med());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		theView.whichIronMed.back().addActionListener((ActionEvent ae) -> {
			
			theView.getSplitPane().setLeftComponent(theView.onIronMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});
		
		theView.venoferDosage.confirmVenoferDosage().addActionListener((ActionEvent ae) -> {
						
			if (theView.venoferDosage.radio_two_weeks().isSelected()) {
				theModel.set_venofer_dosage(1);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);


			} else if (theView.venoferDosage.radio_four_weeks().isSelected()) {
				theModel.set_venofer_dosage(2);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);

			} else if (theView.venoferDosage.radio_nine_weeks().isSelected()) {
				theModel.set_venofer_dosage(3);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);

			}
			
			theView.all_info.set_iron_med_dosage(theModel.get_iron_med_dosage());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.venoferDosage.back().addActionListener((ActionEvent ae) -> {

				theView.getSplitPane().setLeftComponent(theView.whichIronMed);
				theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
			
		});
		

		theView.ferricitDosage.confirmFerricitDosage().addActionListener((ActionEvent ae) -> {
			
			if (theView.ferricitDosage.radio_two_weeks().isSelected()) {
				theModel.set_ferricit_dosage(1);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
				
			} else if (theView.ferricitDosage.radio_four_weeks().isSelected()) {
				theModel.set_ferricit_dosage(2);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
				
			} else if (theView.ferricitDosage.radio_nine_weeks().isSelected()) {
				theModel.set_ferricit_dosage(3);
				theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
				
			}
			
			theView.all_info.set_iron_med_dosage(theModel.get_iron_med_dosage());
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.ferricitDosage.back().addActionListener((ActionEvent ae) -> {

			theView.getSplitPane().setLeftComponent(theView.whichIronMed);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		
		});
		
		theView.hgb_tsat_ferritin_dates.confirmDates().addActionListener((ActionEvent ae) -> {

			//Method gives the difference between the two dates
			//theView.hgb_tsat_ferritin_dates.date_difference();
			
			theModel.set_date_previous_hgb(theView.hgb_tsat_ferritin_dates.dateFormat().format(theView.hgb_tsat_ferritin_dates.dateTime_hgb().toDate()));
			theModel.set_date_previous_tsat_ferritin(theView.hgb_tsat_ferritin_dates.dateFormat().format(theView.hgb_tsat_ferritin_dates.dateTime_tsat_ferritin().toDate()));
			
			theView.all_info.set_date_previous_hgb(theModel.get_date_previous_hgb());
			theView.all_info.set_date_previous_tsat_ferritin(theModel.get_date_previous_tsat_ferritin());
			
			theView.getSplitPane().setLeftComponent(theView.last_three_hgb);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

		});
		
		theView.hgb_tsat_ferritin_dates.back().addActionListener((ActionEvent ae) -> {
			
			if (theModel.get_on_iron_med_num() == 1) {
				
				if (theModel.get_which_iron_med_num() == 1) {
					
					theView.getSplitPane().setLeftComponent(theView.venoferDosage);

				} else if (theModel.get_which_iron_med_num() == 2) {
					
					theView.getSplitPane().setLeftComponent(theView.ferricitDosage);
					
				}
				
			} else {
				
				theView.getSplitPane().setLeftComponent(theView.onIronMed);
				
			}
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		});
		
		theView.last_three_hgb.confirmDates().addActionListener((ActionEvent ae) -> {

			//Method gives the difference between the two dates
			//theView.last_three_hgb.date_difference();
			
			try {
				
				if (!theView.last_three_hgb.get_last_three_hgbs_1_raw().isEmpty()) {
					
					if (theView.last_three_hgb.get_last_three_hgbs_1() >= ranges.getMin_hgb() 
							&& theView.last_three_hgb.get_last_three_hgbs_1() <= ranges.getMax_hgb()) {
						
						last_3_hgb_protocol_1_range = true;
						theModel.set_last_3_hgbs_1(theView.last_three_hgb.get_last_three_hgbs_1());
						theView.all_info.set_last_three_hgbs_1(theModel.get_last_3_hgbs_1());

					} else {
					
						last_3_hgb_protocol_1_range = false;
						
					}
					
					if (!last_3_hgb_protocol_1_range) {
						errorMessage_last_3_hgbs.append("1st Hgb is out of range. \n\n");
					}
					
				}
				
				if (!theView.last_three_hgb.get_last_three_hgbs_2_raw().isEmpty()) {
					
					if (theView.last_three_hgb.get_last_three_hgbs_2() >= ranges.getMin_hgb() 
							&& theView.last_three_hgb.get_last_three_hgbs_2() <= ranges.getMax_hgb()) {
						
						last_3_hgb_protocol_2_range = true;
						theModel.set_last_3_hgbs_2(theView.last_three_hgb.get_last_three_hgbs_2());
						theView.all_info.set_last_three_hgbs_2(theModel.get_last_3_hgbs_2());

					} else {
					
						last_3_hgb_protocol_2_range = false;
						
					}
					
					if (!last_3_hgb_protocol_2_range) {
						errorMessage_last_3_hgbs.append("2nd Hgb is out of range. \n\n");
					}
					
	
				}
				
				if (!theView.last_three_hgb.get_last_three_hgbs_3_raw().isEmpty()) {
					
					if (theView.last_three_hgb.get_last_three_hgbs_3() >= ranges.getMin_hgb() 
							&& theView.last_three_hgb.get_last_three_hgbs_3() <= ranges.getMax_hgb()) {
						
						last_3_hgb_protocol_3_range = true;
						theModel.set_last_3_hgbs_3(theView.last_three_hgb.get_last_three_hgbs_3());
						theView.all_info.set_last_three_hgbs_3(theModel.get_last_3_hgbs_3());

					} else {
					
						last_3_hgb_protocol_3_range = false;
						
					}
					
					if (!last_3_hgb_protocol_3_range) {
						errorMessage_last_3_hgbs.append("3rd Hgb is out of range. \n\n");
					}
					
	
				}
				
				if (theView.last_three_hgb.get_last_three_hgbs_1_raw().isEmpty()) {
					theView.all_info.clear_last_three_hgbs_1();
				}
				
				if (theView.last_three_hgb.get_last_three_hgbs_2_raw().isEmpty()) {
					theView.all_info.clear_last_three_hgbs_2();
				}
				
				if (theView.last_three_hgb.get_last_three_hgbs_3_raw().isEmpty()) {
					theView.all_info.clear_last_three_hgbs_3();
				}
					
				if (!last_3_hgb_protocol_1_range ||
					!last_3_hgb_protocol_2_range || 
					!last_3_hgb_protocol_3_range) {
					
						errorMessage_last_3_hgbs.append("If a field is not needed, leave it empty. \n\n");
						JOptionPane.showMessageDialog(theView.last_three_hgb, errorMessage_last_3_hgbs.toString());
						errorMessage_last_3_hgbs = new StringBuffer("");
						
				} else {
					
				    theView.last_three_hgb.generate_pdf().setVisible(true);
					theView.getSplitPane().setDividerLocation(theView.getWidth()/2);

				}
		 
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(theView.last_three_hgb, "You must enter a valid value.");

			}

		});
		
		theView.last_three_hgb.back().addActionListener((ActionEvent ae) -> {
			
			theView.last_three_hgb.generate_pdf().setVisible(false);
			theView.getSplitPane().setLeftComponent(theView.hgb_tsat_ferritin_dates);
			theView.getSplitPane().setDividerLocation(theView.getWidth()/2);
		
		});
				
		theView.last_three_hgb.generate_pdf().addActionListener((ActionEvent ae) -> {
			
			pdfmaker pdfmaker = new pdfmaker(theModel);
			
			try {
				pdfmaker.open();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		
	}
	
}
