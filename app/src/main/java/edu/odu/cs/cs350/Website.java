package edu.odu.cs.cs350;

import java.util.Collection;
import java.util.LinkedList;

import java.io.File;
import java.io.FileFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class Website {
	//placeholders to temporarily count files
	int html = 0;
	int css = 0;
	int js = 0;
	int images = 0;
	int archives = 0;
	int audio = 0;
	int videos = 0;
	int uncategorized = 0;
	
	//LinkedList (or array?) for storing web Pages created by HTMLExtractor/Translator
	Collection<Page> pages;
	
	// totalSize might store size in MB, might take this out
	int totalSize;
	
	//name of the website
	String name;
	
	//collection of pathnames called "BaseURLs"
	Collection<String> baseURLs;
	//listFolder function
	void listFolder(File dir) {
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
			});
			
			System.out.println("\nDirectory of " + dir.getAbsolutePath());
			listFile(dir);
			
			for(File folder: subDirs) {
				listFolder(folder);
			}
			System.out.println("HTML: " + html + " CSS:" + css + " JS:" + js + " Images:" + images + " Archives:" + archives + " Audio:" + audio
					+ " Videos: " + videos + " Uncategorized:" + uncategorized);
			}
	
	//The "starter" function that reads the user argument, input, and reports user errors and requests new entry
	public void prepareDirectory(String[] args) {
		System.out.println("Preparing Directory...");
		System.out.println("Name of argument passed in:"+args[0]);

		
	new Website().listFolder(new File(args[0]));


	
}
private void listFile(File dir) {
	File[] files = dir.listFiles();
	for (File file: files) {
		System.out.println(file.getName());
    	try {
			System.out.println("File Type:" + Files.probeContentType(file.toPath()));
			if(Files.probeContentType(file.toPath()) != null) {
				sort(Files.probeContentType(file.toPath()));
				//find size of file
				long length = Files.size(file.toPath());
				System.out.println("Size " + length + " bytes");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	//Sorting function for analyzed files
	public void sort(String file) {
		switch(file) {
		case "text/html":
				System.out.println("HTML file found and added");
				html++;
				break;
		case "text/css":
				System.out.println("CSS file found and added");
				css++;
				break;
		case "image/png":
				System.out.println("Image(PNG) file found and added");
				images++;
				break;
		case "image/jpeg":
				System.out.println("Image(JPG) file found and added");
				images++;
		case "text/plain":
				System.out.println("Text/Plain read as JS file found and added");
				js++;
		case "application/x-zip-compressed":
				System.out.println("Zip(Archive) file file found and added");
				archives++;
				break;
		case "video/quicktime":
		case "video/mp4":
				System.out.println("Video(.mov/.mp4) file found and added");
				videos++;
				break;
		case "application/pdf":
				System.out.println("PDF file set as Uncategorized file found and added");
				uncategorized++;
				break;
		case "audio/mpeg":
				System.out.println("Audio file found and added");
				audio++;
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
	
	//Create output packager to allow Website to call the Output function
	OutputPackager Output = new OutputPackager();
	
	
}
