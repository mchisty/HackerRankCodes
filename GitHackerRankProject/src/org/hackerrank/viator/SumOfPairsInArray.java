package org.hackerrank.viator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The Class SumOfPairsInArray.
 * 
 * Complete the function numberOfPairs (int[] a, int k). The function must
 * return an integer denoting the number of distinct pairs (a[i], a[j]) where
 * i!=j in a such that a[i]+a[j]=k.
 * 
 * 
 * Note: Pairs (a[i], a[j]) and (a[j], a[i]) are considered to be the same
 * because they are both composed of the same 2 elements; however, while i!=j,
 * the value of a[i] may be equal to a[j].
 * 
 * Sample Input: <br/>
 * <code>
 * 6 
 * 1 
 * 3 
 * 46
 * 1
 * 3
 * 9
 * 47
 * </code>
 * 
 * Sample output: 2
 * 
 * Explanation: <br/>
 * <code>
 * n = 6
 * a = {1,3,46,1,3,9}
 * k = 47
 * 
 * </code>
 * 
 * There are 4 pairs of unique elements where a[i]+a[j]=47 <br/>
 * <code>
 * (1) a[0]=1, a[2]=46
 * (2) a[2]=46, a[0]=1
 * (3) a[2]=46, a[3]=1
 * (4) a[3]=1, a[2]=46
 * </code>
 * 
 * In the above list, pairs 1 and 2 are equivalent; pairs 3 and 4 are equivalent
 * (because they both use the same i and j). In addition, all 4 pairs contain
 * the same values. Thus we only have 1 distinct pair.
 * 
 * <br/>
 * 
 * Output: 1
 * 
 * 
 * 
 * Sample Input2: 
 * <br/>
 * <code>
 * n=7
 * a = {6,6,3,9,3,5,1}
 * k = 12
 * 
 * 1. a[0]=6, a[6]=1
 * 2. a[6]=1, a[0]=6
 * 3. a[1]=6, a[6]=1
 * 4. a[6]=1, a[1]=6
 * </code>
 *
 * Output: 2
 * 
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
	private static void countAllSums(final int indexPos, final int k, final int a[]) {
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
