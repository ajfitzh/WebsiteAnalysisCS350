package edu.odu.cs.cs350;

public class OutputPackager {
	//The purpose of OutputPackager is to call the
	//JSON, Text, Excel, and CLI output functions
	//and output .JAR file with completed code and 2 executables (Windows and Linux/OSX)
	//Also possibly outputs errors to CLI if not caused by user (if caused by user, that output is handled by Website class
	
	public static void CallOutput() {
		JSON.Output();
		Text.Output();
		Excel.Output();
		CLI.Output();
	}
}
