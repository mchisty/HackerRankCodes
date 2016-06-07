package org.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArgoMatrixRotation {

	int ROWS = 0, COLS = 0;
	int ROTATIONS = 0;
	int tmp[][] = null;
	int a[][] = null;

	public ArgoMatrixRotation() {
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArgoMatrixRotation mt = new ArgoMatrixRotation();
		// mt.takeInput(in);
		mt.readInputFromFile();
		in.close();
		mt.calculate();
	}

	void takeInput(Scanner in) {
		ROWS = in.nextInt();
		COLS = in.nextInt();
		ROTATIONS = in.nextInt();
		a = new int[ROWS][COLS];
		tmp = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				a[i][j] = in.nextInt();
			}
		}
		updateNumberofRotations();
	}

	void readInputFromFile() {
		try {
			File file = new File("C:\\Temp\\matrix_input01.txt");
			FileInputStream fin = new FileInputStream(file);
			InputStreamReader iread = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(iread);

			String line1 = br.readLine();
			StringTokenizer stoken = new StringTokenizer(line1, "\t ");
			ROWS = Integer.parseInt(stoken.nextToken());
			COLS = Integer.parseInt(stoken.nextToken());
			ROTATIONS = Integer.parseInt(stoken.nextToken());
			a = new int[ROWS][COLS];
			tmp = new int[ROWS][COLS];

			for (int i = 0; i < ROWS; ++i) {
				String line2 = br.readLine();
				populateArray(line2, i);
			}

			// ----------------------------
			// for (int i = 0; i < ROWS; ++i) {
			// for (int j = 0; j < COLS; ++j) {
			// System.out.print(a[i][j] + " ");
			// }
			// System.out.println();
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void populateArray(String line, int row) {
		StringTokenizer stoken = new StringTokenizer(line, "\t ");
		int j = 0;
		while (stoken.hasMoreTokens()) {
			a[row][j] = Integer.parseInt(stoken.nextToken());
			++j;
		}
	}

	void updateNumberofRotations() {
		int I = 2 * ROWS + 2 * COLS - 4;
		if (ROTATIONS > I) {
			ROTATIONS = ROTATIONS % I;
		}
	}

	void calculate() {
		for (int count = 0; count < ROTATIONS; ++count) {
			for (int startpos = 0, row1 = 0, col1 = 0; row1 < ROWS && col1 < COLS; ++row1, ++col1, ++startpos) {
				rotate(startpos, row1, col1, ROWS - row1, COLS - col1);
			}
			a = tmp;
			tmp = new int[ROWS][COLS];
			for (int i = 0; i < ROWS; ++i) {
				for (int j = 0; j < COLS; ++j) {
					if (count == ROTATIONS - 1) {
						System.out.print(a[i][j] + " ");
					}
				}
				if (count == ROTATIONS - 1) {
					System.out.println();
				}
			}
		}
	}

	// void rotate(final int startpos, int i, int j, int numOfRows, int numOfCols) {
	// moveTopToBottom(i, j, numOfRows, numOfCols);
	// moveLeftToRight(numOfRows - 1, j, numOfRows, numOfCols);
	// moveBottomToTop(startpos, numOfRows - 1, numOfCols - 1, numOfRows, numOfCols);
	// moveRightToLeft(startpos, i, numOfCols - 1, numOfRows, numOfCols);
	// }

	void rotate(final int startpos, int i, int j, final int numOfRows, final int numOfCols) {
		int endX = numOfRows - i - 1;
		int endY = numOfCols - j - 1;
		if (i < endX && j < endY) {
			moveTopToBottom(i, j, numOfRows, numOfCols);
		}
		// ----------------------------------------------------------
		i = numOfRows - 1;
		endX = numOfRows - i - 1;
		if (i > endX && j < endY) {
			moveLeftToRight(i, j, numOfRows, numOfCols);
		}
		// ----------------------------------------------------------
		j = numOfCols - 1;
		endY = numOfCols - j - 1;
		if (i > endX && j > endY) {
			moveBottomToTop(startpos, i, j, numOfRows, numOfCols);
		}
		// ----------------------------------------------------------
		if (i < endX && j > endY) {
			moveRightToLeft(startpos, i, j, numOfRows, numOfCols);
		}
	}

	void moveTopToBottom(int i, int j, int numOfRows, int numOfCols) {
		if (i < numOfRows - 1) {
			int i1 = i + 1;
			tmp[i1][j] = a[i][j];
			moveTopToBottom(i1, j, numOfRows, numOfCols);
		}
	}

	void moveLeftToRight(int i, int j, int numOfRows, int numOfCols) {
		if (j < numOfCols - 1) {
			int j1 = j + 1;
			tmp[i][j1] = a[i][j];
			moveLeftToRight(i, j1, numOfRows, numOfCols);
		}
	}

	void moveBottomToTop(final int startpos, int i, int j, int numOfRows, int numOfCols) {
		if (i > startpos) {
			int i1 = i - 1;
			tmp[i1][j] = a[i][j];
			moveBottomToTop(startpos, i1, j, numOfRows, numOfCols);
		}
	}

	void moveRightToLeft(final int startpos, int i, int j, int numOfRows, int numOfCols) {
		if (j > startpos) {
			int j1 = j - 1;
			tmp[i][j1] = a[i][j];
			moveRightToLeft(startpos, i, j1, numOfRows, numOfCols);
		}
	}

}
