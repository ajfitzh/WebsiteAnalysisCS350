package edu.odu.cs.cs350;

import java.util.Collection;

public class Link {
    //string name
	String name;
	//unique integer ID
	String id;
	// Link type: intra, internal or external
	String classification;
	//filesize
	long fileSize;
	//URI locator
	String uri;
	//Array to hold unique ID of pages where this is referenced
	Collection<Page> references;
	Link(String name, String id, String uri, String classification){
        this.name = name;
		this.id =  id;
		this.classification = classification;
        // this.fileSize = fileSize;
        this.uri =  uri;
        System.out.println("-Link Created-");
    }
}
