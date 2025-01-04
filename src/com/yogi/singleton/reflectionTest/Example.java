package com.yogi.singleton.reflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.yogi.singleton.Singleton_Eager;

class Foo<T> {
	private T arg;

	private Foo(T t) {
		// private!
		this.arg = t;
	}

	@Override
	public String toString() {
		return "My argument is: " + arg;
	}
}

public class Example {
	public static void main(final String[] args) throws Exception {
		Constructor<Foo> constructor=null;
		//constructor = Foo.class.getDeclaredConstructor(Object.class);
		testFoo();
		testSingleton_Eager();
		testRuntime();
	}

	private static void testRuntime() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<Runtime> runtime = (Class<Runtime>) Class.forName("java.lang.Runtime");
		Constructor constructor2 = runtime.getDeclaredConstructor();
		constructor2.setAccessible(true);
		Runtime obj2 = (Runtime) constructor2.newInstance();
		System.out.println(obj2);
	}

	private static void testFoo() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<Foo> constructor;
		Class foooo= Class.forName("reflectionTest.Foo");
		constructor = foooo.getDeclaredConstructor(Object.class);
		constructor.setAccessible(true);
		Foo<String> foo = constructor.newInstance("arg1");
		System.out.println(foo);
	}
	
	private static void testSingleton_Eager(){
		try {
			Class<Singleton_Eager> singletonClass = (Class<Singleton_Eager>) Class.forName("singleton.Singleton_Eager");
			Constructor constructor1 = singletonClass.getDeclaredConstructor();
			constructor1.setAccessible(true);
			Singleton_Eager obj = (Singleton_Eager) constructor1.newInstance();
			System.out.println(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
