package edu.odu.cs.cs350;

/**
 * @author austi
 *
 */
public class OutputPackager {
	//The purpose of OutputPackager is to call the
	//JSON, Text, Excel, and CLI output functions
	//and output .JAR file with completed code and 2 executables (Windows and Linux/OSX)
	//Also possibly outputs errors to CLI if not caused by user (if caused by user, that output is handled by Website class
	
	/**
	 * @param website
	 */
	public static void callOutput(Website website) {
		//Run JSON, Text, and Excel output. Their return values are their file names,
		// so pass these into CLI output to output it to the scren.
		CLI.output(
			JSON.output(),
			Text.output(website),
			Excel.output(website)
		);

	}
}
