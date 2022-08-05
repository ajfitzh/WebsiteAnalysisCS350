
package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextTest {
     @Test public void TextOutputExist() {
    
    Text fileName = new Text();
    
    assertNotNull(fileName, "Text class should generate filename output");

    
}

@Test public void TextOutputStructure() {

    String fileName = null;
    Website website = new Website();
    Format f = new SimpleDateFormat("MMddyyyy-hhmmss");
    String date = f.format(new Date());
    fileName = date+"-summary.txt";
    assertEquals(fileName, Text.output(website));
}

}