package edu.odu.cs.cs350;

import java.io.File;

public class CLI {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output to the CLI
	//NEEDS: filenames of excel, text, and json files
	
	/*public static void output(String json, String text, String excel) {
		System.out.println("---------Files Output:");
		System.out.println(json);
		System.out.println(text);
		System.out.println(excel);
		*/
	
	

	
		public static void main(String[] argv) {
			
			if (argv.length < 1 ) {
				System.err.println("Argument not found. Please try again");
				System.exit(1);
				
			}
			
			else 
			{
				File dirPath = new File(argv[0]);
				Website website = new Website(dirPath);
			}
		}
	
		public static void output() {
			Excel excel = new Excel();
			String excelName  = excel.getFileName();
			
		
		/*	JSON json = new JSON();
			String jsonName = json.getFileName();
			
			Text text = new Text();
			String textName = text.getFileName();
			
			String.out.println(textName);
			System.out.println(jsonName);
			
		*/
			System.out.println(excelName);
			
		
			
		}
		
}




