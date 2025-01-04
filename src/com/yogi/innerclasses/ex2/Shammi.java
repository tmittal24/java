package com.yogi.innerclasses.ex2;

//First code snippet with a static member.
class Outer1 { // Top-level class

	class Inner1 {
		
		// without static modifier
		// Member or Non-static inner
		// class
		// --- static int x; // ERROR!
	}
}

// Second code snippet without a static member.
class Outer2 { // Top-level class

	class Inner2 {// without static modifier
		// Member or Non-static inner
		// class
		int x; // OK!
	}
}

// Third code snippet with a compile-time
// constant
class Outer3 { // Top-level class

	class Inner3 {// without static modifier
		// Member or Non-static inner class.
		// compile-time constant
		static final int x = 0; // OK!
	}
}
