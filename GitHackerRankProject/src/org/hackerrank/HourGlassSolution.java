package org.hackerrank;

import java.util.Scanner;

public class HourGlassSolution {

	// static int A[][] = { { -1, -1, 0, -9, -2, -2 }, { -2, -1, -6, -8, -2, -5
	// }, { -1, -1, -1, -2, -3, -4 },
	// { -1, -9, -2, -4, -4, -5 }, { -7, -3, -3, -2, -9, -9 }, { -1, -3, -1, -2,
	// -4, -5 } };

	// static int A[][] = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1,
	// 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
	// { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

	final static int row = 6, col = 6;
	static int A[][] = new int[row][col];

	public static void main(String[] args) {
		int max = Integer.MIN_VALUE, result;
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				A[i][j] = in.nextInt();
			}
		}
		in.close();
		// ----------------------------------------------------
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				result = getSumOfHourGlass(i, j);
				if (result > max) {
					max = result;
				}
			}
		}
		System.out.println(max);
	}

	static int getSumOfHourGlass(final int x, final int y) {
		int a[] = new int[7];

		a[0] = A[x][y];
		a[1] = A[x][y + 1];
		a[2] = A[x][y + 2];

		a[3] = A[x + 1][y + 1];

		a[4] = A[x + 2][y];
		a[5] = A[x + 2][y + 1];
		a[6] = A[x + 2][y + 2];
		int sum = 0;
		for (int i = 0; i < a.length; ++i) {
			sum = sum + a[i];
		}

		return sum;
	}

}
