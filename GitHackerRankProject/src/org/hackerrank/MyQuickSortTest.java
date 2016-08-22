package org.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MyQuickSortTest {
	MyQuickSortTest() {
	}

	public static void main(String[] args) {
		MyQuickSortTest mt = new MyQuickSortTest();
		int[] a = { 1, 3, 9, 8, 2, 7, 5 }; // { 5, 8, 1, 3, 7, 9, 2 };
		mt.quickSort(a, 0, a.length - 1);
		System.out.println("Count pivot moves: " + mt.countPivotMoves);
	}

	void quickSort(int a[], int minpos, int maxpos) {
		if (minpos >= maxpos)
			return;
		// System.out.println("minpos: " + minpos + ", maxpos: " + maxpos);
		int pivotPosition = getPartitionPos(a, minpos, maxpos);
		// System.out.println("Pivot position: " + pivotPosition);
		quickSort(a, minpos, pivotPosition - 1);
		quickSort(a, pivotPosition + 1, maxpos);
		printArray(a, minpos, maxpos);
	}

	int countPivotMoves = 0;

	int getPartitionPos(int a[], int minpos, int maxpos) {
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		int pivot = a[minpos];
		for (int i = minpos + 1; i <= maxpos; ++i) {
			if (a[i] < pivot) {
				++countPivotMoves;
				leftList.add(a[i]);
			} else {
				rightList.add(a[i]);
			}
		}
		updateArray(leftList, a, minpos, "LEFT: ");
		// --------------------------------------------
		// This pos value update is crucial,
		// specially for rightlist where pivot position becomes the minpos
		// --------------------------------------------
		int ppos = leftList.size() + minpos; // Pivot Position
		a[ppos] = pivot; // Pivot Value
		updateArray(rightList, a, (ppos + 1), "RIGHT: "); // This pos value
															// update is
															// important
		return ppos;
	}

	void updateArray(List<Integer> list, int a[], int begin, String lr) {
		for (Integer val : list) {
			a[begin++] = val;
		}
	}

	void printArray(int[] a, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
}
