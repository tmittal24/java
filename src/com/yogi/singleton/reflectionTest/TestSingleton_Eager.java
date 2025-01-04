package com.yogi.singleton.reflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.Runtime;

import com.yogi.singleton.Singleton_Eager;
class TestSingleton_Eager {
	public static void main(String[] args) {
		try {

			Class<Singleton_Eager> singletonClass = (Class<Singleton_Eager>) Class.forName("singleton.Singleton_Eager");
			//Class<Singleton_Eager> singletonClass = (Class<Singleton_Eager>) Class.forName("java.lang.Runtime");

			 reflectionUsingNew(singletonClass);

			// singletonClass
			Constructor<?>[] cons = singletonClass.getConstructors();
			if (cons.length > 0) {
				for (int i = 0; i < cons.length; i++) {

				}
			} else {
				System.out.println("No Public constructor for Singleton class");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void reflectionUsingNew(Class<Singleton_Eager> singletonClass) {

		try {
			try {
				Class<Singleton_Eager> singletonClass1 = (Class<Singleton_Eager>) Class.forName("singleton.Singleton_Eager");
				Constructor constructor1 = singletonClass1.getDeclaredConstructor();
				constructor1.setAccessible(true);
				Singleton_Eager obj = (Singleton_Eager) constructor1.newInstance();
				System.out.println(obj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}