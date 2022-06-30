package edu.odu.cs.cs350;

import java.io.FileOutputStream;

//Importing required classes
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;


public class Excel {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .xlsx file
	//NEEDS: # of images/CSS style references, JS scripts, intra-page/external/internal links
	
	 
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx
	String filename;
	//output function for .xlsx file
	public static void output() {
//		XSSFWorkbook workbook = new XSSFWorkbook();
		try(HSSFWorkbook workbook = new HSSFWorkbook()) {
			HSSFSheet firstSheet = workbook.createSheet("summary");
			HSSFRow rowA = firstSheet.createRow(0);
			HSSFCell cellA = rowA.createCell(0);
			cellA.setCellValue(new HSSFRichTextString("Website Analysis"));
			try(FileOutputStream fos = new FileOutputStream("YYYMMDD-hhmmss-summary.xls")) {
				workbook.write(fos);
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Outputting .xlsx file!");
	}
}
