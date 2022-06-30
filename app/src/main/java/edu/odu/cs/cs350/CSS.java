package edu.odu.cs.cs350;

import java.util.Collection;

public class CSS {
	//unique ID for Stylesheet
	int id;
	//Integer for internal (0) or external (1) styling
	int classification;
	//string to hold the URI
	String uri;
	//array to hold the local pages each script is utilized on
	Collection<Page> references;
}
