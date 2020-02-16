package org.hackerrank;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The Class MaximumSumOfSubarrayModuloM.
 */
public class MaximumSumOfSubarrayModuloM {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		long m = 7;
		long[] arr = { 3, 3, 9, 9, 5 };
		long res = maximumSum(arr, m);
		System.out.println(res);
	}

	/**
	 * Maximum sum.
	 *
	 * @param a the a
	 * @param m the m
	 * @return the long
	 */
	static long maximumSum(long[] a, long m) {
		long maxSum = 0;
		TreeSet<Long> prefix = new TreeSet<Long>();
		long currentSum = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.printf("currentSum  = (%d + %d  mod %d) mod %d ", currentSum, a[i], m, m);
			currentSum = (currentSum + a[i] % m) % m; // Question: Why modulo done two times?
			System.out.println("=> " + currentSum);
			SortedSet<Long> set = prefix.tailSet(currentSum + 1); // using tailSet to return a view of the portion of
																	// this set whose
																	// elements >= currentSum + 1.

			System.out.println("tailset => " + set);
			Iterator<Long> itr = set.iterator();
			if (itr.hasNext()) {
				maxSum = Math.max(maxSum, (currentSum - itr.next() + m) % m); // Question: Why ?
			}
			maxSum = Math.max(maxSum, currentSum);
			prefix.add(currentSum);
		}
		return maxSum;
	}
}
