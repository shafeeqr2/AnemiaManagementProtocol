package application;
import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

//import javax.swing.JPanel;

public class AMP_Model {
	
	private String patient_name;
	private String nurse_name;
	private int current_hgb;
	private int last_protocol_hgb;
	private int previous_tsat;
	private int previous_ferritin;
	private String on_esa_med; 
	private int on_esa_med_num;
	private String which_esa_med;
	private String esa_med_dosage;
	private String on_iron_med;
	private int on_iron_med_num;
	private String which_iron_med;
	private int which_iron_med_num;
	private String iron_med_dosage;
	private String date_previous_hgb;
	private String date_previous_tsat_ferritin;
	private int last_3_hgbs_1;
	private int last_3_hgbs_2;
	private int last_3_hgbs_3;
	private int last_2_tsats_1;
	private int last_2_tsats_2;
	private String date_ESA_on_hold;
	
	private EprexDAT EprexDAT = new EprexDAT();
	private AranespDAT AranespDAT = new AranespDAT();
	
	public ranges ranges = new ranges();

	public String get_patient_name(){
		return patient_name;
	}
	
	public void set_patient_name(String name){
		this.patient_name = name;
	}
		
	public String get_nurse_name(){
		return nurse_name;
	}
	
	public void set_nurse_name(String name){
		this.nurse_name = name;
	}
	
	public int get_current_hgb() {
		return current_hgb;
	}
	
	public void set_current_hgb(int hgb) {
		this.current_hgb = hgb;
	}
	
	public int get_last_protocol_hgb() {
		return last_protocol_hgb;
	}
	
	public void set_last_protocol_hgb(int hgb) {
		this.last_protocol_hgb = hgb;
	}
	
	public int get_previous_tsat() {
		return previous_tsat;
	}
	
	public void set_previous_tsat(int tsat) {
		this.previous_tsat = tsat;
	}
	
	public int get_previous_ferritin() {
		return previous_ferritin;
	}
	
	public void set_previous_ferratin(int ferritin) {
		this.previous_ferritin = ferritin;
	}
	
	/*
	 * ON ESA? 
	 * 1 : yes, 2: no, 3: on hold, 4: discontinued */
	public void set_on_esa_med(int on_esa_med_num) {
		
		if (on_esa_med_num == 1) {
			this.on_esa_med = "Yes";
		} else if (on_esa_med_num == 2) {
			this.on_esa_med = "No";
		} else if (on_esa_med_num == 3) {
			this.on_esa_med = "It is currently on hold";
		} else if (on_esa_med_num == 4) {
			this.on_esa_med = "It has been discontinued";
		} else if (on_esa_med_num == 5) {
			this.on_esa_med = "It is currenltly on hold or has been discontinued";
		}
		
		this.on_esa_med_num = on_esa_med_num;
	}
	
	
	public String get_on_esa_med() {
		return on_esa_med;
	}
	
	public int get_on_esa_med_num() {
		return on_esa_med_num;
	}
	
	public void set_which_esa_med(int which_esa_med_num) {
		
		if (which_esa_med_num == 1) {	
			this.which_esa_med = "Aranesp";
		} else if (which_esa_med_num == 2) {
			this.which_esa_med = "Eprex";
		}
	}
	
	public String get_which_esa_med() {
		return which_esa_med;
	}
	
	public EprexDAT getEprexDAT() {
		return EprexDAT;
	}

	public AranespDAT getAranespDAT() {
		return AranespDAT;
	}

	public void set_on_iron_med(int on_iron_med_num) {
		
		if (on_iron_med_num == 1) {
			this.on_iron_med = "Yes";
		} else if (on_iron_med_num == 2) {
			this.on_iron_med = "No";
		} else if (on_iron_med_num == 3) {
			this.on_iron_med = "No, it is currently on hold.";
		}
		
		this.on_iron_med_num = on_iron_med_num;
		
	}
	
	public String get_on_iron_med() {
		return on_iron_med;
	}
	
	public int get_on_iron_med_num() {
		return on_iron_med_num;
	}
	
	public void set_which_iron_med(int which_iron_med_num) {
		
		if (which_iron_med_num == 1) {
			this.which_iron_med = "Venofer";
		} else if (which_iron_med_num == 2) {
			this.which_iron_med = "FerrIecit";
		}
		
		this.which_iron_med_num = which_iron_med_num;
		
	}
	
