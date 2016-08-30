package org.hackerrank.math;

import java.util.Scanner;

public class MathSolutions {

	public static void main(String[] args) {
		MathSolutions ms = new MathSolutions();
		// ms.printMaximumDraws();
		ms.printHandshakes();

	}

	/**
	 * Jim is off to a party and is searching for a matching pair of socks. His
	 * drawer is filled with socks, each pair of a different color. In its worst
	 * case scenario, how many socks (x) should Jim remove from his drawer until
	 * he finds a matching pair?
	 * 
	 * Note: one of the easiest/dumbest solutions
	 */
	void printMaximumDraws() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		in.close();
		// ----------------------------------
		for (int i = 0; i < n; ++i) {
			System.out.println(a[i] + 1);
		}

	}

	void printHandshakes() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		in.close();
		// ----------------------------------
		for (int k = 0; k < n; ++k) {
			int p = a[k];
			int count = 0;
			for (int i = 0; i < p; ++i) {
				for (int j = i + 1; j < p; ++j) {
					++count;
				}
			}
			System.out.println(count);
		}

	}

}
