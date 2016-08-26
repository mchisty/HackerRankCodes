package org.hackerrank.viator;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AbsolutePrime.
 */
public class AbsolutePrime {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		int n = 1000000; // 100; // 15
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = n; i >= 2; --i) {
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		int max = 0;
		int maxPrime = 0;
		for (Integer i : primeNumbers) {
			int sum = getSumOfDigits(i);
			if (sum > max) {
				max = sum;
				maxPrime = i;
			}
		}
		System.out.println("" + maxPrime);
	}

	/**
	 * Gets the sum of digits.
	 *
	 * @param i
	 *            the i
	 * @return the sum of digits
	 */
	static int getSumOfDigits(int i) {
		int sum = 0;
		int tmp = i;
		while (tmp != 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		return sum;
	}

	/**
	 * Checks if is prime.
	 *
	 * @param n
	 *            the n
	 * @return true, if is prime
	 */
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		} else if (n == 1 || (n & 1) == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
