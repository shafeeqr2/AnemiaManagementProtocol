package application;
import java.io.FileOutputStream;
import java.io.IOException;

import org.joda.time.DateTime;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;



public class pdfmaker {
	
	private String patient_name;
	private String nurse_name;
	private int current_hgb;
	private int last_protocol_hgb;
	private float previous_tsat;
	private int previous_ferritin;
	//private String on_esa_med;
	private int on_esa_med_num;
	private String which_esa_med;
	//private String on_iron_med;
	private int on_iron_med_num;
	private String which_iron_med;
	private String iron_med_dosage;
	private String date_previous_hgb;
	private String date_previous_tsat_ferritin;
	private int last_3_hgbs_1;
	private int last_3_hgbs_2;
	private int last_3_hgbs_3;
	private float last_2_tsats_1;
	private float last_2_tsats_2;
	private String date_ESA_on_hold;
	
	private AranespDAT AranespDAT = new AranespDAT();
	private EprexDAT EprexDAT = new EprexDAT();
	
	Font[] fonts = {
			new Font(),
			new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(
					/*Red*/ 0, /*Blue*/ 0, /*Green*/ 0)),
			new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(
					/*Red*/ 0, /*Blue*/ 0, /*Green*/ 0))
	};
	
	
	public Paragraph title() {
		
		Paragraph title = new Paragraph("Hemodialysis for " + patient_name , fonts[1]);
		return title;
	}
	
	public Paragraph introduction() {
		
		Paragraph introduction = new Paragraph("", fonts[2]);
		introduction.add("Patient Name: ");
		introduction.add(patient_name + " \n");
		
		introduction.add("Nurse name: ");
		introduction.add(nurse_name + " \n");
		
		introduction.add("Current Hgb: ");
		introduction.add(current_hgb + " g/L \n");
		
		introduction.add("Last protocol Hgb: ");
		introduction.add(last_protocol_hgb + " g/L \n");
		
		introduction.add("Previous TSAT: ");
		introduction.add(previous_tsat + " % \n");
		
		introduction.add("Previous Ferritin: ");
		introduction.add(previous_ferritin + " mcg/L \n");
		
		if (on_esa_med_num == 1) {
			introduction.add("The patient on the following ESA medication: " + which_esa_med + " \n" );
		} else if (on_esa_med_num == 2) {
			introduction.add("The ESA medication," + which_esa_med + " is on hold. \n");
		} else if (on_esa_med_num == 3) {
			introduction.add("The ESA medication has been discontinued. \n");
		}	
		
		if (on_iron_med_num == 1) {
			introduction.add("The patient is on the following Iron medication: ");
			introduction.add(which_iron_med + " \n");
			introduction.add("Dosage: " + iron_med_dosage + " \n");
		} else {
			introduction.add("The patient is not on iron medication.\n");
		}
		
		introduction.add("Date of previous Hgb: ");
		introduction.add(date_previous_hgb + " \n");
		
		introduction.add("Date of previous TSAT and Ferritin: ");
		introduction.add(date_previous_tsat_ferritin + " \n");
		
		introduction.add("Last three Hgbs: ");
		introduction.add(last_3_hgbs_1 + " \n");
		
		introduction.add("                              ");
		introduction.add(last_3_hgbs_2 + " \n");
		
		introduction.add("                              ");
		introduction.add(last_3_hgbs_3 + " \n");
		
		introduction.add("Date ESA was put on hold: ");
		introduction.add(date_ESA_on_hold + " \n");
		
		introduction.add("Last two TSATs: ");
		introduction.add(last_2_tsats_1 + " \n");
		
		introduction.add("                              ");
		introduction.add(last_2_tsats_2 + " \n");

		return introduction;
		
	}
