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




public class Website {
	//placeholders to temporarily count files
	int htmlCounter = 1;
	int cssCounter = 1;
	int jsCounter = 1;
	int imageryCounter = 1;
	int archivesCounter = 1;
	int audioCounter = 1;
	int videosCounter = 1;
	int uncategorizedCounter = 1;
	
	//ArrayList for storing items (Pages and other items) created by HTMLExtractor/Translator
	Collection<Page> pages = new ArrayList<Page>();
	Collection<Image> images = new ArrayList<Image>();
	Collection<CSS> csssheets = new ArrayList<CSS>();
	Collection<OtherFile> otherFiles = new ArrayList<OtherFile>();
	Collection<JavaScript> javascripts = new ArrayList<JavaScript>();
	
	// totalSize might store size in MB, might take this out
	int totalSize;
	
	//name of the website
	String name;
	
	//collection of pathnames called "BaseURLs"
	Collection<String> baseURLs;

	//The "starter" function that reads the user argument, input, and reports user errors and requests new entry
	public void prepareDirectory(String[] args) {
		
		System.out.println("Preparing Directory:"+args[0]);
		
		new Website().listFolder(new File(args[0]), pages, images, csssheets, otherFiles);
	}
	
private void listFile(File dir, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles) {
	File[] files = dir.listFiles();
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
	//Sorting function for analyzed files
	public void sort(String file, File fileobject, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles, long tempFileSize) {
		String name = fileobject.getName();
		switch(file) {
		case "text/html":
				System.out.println("HTML file found and added");
				
				System.out.println(name);
				pages.add(new Page(name, htmlCounter,tempFileSize,"hi"));
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
				otherFiles.add(new OtherFile(name, archivesCounter, "Zip", tempFileSize, "testPath"));
				archivesCounter++;
				break;
		case "video/quicktime":
		case "video/mp4":
				System.out.println("Video(.mov/.mp4) file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "mov", tempFileSize, "testPath"));
				videosCounter++;
				break;
		case "application/pdf":
				System.out.println("PDF file set as Uncategorized file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "PDF", tempFileSize, "testPath"));
				uncategorizedCounter++;
				break;
		case "audio/mpeg":
				System.out.println("Audio file found and added");
				otherFiles.add(new OtherFile(name, archivesCounter, "Audio", tempFileSize, "testPath"));
				audioCounter++;
				break;
	}
	
	}
	//Translator Strips URLS, examines duplicates, stops at website boundaries
	// Examines HTML, discards default pages like Error 404
	public void Translator() {}
	
	//HTML Extractor extracts anchor tags/links and classifies links as intra-page, intra-site, or external
	//Extracts Image tags and classifies as internal/external images
	//Extracts file size for each image, the URI for each image, and local pages on which it is referenced
	public void htmlExtractor(String htmlfile) {
		int intrapageLinks = 0;
		int intersiteLinks = 0;
		int externalLinks = 0;
		System.out.println("----Start JSoup Analysis---");
		//IF it's an HTML file, use JSoup to decipher HTML objects in it
		File input = new File(htmlfile);
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "");
			
			System.out.println("--Links--");
			Elements links = doc.select("a[href]");
			for(Element link : links) {
				System.out.println(link.attr("href"));
				if(link.attr("href").contains("#")) { intrapageLinks++; }
				else if(link.attr("href").contains("http")) { externalLinks++; }
				else { intersiteLinks++; }
			}
			
			System.out.println("--Image References--");
			Elements imagereferences = doc.select("img[src~=(?i)\\.(svg|png|jpe?g|gif)]");
			for(Element image : imagereferences) {
				System.out.println(image.attr("src"));
			}
			
			System.out.println("--CSS/JS External References--");
			Elements cssreferences = doc.select("link");
			for(Element cssreference : cssreferences) {
				System.out.println(cssreference.attr("href"));
				System.out.println(cssreference.attr("src"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Intra-page Links: " + intrapageLinks );
		System.out.println("Inter-site Links: " + intersiteLinks );
		System.out.println("External Links  : " + externalLinks );
			System.out.println("--End of JSoup Analysis--");
	}
	
	//listFolder function
	void listFolder(File dir, Collection<Page> pages, Collection<Image> images, Collection<CSS> csssheets, Collection<OtherFile> otherFiles) {
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
			});
			
			System.out.println("\nDirectory of " + dir.getAbsolutePath());
			listFile(dir, pages, images, csssheets, otherFiles);
			
			for(File folder: subDirs) {
				listFolder(folder, pages, images, csssheets, otherFiles);
			}
			System.out.println("HTML: " + htmlCounter + " CSS:" + cssCounter + " JS:" + jsCounter + " Images:" + imageryCounter +
					" Archives:" + archivesCounter + " Audio:" + audioCounter
					+ " Videos: " + videosCounter + " Uncategorized:" + uncategorizedCounter);
			}
	
	
	//Create output packager to allow Website to call the Output function
	OutputPackager Output = new OutputPackager();

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
