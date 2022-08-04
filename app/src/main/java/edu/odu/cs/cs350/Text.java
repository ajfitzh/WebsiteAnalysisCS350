package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.Time;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * @author austi
 *
 */
public class Text {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .txt file
	
	//NEEDS: list of all local pages (printed one line per page, sorted lexicographically)
	//NEEDS: local path of page and file size of page
	//NEEDS or CREATES: total size of all pages added together
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx
		/**
		 * 
		 */
		String filename;

	//output function for .txt file
	/**
	 * @param website
	 * @return
	 */
	public static String output(Website website) {
		//string for filename, must have format YYYMMDD-hhmmss-summary.txt
		String fileName = null;
		System.out.println("------------------------------------------------------- in Text.output() .... for each Page in website.Pages");
		for (Page page: website.pages) {
            
        
		System.out.println("---------------------------------------------------------------This page has this name: " + page.name);
		}
		try {
		    // displaying date
		    Format f = new SimpleDateFormat("MMddyyyy-hhmmss");
		    String date = f.format(new Date());
		    fileName = date+"-summary.txt";
		    BufferedWriter writer = new BufferedWriter(new FileWriter(date + "-summary.txt"));
				writer.write("Writing text to my file");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
		}

		return fileName;
	}
}
