package edu.odu.cs.cs350;


import org.junit.Test;
import static org.junit.Assert.*;

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
        	System.out.println("OTHER FILES-----");
        	System.out.println(otherFile.id + ". " + otherFile.typetest + " Name: " + otherFile.name + " | size: " + otherFile.fileSize);
        	
        	if(otherFile.typetest == "Audio")
        	{
        		System.out.println("Gregorian found- does it include the correct fileSize?");
        		//System.out.println("size: " + image.fileSize);
        		audioSize = otherFile.fileSize;
        		assertEquals("audio file gregorian.mp3 should equal 6309639 kb", 6309639, audioSize);
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
                	System.out.println("OTHER FILES-----");
                	System.out.println(otherFile.id + ". " + otherFile.typetest + " Name: " + otherFile.name + " | size: " + otherFile.fileSize);
                	
                	if(otherFile.typetest == "mov")
                	{
                		String moviename;
                		moviename = otherFile.name;
                		if(moviename.contains("baby.mov")) {
                			System.out.println("baby movie found!");
                			movieSize = otherFile.fileSize;
                			assertEquals("movie baby movie should equal 4151160 kb", 4151160, movieSize);
                		}                		        		
                	}	
        	//if(otherFile.name == "IMG-1395.MOV")
        	//{
        	//	System.out.println("Movie IMG-1395 found- does it include the correct fileSize?");
        	//	assertEquals("Movie IMG-1395.MOV should equal 20034826 kb", 20034826, movieSize);
        	//}
        }
     
    }
}