	public String get_which_iron_med() {
		return which_iron_med;
	}
	
	public int get_which_iron_med_num() {
		return which_iron_med_num;
	}

	public void set_venofer_dosage(int iron_med_dosage_num) {
		
		if (iron_med_dosage_num == 1) {
			this.iron_med_dosage = "100mg q 2 weeks";
		} else if (iron_med_dosage_num == 2) {
			this.iron_med_dosage = "100mg q 4 weeks";
		} else if (iron_med_dosage_num == 3) {
			this.iron_med_dosage = "100mg q 9 weeks";
		}
	}

	public void set_ferricit_dosage(int iron_med_dosage_num) {
		
		if (iron_med_dosage_num == 1) {
			this.iron_med_dosage = "125mg q 2 weeks";
		} else if (iron_med_dosage_num == 2) {
			this.iron_med_dosage = "125 mg q 4 weeks";
		} else if (iron_med_dosage_num == 3) {
			this.iron_med_dosage = "125 mg q tx for 9 sessions";
		}
	}
	
	public String days_later(DateTime dt, int days_later) {

		DateTime dt_days_later = new DateTime(dt.toDate());
		dt_days_later = dt.plusDays(days_later);
		
		DateTimeFormat format = null;
		
		return dt_days_later.toString(format.longDate());
		
	}
	
	public  String get_iron_med_dosage() {
		return iron_med_dosage;
	}
	
	public void set_last_3_hgbs_1 (int hgb) {
		this.last_3_hgbs_1 = hgb;
	}
	
	public int get_last_3_hgbs_1() {
		return last_3_hgbs_1;
	}
	
	public void set_last_3_hgbs_2 (int hgb) {
		this.last_3_hgbs_2 = hgb;
	}
	
	public int get_last_3_hgbs_2() {
		return last_3_hgbs_2;
	}
	
	public void set_last_3_hgbs_3 (int hgb) {
		this.last_3_hgbs_3 = hgb;
	}
	
	public int get_last_3_hgbs_3() {
		return last_3_hgbs_3;
	}
	
	public int get_last_2_tsats_1() {
		return last_2_tsats_1;
	}
	
	public void set_last_2_tsats_1(int last_2_tsats_1) {
		this.last_2_tsats_1 = last_2_tsats_1;
	}
	
	public int get_last_2_tsats_2() {
		return last_2_tsats_2;
	}
	
	public void set_last_2_tsats_2(int last_2_tsats_2) {
		this.last_2_tsats_2 = last_2_tsats_2;
	}

	public void set_date_ESA_on_hold(String date) {
		this.date_ESA_on_hold = date;
	}
	
	public String get_date_ESA_on_hold() {
		return date_ESA_on_hold;
	}
	
	public void set_date_previous_hgb(String date) {
		this.date_previous_hgb = date;
	}
	public String get_date_previous_hgb() {
		return date_previous_hgb;
	}
	
	public void set_date_previous_tsat_ferritin(String date) {
		this.date_previous_tsat_ferritin = date;
	}

	public String get_date_previous_tsat_ferritin() {
		return date_previous_tsat_ferritin;
	}

	public boolean hgb_decrease_greater_than_15() {
		if ((this.last_protocol_hgb - this.current_hgb) > 15) {
			return true;
		} else return false;
	}
	
	//QUESTION: Difference between or increase?
	public int difference_between() {
		return this.current_hgb - this.last_protocol_hgb;
	}
	
	public static boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x <= upper;
		}

	public String get_esa_med_dosage() {
		return esa_med_dosage;
	}
 
	public void set_esa_med_dosage(String esa_med_dosage) {
		this.esa_med_dosage = esa_med_dosage;
	}
	
	public String esa_DAT_inc() {

		if (get_which_esa_med().equals("Aranesp")) {	
			return AranespDAT.new_dose("inc", this.get_esa_med_dosage());
		} else {
			return EprexDAT.new_dose("inc", this.get_esa_med_dosage()); 
		}
	}	
	
	public String esa_DAT_dec() {

		if (get_which_esa_med().equals("Aranesp")) {	
			return AranespDAT.new_dose("dec", this.get_esa_med_dosage());
		} else {
			return EprexDAT.new_dose("dec", this.get_esa_med_dosage()); 
		}
	}
		
}
