package org.hackerrank;

import java.util.Scanner;

public class PossiblePath {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i<T; ++i) {
			int a=in.nextInt();
			int b=in.nextInt();
			int x=in.nextInt();
			int y=in.nextInt();
			System.out.println(getResult(a, b, x, y));
		}
		
		in.close();
	}

	private static String getResult(int a, int b, int x, int y) {
		final int A = a;
		final int B = b;
		boolean flagA = false;
		boolean flagB = false;
		while (a <= x) {
			if (a == x || a + b == x) {
				flagA = true;
				break;
			} else
				a = a + b;
		}
		while (b <= y) {
			if (b == y || a + b == y) {
				flagB = true;
				break;
			} else
				a = a + b;
		}
		if (flagA && flagB) {
			return "YES";
		}
		a = A;
		b = B;
		flagA = false;
		flagB = false;
		while (a >= x) {
			if (a == x || a - b == x) {
				flagA = true;
				break;
			} else
				a = a - b;
		}
		while (b >= y) {
			if (b == y || a - b == y) {
				flagB = true;
				break;
			} else
				a = a - b;
		}
		
		return flagA && flagB ? "YES":"NO";
	}
}
