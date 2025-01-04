package com.file.io;

import java.io.File;

public class FileIO1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("C:/work");
		String list[] = file.list();
		
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

	}

}
