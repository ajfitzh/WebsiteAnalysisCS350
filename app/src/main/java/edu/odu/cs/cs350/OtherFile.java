package edu.odu.cs.cs350;

public class OtherFile {

	//unique integer ID
		int id;
		public enum fileType {ARCHIVE, VIDEO, AUDIO, UNCATEGORIZED};
		//string to hold name of the file
		String name;
		//integer to hold size of the file in kb
		long fileSize;
		//string to hold local path of this file
		String path;
		//temporary since idk how to do enum
		String typetest;
		
		OtherFile(String name, int id, String typetest, long fileSize, String path){
	        this.name = name;
			this.id =  id;
			this.typetest = typetest;
	        this.fileSize = fileSize;
	        this.path =  path;
	        System.out.println("-Other File created-");

	    }
}
