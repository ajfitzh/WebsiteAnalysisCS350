package edu.odu.cs.cs350;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class JavaScriptTest{
    @Test public void JavaScriptNameTest() {
		String path = "src/test/resources/BasicSite/Other";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		
		App classUnderTest = new App();
        Website website = new Website();
        String[] args = new String[1];
        args[0] = absolutePath;
        website.prepareDirectory(args);

        //checks other file for HelloWorld
        for (JavaScript javascript: website.javascripts) {
        	if(javascript.id == 5)
        	{
                String testName = javascript.name;
        		assertEquals("HelloWorld",testName);
        	}
        }
     
    }
}