package edu.odu.cs.cs350;

//Importing required classes
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.apache.poi.hssf.usermodel.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Excel {
	//This class is called by OutputPackager and retrieves info from Website, Pages, and others
	// in order to output a .xlsx file
	//NEEDS: # of images/CSS style references, JS scripts, intra-page/external/internal links
	//string for filename, must have format YYYMMDD-hhmmss-summary.xlsx
	String filename;
	//output function for .xlsx file
	public static String output(Website website) {
	    String fileName = getFileName();
		try(HSSFWorkbook workbook = new HSSFWorkbook()) {
			HSSFSheet firstSheet = workbook.createSheet("summary");
			HSSFRow row;
			Map<String, Object[]> webSiteData = new TreeMap<String, Object[]>();
			
			// first generic row of summary spreadsheet
			webSiteData.put("1", 
				new Object[] {"Page", "# Images", "# CSS", "Scripts", "# Links (Intra-Page)", "# Links (Internal)", "# Links (External)"});

			int pageNumber = 1;
			
			for(Page page : website.pages){
				String key = Integer.toString(pageNumber + 1);
				webSiteData.put(key, 
					new Object[] {
						page.name,
						(!(page.images == null || page.images.isEmpty()) ? Integer.toString(page.images.size()) : "0"),
						(!(page.css == null || page.css.isEmpty()) ? Integer.toString(page.css.size()) : "0"),
						(!(page.javascript == null || page.javascript.isEmpty()) ? Integer.toString(page.javascript.size()) : "0"),
						Integer.toString(page.intraLinks),
						Integer.toString(page.intersiteLinks), 
						Integer.toString(page.externalLinks)
					});
				pageNumber++;
			}

			try(FileOutputStream fos = new FileOutputStream(getFileName())) {

			HSSFRow rowA = firstSheet.createRow(0);
			HSSFCell cellA = rowA.createCell(0);
			cellA.setCellValue(new HSSFRichTextString("Website Analysis"));

			Set<String> keyid = webSiteData.keySet();
			int rowid = 0;
	
			for (String key : keyid) {
	
				row = firstSheet.createRow(rowid++);
				Object[] objectArr = webSiteData.get(key);
				int cellid = 0;
	
				for (Object obj : objectArr) {
					HSSFCell cell = row.createCell(cellid++);
					cell.setCellValue((String)obj);
				}
			}
			workbook.write(fos);
			workbook.close();
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy-hhmmss");
   		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now) + "-summary.xls";
	}
}
