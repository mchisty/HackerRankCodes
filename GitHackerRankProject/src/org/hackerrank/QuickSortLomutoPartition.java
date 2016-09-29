package org.hackerrank;

/*
  
Sample input:
7
1 3 9 8 2 7 5

//--------------------------------------
  
Sample output:
1 3 2 5 9 7 8
1 2 3 5 9 7 8
1 2 3 5 7 8 9 

*/
public class QuickSortLomutoPartition {
	public QuickSortLomutoPartition() {
	}

	public static void main(String[] args) {
		// int[] a = { 1, 3, 9, 8, 2, 7, 5 };
		int[] a = { 3, 4, 7, 5, 1, 2 };
		QuickSortLomutoPartition qs = new QuickSortLomutoPartition();
		qs.sort(a);
		qs.printArray(a);
		System.out.println("Count pivot moves: " + qs.countPivotMoves);
	}

	public void sort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	private void quicksort(final int[] a, int p, int r) {
		if (p < r) { // nothing to do if the subarray has fewer than 2 elements
			int q = partition(a, p, r); // q is pivot position
			// printArray(a);
			quicksort(a, p, q - 1); // recursively sort a[p..q-1]
			quicksort(a, q + 1, r); // recursively sort a[q+1..r]
		}
	}

	int countPivotMoves = 0;

	protected int partition(final int[] a, int p, int r) {
		int pivot = a[r]; // the value we pivot around
		int i = p - 1; // i is index into left side
		for (int j = p; j < r; j++) { // j is index into right side
			if (a[j] <= pivot) { // which side does a[j] go into?
				i++; // if left side, make it one larger...
				swap(a, i, j); // ...and get a[j] into the left side
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	// Swap two locations i and j in array a.
	protected void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		++countPivotMoves;
	}

	void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