//------------ANAMOLY NOTIFIERS------------------------------------
	public Paragraph hgb_below_85() {
		
		Paragraph hgb_below_85 = new Paragraph("", fonts[2]);
		hgb_below_85.add("Hgb is below 85. \n");
		
		return hgb_below_85;
	
	}
	
	public Paragraph hgb_decrease_above_15() {
		
		Paragraph hgb_decrease_above_15 = new Paragraph("", fonts[2]);
		hgb_decrease_above_15.add("Hgb decrease is greater than 15. \n");
		
		return hgb_decrease_above_15;
	
	}
	
	public Paragraph notify_md() {
		
		Paragraph notify_md = new Paragraph("", fonts[2]);
		notify_md.add("Notify MD. \n");
		return notify_md;
	}
	
	public Paragraph hgb_below_95_ferritin_below_200() {
		
		Paragraph hgb_below_95_ferritin_below_200 = new Paragraph("", fonts[2]);
		
		hgb_below_95_ferritin_below_200.add("Hgb is below 95 g/L and Ferritin < 200 ng/mL. \n");
		hgb_below_95_ferritin_below_200.add("Notify MD to consider intitiaing iron loading dose. \n");
		
		return hgb_below_95_ferritin_below_200;
	
	}
	
	
	public Paragraph hgb_8594_on_esa(String ESA_dosage) {
		
		Paragraph hgb_8594_on_esa = new Paragraph("", fonts[2]);
		
		hgb_8594_on_esa.add("Increase ESA Dosage to " + ESA_dosage + "\n");
		hgb_8594_on_esa.add("Notify MD if Hgb not between 95 to 115 g/L after three consecutive dose increases. \n");	
		hgb_8594_on_esa.add("Include page 5, ASSESS REASONS FOR ESA HYPORESPONSIVENESS \n");
		hgb_8594_on_esa.add("Remeasure iron bloodwork if not done in the past. \n");

		return hgb_8594_on_esa;
	}
	
	public Paragraph hgb_8594_not_on_esa() {
		
		Paragraph hgb_8594_not_on_esa = new Paragraph("", fonts[2]);
		
		 hgb_8594_not_on_esa.add("Re-measure iron bloodwork, if not done in past week. \n");
		 hgb_8594_not_on_esa.add("Consult MD to initiate ESA \n");
		 hgb_8594_not_on_esa.add("Suggested Initial dose: \n");
		 hgb_8594_not_on_esa.add("Epoetin: 100 units/kg/wk \n");
		 hgb_8594_not_on_esa.add("Darbepoetin: 0.45 mcg/kg/wk \n");

		return hgb_8594_not_on_esa;
	}
	public Paragraph hgb_95115_not_on_esa(AMP_Model theModel) {
		
		Paragraph hgb_95115_not_on_esa = new Paragraph("", fonts[2]);
		hgb_95115_not_on_esa.add("No ESA Required.\n");
		hgb_95115_not_on_esa.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_95115_not_on_esa.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + "\n");
		return hgb_95115_not_on_esa;
	}
	
	public Paragraph hgb_95115_on_esa(AMP_Model theModel) {
		
		Paragraph hgb_95115_on_esa = new Paragraph("", fonts[2]);
		hgb_95115_on_esa.add("Maintain ESA Dosage.\n");
		hgb_95115_on_esa.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_95115_on_esa.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + "\n");

		return hgb_95115_on_esa;
	}
	
	public Paragraph hgb_95115_esa_on_hold(AMP_Model theModel) {
		
		Paragraph hgb_95115_esa_on_hold = new Paragraph("", fonts[2]);
		if (theModel.get_which_esa_med().equals("Aranesp")) {
			
			hgb_95115_esa_on_hold.add("Restart Aranesp  on a reduced dosage of " + theModel.esa_DAT_dec() + ".\n");
			
		
		} else {
			
			hgb_95115_esa_on_hold.add("Restart Eprex on a reduced dosage of " + theModel.esa_DAT_dec() + ".\n");
		}
		
		hgb_95115_esa_on_hold.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_95115_esa_on_hold.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + ".\n");

		return hgb_95115_esa_on_hold;
	}
	
	public Paragraph hgb_above_115_116_to_125_on_esa(AMP_Model theModel) {
		
		Paragraph hgb_above_115_116_to_125_on_esa = new Paragraph("", fonts[2]);
		
		hgb_above_115_116_to_125_on_esa.add("If there is no dosage reduction in the past 3 weeks, decrease ESA dosage to " + theModel.esa_DAT_dec() + ".\n");
		hgb_above_115_116_to_125_on_esa.add("If there have been dosage reductions in the past three weeks, \n"
				+ "continue routine Hgb monitoring every four weeks.\n");
		hgb_above_115_116_to_125_on_esa.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + "\n");

		return hgb_above_115_116_to_125_on_esa;
	}
	
	public Paragraph hgb_above_115_126_and_above(AMP_Model theModel) {
		
		Paragraph hgb_above_115_126_and_above = new Paragraph("", fonts[2]);
		hgb_above_115_126_and_above.add("Hold ESA. Measure Hgb 2 weeks from now. \n");
		hgb_above_115_126_and_above.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 14).toString() + "\n");

		hgb_above_115_126_and_above.add("If Hgb is greater than or equal to 126 g/L for 12 weeks, discontinue ESA. \n");
		hgb_above_115_126_and_above.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_above_115_126_and_above.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + ".\n");
		
		return hgb_above_115_126_and_above;
	}
	
	public Paragraph hgb_above_115_116_to_125_esa_discon(AMP_Model theModel) {
		
		Paragraph hgb_above_115_116_to_125_esa_discon = new Paragraph("", fonts[2]);
		if (theModel.difference_between() >= 10) {
			hgb_above_115_116_to_125_esa_discon.add("The difference between previous Hgb and current Hgb is greater than 10.\n");
			hgb_above_115_116_to_125_esa_discon.add("Resume ESA at reduced dose of " + theModel.esa_DAT_dec() + ".\n");
			
		} else {
			
			hgb_above_115_116_to_125_esa_discon.add("The difference between previous Hgb and current Hgb is less than 10.\n");
			hgb_above_115_116_to_125_esa_discon.add("Continue to Hold ESA.\n");
			
		}
		hgb_above_115_116_to_125_esa_discon.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_above_115_116_to_125_esa_discon.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + "\n");

		return hgb_above_115_116_to_125_esa_discon;
	}
	
	public Paragraph hgb_above_115_not_on_esa(AMP_Model theModel) {
		Paragraph hgb_above_115_not_on_esa = new Paragraph("", fonts[2]);
		hgb_above_115_not_on_esa.add("No ESA Required.\n");
		hgb_above_115_not_on_esa.add("Continue routine Hgb monitoring every four weeks.\n");
		hgb_above_115_not_on_esa.add("Set appointmnent for " + theModel.days_later(DateTime.now(), 28).toString() + "\n");
		
		return hgb_above_115_not_on_esa;
	}
	
