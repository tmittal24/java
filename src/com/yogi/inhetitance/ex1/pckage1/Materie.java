package com.yogi.inhetitance.ex1.pckage1;

public class Materie {
	int zahl;

	public Materie(int zahl) {
		this.zahl = zahl;
	}

	protected void finalize() throws Throwable {
		System.out.println("In the finalize, " + zahl + "st Object");
		super.finalize();
	}

	public void existenzBenachrichtigung() {
		System.out.println("in the  " + zahl + ", object !");
	}

	public static void main(String[] args) throws Error {
		Materie materie = null;
		materie = new Materie(1);
		materie = new Materie(2);
		System.gc();
		materie.existenzBenachrichtigung();
	}
}