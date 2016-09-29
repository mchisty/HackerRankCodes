package org.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//5
//4 8 3 7 2
//---------------------
/**
 * The Class QuickSort1.
 */
// output: 3 2 4 5 7
public class QuickSort1 {
	/**
	 * Partition.
	 *
	 * @param ar
	 *            the ar
	 */
	static void partition(int[] ar) {
		int p = ar[0];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < ar.length; ++i) {
			if (ar[i] >= p) {
				right.add(ar[i]);
			} else {
				left.add(ar[i]);
			}
		}
		List<Integer> result = new ArrayList<>();
		result.addAll(left);
		result.addAll(right);
		// System.out.println("Left list: " + left.toString() + " Right list: "
		// + right.toString());
		int[] x = new int[left.size() + right.size()];
		int i = 0;
		for (Integer r : result) {
			x[i++] = r;
			// System.out.println(" -> " + r);
		}
		printArray(x);
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
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
		in.close();
	}
}
