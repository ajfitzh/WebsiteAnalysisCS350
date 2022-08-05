package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.io.File;

public class ArchiveFileSizeTest {
	@Test public void AudioFileSizeExists() {
		String path = "src/test/resources/BasicSite/";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		
		App classUnderTest = new App();
        Website website = new Website();
        String[] args = new String[1];
        args[0] = absolutePath;
        website.prepareDirectory(args);
        
        long audioSize = 0;
        long movieSize = 0;
            
        for (OtherFile otherFile: website.otherFiles) {
        	//System.out.println("OTHER FILES-----");
        	//System.out.println(otherFile.id + ". " + otherFile.typetest + " Name: " + otherFile.name + " | size: " + otherFile.fileSize);
        	
        	if(otherFile.typetest == "Audio")
        	{
        		//System.out.println("Gregorian found- does it include the correct fileSize?");
        		//System.out.println("size: " + image.fileSize);
        		audioSize = otherFile.fileSize;
        		assertEquals(6309639, audioSize, "audio file gregorian.mp3 should equal 6309639 kb");
        	}
        }
	}
        	@Test public void MovieFileSizeExists() {
        		String path = "src/test/resources/BasicSite/";

        		File file = new File(path);
        		String absolutePath = file.getAbsolutePath();
        		
        		App classUnderTest = new App();
                Website website = new Website();
                String[] args = new String[1];
                args[0] = absolutePath;
                website.prepareDirectory(args);
                
                
                long movieSize = 0;
                    
                for (OtherFile otherFile: website.otherFiles) {
                	//System.out.println("OTHER FILES-----");
                	//System.out.println(otherFile.id + ". " + otherFile.typetest + " Name: " + otherFile.name + " | size: " + otherFile.fileSize);
                	
                	if(otherFile.typetest == "mov")
                	{
                		String moviename;
                		moviename = otherFile.name;
                		if(moviename.contains("baby.mov")) {
                			System.out.println("baby movie found! It's path is:" + otherFile.path);
                			movieSize = otherFile.fileSize;
                			assertEquals(4151160, movieSize, "movie baby movie should equal 4151160 kb");
                		}                		        		
                	}	
        }
     
    }
}
