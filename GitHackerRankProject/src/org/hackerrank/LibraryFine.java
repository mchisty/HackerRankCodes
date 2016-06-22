package org.hackerrank;

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int d1 = in.nextInt();
		int m1 = in.nextInt();
		int y1 = in.nextInt();
		int d2 = in.nextInt();
		int m2 = in.nextInt();
		int y2 = in.nextInt();
		in.close();
		int fine = getFineAmount(d1, m1, y1, d2, m2, y2);
		System.out.println(fine);
	}

	static int getFineAmount(int dayActual, int monthActual, int yearActual, int dayExpected, int monthExpected,
			int yearExpected) {

		if (yearActual > yearExpected) {
			return 10000;
		}
		if (monthActual > monthExpected) {
			if (yearActual == yearExpected) {
				return 500 * (monthActual - monthExpected);
			}
		}
		if (dayActual > dayExpected) {
			if (yearActual == yearExpected && monthActual == monthExpected) {
				return 15 * (dayActual - dayExpected);
			}
		}

		return 0;

	}

}
