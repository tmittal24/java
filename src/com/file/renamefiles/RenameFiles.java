package com.file.renamefiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class RenameFiles {
	public static void main(String[] argv) {

		// TODO - remove hard coding
		if (argv.length != 3) {
			System.err.println("usage: No Input specified, reading file.properties");
			argv = new String[3];
			readPropertiesFile(argv);
		}

		process(argv);

	}

	private static void readPropertiesFile(String[] argv) {
		try {
			// InputStream is =
			// RenameFiles.class.getClassLoader().getResourceAsStream("file.properties");
			Properties props = new Properties();
			props.load(new FileInputStream(new File("file.properties")));

			String prop1 = props.getProperty("dirpath");
			System.out.println("Root Dir = " + prop1);

			String prop2 = props.getProperty("oldFileExtension");
			System.out.println("Old File extension = " + prop2);

			String prop3 = props.getProperty("newFileExtension");
			System.out.println("New File extension = " + prop3);

			argv[0] = prop1;
			argv[1] = prop2;
			argv[2] = prop3;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void process(String[] argv) {
		File dir = new File(argv[0]);
		if (!dir.exists()) {
			System.out.println(argv[0] + " does not exist");
			return;
		} else {
			String patt = argv[1];

			String[] info = dir.list();

			for (int i = 0; i < info.length; i++) {
				File file = new File(argv[0] + dir.separator + info[i]);
				if (file.isDirectory()) {
					String[] arg = new String[] { file.getPath(), patt, argv[2] };
					System.out.println("Start Executing renmae in sub dir : " + arg[0]);

					// make a recursive call to rename subfolders.
					process(arg);
				} else if (file.isFile()) { // skip ., .., other directories, //
											// etc.
					String fileExtension = info[i].substring(info[i].length() - patt.length(), info[i].length());
					if (!fileExtension.equalsIgnoreCase(patt)) {
						continue;
					} else {
						renameFiles(argv, patt, file);
					}
				}
			}
		}

		return;
	}

	private static void renameFiles(String[] argv, String patt, File file) {

		String oldFilePath = file.getPath();
		String newFileName = file.getName();
		String newFileExtension = argv[2];
		newFileName = newFileName.substring(0, newFileName.length() - patt.length());
		File newFile = new File(argv[0] + "\\" + newFileName + newFileExtension);
		// System.out.println(newFileName);

		boolean Rename = file.renameTo(newFile);
		if (!Rename) {
			System.err.println(oldFilePath + ",... does not rename successfully.");
		} else {
			System.out.println("Renaming the file " + oldFilePath + " ---> " + newFile);
		}
	}
}
