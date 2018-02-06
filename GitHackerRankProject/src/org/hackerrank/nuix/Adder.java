package org.hackerrank.nuix;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class Adder.
 */
public class Adder {

	/** The Constant start. */
	final static long start = System.currentTimeMillis();

	/** The Constant TWO. */
	final static BigInteger TWO = new BigInteger("2");

	/** The map. */
	static Map<BigInteger, BigInteger> map = new HashMap<>();

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		int N = 32;
		adder(N);
		System.out.println("------------------------------------------------");
		System.out.println("Time elapsed (seconds): " + (System.currentTimeMillis() - start) / 1000);
		System.out.println("------------------------------------------------");

	}

	/**
	 * Adder.
	 *
	 * @param N
	 *            the n
	 */
	static void adder(int N) {
		for (int i = 0; i < N; ++i) {
			System.out.println(calculateWithMap(BigInteger.valueOf(i)));
			// System.out.println(calculateWithoutHashMap(BigInteger.valueOf(i)));
		}
	}

	// For faster perfroamnce, calculate the value and store in HashMap

	/**
	 * Calculate with map.
	 *
	 * @param N
	 *            the n
	 * @return the big integer
	 */
	static BigInteger calculateWithMap(BigInteger N) {
		if (map.containsKey(N)) {
			return map.get(N);
		}

		if (N.compareTo(TWO) <= 0) {
			map.put(N, N);
			return N;
		}

		BigInteger a = new BigInteger("0");
		for (int i = 1; i <= 3; ++i) {
			a = a.add(calculateWithMap(N.subtract(BigInteger.valueOf(i))));
		}
		map.put(N, a);
		return a;
	}

	/**
	 * Calculate. Without HashMap, performance is too slow. Every time requires recalculation of previous adder numbers
	 *
	 * @param N
	 *            the n
	 * @return the big integer
	 */
	static BigInteger calculateWithoutHashMap(BigInteger N) {
		if (N.compareTo(TWO) <= 0) {
			return N;
		}

		BigInteger a = new BigInteger("0");
		for (int i = 1; i <= 3; ++i) {
			a = a.add(calculateWithoutHashMap(N.subtract(BigInteger.valueOf(i))));
		}
		return a;
	}

}
