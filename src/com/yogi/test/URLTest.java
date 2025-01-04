package com.yogi.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class URLTest {
public static void main(String[] args) {
	
	URLTest obj = new URLTest();
	
	try {
		URL fileUrl = 	new URL("file:C:/Code_Repo/Git/advocacy/advocacy_app/advocacy_app/apps-config/Benefits/Portal/config/dozer/settings.xml") ;
		URLClassLoader plainLoader = new URLClassLoader( new URL[] {fileUrl },      obj.getClass().getClassLoader());
		System.out.println(plainLoader);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}
}
