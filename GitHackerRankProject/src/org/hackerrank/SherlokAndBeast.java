package org.hackerrank;

import java.util.Scanner;

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

	static void test(int n) {
		StringBuilder strb = new StringBuilder();
		int j = 0;
		for (int i = n; i > 0; i--) {
			if (i % 3 == 0 && (n - i) % 5 == 0) {
				for (j = 0; j < i; j++) {
					strb.append("5");
				}
				for (int k = j; k < n; k++) {
					strb.append("3");
				}
				break;

			}
		}
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
