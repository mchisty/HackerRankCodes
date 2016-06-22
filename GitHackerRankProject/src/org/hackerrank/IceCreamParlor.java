package org.hackerrank;

import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int x = 0; x < t; ++x) {
			int amount = in.nextInt();
			int size = in.nextInt();
			int a[] = new int[size];
			for (int i = 0; i < size; ++i) {
				a[i] = in.nextInt();
			}
			int b[] = getIndices(amount, a);
			System.out.println("" + b[0] + " " + b[1]);
		}
		in.close();

	}

	static int[] getIndices(int amount, int[] a) {
		int[] b = new int[2];
		int sum = 0;
		outerloop: for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a.length; ++j) {
				if (i != j) {
					sum = a[i] + a[j];
					if (sum == amount) {
						b[0] = i + 1;
						b[1] = j + 1;
						break outerloop;
					}
				}
			}
		}

		return b;
	}

}
