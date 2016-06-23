package org.hackerrank;

import java.util.Scanner;

// Sample input:
//3
//10 2 5
//12 4 4
//6 2 2
// Sample output:
//6
//3
//5

public class Solution {
	// int[] a = { 10, 2, 5 };
	// int n = a[0];
	// int c = a[1];
	// int m = a[2];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] n = new int[t];
		int[] c = new int[t];
		int[] m = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			n[a0] = in.nextInt();
			c[a0] = in.nextInt();
			m[a0] = in.nextInt();
		}
		in.close();
		// ---------------------------------------------------------
		for (int i = 0; i < t; ++i) {
			int remainder = n[i] % c[i];
			int numChocs = n[i] / c[i];
			numChocs = numChocs + remainder;
			if (numChocs >= m[i]) {
				numChocs = numChocs + test(numChocs, m[i]);
			}

			System.out.println(numChocs);
		}

	}

	static int test(int wraps, final int m) {
		int remainder = wraps % m;
		int numChocs = wraps / m;
		numChocs = numChocs + remainder;
		if (numChocs >= m) {
			test(numChocs, m);
		}
		return numChocs;
	}

}