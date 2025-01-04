package com.yogi.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
	private static final String FILENAME = "c:\\temp\\custom-fields.txt";

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				boolean flag = sCurrentLine.contains("primary.clientId");
				if (flag) {
					patternMatcher(sCurrentLine);
					// System.out.println(sCurrentLine);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void patternMatcher(String line) {
		// Pattern p1 = Pattern.compile("=[a-z]\\d{4}");
		// Pattern p1 = Pattern.compile("=[a-z][a-z][a-z][a-z][a-z]");
		Pattern p1 = Pattern.compile("=[a-z]");
		Matcher m = p1.matcher(line);
		while (m.find()) {
			// System.out.println(m.group(0));
			int s1 = m.start(0);
			int e1 = m.end(0);
			System.out.println(line.substring(s1, e1));
		}
	}
}
