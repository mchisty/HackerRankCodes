package org.hackerrank;

import java.util.Arrays;

public class MyTest2 {
	public static void main(String[] args) {

		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(Arrays.toString(a) + "\n");
		printMaxSum(a);

	}

	static void printMaxSum(int[] arr) {

		// 1) For max continuous sub array
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		/* OR int max_so_far = arr[0]; */

		for (int x : arr) {
			System.out.println("x val: " + x + "\tmax_ending_here: " + max_ending_here + " [max_ending_here + x] : "
					+ (max_ending_here + x));
			max_ending_here = Math.max(x, max_ending_here + x);
			System.out.println(
					"[Updated] max_ending_here: " + max_ending_here + ", [Initial] max_so_far value: " + max_so_far);
			max_so_far = Math.max(max_so_far, max_ending_here);
			System.out.println("[Final] max_so_far value: " + max_so_far);
			System.out.println("---------------------------------------------------------------------");
		}

		System.out.print(max_so_far);

		// 2) For max non-continuous sub array, order doesn't matter
		Arrays.sort(arr);
		int sum = 0;

		// if there is none positive value in entire array
		if (arr[arr.length - 1] <= 0) {
			sum = arr[arr.length - 1];
		} else {
			for (int x : arr) {
				if (x > 0) {
					sum += x;
				}
			}
		}
		System.out.println(" " + sum);
	}
}
