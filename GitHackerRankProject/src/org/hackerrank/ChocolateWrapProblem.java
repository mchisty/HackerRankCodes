package org.hackerrank;

// Sample input:
//3
//10 2 5
//12 4 4
//6 2 2
// Sample output:
//6
//3
//5

public class ChocolateWrapProblem {
	// int[] a = { 10, 2, 5 };
	// int n = a[0];
	// int c = a[1];
	// int m = a[2];

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int t = in.nextInt();
		// int[] n = new int[t];
		// int[] c = new int[t];
		// int[] m = new int[t];
		// for (int a0 = 0; a0 < t; a0++) {
		// n[a0] = in.nextInt();
		// c[a0] = in.nextInt();
		// m[a0] = in.nextInt();
		// }
		// in.close();
		// for (int i = 0; i < t; ++i) {
		// int numChocs = n[i] / c[i];
		// if (numChocs >= m[i]) {
		// numChocs = numChocs + test(numChocs, m[i]);
		// }
		// System.out.println(numChocs);
		// }

		// -----------------------------------------
		// int n = 6, c = 2, m = 2;
		int n = 43203, c = 60, m = 5;
		int numChocs = n / c;
		if (numChocs >= m) {
			numChocs = numChocs + test(numChocs, m);
		}
		System.out.println(numChocs);

	}

	static int test(int wraps, final int m) {
		int remainder = wraps % m;
		int numChocs = wraps / m;
		if (numChocs + remainder >= m) {
			numChocs = numChocs + test(numChocs + remainder, m);
		}
		return numChocs;
	}
}