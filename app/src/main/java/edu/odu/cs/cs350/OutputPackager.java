package edu.odu.cs.cs350;

/** The purpose of OutputPackager is to call the JSON, Text, Excel, and CLI output functions and output .JAR file with completed code and 2 executables (Windows and Linux/OSX) Also possibly outputs errors to CLI if not caused by user (if caused by user, that output is handled by Website class
 * @author austi
 *
 */
public class OutputPackager {
	//
	
	/** callOutput calls the output process on JSON, Text, and Excel functions
	 *  * @param website website class that passes in current data of analysis just run
	 */
	public static void callOutput(Website website) {
		CLI.output(
			JSON.output(),
			Text.output(website),
			Excel.output(website)
		);

	}
}
