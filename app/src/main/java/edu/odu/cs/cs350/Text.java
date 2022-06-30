package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .txt file
	
	//NEEDS: list of all local pages (printed one line per page, sorted lexicographically)
	//NEEDS: local path of page and file size of page
	//NEEDS or CREATES: total size of all pages added together
	
	//string for filename, must have format YYYMMDD-hhmmss-summary.txt
	String filename;
	//output function for .txt file
	public static void Output() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("YYYMMDD-hhmmss-summary.txt"));
			writer.write("Writing text to my file");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Outputting .txt file!");
	}
}
