package misc.crackingcode;

public class MatrixSetAllZerosTest {
	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 1, 1 }, { 1, 2, 3, 0 }, { 1, 2, 4, 5 } };
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		setZeros(matrix);
		System.out.println("------------------------------------------------");
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
