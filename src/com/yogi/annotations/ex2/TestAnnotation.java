package com.yogi.annotations.ex2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {
	public static void main(String args[]) throws SecurityException, ClassNotFoundException {
		for (Method method : Class.forName("com.test2.BuildHouse").getMethods()) {
			// checks if there is annotation present of the given type Developer
			if (method.isAnnotationPresent(com.yogi.annotations.ex2.Developer.class)) {
				try {
					// iterates all the annotations available in the method
					for (Annotation anno : method.getDeclaredAnnotations()) {
						System.out.println("Annotation in Method '" + method + "' : " + anno);
						Developer a = method.getAnnotation(Developer.class);
						if ("Popeye".equals(a.value())) {
							System.out.println("Popeye the sailor man! " + method);
						}
					}
				} catch (Throwable ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
