package org.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class RunningTimeDiffQuickVsInsertionSort {
    int countPivotMovesForQuickSort = 0;
    int countSwapsForInsertionSort = 0;

    public static void main(String[] args) {
	RunningTimeDiffQuickVsInsertionSort rs = new RunningTimeDiffQuickVsInsertionSort();
	// final int[] a = { 1, 3, 9, 8, 2, 7, 5 };
	// int qsArray[] = Arrays.copyOf(a, a.length);
	// int insArray[] = Arrays.copyOf(a, a.length);
	// rs.insertionSort(insArray);
	// rs.quicksort(qsArray);
	// System.out.println("After quick sort: " + Arrays.toString(qsArray));
	// System.out.println("Original again: " + Arrays.toString(a));
	// System.out.println("" + rs.countSwapsForInsertionSort);
	// System.out.println("" + rs.countPivotMovesForQuickSort);
	// -----------------------------------------------------
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = in.nextInt();
	}
	in.close();
	int qsArray[] = Arrays.copyOf(a, a.length);
	int insArray[] = Arrays.copyOf(a, a.length);
	rs.insertionSort(insArray);
	rs.quicksort(qsArray);
	int diff = rs.countSwapsForInsertionSort - rs.countPivotMovesForQuickSort;
	System.out.println(diff);
    }

    // ----------------------
    // Quicksort
    // -----------------------
    public void quicksort(int[] a) {
	quicksort(a, 0, a.length - 1);
    }

    void quicksort(int[] a, int p, int r) {
	if (p < r) {
	    int q = partition(a, p, r);
	    quicksort(a, p, q - 1);
	    quicksort(a, q + 1, r);
	}
    }

    int partition(int[] a, int p, int r) {
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

    void swap(int[] a, int i, int j) {
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
	++countPivotMovesForQuickSort;
    }

    // --------------------------------------
    // insertion sort
    // ---------------------------------------
    void insertionSort(int[] A) {
	for (int i = 1; i < A.length; i++) {
	    int value = A[i];
	    int j = i - 1;
	    while (j >= 0 && A[j] > value) {
		A[j + 1] = A[j];
		j = j - 1;
		++countSwapsForInsertionSort;
	    }
	    A[j + 1] = value;
	}
    }
}
