package edu.odu.cs.cs350;

import java.util.Collection;

public class Image {
	//unique integer ID
	int id;
	//Integer for internal (0) or external (1)
	int classification;
	//file size of the image in kb
	int fileSize;
	//URI locator
	String uri;
	//Array to hold unique ID of pages where this is referenced
	Collection<Page> references;
}
