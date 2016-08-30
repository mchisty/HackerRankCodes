package org.hackerrank;

import java.util.Arrays;

/**
 * Kandane's algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * <br/>
 * 
 * Pseducode: <br/>
 * 
 * <code>
 * def max_subarray(A):
 * max_ending_here = max_so_far = 0
 * for x in A:
 * max_ending_here = max(0, max_ending_here + x)
 * max_so_far = max(max_so_far, max_ending_here)
 * return max_so_far
 * </code>
 * 
 */
/* ================================================ */
// Sample input:
// 1
// Sample output:
// 1 1
/* ================================================ */
//
// Sample input:
// -1 -2 -3 -4 -5 -6
// Sample output:
// -1 -1
//
/* ================================================ */
// Sample input:
// 1 -2
// Sample output:
// 1 1
/* ================================================ */
// Sample input:
// 1 2 3
// Sample output:
// 6 6
// -10
/* ================================================ */
//
// Sample input:
// 1 -1 -1 -1 -1 5
// Sample output:
// 5 6
/* ================================================ */

public class MaximumSumOfSubarray {
	public static void main(String[] args) {

		int arr[] = { -1, 10, -10, 1 }; // { -1, -2, -3, -4, -5, -6 }; //
		// System.out.println(getMaxContiguous(a));
		System.out.println(getMaxNonContiguous(arr));

		// Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		// int sum1 = 0, sum2 = 0;
		// for (int i = 0; i < t; ++i) {
		// int size = in.nextInt();
		// int[] a = new int[size];
		// for (int k = 0; k < size; ++k) {
		// a[k] = in.nextInt();
		// }
		// // sum1 = getMaxContiguous(a);
		// sum2 = getMaxNonContiguous(a);
		// System.out.println("" + sum1);
		// System.out.println("" + sum2);
		// }
		// in.close();

	}

	static int getMaxContiguous(int a[]) {
		int maxEndingHere = 0;
		int max_so_far = Integer.MIN_VALUE;
		for (int x : a) {
			maxEndingHere = Math.max(x, maxEndingHere + x);
			max_so_far = Math.max(max_so_far, maxEndingHere);
		}
		return max_so_far;
	}

	// For non continuous array
	// 1. Add up all
	// 2. Exclude the negatives
	static int getMaxNonContiguous(int arr[]) {
		Arrays.sort(arr);
		int sum = 0;
		if (arr[arr.length - 1] <= 0) {
			sum = arr[arr.length - 1];
		} else {
			for (int x : arr) {
				if (x > 0) {
					sum += x;
				}
			}
		}
		return sum;

	}

}
