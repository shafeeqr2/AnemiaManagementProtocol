package application;

public class ranges {
	
	private static int min_hgb = 60;
	private static int max_hgb = 140;

	private static int min_tsat = 0;
	private static int max_tsat = 100;
	
	private static int min_ferritin = 100;
	private static int max_ferritin = 1000;
	
	
	public static int getMin_hgb() {
		return min_hgb;
	}
	public static void setMin_hgb(int min_hgb) {
		ranges.min_hgb = min_hgb;
	}
	public static int getMax_hgb() {
		return max_hgb;
	}
	public static void setMax_hgb(int max_hgb) {
		ranges.max_hgb = max_hgb;
	}
	public static int getMin_tsat() {
		return min_tsat;
	}
	public static void setMin_tsat(int min_tsat) {
		ranges.min_tsat = min_tsat;
	}
	public static int getMax_tsat() {
		return max_tsat;
	}
	public static void setMax_tsat(int max_tsat) {
		ranges.max_tsat = max_tsat;
	}
	public static int getMin_ferritin() {
		return min_ferritin;
	}
	public static void setMin_ferritin(int min_ferritin) {
		ranges.min_ferritin = min_ferritin;
	}
	public static int getMax_ferritin() {
		return max_ferritin;
	}
	public static void setMax_ferritin(int max_ferritin) {
		ranges.max_ferritin = max_ferritin;
	}
	

	
}
