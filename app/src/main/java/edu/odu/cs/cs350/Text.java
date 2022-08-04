package edu.odu.cs.cs350;

import java.io.FileOutputStream;
import java.io.IOException;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

import org.apache.poi.hssf.usermodel.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.io.File;


/** This class is called by OutputPackager and retrieves info from Website, Pages, and others in order to output a .txt file
 * @author austi
 *
 */
public class Text {
	//
	// 
	
	//NEEDS: list of all local pages (printed one line per page, sorted lexicographically)
	//NEEDS: local path of page and file size of page
	//NEEDS or CREATES: total size of all pages added together
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx

	/** output function for .txt file
	 * @param website Website class to pass in analysis results to output functions 
	 * @return returns string fileName
	 */
	public static String output(Website website) {
		//string for filename, must have format YYYMMDD-hhmmss-summary.txt
		String fileName = getFileName();
		
		for (Page page: website.pages) {
            
		try {
		    // displaying data
		    BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName()));
				writer.write(page.name);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
		}

		
	}
		return fileName;

	}			

	/** retrieves file name according to current date and appends to .txt file
	 * @return returns filename string 
	 */
	public static String getFileName(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy-hhmmss");
		LocalDateTime now = LocalDateTime.now();
	    return dtf.format(now) + "-summary.txt";
	}
}


	