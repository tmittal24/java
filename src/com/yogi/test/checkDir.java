package com.yogi.test;

import java.io.File;

public class checkDir {
	public static void main(String[] args) {
		process("D:\\Shammi_Repository\\Multimedia\\My_Songs\\Hindi cassets");
	}
	
	
	private static void process(String arg) {
		
		File dir = new File(arg);

		String[] children = dir.list();
		if (children == null) {
		    // Either dir does not exist or is not a directory
		} else {
		    for (int i=0; i<children.length; i++) {
		        // Get filename of file or directory
		        String filename1 = children[i];
		        
		        File child1 = new File (arg + "\\" + filename1);
		        String[] children2 = child1.list();
		        for (int j=0; j<children2.length; j++) {
			        // Get filename of file or directory
			        String child2 = children2[j];
			        File child_2 = new File (arg + "\\" + filename1 + "\\"  + child2);
			        if (child_2.isDirectory()){
			        System.out.println(child_2);
			        }
		        }
		        
		       
		    }
		}


	}
}
