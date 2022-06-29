package edu.odu.cs.cs350;

import java.util.LinkedList;

public class Website {

	//LinkedList (or array?) for storing web Pages created by HTMLExtractor/Translator
	LinkedList<Page> pages = new LinkedList<Page>();
	// totalSize might store size in MB, might take this out
	int totalSize;
	//name of the website
	String name;
	//The "starter" function that reads the user argument, input, and reports user erros and requests new entry
	public void PrepareDirectory() {}
	//Translator Strips URLS, examines duplicates, stops at website boundaries
	// Examines HTML, discards default pages like Error 404
	public void Translator() {}
	//HTML Extractor extracts anchor tags/links and classifies links as intra-page, intra-site, or external
	//Extracts Image tags and classifies as internal/external images
	//Extracts file size for each image, the URI for each image, and local pages on which it is referenced
	public void HTMLExtractor() {}
	
	//Create output packager to allow Website to call the Output function
	OutputPackager Output = new OutputPackager();
	
}
