package org.hackerrank;

import java.util.Scanner;

// Sample input
//4
//1
//3
//5
//11

// Output
//-1
//555
//33333
//55555533333

public class SherlokAndBeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] n = new int[t];
		for (int a0 = 0; a0 < t; a0++) {
			n[a0] = in.nextInt();
		}
		in.close();

		for (int i = 0; i < t; ++i) {
			test(n[i]);
		}

	}

	// Only needs to calculate once.
	// Max number of 5 (in left side) + Min number of 3 (right size) is all
	// what's needed
	// e.g
	// 555555
	// 55555533333

	static void test(int n) {
		StringBuilder strb = new StringBuilder();
		int j = 0;
		for (int i = n; i > 0; --i) {
			if (i % 3 == 0 && (n - i) % 5 == 0) {
				for (j = 0; j < i; j++) {
					strb.append("5");
				}
				for (int k = i; k < n; k++) {
					strb.append("3");
				}
				break;

			}
		}

		// Note this line, specifically applicable for n = 5, 10 etc
		if (strb.length() == 0 && n % 5 == 0) {
			for (int k = n; k > 0; k--) {
				strb.append("3");
			}
		} else if (strb.length() == 0) {
			strb.append(-1);
		}

		System.out.println(strb);
	}

}
