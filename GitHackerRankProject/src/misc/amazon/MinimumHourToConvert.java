package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class MinimumHourToConvert {

	public static void main(String[] args) {
		int rows = 4;
		int columns = 5;
		List<List<Integer>> grid = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(0, 1, 1, 0, 1),
				Arrays.asList(0, 1, 0, 1, 0), Arrays.asList(0, 0, 0, 0, 1), Arrays.asList(0, 1, 0, 0, 0))

		);

		int result = minimumHours(rows, columns, grid);
		System.out.println(result);
	}

	static int minimumHours(int rows, int columns, List<List<Integer>> grid) {

		int[][] array = new int[rows][columns];
		for (int i = 0; i < grid.size(); i++) {
			List<Integer> row = grid.get(i);
			for (int j = 0; j < row.size(); ++j) {
				array[i][j] = row.get(j);
			}
		}

		return minDays(array);

	}

	private static int minDays(int[][] grid) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int target = grid.length * grid[0].length;
		int cnt = 0, res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[] { i, j });
					cnt++;
				}
			}
		}
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (cnt == target)
				return res;
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				System.out.println("cur : ");
				IntStream.of(cur).forEach(k -> System.out.print(k + " ,"));
				System.out.println();
				for (int[] dir : dirs) {
					int ni = cur[0] + dir[0];
					int nj = cur[1] + dir[1];
					System.out.println("ni:" + ni + ", nj: " + nj);
					if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0) {
						cnt++;
						queue.offer(new int[] { ni, nj });
						grid[ni][nj] = 1;
					}
				}
			}
			res++;
		}
		return -1;
	}

}
