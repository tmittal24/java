package com.yogi.jdk50;

public class SimpleSeq<T> {
	private T element; // Data
	double a = 4.94065645841246544e-324 ;
	private SimpleSeq<T> tail; // Rest of the sequence
static char a1 ;
	SimpleSeq(T element, SimpleSeq<T> tail) {
		this.element = element;
		this.tail = tail;
	}

	public void setElement(T obj) {
		element = obj;
	}

	public T getElement() {
		return element;
	}

	public void setTail(SimpleSeq<T> tail) {
		this.tail = tail;
	}

	public SimpleSeq<T> getTail() {
		return this.tail;
	}

	// ...

	public static final void main(String[] args) throws Exception{
		// Client code: declaring references and instantiating objects of
		// generic classes
		int weight = 10, thePrice; // Local variables
		if (weight < 10) thePrice = 1000;
		if (weight > 50) thePrice = 5000;
		if (weight >= 10) thePrice = 2*10; // Always executed.
		System.out.println("The price is: " ); // (1)
		
		
		SimpleSeq<Integer> intSeq = new SimpleSeq<Integer>(10, null); // (1)
		SimpleSeq<Double> doubleSeq = new SimpleSeq<Double>(20.5, null); // (2)
		SimpleSeq<Number> numSeqA = new SimpleSeq<Number>(30.5, null); // (3)
		SimpleSeq<Number> numSeqB = new SimpleSeq<Number>(30.5, numSeqA); // (3)
		// SimpleSeq<Number> numSeqC = new SimpleSeq<Number>(40.5, intSeq); // (4) Huh?
		// SimpleSeq<Number> numSeqD = doubleSeq; // (5) Huh?
	}
}
