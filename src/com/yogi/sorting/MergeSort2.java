package com.yogi.sorting;

public class MergeSort2 {

	public static void main(String[] args) {
		MergeSort2 ms = new MergeSort2();
		ms.execute();
	} // end main()

	private void execute() {
		
		int mainArray[] = {-1 ,8, 23, 47, 81, 95, 7, 14, 39, 55, 62, 74,99};
		
		
		splitArray(mainArray);
	}

	private void splitArray(int[] mainArray) {
		int middle = mainArray.length/2;
		
		//int[] arrayA = { -1 ,8, 23, 47, 81, 95};
		int[] arrayA = new int[middle];
		for (int i = 0; i < middle; i++) {
			arrayA[i] = mainArray[i];
		}
		
		
		//int[] arrayB = { 7, 14, 39, 55, 62, 74 };
		int[] arrayB = new int[mainArray.length-middle];
		for (int i = 0; i < mainArray.length-middle; i++) {
			arrayB[i] = mainArray[middle+i];
		}
		
		startProcess(arrayA, arrayB);
	}

	private void startProcess(int[] arrayA, int[] arrayB) {
		int arrayC_len = arrayA.length + arrayB.length;
		int[] arrayC = new int[arrayC_len];
		merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
		display(arrayC);
	}

	// merge A and B into C
	public void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB,
			int[] arrayC) {

		int aDex = 0, bDex = 0, cDex = 0;
		while (aDex < sizeA && bDex < sizeB) {
			// neither array empty
			if (arrayA[aDex] < arrayB[bDex]) {
				arrayC[cDex++] = arrayA[aDex++];
			} else {
				arrayC[cDex++] = arrayB[bDex++];
			}
		}
		while (aDex < sizeA) {
			// arrayB is empty,
			arrayC[cDex++] = arrayA[aDex++]; // but arrayA isn’t
		}
		while (bDex < sizeB) {
			// arrayA is empty,
			arrayC[cDex++] = arrayB[bDex++]; // but arrayB isn’t
		}
	} // end merge()

	private void display(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}

}
