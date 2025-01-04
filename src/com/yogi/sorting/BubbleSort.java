package com.yogi.sorting;

public class BubbleSort {
	public static void main(String a[]) {
		
		System.out.println("Values Before the sort:");
		
		BubbleSort sort = new BubbleSort();
		sort.execute();
	
		System.out.println("END");
	}

	/**
	 * Working of bubble sort algorithm:

		Say we have an array unsorted  A[0],A[1],A[2]................ A[n-1] and A[n] as input. 
		Then the following steps are followed by bubble sort algorithm to sort the values of an array.
		 1.Compare A[0] and A[1] . 
		 2.If A[0]>A[1] then Swap A[0] and A[1].
		 3.Take next A[1] and A[2].
		 4.Comapre these values.
		 5.If A[1]>A[2]  then swap A[1] and A[2]
		 ...............................................................
		................................................................
		at last compare A[n-1] and A[n]. If A[n-1]>A[n] then swap A[n-1] and A[n]. 
		As we see the highest value is reached at nth position. At next iteration leave nth value. 
		Then apply the same steps repeatedly on A[0],A[1],A[2]................ A[n-1] elements repeatedly until the values of array is sorted.
	 */
	public void execute() {
		int array[] = { 12, 9, 4, 99, 120, 1, 3, 10, 88, -1 };
		printArray(array);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				// if (array[j] > array[j+1]) {//ascending order
				if (array[j] > array[j + 1]) { // descending order
					swap(array, j);
				}
			}

		}
		System.out.println("\nValues After the sort:");
		printArray(array);
	}

	private void swap(int array[], int i) {
		int temp = array[i];
		array[i] = array[i + 1];
		array[i + 1] = temp;
	}
	
	private void printArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
}
