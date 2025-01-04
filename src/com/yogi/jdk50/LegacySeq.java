package com.yogi.jdk50;

public class LegacySeq {
	private Object element; // Data

	private LegacySeq tail; // Rest of the sequence

	LegacySeq(Object element, LegacySeq tail) {
		this.element = element;
		this.tail = tail;
	}

	public void setElement(Object obj) {
		element = obj;
	}

	public Object getElement() {
		return element;
	}

	public void setTail(LegacySeq tail) {
		this.tail = tail;
	}

	public LegacySeq getTail() {
		return this.tail;
	}

	// ...

	public static void main(String[] args) {
		LegacySeq intSeq = new LegacySeq(32, new LegacySeq(16, null));
		intSeq.setElement(8.5); // Any object can be added.
		Integer iRef = (Integer) intSeq.getElement(); // ClassCastException at
														// runtime.
	}
}