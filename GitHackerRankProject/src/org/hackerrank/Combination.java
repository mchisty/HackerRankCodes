package org.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class Combination {

	static BigInteger factorial(int num) {
		int perm = 1;
		for (int index = 2; index <= num; ++index) {
			perm = perm * index;
		}
		return new BigInteger("" + perm);
	}

	static BigInteger nCr(int n, int r) {
		BigInteger a1 = factorial(n);
		BigInteger a2 = factorial(n - r);
		BigInteger a3 = factorial(r);
		BigInteger result = a1.divide(a2.multiply(a3));
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a[] = new int[t];
		for (int i = 0; i < t; ++i) {
			a[i] = in.nextInt();
		}
		in.close();

		for (int k = 0; k < a.length; ++k) {
			int n = a[k];
			for (int i = 0; i <= n; ++i) {
				BigInteger result = nCr(n, i);
				System.out.print(result + " ");
			}
			System.out.println();
		}

		// new Combination().test();
	}

	// -------------------------
	public long facDigits(long n) {
		double logFacN = 0;
		for (long i = 2; i <= n; i++) {
			logFacN += Math.log10(i);
		}
		return (long) logFacN + 1;
	}

	public void test() {
		double tenToThe7th = 4;//
		long digits = facDigits((long) tenToThe7th);
		System.out.println("Digits in " + tenToThe7th + "! = " + digits);
	}

}