//IRON PROTOCOL (TSAT)-----------------------------------------------------
	public Paragraph ferritin_above_1000() {
		
		Paragraph ferritin_above_1000 = new Paragraph("", fonts[2]);
		ferritin_above_1000.add("Notify MD that Ferritin is above 1000 micrograms/L.");
		ferritin_above_1000.add("Notify MD if patient has signs and symptoms of sepsis.");
		ferritin_above_1000.add("Notify MD if patient is on antibiotics.");
		
		return ferritin_above_1000;
	}
	
	public Paragraph hgb_above_115_hold_iron() {
		
		Paragraph hgb_above_115_hold_iron  = new Paragraph("", fonts[2]);
		hgb_above_115_hold_iron.add("Present Hgb is above 115. \n");
		hgb_above_115_hold_iron.add("HOLD IRON. \n");
		
		return hgb_above_115_hold_iron;
	}
	
	public Paragraph reassess_12_weeks_from_now() {
		
		Paragraph reassess_12_weeks_from_now = new Paragraph("", fonts[2]); 
		reassess_12_weeks_from_now.add("Measure TSAT and Ferritin in 12 weeks and reassess iron dosage regimen. \n");
		
		return reassess_12_weeks_from_now;
	}
	
	public Paragraph tsat_20_on_esa() { 
		
		Paragraph tsat_20_on_esa = new Paragraph("", fonts[2]);
		
		tsat_20_on_esa.add("Start Iron Loading Dose.\n");
		tsat_20_on_esa.add("Obtain MD order if patient: \n");
		
		tsat_20_on_esa.add(" - has never received IV iron before \n");
		
		tsat_20_on_esa.add(" - has had a loading dose within past 12 weeks \n");
		tsat_20_on_esa.add("IV Iron Loading Dose: \n");
		
		tsat_20_on_esa.add(" - (Every HD for 9 consecutive sessions) \n");
		tsat_20_on_esa.add(" - FerrLecit (R) 125 mg IV \n");
		tsat_20_on_esa.add(" - Venofer (R) 100 mg IV \n");
		tsat_20_on_esa.add("Following Iron Loading Dose Completion, repeat bloodwork 2 weeks post last dose and proceed with IV from Maintenance: Every 2 weeks \n");
		tsat_20_on_esa.add(" - FerrLecit (R) 125 mg IV \n");
		
		tsat_20_on_esa.add(" - Venofer (R) 100 mg IV \n");
		
		return tsat_20_on_esa;
		
	}
	
	public Paragraph tsat_20_not_on_esa() {
		
		Paragraph tsat_20_not_on_esa = new Paragraph("", fonts[2]);

		tsat_20_not_on_esa.add("Continue or maintain iron maintenance dosage every 4 weeks.");

		return tsat_20_not_on_esa;
	}
	
	public Paragraph tsat_20_49_on_iron() {
		Paragraph tsat_20_49_on_iron = new Paragraph("", fonts[2]);
		tsat_20_49_on_iron.add("Continue current maintenance dose. \n");
		tsat_20_49_on_iron.add("Refer to current maintenance dose. \n");
		
		return tsat_20_49_on_iron;
	}
	
	public Paragraph tsat_20_49_not_on_iron(){
		Paragraph tsat_20_49_not_on_iron = new Paragraph("", fonts[2]);
		tsat_20_49_not_on_iron.add("Notify MD to initiate iron maintenance dose if patient has not received iron previously "
				+ "or start IV iron maintenance dose if patient has received iron previously. \n");
		tsat_20_49_not_on_iron.add("If the patient has been on iron, "
				+ "start maintenance dose of Ferrlecit 125 mg IV every 4 weeks "
				+ "OR Venofer 100 mg IV every 4 weeks. \n");
		
		return tsat_20_49_not_on_iron;
	}
	
	public Paragraph tsat_20_49_iron_on_hold(){
		Paragraph tsat_20_49_iron_on_hold = new Paragraph("", fonts[2]);
		tsat_20_49_iron_on_hold.add("Restart Iron Maintenance dose. \n");
		tsat_20_49_iron_on_hold.add("If the patient has been on iron, "
				+ "start maintenance dose of Ferrlecit 125 mg IV every 4 weeks "
				+ "OR Venofer 100 mg IV every 4 weeks. \n");
		
		return tsat_20_49_iron_on_hold;
	}
	
	public Paragraph tsat_greater_than_or_equal_to_50() {
		Paragraph tsat_greater_than_or_equal_to_50 = new Paragraph("", fonts[2]);
		tsat_greater_than_or_equal_to_50.add("Notify MD if iron indices remain high for 3 consecutive measurements. \n");
		return tsat_greater_than_or_equal_to_50;
	}
	//test date
	DateTime dt1 = new DateTime();
