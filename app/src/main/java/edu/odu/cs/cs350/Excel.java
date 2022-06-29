package edu.odu.cs.cs350;

public class Excel {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .xlsx file
	//NEEDS: # of images/CSS style references, JS scripts, intra-page/external/internal links
	
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx
	String filename;
	//output function for .xlsx file
	public static void Output() {
		System.out.println("Outputting .xlsx file!");
	}
}
