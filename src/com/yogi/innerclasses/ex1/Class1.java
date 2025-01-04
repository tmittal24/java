package com.yogi.innerclasses.ex1;

public class Class1 {

	// ////////////////////////////////////////////////////
	interface Inner {// top-level nested
		// interface
	}

	// ///////////////////////////////////////////////////////

	protected InnerClass1 ic;

	public Class1() {
		ic = new InnerClass1();
	}

	public void displayStrings() {
		System.out.println(ic.getString() + ".");
		System.out.println(ic.getAnotherString() + ".");
	}

	static public void main(String[] args) {
		Class1 c1 = new Class1();
		c1.displayStrings();
	}

	// ----------------------------------------------------------------
	protected class InnerClass1 {

		/***********************************************************************
		 * ERROR! The member interface InnerInterface can only be defined inside
		 * a top-level class or interface This will cause an error.
		 * 
		 * Becuase, you can not define a static modifier inside an inner class.
		 * InnerClass1 is an inner class and InnerInterface is implicitly static.
		 * Compiler will complain.
		 **********************************************************************/
		// interface InnerInterface {
		// }

		public String getString() {
			return "InnerClass1: getString invoked";
		}

		public String getAnotherString() {
			return "InnerClass1: getAnotherString invoked";
		}
	}
	// ----------------------------------------------------------------
}
