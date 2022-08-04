package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author austi
 *
 */
public class JSON {
	//This JSON is called by OutputPackager, it should call for the information it needs from Website/Pages/Other and
	//NEEDS: For page entry, # of local images, external images, JS scripts, CSS stylesheets, intra-page, intra-site,and external links
	//NEEDS: For image entry, # of pages the image was displayed on, and listing of pages the images was displayed on
	//NEEDS: For archive/video/audio/uncat entries, need file size and local path to resource
	
	//string for filename, must have the format YYYMMDD-hhmmss-summary.json

	
	/**
	 * @return
	 */
	public static String output() {
			//Find date
		//*******************************************CAPITAL M is MONTH, lowercase m is minute! Doublecheck ...
		    Format f = new SimpleDateFormat("MMddyyyy-hhmmss");
		    String date = f.format(new Date());
		    String fileName = date+"-summary.json";
		    //Write JSON file
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(fileName));
				writer.write("Writing text to my json");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return fileName;
		}
}
