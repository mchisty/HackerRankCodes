package org.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The Class SumOfPairsInArray.
 */
public class SumOfPairsInArray {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		int k = in.nextInt();
		in.close();

		// =======================================
		for (int i = 0; i < a.length; ++i) {
			countAllSums(i, k, a);
		}
		System.out.println("" + testSet.size());

	}

	/** The test set. */
	static Set<Entry> testSet = new HashSet<>();

	/**
	 * Count all sums.
	 *
	 * @param indexPos
	 *            the index pos
	 * @param k
	 *            the k
	 * @param a
	 *            the a
	 */
	private static void countAllSums(int indexPos, int k, int a[]) {
		int n = a[indexPos];
		for (int i = 0; i < a.length; ++i) {
			if (indexPos != i) {
				int sum = a[i] + n;
				if (sum == k) {
					Entry entry = new Entry(n, a[i]);
					testSet.add(entry);
				}
			}
		}
	}

	/**
	 * The Class Entry.
	 */
	private static class Entry {

		/** The low. */
		private final int low;

		/** The high. */
		private final int high;

		/**
		 * Instantiates a new entry.
		 *
		 * @param val1
		 *            the val1
		 * @param val2
		 *            the val2
		 */
		Entry(int val1, int val2) {
			low = val1 < val2 ? val1 : val2;
			high = val2 > val1 ? val2 : val1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + high;
			result = prime * result + low;
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Entry other = (Entry) obj;
			if (this.high != other.high) {
				return false;
			}
			if (this.low != other.low) {
				return false;
			}
			return true;
		}
	}

}
