package edu.odu.cs.cs350;

/** For Command Line Interface Output, currently only used to output json, text, and excel file names
 * @author austi
 *
 */
public class CLI {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output to the CLI
	//NEEDS: filenames of excel, text, and json files
	
	/**
	 * @param json filename for output file
	 * @param text filename for output file
	 * @param excel filename for output file
	 */
	public static void output(String json, String text, String excel) {
		System.out.println("---------Files Output:");
		System.out.println(json);
		System.out.println(text);
		System.out.println(excel);
	}
}



