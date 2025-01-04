package com.yogi.innerclasses.localinner;

import java.io.Serializable;
import java.util.Stack;

class Outer { // Top-level class

	private int cx = 0;

	private final int cx1 = 0;

	int cy = 0;

	// -------------------------------------------------------
	/**
	 * Local classes cannot be declared as static, but they can be defined in a
	 * static context (for example, in a static method).
	 * 
	 */
	static void method() { // Method declaration
		// OK!
		class Inner extends Stack implements Serializable{// Local class
		}
	}
	
//	class Outer { // Top-level class
//
//		   void method() { // Method declaration 
//		      //ERROR! Can not use static modifier
//		      static class Inner {// ERROR! 
//		      }
//		     }
//		}
//


	// -------------------------------------------------------
	void method(int arg, final int fv) {
		int x = 0;
		final int y = 0;

		class Inner {// Local class
			public void test() {
				// Error! Try to access
				// non-final methods of the class
				// System.out.println(arg);// Error! non final local variable
				// System.out.println(x);// Error! non final local variable

				// Ok!
				System.out.println(cx);// Ok! -- field from outer class this is
				// OK
				System.out.println(cy);// Ok! -- field from outer class this is
				// OK
				System.out.println(cx1);// Ok! -- field from outer class this is
				// OK

				System.out.println(fv);// Ok! final local variable
				System.out.println(y);// Ok! --- final local variable
			}
		}

	}
	// -------------------------------------------------------
}
