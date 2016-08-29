package org.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class BeautifulTripletsTest.
 */
public class BeautifulTripletsTest {

	/** The count. */
	static int count = 0;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int a[] = { 1, 2, 4, 5, 7, 8, 10 };
		// int d = 3;
		// for (int k = 0; k < a.length; ++k) {
		// int b[] = getDifferences(a[k], a);
		// increaseCountIfEqualValueFound(d, b);
		// }
		// System.out.println("" + count);
		// ---------------------------------------------------------
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		in.close();
		for (int k = 0; k < a.length; ++k) {
			int b[] = getDifferences(a[k], a);
			increaseCountIfEqualValueFound(d, b);
		}
		System.out.println("" + count);

	}

	/**
	 * Gets the differences.
	 *
	 * @param n
	 *            the n
	 * @param a
	 *            the a
	 * @return the differences
	 */
	private static int[] getDifferences(int n, int a[]) {
		int b[] = new int[a.length];
		for (int i = 0; i < a.length; ++i) {
			b[i] = Math.abs(a[i] - n);
		}
		return b;
	}

	/**
	 * Increase count if equal value found.
	 *
	 * @param d
	 *            the d
	 * @param diff
	 *            the diff
	 */
	private static void increaseCountIfEqualValueFound(int d, int diff[]) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : diff) {
			if (d == i && !set.add(i)) {
				++count;
				break;
			}
		}
	}

}
