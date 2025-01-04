package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class TestSingletonLazy {
	 public static void main(String[] args){
		    try {
				System.out.println("Inside main(): Getting the singleton instance using getInstance()...");
				SingletonLazy s = SingletonLazy.getInstance();

				System.out.println("Inside main(): Trying to use reflection to get another instance...");
				Class<SingletonLazy> clazz = SingletonLazy.class;
				Constructor<SingletonLazy> cons = clazz.getDeclaredConstructor();
				cons.setAccessible(true);
				SingletonLazy s2 = cons.newInstance();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		  }
}
