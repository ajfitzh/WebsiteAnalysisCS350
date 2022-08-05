package edu.odu.cs.cs350;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.io.File;

public class ImageFileSizeTest {
	@Test public void imageFileSizeExists() {
		String path = "src/test/resources/BasicSite/";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		
		App classUnderTest = new App();
        Website website = new Website();
        String[] args = new String[1];
        args[0] = absolutePath;
        website.prepareDirectory(args);
        
        long imageSize = 0;
        for (Image image: website.images) {
        	if(image.id == 3)
        	{
        		//System.out.println("Grump found- does it include the correct fileSize?");
        		//System.out.println("size: " + image.fileSize);
        		imageSize = image.fileSize;
        		assertEquals(1410647, imageSize, "image grump.jpg should equal 141067 kb");
        	}
        }
     
    }
}
