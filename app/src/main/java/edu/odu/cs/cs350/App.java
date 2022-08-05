/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;



/**App is the main class that gets everything done- reads the arguments, creates a website class, calls the analysis function, then calls the output function.
 * @author austi
 * 
 * 
 */

public class App {
/** main is the function that takes in the argument and calls the important analyze, output functions
 * @author austi
 * 
 * @param dirName storing the name of the directory from args[0]
 * 
 */
	public static void main(String[] args) {
    	int check = 0;
    	do {
    		
    		String dirName = args[0];
    		//Check if Argument is provided
    		if(isArgumentProvided(args)==0) {
    			System.exit(0);
    		};
    		
    		//Check for errors in input name
    		checkIfDirectoryEmptyOrInvalid(dirName);

    		check=1;
    	} while(check==0);
    	
    	System.out.println(new App().getGreeting());
    //Test creation of Website Class
        Website website = new Website();
     //Take in Argument Directory
        website.prepareDirectory(args);
       
        
        website.listAllNodes();
        //Test call of Output Packager triggering all output functions
        OutputPackager.callOutput(website);
    }

    
    /** Checks to see if argument is provided
     * @param args The arguments being passed into app, we are expecting only one string that directs us to a non-empty directory
     * @author austi
     * 
     * @return
     */
    static int isArgumentProvided(String[] args) {
    	if(args.length == 0) {
			System.out.println("No Argument Provided- Please provide a valid directory!");
			return 0;
		}
		return 1;
		
	}

 
	/** checks if the directory is empty or an invalid file path
	 * @param dirName the title of the directory being passed into the app
	 * @author austi
	 * 
	 * @return boolean, 0 if invalid file path, 1 if good file path
	 */
	static int checkIfDirectoryEmptyOrInvalid(String dirName) {
    	File file = new File(dirName);
    	Path path = Paths.get(dirName);
    	
		//Check if it is a valid path to a file or directory0
		if(!isValidPath(dirName)) {
		System.out.println("Not a valid path. Please try again with a valid filepath. (Remember to remove the backslash at the end of the directory!)");
		return 0;
		}
		//Check if directory is empty or just a file
		try {
			if (Files.isDirectory(path)) {
		        if (!Files.list(path).findAny().isPresent()) {
		            System.out.println("Directory is empty! Please submit a valid directory file.");
		            return 0;
		        }
		    } else {
		        System.out.println("Not a directory! Please submit a valid directory file.");
		        return 0;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		
	}


	/** checks if it is a valid file path
	 * @param path
	 * @author austi
	 * Direct path to directory in string form
	 * @return 0 if invalid, 1 if valid
	 */
	public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }
        return true;
    }
    
    /** Generates awesome greeting to user
     * @author austi
     * 
     * @return greeting string
     */
    public String getGreeting() {
    	String greeting = "        ________     ________\n"
    			+ "  . - ~|        |-^-|        |~ - .\n"
    			+ "{      |  CS350 |   | Group5 |      }\n"
    			+ "        `.____.'     `.____.' \n"
    			+ "--------------------------------------\n"
    			+ "WEBSITE ANALYZER v1.0";
        return greeting;
    }
    

    }