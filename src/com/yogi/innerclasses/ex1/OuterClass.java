/**
 * 
 */
package com.yogi.innerclasses.ex1;

/**
 * @author Administrator
 * 
 */
public class OuterClass {

	private static String a1 = "A1";

	private String a2 = "A2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(a1);

		// A)
		/***********************************************************************
		 * Static Nested class can be instantiated without the need to create
		 * any outer class object.
		 **********************************************************************/
		OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

		// B)
		/** ERROR!! - Following code is not possible* */
		// OuterClass.InnerClass innerObject1 = new OuterClass.InnerClass();
		/***********************************************************************
		 * To instantiate an inner class, you must first instantiate the outer
		 * class. Then, create the inner object within the outer object with
		 * this syntax:
		 **********************************************************************/
		OuterClass outerObject = new OuterClass();
		OuterClass.InnerClass innerObject = outerObject.new InnerClass();
		
		//OR
		
		OuterClass.InnerClass theInner = new OuterClass().new InnerClass();

	}

	// ----------------------------------------------------------------------------------------------------
	/**
	 * A static nested class interacts with the instance members of its outer
	 * class (and other classes) just like any other top-level class. In effect,
	 * a static nested class is behaviorally a top-level class that has been
	 * nested in another top-level class for packaging convenience
	 */
	public static class StaticNestedClass {
		/***********************************************************************
		 * VALID! The member interface InnerInterface can only be defined inside
		 * a top-level class or interface
		 **********************************************************************/
		interface InnerInterface {
		}

		public void testMethods() {
			String a1 = OuterClass.a1;

			// a static nested class cannot refer directly to instance variables
			// or methods defined in its enclosing class — it can use them only
			// through an object reference
			/*******************************************************************
			 * String a3 = a2; a2 = "";
			 ******************************************************************/
		}

		/**
		 * A static nested class interacts with the instance members of its
		 * outer class (and other classes) just like any other top-level class.
		 * In effect, a static nested class is behaviorally a top-level class
		 * that has been nested in another top-level class for packaging
		 * convenience. Therefore it can declare main method also.
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
			OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
		}
	}

	// ----------------------------------------------------------------------------------------------------

	/**
	 * Objects that are instances of an inner class exist within an instance of
	 * the outer class.
	 */
	public class InnerClass {
		
		static final int xs = 3;		// ok - compile-time constant
		//static int y = 4; 		// compile-time error, an inner class


		/***********************************************************************
		 * ERROR! The member interface InnerInterface can only be defined inside
		 * a top-level class or interface This will cause an error.
		 * 
		 * Becuase, you can not define a static modifier inside an inner class.
		 * InnerClass is an inner class and InnerInterface is implicitly static.
		 * Compiler will complain.
		 **********************************************************************/
		// interface InnerInterface {
		// }

		// The field xx1 cannot be declared static; static fields can only be
		// declared in static or top level types
		//static int xx1 = 0;

		public void testMethods() {
			String a1 = OuterClass.a1;

			// an inner class is associated with an instance of its enclosing
			// class and has direct access to that object's methods and fields.
			// Also, because an inner class is associated with an instance, it
			// cannot define any static members itself.
			String a3 = a2;
			a2 = "";
		}

		/**
		 * Can't declare main method in the Inner class
		 * 
		 * @param args
		 */
		// public static void main(String[] args) {
		// OuterClass.StaticNestedClass nestedObject = new
		// OuterClass.StaticNestedClass();
		// }
	}
	// ----------------------------------------------------------------------------------------------------
}
