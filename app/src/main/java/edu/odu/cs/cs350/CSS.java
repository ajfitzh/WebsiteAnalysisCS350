package edu.odu.cs.cs350;

import java.util.Collection;

public class CSS {
	//String name
	String name;
	//unique ID for Stylesheet
	int id;
	//File size
	long fileSize;
	//Integer for internal (0) or external (1) styling
	int classification;
	//string to hold the URI
	String uri;
	//array to hold the local pages each script is utilized on
	Collection<Page> references;
	
	CSS(String name, int id, int classification, long fileSize, String uri){
        this.name = name;
		this.id =  id;
        this.classification = classification;
        this.fileSize = fileSize;
        this.uri =  uri;
        System.out.println("-CSS Reference created-");

    }
}
