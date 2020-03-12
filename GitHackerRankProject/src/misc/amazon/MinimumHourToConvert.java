package misc.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem description: <br/>
 * 
 * Cloudfront can be visualized as 2D grid servers. When Amazon wants to host a
 * file on Cloudfront, the file needs to be distributed to all servers. The
 * servers are in the form of a 2D array of 0s and 1s, where 0 represents a
 * server that has not yet to receive the file and 1 represents a server that
 * already has the file.
 * 
 * 
 * Amazon will initially send the file to a handful of servers based on expected
 * utilisation. A server, upon receiving the a file, will then send the file to
 * adjacent servers that don't yet have the file.
 * 
 * An adjacent sever is either on the left, right, above or below a given
 * server. To conserver bandwidth, once a server receives a file, it will wait 1
 * hour before sending the file to adjacent servers.
 * 
 * 
 * Given the 2D array representing the existence of a new file on each server,
 * write an algorithm that will determine the minimum number of hours required
 * to send the file to all available servers.
 * 
 * Input<br/>
 * -----------------<br/>
 * The input to the method consisting of the arguments<br/>
 * rows: an integer representing the number of rows in the grid<br/>
 * columns: an integer representing the number of columns in the grid<br/>
 * grid: interger array representing the current status of servers. <br/>
 * 
 * 
 * Output<br/>
 * --------------<br/>
 * Return a integer representing the minimum number of hours required to send
 * the file to all available servers. Return -1 if all available servers cannot
 * receive the file.
 * 
 * Note: Diagonally placed cells are not considered as adjacent.<br/>
 * 
 * 
 * Example:<br/>
 * =========================
 * 
 * Input<br/>
 * 
 * rows=4<br/>
 * columns=5<br/>
 * grid= <br/>
 * [[0,1,1,0,1],<br/>
 * [0,1,0,1,0],<br/>
 * [0,0,0,0,1],<br/>
 * [0,1,0,0,0]]<br/>
 * 
 * 
 * Output<br/>
 * 
 * 2
 * 
 */
public class MinimumHourToConvert {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int rows = 4;
		int columns = 5;
		List<List<Integer>> grid = new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(0, 1, 1, 0, 1),
				Arrays.asList(0, 1, 0, 1, 0), Arrays.asList(0, 0, 0, 0, 1), Arrays.asList(0, 1, 0, 0, 0))

		);

		int result = minimumHours(rows, columns, grid);
		System.out.println(result);
	}

	/**
	 * Minimum hours.
	 *
	 * @param rows    the rows
	 * @param columns the columns
	 * @param grid    the grid
	 * @return the int
	 */
	static int minimumHours(int rows, int columns, List<List<Integer>> grid) {

		int[][] array = new int[rows][columns];
		for (int i = 0; i < grid.size(); i++) {
			List<Integer> row = grid.get(i);
			for (int j = 0; j < row.size(); ++j) {
				array[i][j] = row.get(j);
			}
		}

		return calcMinHours(array);

	}

	/**
	 * Min days.
	 *
	 * @param grid the grid
	 * @return the int
	 */
	private static int calcMinHours(int[][] grid) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int gridMatrixSize = grid.length * grid[0].length;
		int cnt = 0, res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[] { i, j });
					cnt++;
				}
			}
		}
		System.out.println("Q size:" + queue.size());

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (cnt == gridMatrixSize)
				return res;
			for (int queueIndex = 0; queueIndex < size; queueIndex++) {
				int[] cur = queue.poll();
				for (int[] dir : dirs) {
					int ni = cur[0] + dir[0];
					int nj = cur[1] + dir[1];
//					System.out.println("ni:" + ni + ", nj: " + nj);
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
