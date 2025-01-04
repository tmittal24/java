package com.yogi.sorting;

/**
 * 
 * @author ymittal2
 *
 */
public class MergeSort1 {
	public static void main(String[] args) {
		MergeSort1 mSort = new MergeSort1();
		mSort.execute();
	}

	public void execute() {
		int array[] = { 12, 9, 4, 99, 120, 1, 3, 10};
		printArray(array);
		merge_sort_algo(array, 0, array.length-1);
		printArray(array);
	}

	public void merge_sort_algo_yogi(int array[], int startIndex, int lastIndex) {
		if (startIndex >= lastIndex) {
			return;
		}

		int arrayMiddle = (startIndex + lastIndex) / 2;
		
		merge_sort_algo(array, startIndex, arrayMiddle);
		merge_sort_algo(array, arrayMiddle + 1, lastIndex);
		
		
		mergeAlgo(array, startIndex, lastIndex, arrayMiddle);
		printArray(array);
	}

	private void mergeAlgo(int[] array, int startIndex, int lastIndex,
			int arrayMiddle) {
		int end_low = arrayMiddle;
		int start_high = arrayMiddle + 1;
		
		while ((startIndex <= end_low) && (start_high <= lastIndex)) {
			if (array[startIndex] < array[start_high]) {
				startIndex++;
			} else {
				int temp = array[start_high];
				for (int k = start_high - 1; k >= startIndex; k--) {
					array[k + 1] = array[k];
				}
				array[startIndex] = temp;
				startIndex++;
				end_low++;
				start_high++;
			}
		}
	}
	
	public void merge_sort_algo(int array[], int startIndex, int lastIndex) {

		if (startIndex >= lastIndex) {
			return;
		}

		int arrayMiddle = (startIndex + lastIndex) / 2;
		
		merge_sort_algo(array, startIndex, arrayMiddle);
		merge_sort_algo(array, arrayMiddle + 1, lastIndex);
		
		
		mergeAlgo(array, startIndex, lastIndex, arrayMiddle);
		printArray(array);
	}



	private void printArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}
}
