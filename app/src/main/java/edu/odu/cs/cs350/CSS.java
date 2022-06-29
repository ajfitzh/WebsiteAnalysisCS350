package edu.odu.cs.cs350;

public class CSS {
	//unique ID for Stylesheet
	int id;
	//Integer for internal (0) or external (1) styling
	int classification;
	//string to hold the URI
	String URI;
	//array to hold the local pages each script is utilized on
	int[] references;
}
