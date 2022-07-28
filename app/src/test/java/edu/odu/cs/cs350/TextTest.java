
package edu.odu.cs.cs350;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextTest {
     @Test public void TextOutputExist() {
    
    Text fileName = new Text();
    
    assertNotNull("Text class should generate filename output", fileName);

    
}

@Test public void TextOutputStructure() {

    String fileName = null;
    Format f = new SimpleDateFormat("MMddyyyy-hhmmss");
    String date = f.format(new Date());
    fileName = date+"-summary.txt";
    assertEquals(fileName, Text.output());
}

}