//--------------CONSTRUCTOR-----------------------------------
	public pdfmaker(AMP_Model theModel) {
		
		patient_name = theModel.get_patient_name();
		nurse_name = theModel.get_nurse_name();
		current_hgb = theModel.get_current_hgb();
		last_protocol_hgb = theModel.get_last_protocol_hgb();
		previous_tsat = theModel.get_previous_tsat();
		previous_ferritin = theModel.get_previous_ferritin();
		//on_esa_med = theModel.get_on_esa_med(); //(NOT NEEDED, ON ESA MED DETERMINED BY NUMBER
		on_esa_med_num = theModel.get_on_esa_med_num();
		which_esa_med = theModel.get_which_esa_med();
		//on_iron_med = theModel.get_on_iron_med(); //NOT NEEDED. ON IRON MED DETERMINED BY NUMBER
		on_iron_med_num = theModel.get_on_iron_med_num();
		which_iron_med = theModel.get_which_iron_med();
		iron_med_dosage = theModel.get_iron_med_dosage();
		last_3_hgbs_1 = theModel.get_last_3_hgbs_1();
		last_3_hgbs_2 = theModel.get_last_3_hgbs_2();
		last_3_hgbs_3 = theModel.get_last_3_hgbs_3();
		last_2_tsats_1 = theModel.get_last_2_tsats_1();
		last_2_tsats_2 = theModel.get_last_2_tsats_2();	
		date_ESA_on_hold = theModel.get_date_ESA_on_hold();
		date_previous_hgb = theModel.get_date_previous_hgb();
		date_previous_tsat_ferritin = theModel.get_date_previous_tsat_ferritin();
		
		Document document = new Document();
		
		//Portrait, Letterhead
		Rectangle rect = new Rectangle(PageSize.LETTER);
		
		//rotate() is for landscape
		//Rectangle rect_landscape = new Rectangle(PageSize.LETTER.rotate());
		document.setPageSize(rect);
		
		//More fonts can be added to the list as needed

		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("Hemodialysis for " + patient_name + ".pdf"));
			
			document.open();
			Paragraph title = title();
			Paragraph introduction = introduction();
			document.add(title);
			document.add(introduction);	
			
