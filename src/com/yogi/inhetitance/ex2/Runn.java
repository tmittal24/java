package com.yogi.inhetitance.ex2;

public class Runn {

	class SuperBase{} 
	class Base extends SuperBase{} 
	class Derived extends Base{} 

	class CovariantTest1 { 
	Base getIt(){return new Base();} 

	} 

	class SubCovariantTest extends CovariantTest1 { 
		public Base getIt() {return new Derived();} 
		//public SuperBase getIt() {return new Base();} 

	} 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
