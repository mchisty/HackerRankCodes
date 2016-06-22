package org.hackerrank;

import java.util.Scanner;

// int dimesion = 4;
// char[][] aChar = { // start
// { '1', '1', '1', '2' }, // 1st row
// { '1', '9', '1', '2' }, // 2nd row
// { '1', '8', '9', '2' }, // 3rd row
// { '1', '2', '3', '4' } // 4th row
// }; // end

public class CavityMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dimesion = in.nextInt();
		String grid[] = new String[dimesion];
		for (int grid_i = 0; grid_i < dimesion; grid_i++) {
			grid[grid_i] = in.next();
		}
		in.close();
		// populate into char array
		char[][] aChar = new char[dimesion][dimesion];
		for (int i = 0; i < dimesion; ++i) {
			aChar[i] = grid[i].toCharArray();
		}
		for (int i = 0; i < dimesion; ++i) {
			for (int j = 0; j < dimesion; ++j) {
				char[] b = getAdjacentCellValues(aChar, i, j, dimesion, dimesion);
				if (null != b) {
					aChar[i][j] = 'X';
				}
			}
		}
		// --------------------------------
		// Print
		for (int i = 0; i < dimesion; ++i) {
			for (int j = 0; j < dimesion; ++j) {
				System.out.print(aChar[i][j]);
			}
			System.out.println();
		}
	}

	static boolean isOnBorder(final int i, final int j, final int row, final int col) {
		if (i == 0 || j == 0) {
			return true;
		}
		if (i == row - 1 || j == col - 1) {
			return true;
		}
		return false;
	}

	static char[] getAdjacentCellValues(final char[][] a, final int i, final int j, final int row, final int col) {
		if (isOnBorder(i, j, row, col)) {
			return null;
		}
		char b[] = new char[4];
		b[0] = a[i - 1][j];
		b[1] = a[i][j - 1];
		b[2] = a[i + 1][j];
		b[3] = a[i][j + 1];
		for (int x = 0; x < 4; ++x) {
			if (b[x] >= a[i][j]) {
				return null;
			}
		}
		return b;
	}
}
