package edu.odu.cs.cs350;

/** Class to hold relevant characteristics of each individual "Other" file, either Archive, Video, Audio, or Uncategorized files 
 * 
 *
 */
public class OtherFile {

	
		/** unique integer ID
		 * 
		 */
		int id;
		/** enumeration type for ARCHIVE, VIDEO, AUDIO, or UNCATEGORIZED files
		 * @author austi
		 *
		 */
		public enum fileType {ARCHIVE, VIDEO, AUDIO, UNCATEGORIZED};
		
		/** string to hold name of the file
		 * 
		 */
		String name;
		
		/** integer to hold size of the file in kb
		 * 
		 */
		long fileSize;
		
		/** string to hold local path of this file
		 * 
		 */
		String path;
		
		/** alternate storage method for type as ENUM buggy (08/04/2022)
		 * 
		 */
		String typetest;
		
		/** constructor for OtherFile from analysis
		 * @param name string name of file passed by analysis
		 * @param id id # generated by analysis
		 * @param typetest string type of file passed by analysis
		 * @param fileSize size of file in kb passed by analysis
		 * @param path path of file passed by analysis 
		 */
		OtherFile(String name, int id, String typetest, long fileSize, String path){
	        this.name = name;
			this.id =  id;
			this.typetest = typetest;
	        this.fileSize = fileSize;
	        this.path =  path;
	        System.out.println("-Other File created-");

	    }
}
