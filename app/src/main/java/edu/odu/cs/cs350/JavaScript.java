package edu.odu.cs.cs350;

import java.util.Collection;

public class JavaScript {
	//string name
	String name;
	//unique integer ID
	int id;
	//Integer for internal (0) or external (1)
	int classification;
	//filesize
	long fileSize;
	//URI locator
	String uri;
	//Array to hold unique ID of pages where this is referenced
	Collection<Page> references;
	JavaScript(String name, int id, int classification, long fileSize, String uri){
        this.name = name;
		this.id =  id;
		this.classification = classification;
        this.fileSize = fileSize;
        this.uri =  uri;
        System.out.println("-JavaScript File created-");

    }
}
