package application;

public class EprexDAT {
	
    String change;
    String current_dose;
    String new_dose;
        
    private String new_dose(String change, String inc_dose, String dec_dose) {
    	if (change == "inc") {
    		return inc_dose;
    	} else {
    		return dec_dose;
    	}
    }
    
    public String new_dose(String change, String current_dose) {
    	this.change = change;
    	this.current_dose = current_dose;
    	switch (current_dose) {
	 	   case "1000 units every 1 week": new_dose = new_dose(change, "10 mcg every 1 week", "D/C, check Hgb in 2 weeks");
		            break;
	 	   case "2000 units every 1 week": new_dose = new_dose(change, "20 mcg every 1 week", "1000 units every 1 week");
	 	  			break;
	 	   case "3000 units every 1 week": new_dose = new_dose(change, "30 mcg every 1 week", "2000 units every 1 week");
		            break;
	 	   case "2000 units 2 times per week": new_dose = new_dose(change, "40 mcg every 1 week", "3000 units every 1 week");
		            break;
	 	   case "3000 units 2 times per week": new_dose = new_dose(change, "50 mcg every 1 week", "2000 units 2 times per week");
		            break;
	 	   case "4000 units 2 times per week": new_dose = new_dose(change, "60 mcg every 1 week", "3000 units 2 times per week");
		            break;
	 	   case "5000 units 2 times per week": new_dose = new_dose(change, "80 mcg every 1 week", "4000 units 2 times per week");
		            break;
	 	   case "6000 units 2 times per week": new_dose = new_dose(change, "100 mcg every 1 week", "5000 units 2 times per week");
		            break;
	 	   case "8000 units 2 times per week": new_dose = new_dose(change, "130 mcg every 1 week", "6000 units 2 times per week");
	 	   			break;
	 	   case "10,000 units 2 times per week": new_dose = new_dose(change, "150 mcg every 1 week", "8000 units 2 times per week");
	 	   			break;
	 	   case "8000 units 3 times per week": new_dose = new_dose(change, "Check with nephrologist", "10,000 units 2 times per week");
	 	   			break;
	 	   case "10,000 units 3 times per week": new_dose = new_dose(change, "Check with nephrologist", "8000 units 3 times per week");
	 	   			break;
		   default: new_dose = "Dosage value not specified test";
		       break;	
    	}
    	return new_dose;
    }
    
}
