package org.hackerrank;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class FlatLandSpaceStations.
 */
public class FlatLandSpaceStations {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int n = 6;
		// int m = 6;
		// int[] c = { 0, 1, 2, 4, 3, 5 };
		// int result = getResult(n, m, c);
		// System.out.println(result);

		// -------------------------------------
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] c = new int[m];
		for (int i = 0; i < m; ++i) {
			c[i] = in.nextInt();
		}
		int result = getResult(n, m, c);
		System.out.println(result);

		in.close();

	}

	/**
	 * Gets the result.
	 *
	 * @param n
	 *            the n
	 * @param m
	 *            the m
	 * @param c
	 *            the c
	 * @return the result
	 */
	private static int getResult(int n, int m, int[] c) {
		int result = 0;
		int tmp = 0;
		if (n == m) {
			result = 0;
		} else {
			for (int i = 0; i < n; i++) {
				tmp = Math.abs(c[0] - i);
				for (int j = 0; j < m; j++) {
					if (Math.abs(c[j] - i) < tmp) {
						tmp = Math.abs(c[j] - i);
					}

				}
				if (tmp > result) {
					result = tmp;
				}
			}
		}

		return result;
	}

}
