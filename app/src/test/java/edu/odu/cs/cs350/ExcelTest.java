package edu.odu.cs.cs350;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class ExcelTest {
    @Test public void excelFileNameOutput() {
        
        String fileName = Excel.getFileName();
        String fileDateTime = fileName.replace("-summary.xlsx", "");
        System.out.println(fileName);
        assertNotNull("Excel class should generate filename output", fileName);

        // check date time format matches requirement
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyymmdd-hhmmss", Locale.US)
            .withResolverStyle(ResolverStyle.STRICT);
        assertNotNull(dateFormatter.parse(fileDateTime));
        
        // verify file format
        String fileFormat = fileName.substring(fileName.indexOf('.') + 1);
        System.out.println(fileFormat);
        assertEquals(fileFormat, "xlsx");
    }
}
