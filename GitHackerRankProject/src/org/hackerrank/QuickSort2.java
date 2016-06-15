package org.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class QuickSort2 {

	Stack<List<Integer>> st = new Stack<>();
	Map<String, List<Integer>> map = new HashMap<>();
	final static String LEFT = "LEFT";
	final static String RIGHT = "RIGHT";

	public QuickSort2() {

	}

	public static void main(String[] args) {

		QuickSort2 q = new QuickSort2();
		// int[] ar = { 1,3,2 };
		int[] ar = { 5, 8, 1, 3, 7, 9, 2 };
		List<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < ar.length; ++i) {
			arrList.add(ar[i]);
		}
		q.quickSort(ar);
	}

	static void quickSort(int[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}



	static int partition(int ar[], int minpos, int maxpos) {
		int p = ar[minpos];
		ArrayList<Integer> leftlist = new ArrayList<Integer>();
		ArrayList<Integer> rightlist = new ArrayList<Integer>();

		for (int i = minpos + 1; i <= maxpos; i++) {
			if (ar[i] > p)
				rightlist.add(ar[i]);
			else
				leftlist.add(ar[i]);
		}
		copy(leftlist, ar, minpos);
		int ppos = leftlist.size() + minpos;
		ar[ppos] = p;
		copy(rightlist, ar, ppos + 1);

		return minpos + leftlist.size();
	}

	static void copy(ArrayList<Integer> list, int ar[], int startIdx) {
		for (int num : list) {
			ar[startIdx++] = num;
		}
	}

	static void quickSort(int ar[], int minpos, int maxpos) {
		if (minpos >= maxpos)
			return;

		int pos = partition(ar, minpos, maxpos);

		quickSort(ar, minpos, pos - 1);
		quickSort(ar, pos + 1, maxpos);

		printArray(ar, minpos, maxpos);
	}

	static void printArray(int[] ar, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}

	// ===============================================

	// If the array length > 2,
	// i. partition the array into two
	// ii. call sort method passing the left array
	// iii. call sort method passing the right array
	// iv. merger the left array with the partition and the right array in this
	// other.
	// v. print the resulting sub array before every return v. return the sub
	// array.

	void partition(List<Integer> arrList) {
		List<Integer> result = new ArrayList<>();
		if (arrList.size() <= 1) {
			result = arrList;
		}
		// TODO: swap
		else if (arrList.size() == 2) {
			int a = arrList.get(0);
			int b = arrList.get(1);
			if (a > b) {
				arrList.set(0, b);
				arrList.set(1, a);
			}
			result.addAll(arrList);
		} else {
			int pivot = arrList.get(0);
			List<Integer> leftList = new ArrayList<>();
			List<Integer> rightList = new ArrayList<>();
			for (int i = 0; i < arrList.size(); ++i) {
				int x = arrList.get(i);
				if (x < pivot) {
					leftList.add(x);
				} else if ((x > pivot)) {
					rightList.add(x);
				}
			}

			result.addAll(leftList);
			result.add(pivot);
			result.addAll(rightList);
			System.out.println(result.toString());
			partition(result);
		}

	}

}
