
package edu.odu.cs.cs350;

import org.junit.Test;
import static org.junit.Assert.*;


public class TextTest {
    
    String fileName = Text.getFileName();
    String fileDateTime = fileName.replace("-summary.txt", "");
    System.out.println(fileName);
    assertNotNull("Text class should generate filename output", fileName);
}
