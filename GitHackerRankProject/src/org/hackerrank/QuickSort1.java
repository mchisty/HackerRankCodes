package org.hackerrank;

/**
 * arr[] = {10, 80, 30, 90, 40, 50, 70}
 * 
 * Indexes: 0 1 2 3 4 5 6
 * 
 * low = 0, high = 6, pivot = arr[h] = 70 <br/>
 * Initialize index of smaller element, i = -1
 * 
 * Traverse elements from j = low to high-1 j = 0 : Check if arr[j] <= pivot
 * <br/>
 * Since 10<=70, do i++ and swap(arr[i], arr[j])
 * 
 * i = 0 arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j are same
 * 
 * j = 1 : Since arr[j] > pivot i.e. 80>70, do nothing // No change in i and
 * arr[]
 * 
 * j = 2 : Since arr[j] <= pivot i.e. 30<=70, <br/>
 * do i++ and swap(arr[i], arr[j])<br/>
 * i = 1
 * 
 * arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30
 * 
 * j = 3 : Since arr[j] > pivot i.e. 90>70, do nothing // No change in i and
 * arr[]
 * 
 * j = 4 : Since arr[j] <= pivot i.e. 40<=70, <br/>
 * do i++ and swap(arr[i], arr[j]) <br/>
 * i = 2
 * 
 * arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
 * 
 * j = 5 : Since arr[j] <= pivot i.e. 50<=70, <br/>
 * do i++ and swap arr[i] with arr[j] <br/>
 * i = 3
 * 
 * arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped
 * 
 * We come out of loop because j is now equal to high-1. <br/>
 * Finally we place pivot at correct position by swapping arr[i+1] and arr[high]
 * (or pivot)
 * 
 * arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped
 * 
 * Now 70 is at its correct place. All elements smaller than 70 are before it
 * and all elements greater than 70 are after it.
 * 
 */
public class QuickSort1 {


	static int getPartition(int arr[], int low, int high) {
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j < high; ++j) {
			if (arr[j] < pivot) {
				i += 1;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

		i += 1;
		int tmp = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp;
		return i;
	}

	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotPosition = getPartition(arr, low, high);
			quickSort(arr, low, pivotPosition - 1);
			quickSort(arr, pivotPosition + 1, high);
		}
	}

	/**
	 * Prints the array.
	 *
	 * @param ar
	 *            the ar
	 */
	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
}
