package org.hackerrank;

import java.util.Scanner;

public class TestPrimarility {

	private static void printStats(int count, long n, boolean isPrime) {
		String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.err.println(caller + " performed " + count + " checks, determined " + n
						+ ((isPrime) ? " is PRIME." : " is NOT PRIME."));
	}

	/**
	 * Better: O(n) algorithm Checks if n is divisible by any number from 2 to n/2, but is asymptotically the same as isPrimeWorst
	 **/
	public static boolean isPrimeLessWorst(int n) {
		int count = 0;
		if (n == 1) {
			printStats(++count, n, false);
			return false;
		}
		int i = 1;
		while (i++ < n / 2) {
			count++;
			if (n % i == 0) {
				printStats(++count, n, false);
				return false;
			}
		}
		printStats(++count, n, true);
		return true;
	}

	/**
	 * O(n^(1/2)) Algorithm Checks if n is divisible by any number from 2 to sqrt(n).
	 **/
	public static boolean isPrimeGood(int n) {
		int count = 0;
		if (n == 1) {
			printStats(++count, n, false);
			return false;
		} else if (n == 2) {
			printStats(++count, n, true);
			return true;
		}

		// return false n is divisible by any i from 2 to n
		int i = 1;
		while (i++ < Math.sqrt(n)) {
			count++;
			if (n % i == 0) {
				printStats(++count, n, false);
				return false;
			}
		}
		printStats(++count, n, true);
		return true;
	}

	/**
	 * Improved O( n^(1/2)) ) Algorithm Checks if n is divisible by 2 or any odd number from 3 to sqrt(n). The only way to improve on this is to check
	 * if n is divisible by all KNOWN PRIMES from 2 to sqrt(n).
	 **/
	public static boolean isPrimeBest(int n) {
		int count = 0;
		if (n == 2) {
			printStats(++count, n, true);
			return true;
		} else if (n == 1 || (n & 1) == 0) {
			printStats(++count, n, false);
			return false;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			count++;
			if (n % i == 0) {
				printStats(++count, n, false);
				return false;
			}
		}
		// n is prime
		printStats(++count, n, true);
		return true;
	}

	// --------------- my own test --------------

	static boolean isMyPrime(long n) {
		int count = 0;
		if (n == 2) {
			printStats(++count, n, true);
			return true;
		} else if (n == 1) {
			printStats(++count, n, false);
			return false;
		}
		// check if n is a multiple of 2
		if (n % 2 == 0) {
			printStats(++count, n, false);
			return false;
		}
		// if not, then just check the odds
		for (int i = 3; i < Math.sqrt(n); i += 2) {
			count++;
			if (n % i == 0) {
				printStats(++count, n, false);
				return false;
			}
		}
		printStats(++count, n, true);
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// int n = 2147483647; // scan.nextInt();
		long n = 3203431780337L; // 2147483647; // scan.nextInt();
		// isPrimeLessWorst(n);
		// isPrimeGood(n);
		// isPrimeBest(n);
		isMyPrime(n);
		scan.close();
		System.out.println();
	}

}
