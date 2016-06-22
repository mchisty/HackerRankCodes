package org.hackerrank;

public class Test {

	public static void main(String[] args) {
		int[][] a = { // start
				{ 1, 1, 1, 2 }, // 1st row
				{ 1, 9, 1, 2 }, // 2nd row
				{ 1, 8, 9, 2 }, // 3rd row
				{ 1, 2, 3, 4 } // 4th row
		}; // end

		int dimesion = 4;
		char[][] aChar = new char[dimesion][dimesion];
		// int i = 1;
		// int j = 2;
		// boolean flag = isOnBorder(i, j, row, col);
		// System.out.println(a[i][j] + " is on border? " + flag);
		// getAdjacentCellValues(a, i, j, row, col);
		// int[] b = getAdjacentCellValues(a, i, j, row, col);
		// System.out.println("adjacent value " + Arrays.toString(b));

		for (int i = 0; i < dimesion; ++i) {
			for (int j = 0; j < dimesion; ++j) {

				aChar[i][j] = (char) (a[i][j] + '0');
				int[] b = getAdjacentCellValues(a, i, j, dimesion, dimesion);
				if (null != b) {
					aChar[i][j] = 'X';
				}
			}
		}

		// --------------------------------
		for (int i = 0; i < dimesion; ++i) {
			for (int j = 0; j < dimesion; ++j) {
				System.out.print(aChar[i][j]);
			}
			System.out.println();
		}

	}

	// ------------------------------
	static boolean isOnBorder(final int i, final int j, final int row, final int col) {
		if (i == 0 || j == 0) {
			return true;
		}
		if (i == row - 1 || j == col - 1) {
			return true;
		}
		return false;
	}

	// ------------------------------
	static int[] getAdjacentCellValues(final int[][] a, final int i, final int j, final int row, final int col) {
		if (isOnBorder(i, j, row, col)) {
			return null;
		}
		int b[] = new int[4];
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
