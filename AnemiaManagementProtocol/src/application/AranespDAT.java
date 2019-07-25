package application;

public class AranespDAT {
	
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
	 	   case "10 mcg every 2 weeks": new_dose = new_dose(change, "10 mcg every 1 week", "D/C, check Hgb in 2 weeks");
		            break;
	 	   case "10 mcg every 1 week": new_dose = new_dose(change, "20 mcg every 1 week", "10 mcg every 1 week");
	 	  			break;
	 	   case "20 mcg every 1 week": new_dose = new_dose(change, "30 mcg every 1 week", "10 mcg every 1 week");
		            break;
	 	   case "30 mcg every 1 week": new_dose = new_dose(change, "40 mcg every 1 week", "20 mcg every 1 week");
		            break;
	 	   case "40 mcg every 1 week": new_dose = new_dose(change, "50 mcg every 1 week", "30 mcg every 1 week");
		            break;
	 	   case "50 mcg every 1 week": new_dose = new_dose(change, "60 mcg every 1 week", "40 mcg every 1 week");
		            break;
	 	   case "60 mcg every 1 week": new_dose = new_dose(change, "80 mcg every 1 week", "50 mcg every 1 week");
		            break;
	 	   case "80 mcg every 1 week": new_dose = new_dose(change, "100 mcg every 1 week", "60 mcg every 1 week");
		            break;
	 	   case "100 mcg every 1 week": new_dose = new_dose(change, "130 mcg every 1 week", "80 mcg every 1 week");
	 	   			break;
	 	   case "130 mcg every 1 week": new_dose = new_dose(change, "150 mcg every 1 week", "100 mcg every 1 week");
	 	   			break;
	 	   case "150 mcg every 1 week": new_dose = new_dose(change, "Check with nephrologist", "130 mcg every 1 week");
	 	   			break;
		   default: new_dose = "Dosage value not specified";
		       break;	
    	}

    	return new_dose;
    }
    
}
