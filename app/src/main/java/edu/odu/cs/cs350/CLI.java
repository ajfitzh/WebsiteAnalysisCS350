package edu.odu.cs.cs350;

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




