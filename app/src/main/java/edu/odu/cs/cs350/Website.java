package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




/** Website class to perform analysis of entire directory and store information in separate collections
 * @author austi
 *
 */
public class Website {
	/** placeholder html int to temporarily count files
	 * 
	 */
	int htmlCounter = 1;
	/** placeholder css int to temporarily count files
	 * 
	 */
	int cssCounter = 1;
	/** placeholder js int to temporarily count files
	 * 
	 */
	int jsCounter = 1;
	/** placeholder image int to temporarily count files
	 * 
	 */
	int imageryCounter = 1;
	/** placeholder archive int to temporarily count files
	 * 
	 */
	int archivesCounter = 1;
	/** placeholder audio int to temporarily count files
	 * 
	 */
	int audioCounter = 1;
	/** placeholder video int to temporarily count files
	 * 
	 */
	int videosCounter = 1;
	/** placeholder uncategorized int to temporarily count files
	 * 
	 */
	int uncategorizedCounter = 1;
	
	
	/** ArrayList for storing items (Pages and other items) created by HTMLExtractor/Translator
	 * 
	 */
	Collection<Page> pages = new ArrayList<Page>();
	/** collection of images
	 * 
	 */
	Collection<Image> images = new ArrayList<Image>();
	/** collection of CSS sheets
	 * 
	 */
	Collection<CSS> csssheets = new ArrayList<CSS>();
	/** collection of otherFiles
	 * 
	 */
	Collection<OtherFile> otherFiles = new ArrayList<OtherFile>();
	/** collection of javascript
	 * 
	 */
	Collection<JavaScript> javascripts = new ArrayList<JavaScript>();

	/** totalSize might store size in MB, might take this out
	 * 
	 */
	int totalSize;
	
	/** name of the website
	 * 
	 */
	String name;
	
	/**  collection of pathnames called "BaseURLs"
	 * 
	 */
	Collection<String> baseURLs;

	/** The "starter" function that reads the user argument, input, and reports user errors and requests new entry
	 * @param args
	 */
	public void prepareDirectory(String[] args) {
		
		//System.out.println("Preparing Directory:"+args[0]);
		
		new Website().listFolder(new File(args[0]), pages, images, csssheets, otherFiles);
	}
	
/**
 * @param dir
 * @param pages
 * @param images
 * @param csssheets
 * @param otherFiles
 */
private void listFile(File dir, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles) {
	File[] files = dir.listFiles();
	if(files != null) {
	for (File file: files) {
		System.out.println(file.getName());
    	try {
			System.out.println("File Type:" + Files.probeContentType(file.toPath()));
			if(Files.probeContentType(file.toPath()) != null) {
				//find size of file
				long tempFileSize = Files.size(file.toPath());
				//Main sorting function for files
				sort(Files.probeContentType(file.toPath()), file, pages, images, csssheets, otherFiles, tempFileSize);
				System.out.println("Size " + tempFileSize + " bytes");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
	//Sorting function for analyzed files
	/**
	 * @param file
	 * @param fileobject
	 * @param pages
	 * @param images
	 * @param csssheets
	 * @param otherFiles
	 * @param tempFileSize
	 */
	public void sort(String file, File fileobject, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles, long tempFileSize) {
		String name = fileobject.getName();
		switch(file) {
		case "text/html":
				System.out.println("HTML file found and added");
				
				System.out.println(name);
				
				pages.add(new Page(name, htmlCounter,tempFileSize,fileobject.getPath()));
				htmlCounter++;
				break;
		case "text/css":
				System.out.println("CSS file found and added");				
				System.out.println(name);
				csssheets.add(new CSS(name, cssCounter,1, tempFileSize,"testURI"));
				cssCounter++;
				break;
		case "image/png":
				System.out.println("Image(PNG) file found and added");
				images.add(new Image(name, imageryCounter, 1, tempFileSize, "testURI"));
				imageryCounter++;
				break;
		case "image/jpeg":
				System.out.println("Image(JPG) file found and added");
				images.add(new Image(name, imageryCounter, 1, tempFileSize, "testURI"));
				imageryCounter++;
				break;
		case "text/plain":
				System.out.println("Text/Plain read as JS file found and added");
				javascripts.add(new JavaScript(name, jsCounter,1, tempFileSize,"testURI"));
				jsCounter++;
				break;
		case "application/x-zip-compressed":
				System.out.println("Zip(Archive) file file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "Zip", tempFileSize, fileobject.getPath()));
				archivesCounter++;
				break;
		case "video/quicktime":
		case "video/mp4":
				System.out.println("Video(.mov/.mp4) file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "mov", tempFileSize, fileobject.getPath()));
				videosCounter++;
				break;
		case "application/pdf":
				System.out.println("PDF file set as Uncategorized file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "PDF", tempFileSize, fileobject.getPath()));
				uncategorizedCounter++;
				break;
		case "audio/mpeg":
				System.out.println("Audio file found and added");
				System.out.println("file path: " + fileobject.getPath());
				otherFiles.add(new OtherFile(name, archivesCounter, "Audio", tempFileSize, fileobject.getPath()));
				audioCounter++;
				break;
	}
	
	}
	//Translator Strips URLS, examines duplicates, stops at website boundaries
	// Examines HTML, discards default pages like Error 404
	/**
	 * 
	 */
	public void Translator() {}
	
	
	
	//listFolder function
	/**
	 * @param dir
	 * @param pages
	 * @param images
	 * @param csssheets
	 * @param otherFiles
	 */
	void listFolder(File dir, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles) {
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
			});
			
			System.out.println("\nDirectory of " + dir.getAbsolutePath());
			listFile(dir, pages, images, csssheets, otherFiles);
			if(subDirs != null) {
			for(File folder: subDirs) {
				listFolder(folder, pages, images, csssheets, otherFiles);
			}
			System.out.println("HTML: " + htmlCounter + " CSS:" + cssCounter + " JS:" + jsCounter + " Images:" + imageryCounter +
					" Archives:" + archivesCounter + " Audio:" + audioCounter
					+ " Videos: " + videosCounter + " Uncategorized:" + uncategorizedCounter);
			}
	}
	
	
	//Create output packager to allow Website to call the Output function
	/**
	 * 
	 */
	OutputPackager Output = new OutputPackager();

	/**
	 * 
	 */
	public void listAllNodes() {

		System.out.println("---------Pages in Site");
		for (Page page: pages) {
            System.out.println(page.id + ". " + page.name + " | size: " + page.fileSize);
        }
		System.out.println("---------Images in Site");
		for (Image image: images) {
            System.out.println(image.id + ". " + image.name + " | size: " + image.fileSize);
        }
		System.out.println("---------CSS Sheets in Site");
		for (CSS sheet: csssheets) {
            System.out.println(sheet.id + ". " + sheet.name + " | size: " + sheet.fileSize);
        }
		System.out.println("---------JavaScript Files in Site");
		for (JavaScript script: javascripts) {
            System.out.println(script.id + ".  Name: " + script.name + " | size: " + script.fileSize);
        }
		System.out.println("---------Other Files in Site");
		for (OtherFile otherFile: otherFiles) {
            System.out.println(otherFile.id + ". " + otherFile.typetest + " Name: " + otherFile.name + " | size: " + otherFile.fileSize);
        }

//		Collection<Image> images;
//		Collection<CSS> csssheets;
//		Collection<OtherFile> otherFiles;
		
	}
	
	
}
