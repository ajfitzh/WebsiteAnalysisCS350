package edu.odu.cs.cs350;

import java.util.Collection;

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
        System.out.println("-Page created-");

    }
	//array holding unique ID's of all CSS scripts referenced by this page
	Collection<CSS> css;
	//array holding unique ID's of all Javascript scripts referenced by this page
	Collection<JavaScript> javascript;
	//Array holding unique ID's of all Images referenced by this page
	Collection<Image> images;
	//Array holding unique ID's of all Links referenced by this page
	Collection<Page> links;
}
