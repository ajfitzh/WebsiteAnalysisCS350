package edu.odu.cs.cs350;

//Importing required classes
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.apache.poi.hssf.usermodel.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Excel {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .xlsx file
	//NEEDS: # of images/CSS style references, JS scripts, intra-page/external/internal links
	
	 
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx
	String filename;
	//output function for .xlsx file
	public static String output() {
	    Format f = new SimpleDateFormat("MMddyyyy-hhmmss");
	    String date = f.format(new Date());
	    String fileName = date + "-summary.xls";
//		XSSFWorkbook workbook = new XSSFWorkbook();
		try(HSSFWorkbook workbook = new HSSFWorkbook()) {
			HSSFSheet firstSheet = workbook.createSheet("summary");

			
			//HSSFRow rowA = firstSheet.createRow(0);
			//HSSFCell cellA = rowA.createCell(0);
			//cellA.setCellValue(new HSSFRichTextString("Website Analysis"));
			
			HSSFRow row;

			Map<String, Object[]> webSiteData = new TreeMap<String, Object[]>();
			
			// first generic row of summary spreadsheet
			webSiteData.put("1", 
				new Object[] {"Page", "#Images", "#CSS", "Scripts", "#Links (Intra-Page)", "#Links (Internal)", "#Links (External)"});

			try(FileOutputStream fos = new FileOutputStream(getFileName())) {

			HSSFRow rowA = firstSheet.createRow(0);
			HSSFCell cellA = rowA.createCell(0);
			cellA.setCellValue(new HSSFRichTextString("Website Analysis"));
			try(FileOutputStream fos1 = new FileOutputStream(fileName)) {

				workbook.write(fos1);
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return fileName;
	}

	// Generate filename for .xlsx file
	public static String getFileName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyymmdd-hhmmss");
   		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now) + "-summary.xlsx";
	}
}