//---------------------------HGB ESA PROTOCOL---------------------------------------
			
			//0 <= Hgb <= 84 or Decrease in Hgb greater than 15
			//HGB/ESA Protocol ends
			if (theModel.hgb_decrease_greater_than_15() || 
				(theModel.isBetween(theModel.get_current_hgb(),0,84))) {
				
				if (theModel.hgb_decrease_greater_than_15()) {
					
					Paragraph hgb_decrease_above_15 = hgb_decrease_above_15();	
					document.add(hgb_decrease_above_15);
				
				}
				
				if ((theModel.isBetween(theModel.get_current_hgb(),0,84))) {
					
					Paragraph hgb_below_85 = hgb_below_85();
					document.add(hgb_below_85);
				
				}
				//CONTINUE HERE
				Paragraph notify_md = notify_md();
				document.add(notify_md);
				
			} else {
				//The HGB/ESA Protocol continues
				
				//85 <= Hgb <= 94
				if (theModel.isBetween(theModel.get_current_hgb(),85,94)) {
				
					//Ferritin below 200
					if (theModel.isBetween(theModel.get_previous_ferritin(),0,200)) {
						
						Paragraph hgb_below_95_ferritin_below_200 = hgb_below_95_ferritin_below_200();		
						document.add(hgb_below_95_ferritin_below_200);
											
					} else {
						
						if (on_esa_med_num == 1) {
							
							Paragraph hgb_8594_on_esa = hgb_8594_on_esa(theModel.esa_DAT_inc());	
							document.add(hgb_8594_on_esa);
			
						} else if (on_esa_med_num == 2) {
							
							Paragraph hgb_8594_not_on_esa = hgb_8594_not_on_esa();
							document.add(hgb_8594_not_on_esa);
			
						}
						
					}
				
				//95 <= Hgb <= 115	
				} else if (theModel.isBetween(theModel.get_current_hgb(),95,115)) { 

					if (on_esa_med_num == 1) {
						Paragraph hgb_95115_on_esa = hgb_95115_on_esa(theModel);
						document.add(hgb_95115_on_esa);

					} else if (on_esa_med_num == 2) {
						Paragraph hgb_95115_not_on_esa = hgb_95115_not_on_esa(theModel);
						document.add(hgb_95115_not_on_esa);

					} else if (on_esa_med_num == 3) {
						Paragraph hgb_95115_esa_on_hold = hgb_95115_esa_on_hold(theModel);
						document.add(hgb_95115_esa_on_hold);
						
					}
					
				//115 < Hgb
				} else if (theModel.get_current_hgb() > 115) {
					
					if (on_esa_med_num == 1) {

						if (theModel.isBetween(theModel.get_current_hgb(), 116, 125)) {
							Paragraph hgb_above_115_116_to_125_on_esa = hgb_above_115_116_to_125_on_esa(theModel);
							document.add(hgb_above_115_116_to_125_on_esa);
						} else if (theModel.get_current_hgb() >= 126) {
							Paragraph hgb_above_115_126_and_above = hgb_above_115_126_and_above(theModel);
							document.add(hgb_above_115_126_and_above);
						}
					} else if (on_esa_med_num == 2) {
											
						Paragraph hgb_above_115_not_on_esa = hgb_above_115_not_on_esa(theModel);
						document.add(hgb_above_115_not_on_esa );

					} else if (on_esa_med_num == 5) {
						
						if (theModel.isBetween(theModel.get_current_hgb(), 116, 125)) {
							Paragraph hgb_above_115_116_to_125_esa_discon = hgb_above_115_116_to_125_esa_discon(theModel);
							document.add(hgb_above_115_116_to_125_esa_discon);
						} else if (theModel.get_current_hgb() >= 126) {
							Paragraph hgb_above_115_126_and_above = hgb_above_115_126_and_above(theModel);
							document.add(hgb_above_115_126_and_above);
						}
					}
				}
		
			//} <- this bracket is for the protocol up. It was commented out here
		    // and inserted at the bottom so that if Hgb is below 85 or decrease is greater
			// than 15, the program does not carry on with the Iron protocol.
//---------------------------IRON/IV IRON PROTOCOL---------------------------------------
				if (theModel.get_previous_ferritin() > 1000 ||
						(theModel.get_current_hgb() > 115)) {
					//Do not continue with TSAT
					if (theModel.get_previous_ferritin() > 1000) {				
	
						Paragraph ferritin_above_1000 = ferritin_above_1000();
						document.add(ferritin_above_1000);
					}
					
					if (theModel.get_current_hgb() > 115) {
						Paragraph hgb_above_115_hold_iron = hgb_above_115_hold_iron();
						document.add(hgb_above_115_hold_iron);
					}
					
				} else {
					if (theModel.isBetween(theModel.get_previous_tsat(), 0, 19)) {
						
						if (on_esa_med_num == 1) {
							//Change to ESA Med
							Paragraph tsat_20_on_esa = tsat_20_on_esa();					
							document.add(tsat_20_on_esa);
	
						} else {
							
							Paragraph tsat_20_not_on_esa = tsat_20_not_on_esa();
							document.add(tsat_20_not_on_esa);
	
						}
						
						
					} else if (theModel.isBetween(theModel.get_previous_tsat(), 20, 49)) {
						
						if (on_iron_med_num == 1) {
							Paragraph tsat_20_49_on_iron = tsat_20_49_on_iron();
							document.add(tsat_20_49_on_iron);
						} else if (on_iron_med_num == 2) {
							Paragraph tsat_20_49_not_on_iron = tsat_20_49_not_on_iron();
							document.add(tsat_20_49_not_on_iron);
						} else if (on_iron_med_num == 3) {
							Paragraph tsat_20_49_iron_on_hold = tsat_20_49_iron_on_hold();
							document.add(tsat_20_49_iron_on_hold);
						}
						
						
					} else if (theModel.get_previous_tsat() > 49) {
						
						
						
					}
					
					Paragraph reassess_12_weeks_from_now = reassess_12_weeks_from_now();
					document.add(reassess_12_weeks_from_now);
				}
			}
			
			document.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}	
	}
	
	public void open() throws IOException
	{
	    Desktop desktop = Desktop.getDesktop();

	    desktop.open(new File("Hemodialysis for " + patient_name + ".pdf"));
	}
	
	
}
