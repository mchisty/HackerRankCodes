package org.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int n1 = in.nextInt();
		int nth = in.nextInt();
		in.close();
		System.out.println(getNthVal(BigInteger.valueOf(n), BigInteger.valueOf(n1), nth));

	}

	static BigInteger getResult(BigInteger n1, BigInteger n) {
		return n.add(n1.multiply(n1));
	}

	static BigInteger getNthVal(BigInteger first, BigInteger second, int nthTerm) {
		int count = 2;
		BigInteger n = BigInteger.ZERO;
		while (count < nthTerm) {
			n = getResult(second, first);
			first = second;
			second = n;
			++count;
		}
		return n;
	}

}
