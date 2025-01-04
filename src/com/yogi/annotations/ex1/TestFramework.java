package com.yogi.annotations.ex1;

import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class TestFramework {
	static void executeTests(String className) {
		try {
			Object obj = Class.forName(className).newInstance();
			TestParameters tp = obj.getClass().getAnnotation(TestParameters.class);
			if (tp != null) {
				String methodList = tp.testMethods();
				StringTokenizer st = new StringTokenizer(methodList, ",");
				while (st.hasMoreTokens()) {
					String methodName = st.nextToken().trim();
					Method m = obj.getClass().getDeclaredMethod(methodName);
					System.out.println("");
					System.out.println(methodName);
					System.out.println("----------------");
					String result = invoke(m, obj);
					System.out.println("Result: " + result);
				}
			} else {
				System.out.println("No annotation found for " + obj.getClass());
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}

	static String invoke(Method m, Object o) {
		String result = "PASSED";
		try {
			m.invoke(o);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex + "\n" + ex.getCause());
			result = "FAILED";
		}
		return (result);
	}

	public static void main(String[] args) {
		String[] args1 = {"com.test.StringUtility"};
		args = args1;
		if (args.length == 0) {
			System.out.println("Must specify class name (without an extension)");
		} else {
			executeTests(args[0]);
		}
	}
}
