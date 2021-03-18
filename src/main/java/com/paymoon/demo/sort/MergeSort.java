package com.paymoon.demo.sort;
/* Java program for Merge Sort */
class MergeSort { 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int left, int middle, int right) 
	{ 
		// Find sizes of two subarrays to be merged 
		int leftArrayLength = middle - left + 1; 
		int rightArrayLength = right - middle; 

		/* Create temp arrays */
		int leftTempArray[] = new int[leftArrayLength]; 
		int rightTempArray[] = new int[rightArrayLength]; 

		/*Copy data to temp arrays*/
		for (int i = 0; i < leftArrayLength; ++i) {
			int arrIndex = left + i;
			leftTempArray[i] = arr[arrIndex]; 
		}
		for (int j = 0; j < rightArrayLength; ++j) {
			int arrIndex = middle + 1 + j;
			rightTempArray[j] = arr[arrIndex]; 
		}

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int leftSubArrayIndex = 0;
		int rightSubArrayIndex = 0; 

		// Initial index of merged subarry array 
		int mergedArrayIndex = left; 
		while (leftSubArrayIndex < leftArrayLength && rightSubArrayIndex < rightArrayLength) { 
			if (leftTempArray[leftSubArrayIndex] <= rightTempArray[rightSubArrayIndex]) { 
				arr[mergedArrayIndex] = leftTempArray[leftSubArrayIndex]; 
				leftSubArrayIndex++; 
			} 
			else { 
				arr[mergedArrayIndex] = rightTempArray[rightSubArrayIndex]; 
				rightSubArrayIndex++; 
			} 
			mergedArrayIndex++; 
		} 

		/* Copy remaining elements of leftTempArray[] if any */
		while (leftSubArrayIndex < leftArrayLength) { 
			arr[mergedArrayIndex] = leftTempArray[leftSubArrayIndex]; 
			leftSubArrayIndex++; 
			mergedArrayIndex++; 
		} 

		/* Copy remaining elements of rightTempArray[] if any */
		while (rightSubArrayIndex < rightArrayLength) { 
			arr[mergedArrayIndex] = rightTempArray[rightSubArrayIndex]; 
			rightSubArrayIndex++; 
			mergedArrayIndex++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int left, int right) 
	{ 
		if (left < right) { 
			// Find the middle point 
			int m = (left + right) / 2; 

			// Sort first and second halves 
			sort(arr, left, m); 
			sort(arr, m + 1, right); 

			// Merge the sorted halves 
			merge(arr, left, m, right); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = { 3, 1, 5, 6, 9, 7, 2, 4 };

		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSort ob = new MergeSort(); 
		ob.sort(arr, 0, arr.length - 1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 
/* This code is contributed by Rajat Mishra */
