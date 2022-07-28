package edu.odu.cs.cs350;

import java.util.Collection;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Page {

	//name of the webpage- maybe the header?
	String name;
	//unique ID number
	int id;
	//file size in KB
	long fileSize;
	//local pathname within website
	String path;
    Page(String name, int id, long fileSize, String path){
        this.name =  name;
        this.id = id;
        this.fileSize = fileSize;
        this.path =  path;
        System.out.println("-Page " + name + " " + id + "path: " + path + " created-");
        htmlExtractor(path);

    }
	//array holding unique ID's of all CSS scripts referenced by this page
	Collection<CSS> css;
	//array holding unique ID's of all Javascript scripts referenced by this page
	Collection<JavaScript> javascript;
	//Array holding unique ID's of all Images referenced by this page
	Collection<Image> images;
	//Array holding unique ID's of all Links referenced by this page
	Collection<Page> links;
	

		

	
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
	}
		
	
	


		


