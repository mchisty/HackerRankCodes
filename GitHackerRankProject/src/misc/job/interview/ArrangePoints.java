package misc.job.interview;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangePoints {

	public static void main(String[] args) {
		int[] x = { 2, 3, 1, 3, 3, 5, 2, 2, 10, 11, 12 };
		int[] y = { 5, 6, 2, 5, 4, 1, 3, 2, 20, 12, 22 };
		int N = x.length;
		int out[][] = solve(N, x, y);

		for (int i = 0; i < N; i++) {
			System.out.println(out[i][0] + ", " + out[i][1]);
		}
	}

	static int[][] solve(int N, int[] x, int[] y) {
		int grid[][] = new int[N][N];
		for (int i = 0; i < N; ++i) {
			grid[i][0] = x[i];
			grid[i][1] = y[i];
		}

		Arrays.sort(grid, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int result = o1[0] - o2[0];
				if (result == 0) {
					result = o2[1] - o1[1];
				}
				return result;
			}
		}

		);
		return grid;
	}

}
