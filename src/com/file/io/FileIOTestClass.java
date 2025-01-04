package com.file.io;

import java.io.File;
import java.io.FilenameFilter;

public class FileIOTestClass {
    
    FileIOTestClass() {		
    }

	private void deleteAllFiles() {
		try {
		    System.out.println("Inside the constructor");
		
		    File[] list = new File("c:/tcf/cache").listFiles();
		    System.out.println("No of files in the directory : " + list.length);
		
		    for (int i = 0; i < list.length; i++) {
		    	//log the file name to be deleted
		    	System.out.println(" File Name : " + list[i].getName());
		        list[i].delete();
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
 
	/**
	  * Delete files and folders present in a given folder path
	  * @param file File Object representing cache path
	  */	
	 public void deleteFilesInDirectory(File file) {

		 //if given path is not a directory, return
		 if ( ! file.isDirectory()) {
			 return;
		 }
       
		 try {
			 FilenameFilter ff = null;
			 
			 File[] files = file.listFiles(ff);
			 System.out.println("No of files in the directory : " + files.length);
			 for (int i=0; i<files.length; i++) {
				 File fileFolder = files[i];
				 System.out.println("File Name: " + files[i].getName());
				 //if we encounter a directory, we delete all
				 //files within the same and then delete the directory
				 if ( fileFolder.isDirectory()) {
					 deleteFilesInDirectory(fileFolder);
				 }
				 fileFolder.delete();
			 }
		 } catch (Exception ignore) {
           
		 }
	 }   
 	
    public static void main(String[] args) {
        System.out.println("Hello World!");

        FileIOTestClass obj = new FileIOTestClass();
        //obj.deleteAllFiles();
        obj.deleteFilesInDirectory(new File("c:/tcf/cache"));
    }
}
