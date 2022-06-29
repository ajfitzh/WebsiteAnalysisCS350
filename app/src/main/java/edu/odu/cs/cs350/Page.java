package edu.odu.cs.cs350;

public class Page {

	//name of the webpage- maybe the header?
	String name;
	//unique ID number
	int id;
	//file size in KB
	int fileSize;
	//local pathname within website
	String path;
	//array holding unique ID's of all CSS scripts referenced by this page
	int[] CSS;
	//array holding unique ID's of all Javascript scripts referenced by this page
	int[] JS;
	//Array holding unique ID's of all Images referenced by this page
	int[] Images;
	//Array holding unique ID's of all Links referenced by this page
	int[] Links;
}
