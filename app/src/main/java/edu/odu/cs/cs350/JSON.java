package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {
	//This JSON is called by OutputPackager, it should call for the information it needs from Website/Pages/Other and
	//NEEDS: For page entry, # of local images, external images, JS scripts, CSS stylesheets, intra-page, intra-site,and external links
	//NEEDS: For image entry, # of pages the image was displayed on, and listing of pages the images was displayed on
	//NEEDS: For archive/video/audio/uncat entries, need file size and local path to resource
	
	//string for filename, must have the format YYYMMDD-hhmmss-summary.json
	String filename;
	
	public static void output() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("YYYMMDD-hhmmss-summary.json"));
			writer.write("Writing text to my json");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Outputting .json file!");
	}
}
