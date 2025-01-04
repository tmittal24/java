package com.yogi.sorting;

public class SelectionSort {
	public static void main(String a[]) {
		SelectionSort sSort = new SelectionSort();
		sSort.execute();
	}

	/*
	 * Working of the selection sort :
		Say we have an array unsorted A[0],A[1],A[2]................ A[n-1] and A[n] as input. 
		Then the following steps are followed by selection sort algorithm to sort the values of an array . 
		(Say we have a key index_of_min that indicate the position of minimum value)
		1.Initaily varaible  index_of_min=0;
		2.Find the minimum value in the unsorted array.
		3.Assign the index of the minimum value into index_of_min variable.
		4.Swap minimum value to first position.
		5.Sort the remaining values of array (excluding the first value).
	 */
	public void execute() {
		int array[] = { 12, 9, 4, 99, 120, 1, 3, 10, 88, -1 };
		printArray(array);
		
		sort(array);
		
		printArray(array);
	}

	private void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int index_of_min = i;
			for (int j = i; j < array.length ; j++) {
				if (array[index_of_min] < array[j]) { // descending order
					index_of_min = j;
				}
			}
			swap(array, index_of_min, i);
		}
	}

	private void swap(int array[],int index_of_min, int i) {
		int temp = array[i];
		array[i] = array[index_of_min];
		array[index_of_min] = temp;
	}

	private void printArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
}